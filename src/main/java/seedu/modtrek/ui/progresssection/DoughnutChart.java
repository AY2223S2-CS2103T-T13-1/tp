package seedu.modtrek.ui.progresssection;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * A doughnut chart that displays summary statistics of the degree progress.
 * @author jewelsea from stackoverflow.com, modified from
 *     https://stackoverflow.com/questions/24121580/can-piechart-from-javafx-be-displayed-as-a-doughnut
 */
public class DoughnutChart extends PieChart {
    /**
     * The center label of the doughnut (displaying % completion, CAP).
     */
    private StackPane doughnutCenterLabel;
    private Circle innerCircle;

    /**
     * The individual tag labels representing each category of the curriculum.
     */
    private VBox[] dataLabels;

    /**
     * Instantiates a new doughnut chart.
     * @param doughnutData The data to be fed into the doughnut chart and displayed.
     */
    public DoughnutChart(ObservableList<Data> doughnutData) {
        super(doughnutData);

        applyChartStyles();

        createCenterLabel();
        createDataLabels();
        addLabels();
    }

    /**
     * {@inheritDoc}
     * Also correctly positions the center label (in the center of the doughnut) and data labels (individual
     * tag labels).
     * @param top {@inheritDoc}
     * @param left {@inheritDoc}
     * @param contentWidth {@inheritDoc}
     * @param contentHeight {@inheritDoc}
     */
    @Override
    protected void layoutChartChildren(double top, double left, double contentWidth, double contentHeight) {
        super.layoutChartChildren(top, left, contentWidth, contentHeight);

        updateCenterLabelLayout();
        updateDataLabelsLayout();
    }

    /**
     * Adds center and data labels on the doughnut chart.
     */
    private void addLabels() {
        addNodeToChart(doughnutCenterLabel);
        for (VBox dataLabel : dataLabels) {
            addNodeToChart(dataLabel);
        }
    }

    /**
     * Creates the center label of the doughnut chart.
     * The center label showcases the percentage completion of the degree progress and CAP.
     */
    private void createCenterLabel() {
        innerCircle = new Circle();
        innerCircle.setStyle("-fx-fill: -black");

        Text percent = new Text("0% completed");
        percent.setStyle("-fx-fill: -teal;");
        percent.getStyleClass().add("h2");

        Text totalMc = new Text("0/160 MCs");
        totalMc.setStyle("-fx-fill: -white;");
        totalMc.getStyleClass().add("h3");

        Text cap = new Text("CAP: 5.00");
        cap.setStyle("-fx-fill: -white;");
        cap.getStyleClass().add("h3");

        VBox labels = new VBox(percent, totalMc, cap);
        labels.getStyleClass().add("doughnut-center-label");

        doughnutCenterLabel = new StackPane(innerCircle, labels);
    }

    /**
     * Creates the data labels of the doughnut chart.
     */
    private void createDataLabels() {
        final int numTags = 6;

        // TODO: call from Tags enum
        Map<String, String> tagColors = new HashMap<>();
        tagColors.put("ULR", "red");
        tagColors.put("ITP", "orange");
        tagColors.put("UE", "yellow");
        tagColors.put("MS", "green");
        tagColors.put("CSF", "blue");
        tagColors.put("CSBD", "purple");

        dataLabels = new VBox[numTags];

        Map<String, String> labelTexts = getDataLabelTexts();

        ObservableList<Data> doughnutData = getData();
        assert doughnutData.size() == numTags * 2 : "Number of divisions of doughnut chart should be 12.";
        for (int i = 0; i < doughnutData.size(); i += 2) {
            Data completeData = doughnutData.get(i);

            String tag = completeData.getName().split("_")[0];
            Text completeLabel = new Text(labelTexts.get(tag));
            completeLabel.getStyleClass().addAll("p1");
            completeLabel.setStyle("-fx-fill: -tag-" + tagColors.get(tag) + ";");
            completeLabel.setTextAlignment(TextAlignment.CENTER);

            VBox dataLabel = new VBox(completeLabel);
            dataLabel.getStyleClass().add("data-label");
            dataLabels[i / 2] = dataLabel;
        }
    }


