import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class FileServiceTest {

    static FileToCheck gifFile = new FileToCheck();

    static FileToCheck jpgFile = new FileToCheck();

    static String jpgContent = "FF D8 FF E0 00 10 4A 46 49 46 ";

    static String gifContent = "47 49 46 38 39 61 20 03 58 02 ";



    @BeforeClass
    public static void beforeClass() {
        gifFile.setExtension("gif");
        gifFile.setPath("src/test/java/resources/sampleGif.gif");

        jpgFile.setExtension("jpg");
        jpgFile.setPath("src/test/java/resources/sampleJPG.jpg");
    }

    @Test
    public void readFileTest() throws FileNotFoundException {
        String resultJpg = new FileService().readFile(jpgFile.getPath());
        assertEquals(jpgContent, resultJpg);

        String resultGif = new FileService().readFile(gifFile.getPath());
        assertEquals(gifContent, resultGif);

        assertNotEquals(jpgContent, resultGif);
    }

    @Test
    public void compareMagicNumbersTest() {
        String resultJpgTrue = new FileService().compareMagicNumbers(jpgContent, "jpg");

        assertEquals("The file extension is true!", resultJpgTrue);

        String resultJpgFalse = new FileService().compareMagicNumbers(jpgContent, "gif");

        assertEquals("Extension is gif, while actually it's jpg", resultJpgFalse);
    }


}
