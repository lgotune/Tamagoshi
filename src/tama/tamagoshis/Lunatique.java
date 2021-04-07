/**
 *
 */
package tama.tamagoshis;

/**
 * @author fab
 *
 */
public class Lunatique extends Tamagoshi {

    /**
     * Constructeur tamagoshi de type lunatique
     * @param name
     */
    public Lunatique(String name) {
        super(name);
    }

    /**
     * Consommer le fun d'un lunatique
     * @see Tamagoshi#consommeEnergy()
     */
    @Override
    public boolean consommeEnergy() {
        if (generateur.nextBoolean())
            energy--;
        return super.consommeEnergy();
    }

    /**
     * Consommer le fun d'un lunatique
     * @see Tamagoshi#consommeFun()
     */
    @Override
    public boolean consommeFun() {
        if (generateur.nextBoolean())
            setFun(getFun() - 1);
        return super.consommeFun();
    }

}
