package main.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Login a class that contains the name and password for user
 */
@Component
public class Login implements Serializable
{
    public Login( )
    {
    }

    private String name;
    private String password;

    /**
     * getName - get funcrion
     * @return  string -name of user
     */
    public String getName() {
        return name;
    }

    /**
     * setName - get funcrion
     * @param name string -name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getPassword
     * @return string -password of user
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword
     * @param password string -password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}