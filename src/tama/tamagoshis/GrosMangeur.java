package tama.tamagoshis;

public class GrosMangeur extends Tamagoshi {

    /**
     * Constructeur tamagoshi de type gros mangeur
     * @param name
     */
    public GrosMangeur(String name) {
        super(name);
    }

    /**
     * Consommer le fun d'un gros mangeur
     * @return
     */
    @Override
    public boolean consommeFun() {
        energy--;
        return super.consommeFun();
    }
}
