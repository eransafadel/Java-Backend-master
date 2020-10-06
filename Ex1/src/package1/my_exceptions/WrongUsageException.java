package package1.my_exceptions;

import java.io.IOException;

import static package1.utils.Const.WRONG_ARGS;

/**
 * package1.MyExceptions.WrongUsageException- class that extends from
 * IOException and Handles a package1.MyExceptions.WrongUsageException thrown exception
 */
public class WrongUsageException extends IOException {
    @Override
    public String toString() {
        return WRONG_ARGS;
    }
}
