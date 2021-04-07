package tama;

import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import javax.swing.*;
        import dessin.Cercle;
        import dessin.ObjetGraphique;
        import dessin.Rectangle;
        import tama.tamagoshis.Tamagoshi;

public class TamaJPanel extends JPanel {

    private List<Color> listeCouleurs;
    private ArrayList<ObjetGraphique> listeFigures;
    private Cercle oeilGauche, oeilDroit, tete;
    private Rectangle bouche;

    /** Constructeur TamaJPanel */
    public TamaJPanel() {
        oeilGauche = new Cercle(new Point(160,150),20);
        oeilDroit = new Cercle(new Point(240,150),20);
        tete = new Cercle(new Point(200,200),100);
        bouche = new Rectangle(new Point(150,220),100,40);
        listeCouleurs = Arrays.asList(Color.BLACK,Color.BLUE,Color.GREEN,Color.RED,Color.ORANGE,Color.WHITE);
        listeFigures = new ArrayList<ObjetGraphique>(Arrays.asList(oeilDroit,oeilGauche,bouche,tete));
    }

    /** Afficher les formes */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(ObjetGraphique og : listeFigures){
            if (og.getVisible()) {
                og.dessineToi(g);
            }
        }
    }


}