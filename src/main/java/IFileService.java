import java.io.File;
import java.io.FileNotFoundException;

public interface IFileService {

    String readFile(String path) throws FileNotFoundException;

    void compareMagicNumbers(String fileContent, String extension);

    void checkExtension(FileToCheck fileToCheck);

}
