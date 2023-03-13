package seedu.modtrek.ui.modulelist;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.modtrek.model.module.Code;
import seedu.modtrek.model.module.Credit;
import seedu.modtrek.model.module.Grade;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.model.module.SemYear;
import seedu.modtrek.model.tag.Tag;

@ExtendWith(ApplicationExtension.class)
public class ModuleCardTest {

    @Start
    private void start(Stage stage) {
        Module moduleWithoutGrade = new Module(
                new Code("CS1000"),
                new Credit("4"),
                new SemYear("Y1S1"),
                Collections.EMPTY_SET,
                new Grade("")
        );
        ModuleCard moduleCardWithoutGrade = new ModuleCard(moduleWithoutGrade);
        moduleCardWithoutGrade.getRoot().setId("moduleCardWithoutGrade");

        Set<Tag> tags = new HashSet<>();
        tags.add(new Tag("COMPUTER SCIENCE FOUNDATION"));
        Module moduleWithTag = new Module(
                new Code("CS1000"),
                new Credit("4"),
                new SemYear("Y1S1"),
                tags,
                new Grade("A+")
        );
        ModuleCard moduleCardWithTag = new ModuleCard(moduleWithTag);
        moduleCardWithTag.getRoot().setId("moduleCardWithTag");

        StackPane pane = new StackPane();
        pane.getChildren().addAll(moduleCardWithoutGrade.getRoot(), moduleCardWithTag.getRoot());
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("view/main-window.css");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testEmptyGrade(FxRobot robot) {
        Label gradeLabel = robot.lookup("#moduleCardWithoutGrade").lookup(".module-card-grade").queryAs(Label.class);
        assert gradeLabel != null : "Label component for grade should not be null";
        Assertions.assertThat(gradeLabel.getText()).hasToString("–");
    }

    @Test
    public void testTagPresent(FxRobot robot) {
        Label tagLabel = robot.lookup("#moduleCardWithTag").lookup(".module-card-tag").queryAs(Label.class);
        assert tagLabel != null : "Label component for tag should not be null";
        Assertions.assertThat(tagLabel.getText()).hasToString("CSF");
    }
}
