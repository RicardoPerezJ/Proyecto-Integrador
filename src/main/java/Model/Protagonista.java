/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author Ricardo
 */
public class Protagonista {

    private int x, y, vida;

    ImageIcon prota;

    String atras, frente, derecha, izquierda;

    public Protagonista(int x, int y) {
        
        vida = 3;

        this.x = x;
        this.y = y;
        prota = new ImageIcon("./src/main/resources/protagonistaDerecha.png");

        atras = "./src/main/resources/protagonistaAtras.png";
        derecha = "./src/main/resources/protagonistaDerecha.png";
        izquierda = "./src/main/resources/protagonistaIzquierda.png";
        frente = "./src/main/resources/Protagonista.png";
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    

    public String getAtras() {
        return atras;
    }

    public void setAtras(String atras) {
        this.atras = atras;
    }

    public String getFrente() {
        return frente;
    }

    public void setFrente(String frente) {
        this.frente = frente;
    }

    public String getDerecha() {
        return derecha;
    }

    public void setDerecha(String derecha) {
        this.derecha = derecha;
    }

    public String getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(String izquierda) {
        this.izquierda = izquierda;
    }

    public void setProta(String prota) {
        this.prota = new ImageIcon(prota);
    }

    public ImageIcon getProta() {
        return prota;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void perderVida (){
        setVida(getVida()-1);
    }
    
    public void restaurarVida (){
        setVida(3);
    }

    public void mover(int x, int y) {
        int valorMatriz = new Bounds().getLimites()[getY() + y][getX() + x];
       // System.out.println("x: " + this.x + "y: " + this.y); //Para comprobar la posicion en consola
        //System.out.println(valorMatriz);

        if (valorMatriz == 0) { //Si la casilla es 0 se actualiza su posicion
            setX(getX()+x);
            setY(getY()+y);
        }

    }

}
