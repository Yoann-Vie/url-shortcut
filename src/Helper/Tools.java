package Helper;

/**
 *
 */
public class Tools {

    /**
     * Upper only first char of a string
     * @param string String
     * @return String
     */
    public static String ucfirst(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
