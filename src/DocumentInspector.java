import java.io.File;

public class DocumentInspector {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java -cp out DocumentInspector <filename>");
            return;
        }

        String filename = args[0];
        File file = new File(filename);

        System.out.println("===== Document Inspector =====");
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent directory: " + file.getParent());
        System.out.println("Exists: " + file.exists());
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Executable: " + file.canExecute());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("==============================");
    }
}