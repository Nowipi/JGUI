package testing.todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final class ResourceUtils {

    public static InputStream getResourceStream(String fileName) {
        return ResourceUtils.class.getResourceAsStream(fileName);
    }

    public static byte[] getFileContents(String fileName) throws FileNotFoundException {
        try(var in = getResourceStream(fileName)) {
            if (in == null) {
                throw new FileNotFoundException(fileName);
            }
            return in.readAllBytes();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
