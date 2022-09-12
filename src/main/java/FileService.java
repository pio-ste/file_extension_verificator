import java.io.*;

public class FileService implements IFileService{

    private static final String gif87a = "47 49 46 38 37 61";

    private static final String gif89a = "47 49 46 38 39 61";

    private static final String jpg = "FF D8 FF E0";

    @Override
    public String readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        int value;
        int i = 0;
        int size = 10;
        StringBuilder hex = new StringBuilder();
        try(InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            while ((value = inputStream.read()) != -1 && i++ < size) {
                hex.append(String.format("%02X ", value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hex.toString();
    }

    @Override
    public String compareMagicNumbers(String fileContent, String extension) {
        if (fileContent.startsWith(gif87a) || fileContent.startsWith(gif89a)) {
            if (extension.equals("gif")) {
                return "The file extension is true!";
            } else {
                return "Extension is "+ extension +", while actually it's gif";
            }
        } else if (fileContent.startsWith(jpg)) {
            if (extension.equals("jpg")) {
                return "The file extension is true!";
            } else {
                return "Extension is "+ extension +", while actually it's jpg";
            }
        } else {
            return "The file extension is not recognized!";
        }


    }

    @Override
    public void checkExtension(FileToCheck fileToCheck) {
        try {
            String fileContent = readFile(fileToCheck.getPath());
            String result = compareMagicNumbers(fileContent, fileToCheck.getExtension());
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
