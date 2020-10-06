package package1;

import package1.my_exceptions.BadInputException;
import package1.my_exceptions.WrongUsageException;

/**
 * A program that reads from a url list file and prints the list sorted by content size.
 * The program writes output into a file that contains the url and the size of the content in the byte.
 *
 * @author Eran Safadel
 * @version 1.0
 * @since 2020-04-19
 */
public class MyMain {

    public static void main(String[] args) {


        try {
            Controller controller = new Controller();// Instance of Controller
            controller.run(args);
        } catch (WrongUsageException | BadInputException e) {
            System.err.println(e.toString());
        }


    }

}
