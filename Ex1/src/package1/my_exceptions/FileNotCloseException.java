package package1.my_exceptions;


import java.io.IOException;

import static package1.utils.Const.FILE_NOT_CLOSE;


/**
 * package1.MyExceptions.FileNotCloseException- class that extends from
 * IOException and Handles a package1.MyExceptions.FileNotCloseException thrown exception
 */
public class FileNotCloseException extends IOException {
    @Override
    public String toString() {
        return FILE_NOT_CLOSE;
    }
}
