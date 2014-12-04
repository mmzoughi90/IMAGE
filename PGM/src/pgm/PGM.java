/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     */
    public static void main(String[] args) {
        try {
            ImagePGM im = new ImagePGM("lena");

            im.ecrirePGM("lena2");
            
            im.histogramme();
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
