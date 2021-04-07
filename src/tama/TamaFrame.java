package tama;


import tama.tamagoshis.Tamagoshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class TamaFrame extends javax.swing.JFrame implements ActionListener {

    private Utilisateur utilisateur;

    private JButton boutonNourrir,boutonJouer;
    private TamaJPanel tamaPanel;
    private JPanel boutons, zoneTexte;
    private JTextArea leDialogueDuTamagoshi;
    private TamaGame jeuEnCours;
    private Tamagoshi tamago;

    /** Constructeur TamaFrame */
    public TamaFrame(TamaGame jeu){
        tamago = null;
        leDialogueDuTamagoshi = new JTextArea();
        boutonNourrir = new JButton("Nourrir");
        boutonJouer = new JButton("Jouer");

        tamaPanel = new TamaJPanel();
        boutons = new JPanel(new FlowLayout());
        zoneTexte = new JPanel(new FlowLayout());

        boutons.add(boutonNourrir);
        boutons.add(boutonJouer);
        zoneTexte.add(leDialogueDuTamagoshi);

        boutonNourrir.addActionListener(this);
        boutonJouer.addActionListener(this);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.SOUTH,boutons);
        getContentPane().add(BorderLayout.CENTER,tamaPanel);
        getContentPane().add(BorderLayout.NORTH,zoneTexte);


        this.jeuEnCours = jeu;
    }
    /** Faire parler le tamagoshi */
    public void leTamagoshiParle(){
        this.tamago.parle();
        this.tamago.renvoyerEtat();
        this.leDialogueDuTamagoshi.setText(this.tamago.renvoyerEtat());
    }
    /** Retourner le tamagoshi */
    public Tamagoshi getTamago() {
        return tamago;
    }
    /** Modifier le tamagoshi */
    public void setTamago(Tamagoshi tamago) {
        this.tamago = tamago;
    }
    /** Retourner le bouton Nourrir */
    public JButton getBoutonNourrir() {
        return boutonNourrir;
    }
    /** Retourner le bouton Jouer */
    public JButton getBoutonJouer() {
        return boutonJouer;
    }

    /** Actions à l'appui des boutons */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boutonNourrir){
            tamago.mange();
            leTamagoshiParle();
            jeuEnCours.disableButtonOnFrame(boutonNourrir.getText());
        }
        else if (e.getSource() == boutonJouer){
            tamago.joue();
            leTamagoshiParle();
            jeuEnCours.disableButtonOnFrame(boutonJouer.getText());
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {  }

    public void mouseReleased(MouseEvent e) {  }

    public void mouseEntered(MouseEvent e) {  }

    public void mouseExited(MouseEvent e) {   }

    /** Initialiser les frames */
    public void initialisationFrame(){
        this.setSize(400,400);
        this.setLocation(300,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(this.getTamago().getName());
        this.setVisible(true);
    }
    public static void main(String[] args) {

    }

}