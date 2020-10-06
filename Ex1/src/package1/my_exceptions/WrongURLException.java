package package1.my_exceptions;


import static package1.utils.Const.URL_VALIDITY;

/**
 * package1.MyExceptions.WrongURLException- class that extends from IOException
 * and Handles a package1.MyExceptions.WrongURLException thrown exception
 */
public class WrongURLException extends Exception {
    @Override
    public String toString() {
        return URL_VALIDITY;
    }
}
