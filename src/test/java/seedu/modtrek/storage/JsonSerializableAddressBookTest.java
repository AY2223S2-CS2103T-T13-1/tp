package seedu.modtrek.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.modtrek.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.modtrek.commons.exceptions.IllegalValueException;
import seedu.modtrek.commons.util.JsonUtil;
import seedu.modtrek.model.DegreeProgression;
import seedu.modtrek.storage.JsonSerializableAddressBook;
import seedu.modtrek.testutil.TypicalPersons;

public class JsonSerializableAddressBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableAddressBookTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
<<<<<<< HEAD:src/test/java/seedu/modtrek/storage/JsonSerializableAddressBookTest.java
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableAddressBook.class).get();
        DegreeProgression addressBookFromFile = dataFromFile.toModelType();
        DegreeProgression typicalPersonsAddressBook = TypicalPersons.getTypicalAddressBook();
=======
        JsonSerializableDegreeProgression dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableDegreeProgression.class).get();
        AddressBook addressBookFromFile = dataFromFile.toModelType();
        AddressBook typicalPersonsAddressBook = TypicalPersons.getTypicalAddressBook();
>>>>>>> pr/37:src/test/java/seedu/address/storage/JsonSerializableAddressBookTest.java
        assertEquals(addressBookFromFile, typicalPersonsAddressBook);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableDegreeProgression dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableDegreeProgression.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableDegreeProgression dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableDegreeProgression.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableDegreeProgression.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }

}
