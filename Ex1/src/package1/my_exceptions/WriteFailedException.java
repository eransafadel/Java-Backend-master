package package1.my_exceptions;

import java.io.IOException;
import static package1.utils.Const.WRITE_BROKEN;

/**
 * package1.MyExceptions.WriteFailedException- class that extends from
 * IOException and Handles a package1.MyExceptions.WriteFailedException thrown exception
 */
public class WriteFailedException extends IOException {
    @Override
    public String toString() {
        return WRITE_BROKEN;
    }
}
