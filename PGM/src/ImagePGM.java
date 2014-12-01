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
import java.io.*;

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
    public ImagePGM(String texte) {
        Reader reader = new FileReader(texte + ".pgm");
        BufferReader in = new BufferReader(reader);
        String ligne = in.readline();

        int n;
        n = 0;
        while (ligne
                != null) {

            String delimiteur = " ";
            StringTokenizer st = new StringTokenizer(ligne, delimiteur);
            ArrayList<Integer> mots = new ArrayList<Integer>();
            if (n = 3) {
                this.l = Integer.parseInt(st.nextToken());
                this.h = Integer.parseInt(st.nextToken());
            }
            if (n = 4) {
                this.grisMax = Integer.parseInt(st.nextToken());
            }
            if (n >= 5) {
                while (st.hasMoreTokens()) {

                    Integer mot = Integer.parseInt(st.nextToken());

                    mots.add(pix);
                }

            }
            this.pixels.add(mots);
            n++;
        }
    }

// ecrire une image PGM
    public void ecrirePGM(String nom) throws IOException {
        Writer writer = new FileWriter(nom + ".pgm");
        writer.write("P2" + "\n");
        writer.write("#" + "\n");
        writer.write(l + " " + h + "\n");
        writer.write(grisMax + "\n");

        for (ArrayList<Integer> l : this.pixels) {
            for (int i : l) {
                writer.write(i + " ");
            }
            writer.write("\n");
            writer.flush();
        }
        writer.close();

    }

}
