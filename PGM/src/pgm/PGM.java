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
            
            ImagePGM histo = im.histogramme();
            int c=0;
            for(int i=0;i<histo.getL();i++)
            {
                for(int j=0;j<histo.getH();j++)
                {
                    if(histo.getPixels().get(i).get(j)==255)
                    {
                        c++;
                    }
                }
            }
            System.out.println(c);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
