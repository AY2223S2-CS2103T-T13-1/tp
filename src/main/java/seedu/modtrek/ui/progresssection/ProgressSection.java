package seedu.modtrek.ui.progresssection;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.modtrek.model.DegreeProgressionData;
import seedu.modtrek.ui.UiPart;

/**
 * A subsection within the ResultsSection (left panel) that displays the current degree progress of the user.
 */
public class ProgressSection extends UiPart<Region> {
    private static final String FXML = "progresssection/ProgressSection.fxml";

    @FXML
    private StackPane progressSection;

    /**
     * Instantiates a ProgressSection.
     */
    public ProgressSection(DegreeProgressionData degreeProgressionData) {
        super(FXML);

        DoughnutChart doughnutChart = new DoughnutChart(degreeProgressionData);
        progressSection.getChildren().add(doughnutChart);
    }
}