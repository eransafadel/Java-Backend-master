package package1.utils;


public class Const {
    public static final int COUNT_ARGS = 2;/**size of arguments   */
    public static final String BAD_INPUT="Bad input";/** user enter problem file */
    public static final int INPUT = 0;/** The name of input file that user enter */
    public static final int OUTPUT = 1;/** The name of input file that user enter */
    public static final int ZERO=0;/**zero  */
    public static final int FAIL= -1; /**Read operation fail  */

    /** exceptions */
    public static final String SERVER_FALLEN="IOException: The read if fail ( Server fallen and etc..)";/**the server fallen  */
    public static final String WRITE_BROKEN="Write not succeed";/** write not succeed */
    public static final String FILE_NOT_CLOSE="close not success"; /**close not success  */
    public static final String OPEN_STREAM="WrongOpenStreamException: openStream is not valid";/** openStream is not valid */
    public static final String URL_VALIDITY="WrongURLException: URL is not valid";/** URL is not valid */
    public static final String WRONG_ARGS =" WrongUsageException: Wrong usage";/** Wrong usage of arguments */




}
