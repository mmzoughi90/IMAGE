/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgm;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ImagePGMTest {

    public ImagePGMTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getL method, of class ImagePGM.
     */
    @Test
    public void testGetL() {

    }

    /**
     * Test of setL method, of class ImagePGM.
     */
    @Test
    public void testSetL() {

    }

    /**
     * Test of getH method, of class ImagePGM.
     */
    @Test
    public void testGetH() {

    }

    /**
     * Test of setH method, of class ImagePGM.
     */
    @Test
    public void testSetH() {

    }

    /**
     * Test of getGrisMax method, of class ImagePGM.
     */
    @Test
    public void testGetGrisMax() {

    }

    /**
     * Test of setGrisMax method, of class ImagePGM.
     */
    @Test
    public void testSetGrisMax() {

    }

    /**
     * Test of getPixels method, of class ImagePGM.
     */
    @Test
    public void testGetPixels() {

    }

    /**
     * Test of setPixels method, of class ImagePGM.
     */
    @Test
    public void testSetPixels() {

    }

    /**
     * Test of ecrirePGM method, of class ImagePGM.
     *
     * @throws java.io.IOException
     */
    @Test

    public void testEcrirePGM() throws IOException{

        System.out.println("ecrirePGM");


        int longueur = 1 + (int) ((Integer.MAX_VALUE)*Math.random());
        int hauteur = 1 + (int) ((Integer.MAX_VALUE)*Math.random());
        int v;
        ImagePGM image = new ImagePGM(longueur,hauteur,255);
        for(int i=0; i<longueur; i++)
        {
            for(int j=0; j<hauteur;j++)
            {
                v = 1 + (int) (255*Math.random());

                image.getPixels().get(i).add(j, v);
            }
        }
        image.ecrirePGM("imageEcrite");
        ImagePGM imageEcrite = new ImagePGM("imageEcrite");
        assertTrue(imageEcrite.equals(image));
    }

    /**
     * Test of seuiller method, of class ImagePGM.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSeuiller() throws Exception {
        System.out.println("seuiller");
        ImagePGM image = new ImagePGM("lena");
        int s = 0 + (int) (255 * Math.random());
        int i = 0 + (int) ((image.getL() - 1) * Math.random());
        int j = 0 + (int) ((image.getH() - 1) * Math.random());
        boolean b1 = image.seuiller(s).getPixels().get(i).get(j) == 255 && image.getPixels().get(i).get(j) >= s;
        boolean b2 = image.seuiller(s).getPixels().get(i).get(j) == 0 && image.getPixels().get(i).get(j) < s;
        assertTrue(b1 || b2);
    }

    /**
     * Test of histogramme method, of class ImagePGM.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testHistogramme() throws IOException {
        System.out.println("histogramme");
        ImagePGM image = new ImagePGM("lena");
        ImagePGM histo = image.histogramme();
        int a = 0;
        int b = 0;
        int i = 0 + (int) (255 * Math.random());
        for (int j = 0; j < histo.getH(); j++) {
            if (histo.getPixels().get(i).get(j) == 255) {
                a++;
            }
        }
        for (int k = 0; k < image.getL(); k++) {
            for (int j = 0; j < image.getH(); j++) {
                if (image.getPixels().get(k).get(j) == i) {
                    b++;
                }
            }
        }
        assertTrue(a == b);
    }
}
