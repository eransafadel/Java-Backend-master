package package1;

import java.net.URL;

/**
 * package1.URLAndBytes : class the responsible to build the Object-(URL,size of bytes) for the list we build.
 * Data members: myURL- String that hold the URl.
 * : myCount- Integer the hold the size of bytes.
 */
public class URLAndBytes implements Comparable<URLAndBytes> {


    private String myURL;
    /**
     * String that hold the URl.
     */
    private Integer myCount; /**Integer the hold the size of bytes. */

    /**
     * @return myCount - return size of bytes
     */
    public Integer getMyCount() {
        return myCount;
    }

    /**
     * Ctor that initialize data members
     *
     * @param url   - String that hold the URl.
     * @param count - Integer the hold the size of bytes.
     */
    // Ctor of package1.URLAndBytes
    URLAndBytes(URL url, Integer count) {

        this.myURL = url.toString();
        this.myCount = count;
    }

    @Override
    public String toString() {
        return myURL + " " + myCount.toString();
    }


    /**
     * Compare to - is comparator the compare between 2 package1.URLAndBytes
     *
     * @param other -  the other  package1.URLAndBytes obj.
     * @return -Compares this object with the specified object for order.  Returns a
     * * negative integer, zero, or a positive integer as this object is less
     * * than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(URLAndBytes other) {
        int number = other.getMyCount();
        /* For Ascending order*/
        return this.myCount - number;

    }
}
