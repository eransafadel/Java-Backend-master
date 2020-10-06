package package1;

import package1.my_exceptions.WrongOpenStreamException;
import package1.my_exceptions.WrongURLException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import static package1.utils.Const.*;

/**
 * package1.BuildDataStructure - class that build ArrayList of valid url with num of bytes
 * Data members:
 * sup - package1.WordSupplier type
 * input - InputStream type that read from file
 * url - URL type that get from curr line
 * myList - ArrayList type that put url and number of bytes if url is valid
 */
public class BuildDataStructure {
    private WordSupplier sup;
    private InputStream input = null;
    private URL url = null;
    private ArrayList<URLAndBytes> myList;

    /**
     * Ctor that Initializes data members.
     *
     * @param sup    - package1.WordSupplier type .
     * @param myList - ArrayList type that put url and number of bytes if url is valid.
     */
    public BuildDataStructure(WordSupplier sup, ArrayList<URLAndBytes> myList) {
        this.sup = sup;
        this.myList = new ArrayList<>();
        this.myList = myList;
    }

    /**
     * Function that build list of url and number of bytes if task is successful.
     *
     * @throws FileNotFoundException - thrown if file not found.
     */
    public void buildList() throws FileNotFoundException {
        ArrayList<String> myFile = sup.getWords();
        for (String s : myFile) {
            try {
                validURL(s);
                int myCountBytes = checkByteValid();
                myList.add(new URLAndBytes(url, myCountBytes));
            } catch (WrongURLException e) {
                System.err.println(e.toString());
            } catch (WrongOpenStreamException e) {
                System.err.println(e.toString());
            }
        }
        Collections.sort(myList);
    }


    /**
     * Function that check if url is valid.
     * (like server fallen and etc..).
     *
     * @return count - int type that hold count of bytes of url.
     */
    private int checkByteValid() {
        int count = ZERO;
        try {
            while ((input.read()) != FAIL)
                count++;
        } catch (IOException e) {

            count = ZERO;
            System.err.println(SERVER_FALLEN);
        }
        return count;
    }


    /**
     * @param currLine -  String  that indicate the current line on file.
     * @throws WrongURLException        - Exception that thrown if there is URL is wrong.
     * @throws WrongOpenStreamException -Exception that thrown if there is open stream is fail.
     */
    private void validURL(String currLine) throws WrongURLException, WrongOpenStreamException {

        try {
            url = new URL(currLine); //MalformedURLException
            input = url.openStream(); // IOException
        } catch (MalformedURLException e)//if URL not success
        {
            throw new WrongURLException();
        } catch (IOException e)//
        {
            throw new WrongOpenStreamException();
        }
    }


}