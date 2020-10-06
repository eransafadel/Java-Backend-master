package package1.my_exceptions;

import java.io.IOException;
import static package1.utils.Const.BAD_INPUT;

/**
 * package1.MyExceptions.BadInputException- class that extends from IOException and Handles a package1.MyExceptions.BadInputException thrown exception
 */
public class BadInputException extends IOException {
    @Override
    public String toString() {
        return BAD_INPUT;
    }
}
