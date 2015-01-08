package pgm;

import java.util.*;
import java.io.*;

/**
 *
 * @author Mzoughi
 */
public class PGM {

    private PGM() {

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     *
     */
    public static void main(String[] args) throws IOException {
        ImagePGM image = new ImagePGM("lena");
        image.seuiller(100).ecrirePGM("Seuillage100");

    }
}
