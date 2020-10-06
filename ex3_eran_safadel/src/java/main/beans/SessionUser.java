package main.beans;
import org.springframework.stereotype.Component;


import java.io.Serializable;


/** this is a simple bean class instantiated in session
  it contains a boolean
*/
@Component
public class SessionUser implements Serializable {
    private Boolean flag ;


    public SessionUser() {
        this.flag = false;
    }

    /**
     * getFlag return the flag if user logged in successful
     * @return flag - bollean that indicate if user logged in
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * getFlag get on param a flag  and set to member flag
     * @param flag flag - bollean that indicate if user logged in
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}