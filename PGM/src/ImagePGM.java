/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mzoughi
 */
import java.util.*;
import java.awt.*;

public class ImagePGM {
    private int l;
    private int h;
    private int grisMax;
    private ArrayList<ArrayList<Integer>> pixels;

    public ImagePGM(int l, int h, int grisMax) {
        this.l = l;
        this.h = h;
        this.grisMax = grisMax;
        pixels = new ArrayList<ArrayList<Integer>>();
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getGrisMax() {
        return grisMax;
    }

    public void setGrisMax(int grisMax) {
        this.grisMax = grisMax;
    }

    public ArrayList<ArrayList<Integer>> getPixels() {
        return pixels;
    }

    public void setPixels(ArrayList<ArrayList<Integer>> pixels) {
        this.pixels = pixels;
    }
    
    
    // méthode permettant la lecture d'un PGM
    public ImagePGM(String texte){
        Reader reader = new FileReader(texte+".pgm");
        BufferReader in = new BufferReader(reader);
        String ligne = in.readline();
        
        n=O;
        while (ligne!=0) {
            String delimiteur = " ";
            StringTokenizer st= new StringTokenizer(ligne,delimiteur);
            ArrayList<Integer> pixelsHoriz = new ArrayList<Integer>();
            while (st.hasMoreTokens()) {
            String mot = st.nextToken;
            pixelsHoriz.add()
            
        }
        }
    }
            
    
}
