package hac;
import java.io.IOException;

import static hac.Utils.PARAMS_WRONG;

/**
 * class that catch exeption from type ParamsWrongException
 */
public class ParamsWrongException extends IOException {

    /**
     * @return String from type ParamsWrongException
     */
    @Override
    public String toString() {
        return PARAMS_WRONG;
    }
}
