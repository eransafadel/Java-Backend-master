package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * package1.FileReader - class that read data from file and write to arrayList of string
 * Data members:
 * myFile - ArrayList contains each cell - is a row in the file
 * inputString -The file name from which we read the data
 * reader - for Scanner
 */

public class FileReader implements WordSupplier {

    private ArrayList<String> myFile;
    private String inputString;

    /**
     * Ctor that initializes data members
     *
     * @param inputString- The file name from which we read the data
     */
    FileReader(String inputString) {
        this.inputString = inputString;
        this.myFile = new ArrayList<>();
    }

    /**
     * Function that read data from file and input all rows to Arraylist
     *
     * @return myFile - return the Arraylist that contains all rows from file
     * @throws FileNotFoundException - If the scanner fails the exception is thrown
     */
    @Override
    public ArrayList<String> getWords() throws FileNotFoundException {
        File myReadFile = new File(inputString);
        Scanner reader = new Scanner(myReadFile);//BAD input

        while (reader.hasNextLine())
            myFile.add(reader.nextLine());

        reader.close();
        return myFile;
    }
}
