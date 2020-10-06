package package1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * package1.WordSupplier - interface that define function getWords() that throws FileNotFoundException.
 */
public interface WordSupplier {

    ArrayList<String> getWords() throws FileNotFoundException;
}
