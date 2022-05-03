import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class Make {
    public static void main(String args[]){
        String spa = FileSystems.getDefault().getSeparator();
        String BASE_DIR = ".";
        String NEW_DIR = BASE_DIR + spa + args[0] + spa + args[1];
        try{
            Path source = Paths.get(BASE_DIR + spa + "Main.java");
            Path target_folder = Paths.get(NEW_DIR);
            Path target_file   = Paths.get(NEW_DIR + spa + "Main.java");
            Files.createDirectories(target_folder);
            Files.copy(source, target_file);
        }catch(FileAlreadyExistsException e){
            System.out.println(String.format("file %s already exists",e.getMessage()));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
      }
}