    /**
     * Positions the center label correctly such that it is in the center
     * of the doughnut chart.
     */
    private void updateCenterLabelLayout() {
        Map<String, Double> chartProperties = getChartProperties();
        double centerX = chartProperties.get("centerX");
        double centerY = chartProperties.get("centerY");
        double radius = chartProperties.get("radius");

        doughnutCenterLabel.setLayoutX(centerX);
        doughnutCenterLabel.setLayoutY(centerY);

        final double scale = 1.3;
        innerCircle.setRadius(radius / scale);
    }

    /**
     * Positions each data label correctly such that it is aligned to its corresponding
     * arc area on the doughnut chart.
     */
    private void updateDataLabelsLayout() {
        Map<String, Double> angles = getDataLabelAngles();

        final double offsetScale = 1.4;
        Map<String, Double> chartProperties = getChartProperties();
        double centerX = chartProperties.get("centerX");
        double centerY = chartProperties.get("centerY");
        double radius = chartProperties.get("radius") * offsetScale;

        ObservableList<Data> doughnutData = getData();
        assert dataLabels.length == doughnutData.size() / 2
                : "Number of data labels should be half the number of doughnut data";
        for (int i = 0; i < doughnutData.size(); i += 2) {
            VBox dataLabel = dataLabels[i / 2];
            Data completeData = doughnutData.get(i);
            String tag = completeData.getName().split("_")[0];

            double angle = angles.get(tag);
            double xCoord = centerX + radius * Math.cos(angle);
            double yCoord = centerY + radius * Math.sin(angle);

            dataLabel.setLayoutX(xCoord);
            dataLabel.setLayoutY(yCoord);
        }
    }

    /**
     * Sets the CSS styles of the doughnut chart and its arc areas.
     */
    private void applyChartStyles() {
        super.setLegendVisible(false);
        super.setLabelsVisible(false);

        /* Change colors of doughnut chart */
        final int numTags = 6;

        // TODO: call from Tags enum
        Map<String, String> tagColors = new HashMap<>();
        tagColors.put("ULR", "red");
        tagColors.put("ITP", "orange");
        tagColors.put("UE", "yellow");
        tagColors.put("MS", "green");
        tagColors.put("CSF", "blue");
        tagColors.put("CSBD", "purple");

        ObservableList<Data> doughnutData = getData();
        assert doughnutData.size() == numTags * 2 : "Number of divisions of doughnut chart should be 12.";
        for (int i = 0; i < doughnutData.size(); i += 2) {
            Data completeData = doughnutData.get(i);
            Data incompleteData = doughnutData.get(i + 1);

            Node completeDataNode = completeData.getNode();
            String tag = completeData.getName().split("_")[0];
            completeDataNode.setStyle(
                    "-fx-background-color: -tag-" + tagColors.get(tag) + "; "
                            + "-fx-border-width: 0;"
            );

            Node incompleteDataNode = incompleteData.getNode();
            if (isNoneComplete()) {
                incompleteDataNode.setStyle(
                        "-fx-background-color: -tag-" + tagColors.get(tag) + "; "
                                + "; -fx-opacity: 0.25;" + "-fx-border-width: 0;"
                );
            } else {
                incompleteDataNode.setStyle("-fx-background-color: -black; -fx-border-width: 0;");
            }

        }
    }


    /* HELPER FUNCTIONS */

    /**
     * Adds a JavaFX Node to the doughnut chart's topmost component.
     * @param node The JavaFX Node to be added.
     */
    private void addNodeToChart(Node node) {
        if (getData().size() > 0) {
            Node pie = getData().get(0).getNode();
            if (pie.getParent() instanceof Pane) {
                Pane parent = (Pane) pie.getParent();

                if (!parent.getChildren().contains(node)) {
                    parent.getChildren().add(node);
                }
            }
        }
    }

