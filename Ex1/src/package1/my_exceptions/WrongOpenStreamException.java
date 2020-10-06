package package1.my_exceptions;

import java.io.IOException;

import static package1.utils.Const.OPEN_STREAM;

/**
 * package1.MyExceptions.WrongOpenStreamException- class that extends from IOException
 * and Handles a package1.MyExceptions.WrongOpenStreamException thrown exception
 */
public class WrongOpenStreamException extends IOException {
    @Override
    public String toString() {
        return OPEN_STREAM;
    }
}
