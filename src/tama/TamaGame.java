package tama;

import tama.tamagoshis.GrosJoueur;
import tama.tamagoshis.GrosMangeur;
import tama.tamagoshis.Lunatique;
import tama.tamagoshis.Tamagoshi;
import tama.Utilisateur;

import javax.swing.*;
import java.util.*;

/**
 * un petit jeu avec des tamagoshis
 */
public class TamaGame {

    /** Liste initiale de tamagoshis */
    private List<Tamagoshi> allTamagoshis;
    /** Liste des tamagoshis vivants */
    private List<Tamagoshi> aliveTamagoshis;
    /** Liste des frames de tamagoshis */
    private List<TamaFrame> frameTamagoshis;
    /** Liste de noms pour les tamagoshis */
    private List<String> nameListe;
    /** Nombre de cycle */
    private int nbCycle;
    /** Sert à définir le nombre de boutons pour faire un cycle */
    private int num;
    /** Pop-up de résultat */
    private JOptionPane popup;

    /** Constructeur TamaGame */
    public TamaGame() {
        allTamagoshis = new ArrayList<>();
        aliveTamagoshis = new ArrayList<>();
        nameListe = new ArrayList<>();
        frameTamagoshis = new ArrayList<>();
        popup = new JOptionPane();
        nbCycle = 0;
        init();
    }

    /** Initialisation de la partie */
    public void init(){
        nameListe.addAll(Arrays.asList("Luffy","Zoro","Sanji","Ussopp","Nami","Chopper","Robin","Franky","Brook","Jinbe","Kaido","Linlin","Shanks","Newgate","Teach"));
        String value = JOptionPane.showInputDialog("Combien de tamagoshi joue ?");
        int n = Integer.parseInt(value);
        for (int i = 0; i < n; i++) {
            TamaFrame tf = new TamaFrame(this);
            if(Math.random() > 0.5){
                double r = Math.random();
                if(r < 0.33){
                    GrosJoueur gj = new GrosJoueur(nameListe.remove((int)(Math.random() * nameListe.size())));
                    allTamagoshis.add(gj);
                    tf.setTamago(gj);
                    frameTamagoshis.add(tf);
                }else if(r > 0.33 && r < 0.66){
                    GrosMangeur gm = new GrosMangeur(nameListe.remove((int)(Math.random() * nameListe.size())));
                    allTamagoshis.add(gm);
                    tf.setTamago(gm);
                    frameTamagoshis.add(tf);
                }else{
                    Lunatique l = new Lunatique(nameListe.remove((int)(Math.random() * nameListe.size())));
                    allTamagoshis.add(l);
                    tf.setTamago(l);
                    frameTamagoshis.add(tf);
                }
            }else{
                Tamagoshi t = new Tamagoshi(nameListe.remove((int)(Math.random() * nameListe.size())));
                allTamagoshis.add(t);
                tf.setTamago(t);
                frameTamagoshis.add(tf);
            }
        }
        for (TamaFrame tf :frameTamagoshis) {
            tf.initialisationFrame();
            tf.leTamagoshiParle();
        }
        aliveTamagoshis.addAll(allTamagoshis);
    }

    public void enableAllButtons(){
        for (TamaFrame tf:frameTamagoshis) {
            if(tf.getTamago().isAlive()){
                if (num % 2 == 0) {
                    tf.getBoutonNourrir().setEnabled(true);
                    tf.getBoutonJouer().setEnabled(true);
                    num = 0;
                }
            }else{
                tf.getBoutonNourrir().setEnabled(false);
                tf.getBoutonJouer().setEnabled(false);
            }

        }
        System.out.println(num);
        finTour();
    }


    /** Gérer la fin du tour */
    public void finTour(){
        for (Iterator<TamaFrame> iterator = frameTamagoshis.iterator(); iterator.hasNext();) {
            TamaFrame t = iterator.next();
            if (!t.getTamago().consommeEnergy() || !t.getTamago().consommeFun() || t.getTamago().vieillit())
                aliveTamagoshis.remove(t.getTamago());
            if (aliveTamagoshis.isEmpty() || nbCycle == Tamagoshi.getLifeTime()){
                t.getBoutonJouer().setEnabled(false);
                t.getBoutonNourrir().setEnabled(false);
                t.dispose();
            }

        }
        if (aliveTamagoshis.isEmpty() || nbCycle == Tamagoshi.getLifeTime()){
            JOptionPane.showMessageDialog(null,resultat(),"",JOptionPane.INFORMATION_MESSAGE);
            frameTamagoshis.clear();
        }
    }

    /**
     * Gérer l'activation des boutons pendant le tour
     * @param nomDuBouton
     */
    public void disableButtonOnFrame(String nomDuBouton){
        for (TamaFrame tf:frameTamagoshis) {
            if(tf.getBoutonJouer().getText().equals(nomDuBouton)){
                tf.getBoutonJouer().setEnabled(false);
            }else if(tf.getBoutonNourrir().getText().equals(nomDuBouton)) {
                tf.getBoutonNourrir().setEnabled(false);
            }
        }
        if(num<2){
            num++;
        }else{
            num = 0;

        }
        if(num == 0){nbCycle ++;}
        enableAllButtons();
        for (TamaFrame tf:frameTamagoshis) {
            tf.leTamagoshiParle();
        }
    }

    /*@SuppressWarnings("unchecked")
    private void initialisation() {
        System.out.println("Entrez le nombre de tamagoshis désiré !");
        int n = 0;
        while (n < 1) {
            System.out.println("Saisisez un nombre > 0 :");
            try {
                n = Integer.parseInt(Utilisateur.saisieClavier());
            } catch (NumberFormatException e) {
                System.out.println("Il faut saisir un nombre !");
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Entrez le nom du tamagoshi numéro " + i + " : ");
            if (Math.random() < .5)
                allTamagoshis.add(new GrosJoueur(Utilisateur.saisieClavier()));
            else
                allTamagoshis.add(new GrosMangeur(Utilisateur.saisieClavier()));

        }
//		aliveTamagoshis = (List<Tamagoshi>) allTamagoshis.clone();
        // ou encore pour le même résultat
        aliveTamagoshis = new ArrayList<Tamagoshi>(allTamagoshis);
    }*/



    private double score() {
        int score = 0;
        for (Tamagoshi t : allTamagoshis)
            score += t.getAge();
        return score * 100 / (Tamagoshi.getLifeTime() * allTamagoshis.size());
    }

    private String resultat() {
        String res = "";
        for (Tamagoshi t : allTamagoshis) {
            String classe = t.getClass().getSimpleName();
            if (!res.equals("")) {
                res = res + t.getName() + " qui était un " + classe + " ";
            }else{
                res = t.getName() + " qui était un " + classe + " ";
            }
            if(t.getAge() == Tamagoshi.getLifeTime()){
                res = res + " a survécu et vous remercie :)\n";
            }else{
                res = res + " n'est pas arrivé au bout et ne vous félicite pas :(\n";
            }
            System.out.println(res);
        }
        res = res + "niveau de difficulté : " + allTamagoshis.size() + ", score obtenu : " + score() + "%";
        return res;
    }

    /** Launch a new instance of the game */
    public static void main(String[] args) {
        TamaGame jeu = new TamaGame();
        //jeu.play();
    }

    @Override
    public String toString() {
        return "tamagame";
    }

}