    /**
     * Calculates and obtains some of the doughnut chart's geometric properties.
     * @author jewelsea from stackoverflow.com
     * @return The x and y coordinates of the center, and radius of the doughnut chart, in the
     *     form of a hashmap.
     */
    private Map<String, Double> getChartProperties() {
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Data data : getData()) {
            Node node = data.getNode();

            Bounds bounds = node.getBoundsInParent();
            if (bounds.getMinX() < minX) {
                minX = bounds.getMinX();
            }
            if (bounds.getMinY() < minY) {
                minY = bounds.getMinY();
            }
            if (bounds.getMaxX() > maxX) {
                maxX = bounds.getMaxX();
            }
            if (bounds.getMaxY() > maxY) {
                maxY = bounds.getMaxY();
            }
        }

        double centerX = minX + (maxX - minX) / 2;
        double centerY = minY + (maxY - minY) / 2;
        double radius = (maxX - minX) / 2;

        Map<String, Double> properties = new HashMap<>();
        properties.put("centerX", centerX);
        properties.put("centerY", centerY);
        properties.put("radius", radius);

        return properties;
    }

    /**
     * Calculates and obtains the positional angles for all 6 data label components, so that
     * each data label component can be aligned to its corresponding arc area on the doughnut chart.
     * @return The positional angles for each data label.
     */
    private Map<String, Double> getDataLabelAngles() {
        final int numTags = 6;
        final int totalCurriculumCredits = 160;

        Map<String, Double> angles = new HashMap<>();

        double accCredits = 0;

        double fullAngle = 2 * Math.PI;

        ObservableList<Data> doughnutData = getData();
        assert doughnutData.size() == numTags * 2 : "Number of divisions of doughnut chart should be 12.";
        for (int i = 0; i < doughnutData.size(); i += 2) {
            Data completeData = doughnutData.get(i);
            Data incompleteData = doughnutData.get(i + 1);

            double completeCredits = completeData.getPieValue();
            double incompleteCredits = incompleteData.getPieValue();

            // TODO: call credits for each Tag from model/logic (?)
            double totalCredits = completeCredits + incompleteCredits;

            String tag = completeData.getName().split("_")[0];

            double offset = totalCredits / 2;
            offset += accCredits;

            double angle = (offset / totalCurriculumCredits) * fullAngle;
            angles.put(tag, angle);

            accCredits += totalCredits;
        }

        return angles;
    }


    private Map<String, String> getDataLabelTexts() {
        final int numTags = 6;

        Map<String, String> tagLongForm = new HashMap<>();
        tagLongForm.put("ULR", "University Level\nRequirements");
        tagLongForm.put("CSF", "CS Foundation");
        tagLongForm.put("CSBD", "CS\nBreadth & Depth");
        tagLongForm.put("ITP", "IT\nProfessionalism");
        tagLongForm.put("UE", "Unrestricted\nElectives");
        tagLongForm.put("MS", "Mathematics &\nSciences");

        Map<String, String> texts = new HashMap<>();

        ObservableList<Data> doughnutData = getData();
        assert doughnutData.size() == numTags * 2 : "Number of divisions of doughnut chart should be 12.";
        for (int i = 0; i < doughnutData.size(); i += 2) {
            Data completeData = doughnutData.get(i);
            Data incompleteData = doughnutData.get(i + 1);

            double completeCredits = completeData.getPieValue();
            double incompleteCredits = incompleteData.getPieValue();

            // TODO: call credits for each Tag from model/logic (?)
            double totalCredits = completeCredits + incompleteCredits;

            long percentCompleted = Math.round(completeCredits / totalCredits * 100);

            String tag = completeData.getName().split("_")[0];

            String text = tagLongForm.get(tag) + "\n" + percentCompleted + "%";
            texts.put(tag, text);
        }

        return texts;
    }

    // TODO: call from logic/storage/model
    private boolean isNoneComplete() {
        final int numTags = 6;

        ObservableList<Data> doughnutData = getData();
        assert doughnutData.size() == numTags * 2 : "Number of divisions of doughnut chart should be 12.";
        for (int i = 0; i < doughnutData.size(); i += 2) {
            Data completeData = doughnutData.get(i);
            if (completeData.getPieValue() > 0) {
                return false;
            }
        }

        return true;
    }
}
