package package1;

import package1.my_exceptions.BadInputException;
import package1.my_exceptions.FileNotCloseException;
import package1.my_exceptions.WriteFailedException;
import package1.my_exceptions.WrongUsageException;

import java.io.*;
import java.util.*;

import static package1.utils.Const.*;

/**
 * package1.Controller -handle the program
 * functions: run and countArgs
 */

public class Controller {

    /**
     * Functions: run- run the program.
     * :countArgs- check if the count args is correct
     * Data members: myList- hold the list (Url,size of bytes)
     */
    private ArrayList<URLAndBytes> myList;


    public Controller() {
        this.myList = new ArrayList<>();
    }


    /**
     * This function run the program
     *
     * @param args - arguments from user
     * @throws BadInputException   - Exception that thrown if we not succeed to read from file.
     * @throws WrongUsageException -Exception that thrown if count args not equal to 2.
     */
    public void run(String[] args) throws BadInputException, WrongUsageException {

        countArgs(args);


        try {
            WordSupplier w = new FileReader(args[INPUT]);
            BuildDataStructure rw = new BuildDataStructure(w, myList);//ctor
            rw.buildList();
            WriteToFile writeToFile = new WriteToFile(args[OUTPUT], myList);
            writeToFile.execute();

        } catch (FileNotFoundException e) {
            throw new BadInputException();
        } catch (WriteFailedException e) {
            System.err.println(e.toString());
        } catch (FileNotCloseException e) {
            System.err.println(e.toString());
        }


    }

    /**
     * Internal function that checks if the args.length= COUNT_ARGS
     *
     * @param args - arguments from user
     * @throws WrongUsageException -Exception that thrown if args.length is not equal 2
     */
    private void countArgs(String[] args) throws WrongUsageException {
        if (args.length != COUNT_ARGS) {
            throw new WrongUsageException();
        }
    }

}




