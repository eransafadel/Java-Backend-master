package main.Model;

/**
 * ObjGithub - thhe object  we get from github.
 */
public class ObjGithub
{
    public ObjGithub()
    {

    }

    private String login;
    private String html_url;
    private String followers;

    /**
     * getLogin - get funcrion.
     * @return String - "login"  the name of user logged in.
     */
    public String getLogin() {
        return login;
    }

    /**
     * setLogin -  set function.
     * @param login String - "login"  the name of user logged in.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * getHtml_url - get function.
     * @return html_url - the url of user.
     */
    public String getHtml_url() {
        return html_url;
    }

    /**
     * setHtml_url - set function.
     * @param html_url html_url - the url of user.
     */
    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    /**
     * getFollowers -get function.
     * @return followers.
     */
    public String getFollowers() {
        return followers;
    }

    /**
     * setFollowers - set function.
     * @param followers followers.
     */
    public void setFollowers(String followers) {
        this.followers = followers;
    }
}