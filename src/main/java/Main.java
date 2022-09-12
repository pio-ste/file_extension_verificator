import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        IFileService fileService = new FileService();

        do {
            FileToCheck fileToCheck = new FileToCheck();
            System.out.println("Enter the path to the file: ");
            String path = scanner.nextLine();
            if (path.isEmpty()) {
                throw new ValidationException("Path can not be empty!");
            }
            fileToCheck.setPath(path);
            System.out.println("Enter the extension of the file (e.g. gif, jpg, txt): ");
            String extension = scanner.nextLine();
            if (extension.isEmpty()) {
                throw new ValidationException("Extension can not be empty!");
            }
            fileToCheck.setExtension(extension.toLowerCase());
            switch (fileToCheck.getExtension()) {
                case "gif":
                case "jpg":
                    fileService.checkExtension(fileToCheck);
                    break;
                case "txt":
                    System.out.println("There is no magic numbers for txt file!");
                    break;
                default:
                    System.out.println("Not supported extension!");
            }
        } while (true);
    }
}
