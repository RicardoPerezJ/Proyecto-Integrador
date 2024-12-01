/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.Personajes;
import Model.Bounds;
import Model.Enemigo;
import Model.Premio;
import Model.Protagonista;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class Laberinto extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Laberinto
     */
    private Protagonista protagonista;
    private Enemigo enemigo;
    private Bounds laberinto;
    private Personajes personajes;
    private ImageIcon muro;
    private ImageIcon camino;
    private ImageIcon[] arregloImagenes;
    private ArrayList<Enemigo> enemigos;
    private ArrayList<Premio> premios;
    private int premiosObtenidos;
    private Thread hilo;
    private boolean reiniciar;
    private String txt;

    public Laberinto() {

        initComponents();

        txt = "";
        reiniciar = false;

        enemigos = new ArrayList();
        premios = new ArrayList();

        personajes = new Personajes();

        laberinto = new Bounds();

        arregloImagenes = new ImageIcon[2];

        arregloImagenes[1] = new ImageIcon("./src/main/resources/pisoo.png");
        arregloImagenes[0] = new ImageIcon("./src/main/resources/muroo.png");

        muro = new ImageIcon("./src/main/resources/muroo.png");
        camino = new ImageIcon("./src/main/resources/pisoo.png");

        protagonista = new Protagonista(2, 3);
        enemigos.add(new Enemigo(7, 7, personajes.getEnemigo().getEnemigo()));
        enemigos.add(new Enemigo(7, 7, personajes.getEnemigo().getEnemigo2()));

        premios.add(new Premio(18, 21, personajes.getPremio().getPremio()));
        premios.add(new Premio(5, 14, personajes.getPremio().getPremio()));
        premios.add(new Premio(21, 21, personajes.getPremio().getPremio()));

        hilo = new Thread(this);
        hilo.start();

        this.setPreferredSize(new Dimension(1080, 810));

        setLayout(null);

    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public boolean isReiniciar() {
        return reiniciar;
    }

    public void setReiniciar(boolean reiniciar) {
        this.reiniciar = reiniciar;
    }

    public Protagonista getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Protagonista protagonista) {
        this.protagonista = protagonista;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigoUno(Enemigo enemigoUno) {
        this.enemigo = enemigoUno;
    }

    public Enemigo getEnemigoDos() {
        return enemigo;
    }

    public void setEnemigoDos(Enemigo enemigoDos) {
        this.enemigo = enemigoDos;
    }

    public Bounds getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(Bounds laberinto) {
        this.laberinto = laberinto;
    }

    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        int size = 34;

        super.paintComponents(g);
        int indiceImg = 0;
        for (var y = 0; y < laberinto.getLimites().length; y++) {
            for (int x = 0; x < laberinto.getLimites()[y].length; x++) {
                indiceImg = laberinto.getLimites()[y][x];
                g.drawImage(arregloImagenes[indiceImg].getImage(), x * size, y * size, size, size, this);

            }
        }

        g.drawImage(getProtagonista().getProta().getImage(), getProtagonista().getX() * size, getProtagonista().getY() * size, this);

        int x, y;
        for (int i = 0; i < enemigos.size(); i++) {
            x = enemigos.get(i).getPosX();
            y = enemigos.get(i).getPosY();
            g.drawImage(enemigos.get(i).getEnemigo().getImage(), x * size, y * size, this);

            if (protagonista.getX() == enemigos.get(i).getPosX() && protagonista.getY() == enemigos.get(i).getPosY()) {
                personajes.getProtagonista().perderVida();

                setTxt("!Recibiste daño¡");

                if (personajes.getProtagonista().getVida() <= 0) {
                    
                    reiniciar();
                }
                System.out.println("Vidas: " + personajes.getProtagonista().getVida());
            }

        }

        for (int i = 0; i < premios.size(); i++) {
            x = premios.get(i).getX();
            y = premios.get(i).getY();
            g.drawImage(premios.get(i).getPremio().getImage(), x * size, y * size, this);

            for (Premio premios : premios) {

                if (!premios.isRecolectado() && protagonista.getX() == premios.getX() && protagonista.getY() == premios.getY()) {
                    premios.recolectar();
                    premiosObtenidos++;
                    setTxt("Conseguiste una pelicula \n\n");

                    this.premios.remove(premios);

                    if (premiosObtenidos == 3) {

                        setTxt("Tienes todas las peliculas \n"+"Es hora de irse");

                    }

                }

            }

        }

    }

    public void reiniciar() {
        
        setTxt("Haz perdido");
        protagonista = new Protagonista(2, 3);
        protagonista.restaurarVida();
        premiosObtenidos = 0;
        premios = new ArrayList();

        premios.add(new Premio(18, 21, personajes.getPremio().getPremio()));
        premios.add(new Premio(5, 14, personajes.getPremio().getPremio()));
        premios.add(new Premio(21, 21, personajes.getPremio().getPremio()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        while (hilo != null) {
            try {
                reEscribir();
                repaint();
                hilo.sleep(300);

            } catch (InterruptedException ex) {
                Logger.getLogger(Laberinto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void iniciarHilo() {
        hilo.start();

    }

    public void reEscribir() {
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).moverEnemigo();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
