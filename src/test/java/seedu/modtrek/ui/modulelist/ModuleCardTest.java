package seedu.modtrek.ui.modulelist;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import javafx.scene.Node;
import javafx.scene.control.Label;
import seedu.modtrek.model.module.Code;
import seedu.modtrek.model.module.Credit;
import seedu.modtrek.model.module.Grade;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.model.module.SemYear;
import seedu.modtrek.model.tag.Tag;

@ExtendWith(ApplicationExtension.class)
public class ModuleCardTest {

    @Test
    public void testEmptyGrade() {
        Module moduleWithoutGrade = new Module(
                new Code("CS1000"),
                new Credit("4"),
                new SemYear("Y1S1"),
                Collections.EMPTY_SET,
                new Grade("")
        );

        ModuleCard moduleCard = new ModuleCard(moduleWithoutGrade);

        Node gradeLabelNode = moduleCard.getRoot().lookup(".module-card-grade");
        assert gradeLabelNode != null : ".module-card-grade component should not be null";
        assert gradeLabelNode instanceof Label : ".module-card-grade component should be a Label";
        Label gradeLabel = (Label) gradeLabelNode;
        Assertions.assertThat(gradeLabel.getText()).hasToString("–");
    }

    @Test
    public void testTagPresent() {
        Set<Tag> tags = new HashSet<>();
        tags.add(new Tag("COMPUTER SCIENCE FOUNDATION"));

        Module moduleWithTag = new Module(
                new Code("CS1000"),
                new Credit("4"),
                new SemYear("Y1S1"),
                tags,
                new Grade("A+")
        );

        ModuleCard moduleCard = new ModuleCard(moduleWithTag);

        Node tagNode = moduleCard.getRoot().lookup(".module-card-tag");
        assert tagNode != null : ".module-card-tag component should not be null";
        assert tagNode instanceof Label : ".module-card-tag component should be a Label";
        Label tag = (Label) tagNode;
        Assertions.assertThat(tag.getText()).hasToString("CSF");
    }
}
