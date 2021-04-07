package dessin;

import java.awt.*;

/**
 * The Class Cercle.
 */
public class Cercle extends ObjetGraphique {

    private Point centre;
    private int rayon;

    public Cercle(){
        centre=new Point();
        rayon=0;
    }
    public Cercle(Point centre,int rayon){
        this.centre=centre;
        this.rayon=rayon;
    }

    public Cercle(Point centre,int rayon,Color couleur){
        super(couleur);
        this.centre=centre;
        this.rayon=rayon;
    }

    public void setLocation(Point p){
        centre=p;
    }
    public void setRayon(int r){
        rayon=r;
    }

    public Point getLocation(){
        return(centre);
    }

    public int getRayon(){
        return(rayon);
    }

    public void dessineToi(Graphics g){
        super.dessineToi(g);
        g.drawOval(centre.x-rayon,centre.y-rayon,rayon*2,rayon*2);
    }

    public boolean contient(int vx,int vy){
        int dx,dy,d;
        dx=vx-centre.x;
        dy=vy-centre.y;
        d=dx*dx+dy*dy;
        return( d<=(rayon*rayon));
    }

}