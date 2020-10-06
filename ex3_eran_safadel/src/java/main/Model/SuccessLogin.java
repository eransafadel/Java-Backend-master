package main.Model;

/**
 * SuccessLogin - class that show is user success to logged in.
 */
public class SuccessLogin
{
        public SuccessLogin(){}
        private Boolean success;

    /**
     * - get function.
     * @return success a bollean var that indicate if user success to login.
     */
    public Boolean getSuccess() {
            return success;
        }

    /**
     * setSuccess - set function.
     * @param success success a bollean var that indicate if user success to login.
     */
    public void setSuccess(Boolean success) {
            this.success = success;
        }

}
