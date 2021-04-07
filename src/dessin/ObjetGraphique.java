package dessin;

import java.awt.*;

public abstract class ObjetGraphique {

    private Color couleur;
    private boolean visible;

    public ObjetGraphique(){
        this(Color.black);
        visible = true;
    }

    public ObjetGraphique(Color coul){
        couleur=coul;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setColor(Color coul){ couleur=coul;}

    public Color getColor() { return(couleur);}

    public void dessineToi(Graphics graph){
        graph.setColor(getColor());
    }

    public abstract boolean contient(int a,int b);
}
