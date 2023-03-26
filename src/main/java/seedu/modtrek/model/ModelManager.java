package seedu.modtrek.model;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.modtrek.commons.core.GuiSettings;
import seedu.modtrek.commons.core.LogsCenter;
import seedu.modtrek.logic.commands.CommandResult;
import seedu.modtrek.model.module.Module;

/**
 * Represents the in-memory model of the degree progression data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final DegreeProgression degreeProgression;
    private final UserPrefs userPrefs;
    private final FilteredList<Module> filteredModules;

    /**
     * Initializes a ModelManager with the given DegreeProgression and userPrefs.
     */
    public ModelManager(ReadOnlyDegreeProgression degreeProgression, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(degreeProgression, userPrefs);

        logger.fine("Initializing with address book: " + degreeProgression + " and user prefs " + userPrefs);

        this.degreeProgression = new DegreeProgression(degreeProgression);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredModules = new FilteredList<>(this.degreeProgression.getModuleList());
    }

    public ModelManager() {
        this(new DegreeProgression(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getDegreeProgressionFilePath() {
        return userPrefs.getFilePath();
    }

    @Override
    public void setDegreeProgressionFilePath(Path filePath) {
        requireNonNull(filePath);
        userPrefs.setFilePath(filePath);
    }

    //=========== DegreeProgression ================================================================================

    @Override
    public void setDegreeProgression(ReadOnlyDegreeProgression degreeProgression) {
        this.degreeProgression.resetData(degreeProgression);
    }

    @Override
    public ReadOnlyDegreeProgression getDegreeProgression() {
        return degreeProgression;
    }

    @Override
    public boolean hasModule(Module module) {
        requireNonNull(module);
        return degreeProgression.hasModule(module);
    }

    @Override
    public void deleteModule(Module target) {
        degreeProgression.removeModule(target);
    }

    @Override
    public void addModule(Module module) {
        degreeProgression.addModule(module);
        updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
    }

    @Override
    public void setModule(Module target, Module editedModule) {
        requireAllNonNull(target, editedModule);

        degreeProgression.setModule(target, editedModule);
    }

    //=========== Filtered Module List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Module} backed by the internal list of
     * {@code versionedDegreeProgression}
     */
    @Override
    public ObservableList<Module> getFilteredModuleList() {
        return filteredModules;
    }

    @Override
    public void updateFilteredModuleList(Predicate<Module> predicate) {
        requireNonNull(predicate);
        filteredModules.setPredicate(predicate);
    }

    @Override
    public TreeMap<? extends Object, ObservableList<Module>> getModuleGroups() {
        return degreeProgression.getModuleGroups();
    }

    @Override
    public TreeMap<?, ObservableList<Module>> sortModuleGroups(CommandResult.Sort sort) {
        return degreeProgression.sortModuleGroups(sort);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return degreeProgression.equals(other.degreeProgression)
                && userPrefs.equals(other.userPrefs)
                && filteredModules.equals(other.filteredModules);
    }

}
