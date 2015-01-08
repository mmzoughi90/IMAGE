
package pgm;

import java.util.*;
import java.io.*;

/**
 *
 * @author Mzoughi
 */
public class PGM {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        ImagePGM image = new ImagePGM("lena");
        image.seuiller(100).ecrirePGM("Seuillage100");
        ImagePGM clone = image.clone();
        System.out.println(image.equals(clone));
    }
}