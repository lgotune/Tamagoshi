package dessin;

import java.awt.*;

public class Rectangle extends ObjetGraphique{
    private java.awt.Rectangle rec;

    public Rectangle(int x, int y, int largeur, int hauteur) {
        rec=new java.awt.Rectangle(x,y,largeur,hauteur);
    }

    public Rectangle(Point p, int largeur,int hauteur) {
        this(p.x,p.y,largeur, hauteur);
    }

    public Rectangle(Point p, int largeur,int hauteur,Color c) {
        this(p.x,p.y,largeur, hauteur);
        setColor(c);
    }

    @Override
    public void dessineToi(Graphics g) {
        super.dessineToi(g);
        g.drawRect(rec.x,rec.y,rec.width,rec.height);
    }

    @Override
    public boolean contient(int x, int y) {
        return rec.contains(x, y);
    }
}
