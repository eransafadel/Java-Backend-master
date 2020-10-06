package hac;
import java.io.IOException;
import static hac.Utils.FAIL_REDIRECT;

/**
 *  * class that catch exception from type RedirectException
 */
public class RedirectException extends IOException
{
    /**
     * @return string from type RedirectException
     */
    @Override
    public String toString() {
        return FAIL_REDIRECT;
    }
}
