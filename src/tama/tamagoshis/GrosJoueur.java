package tama.tamagoshis;

public class GrosJoueur extends Tamagoshi {

    /**
     * Constructeur tamagoshi de type gros joueur
     * @param name
     */
    public GrosJoueur(String name) {
        super(name);
    }

    /**
     * Consommer le fun d'un gros joueur
     * @return
     */
    @Override
    public boolean consommeFun() {
        setFun(getFun()-1);
        return super.consommeFun();
    }

}
