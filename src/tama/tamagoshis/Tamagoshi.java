package tama.tamagoshis;

import java.util.Random;

public class Tamagoshi {

    private String etatDuTamagoshi;
    private String name;
    protected Random generateur;
    private int age;
    private int maxEnergy;
    private int maxFun;
    private int fun;
    public int getFun() {
        return fun;
    }

    public void setFun(int fun) {
        this.fun = fun;
    }

    protected int energy;
    private static int lifeTime = 5;

    /**
     * @param name Tamagoshi's name
     */
    public Tamagoshi(String name) {
        this.name = name;
        generateur = new Random();
        age = 0;
        maxEnergy = generateur.nextInt(5) + 5;
        maxFun = generateur.nextInt(5) + 5;
        energy = generateur.nextInt(5) + 3;
        fun = generateur.nextInt(5) + 3;
    }

    public String parler(){
        return etatDuTamagoshi;
    }


    public void parle() // Exo 16
    {
        String etat = "";
        if (energy < 5)
            etat += "je suis affamé";
        if (fun < 5) {
            if (!etat.isEmpty())
                etat += " et ";
            etat += "je m'ennuie à mourrir";
        }
        if (etat.isEmpty()) {
            etat = "Tout va bien !";
        } else {
            etat = etat + " !";
        }
        etatDuTamagoshi = etat;

    }

    public String renvoyerEtat(){
        return this.etatDuTamagoshi;
    }

    /*private void parler(String phrase) {
        System.out.println("\n\t" + name + " : \"" + phrase + "\"");
    }*/

    public boolean mange() { // Exo 4
        if (energy < maxEnergy) {
            energy += generateur.nextInt(3) + 1;
            etatDuTamagoshi = "C'est trop bon !";
            return true;
        } else {
            etatDuTamagoshi = "Pas  faim !!";
            return false;
        }
    }

    public boolean vieillit() { // Exo 5
        age++;
        return age == getLifeTime();
    }

    public boolean consommeEnergy() { // Exo 6
        energy--;
        if (energy <= 0) {
            etatDuTamagoshi = "J'ai subi le manque de nourriture X_X";
            return false;
        }
        return true;
    }

    public boolean consommeFun() { // Exo 6
        fun--;
        if (fun <= 0) {
            etatDuTamagoshi = "Je suis triiiiiiiiste X_X";
            return false;
        }
        return true;
    }

    /**
     * @return Returns the age.
     */
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /**
     * @return Returns the lifeTime.
     */
    public static int getLifeTime() {
        return lifeTime;
    }

    public boolean joue() {
        if (fun < maxFun) {
            fun += generateur.nextInt(3) + 1;
            etatDuTamagoshi = "C'est drôle !";
            return true;
        } else {
            etatDuTamagoshi = "Laisse-moi tranquille, je fais du Java !!";
            return false;
        }
    }

    public String toString() {
        return name + " : energy=" + energy + ", fun=" + fun;
    }

    public boolean isAlive() {
        return fun > 0 && energy > 0 && age <= getLifeTime();
    }

}
