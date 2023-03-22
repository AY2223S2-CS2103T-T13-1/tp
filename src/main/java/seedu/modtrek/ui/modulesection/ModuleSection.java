package seedu.modtrek.ui.modulesection;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.ui.UiPart;

/**
 * A subsection within the ResultsSection (left panel) that displays modules
 */
public class ModuleSection extends UiPart<Region> {
    private static final String FXML = "modulesection/ModuleSection.fxml";

    @FXML
    protected HBox moduleSectionNav;

    @FXML
    private StackPane moduleListPlaceholder;

    /**
     * Instantiates a ModuleSection.
     * @param modules The list of modules to display in the ModuleSection.
     */
    public ModuleSection(ObservableList<Module> modules) {
        super(FXML);

        ModuleList moduleList = new ModuleList(modules);
        moduleListPlaceholder.getChildren().add(moduleList.getRoot());
    }
}