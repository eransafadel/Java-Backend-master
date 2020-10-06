package main.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * User - contains username,id , count and url of user.
 */
@Entity
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@NotBlank(message = "Name is mandatory")
    private String userName;

    //@NotBlank(message = "Url is mandatory")
    private String url;

   //@NotBlank(message = "count is mandatory")
    private int count;

    public User() {}

    /**
     *
     * @param userName  userName
     * @param url url
     */
    public User(String userName, String url) {
        this.userName = userName;
        this.url = url;
        this.count = 1;
    }

    /**
     * setId -set function.
     * @param id - user id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * getId -get function.
     * @return id - user id
     */
    public long getId() {
        return id;
    }

    /**
     * getUserName - get function.
     * @return return userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * getCount - get function.
     * @return - return count.
     */
    public int getCount() {
        return count;
    }

    /**
     * setCount - set function.
     * @param count - count
     */
    public void setCount(int count) {
        this.count += 1;
    }

    /**
     * setUserName- set function.
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * getUrl- get function.
     * @return return url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * toString function.
     * @return  String that concatenate the all data members.
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", url=" + url +", count="+count + '}';
    }
}

