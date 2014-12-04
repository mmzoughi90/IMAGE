package pgm;

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
        if(l*h==0)
        {
            pixels = null;
        }
        pixels = new ArrayList<>();
        int i, j;
        for (i = 0; i < l; i++) {
            ArrayList colonne = new ArrayList();
            pixels.add(colonne);
            for (j = 0; j < h; j++) {

                pixels.get(i).set(j, 0);
            }
        }
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
    public ImagePGM(String texte) throws IOException {
        pixels = new ArrayList<>();
        Reader reader = new FileReader(texte + ".pgm");
        BufferedReader in = new BufferedReader(reader);
        String ligne = in.readLine();

        int n;
        n = 1;
        while (ligne != null) {

            String delimiteur = " \t";
            StringTokenizer st = new StringTokenizer(ligne, delimiteur);
            ArrayList<Integer> mots = new ArrayList<>();
            if (n == 3) {
                this.l = Integer.parseInt(st.nextToken());
                this.h = Integer.parseInt(st.nextToken());
            }
            if (n == 4) {
                this.grisMax = Integer.parseInt(st.nextToken());
            }
            if (n >= 5) {
                while (st.hasMoreTokens()) {

                    Integer mot = Integer.parseInt(st.nextToken());

                    mots.add(mot);
                }

                this.pixels.add(mots);
            }
            n++;
            ligne = in.readLine();
        }
    }

// ecrire une image PGM
    public void ecrirePGM(String nom) throws IOException {
        Writer writer = new FileWriter(nom + ".pgm");
        writer.write("P2" + "\n");
        writer.write("#" + "\n");
        writer.write(l + " " + h + "\n");
        writer.write(grisMax + "\n");
        if (pixels != null) {
            System.out.println("qdfsdfsg");
            for (ArrayList<Integer> ln : this.pixels) {
                for (int i : ln) {
                    writer.write(i + "\t");
                }
                writer.write("\n");
                writer.flush();
            }
        }
        writer.close();

    }

    public ImagePGM seuiller(int s) throws CloneNotSupportedException {
        int i, j;
        ImagePGM seuillage = (ImagePGM) this.clone();
        for (i = 0; i < l; i++) {
            for (j = 0; j < h; j++) {
                if ((int) pixels.get(i).get(j) <= s) {
                    seuillage.pixels.get(i).set(j, 0);
                } else {
                    seuillage.pixels.get(i).set(j, 255);
                }
            }
        }
        return seuillage;
    }

    public ImagePGM histogramme() {
        ArrayList vectHisto = new ArrayList();
        int i, j;
        int h=0;
        for (i = 0; i < 256; i++) {
            vectHisto.add(i, 0);
        }
        for (i = 0; i < l; i++) {
            for (j = 0; j < h; j++) {
                vectHisto.set((int) pixels.get(i).get(j), (int) vectHisto.get((int) pixels.get(i).get(j)) + 1);
            }
        }
        for (i = 0; i < 256; i++) {
            if (h < (int) vectHisto.get(i)) {
                h=(int) vectHisto.get(i);
            }
        }
        ImagePGM histo = new ImagePGM(256, h, 255);
        for (i = 0; i < 256; i++) {
            for (j = h - (int) vectHisto.get(i); j < h; j++) {
                histo.pixels.get(i).set(j, 255);
            }
        }
        return histo;
    }

}
