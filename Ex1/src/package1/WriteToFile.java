package package1;

import package1.my_exceptions.FileNotCloseException;
import package1.my_exceptions.WriteFailedException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static package1.utils.Const.FILE_NOT_CLOSE;
import static package1.utils.Const.WRITE_BROKEN;


/**
 * package1.WriteToFile -write to file.
 * Data members: outputFile- the name of file that we write to him.
 * :myList - list that hold (URL,size of bytes)) we build.
 */
public class WriteToFile {
    private String filename;
    /**
     * the name of file that we write to him.
     */
    private ArrayList<URLAndBytes> myList;/**list that hold (URL,size of bytes)) we build.*/

    /**
     * Ctor that initialize the data members
     *
     * @param outputFile- the name of file that we write to him.
     * @param myList      - list that hold (URL,size of bytes)) we build.
     */
    WriteToFile(String outputFile, ArrayList<URLAndBytes> myList) {
        this.filename = outputFile;
        this.myList = myList;
    }

    /**
     * execute - function that try write to file output.
     * catch IOException - if  close file not successful / Write not succeed.
     */
    public void execute() throws WriteFailedException, FileNotCloseException {
        FileWriter outputFile = null;
        try {
            outputFile = new FileWriter(this.filename);
            for (URLAndBytes urlAndBytes : myList) {
                outputFile.write(urlAndBytes.toString());
                outputFile.append("\n");
                outputFile.flush();
            }
        } catch (IOException ignored) {
            throw new WriteFailedException();
        }
        finally {
            try {
                assert outputFile != null;
                outputFile.close();
            } catch (IOException e) {
                throw new FileNotCloseException();
            }
        }

    }
}
