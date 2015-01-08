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
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) {
        try {
            ImagePGM image = new ImagePGM("lena");
            image.seuiller(250).ecrirePGM("lena2");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
