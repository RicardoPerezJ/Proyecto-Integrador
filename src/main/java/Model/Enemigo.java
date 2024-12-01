/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Ricardo
 */
public class Enemigo {

    private int posX, posY;

    ImageIcon enemigo, enemigo2;

    public Enemigo() {
        enemigo = new ImageIcon("./src/main/resources/Enemigo2.png");
        enemigo2 = new ImageIcon("./src/main/resources/Enemigo1.png");

    }

    public Enemigo(int posX, int posY, ImageIcon enemigo) {
        this.posX = posX;
        this.posY = posY;
        this.enemigo = enemigo;
        this.enemigo2 = enemigo2;
    }
    

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public ImageIcon getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(ImageIcon enemigo) {
        this.enemigo = enemigo;
    }

    public ImageIcon getEnemigo2() {
        return enemigo2;
    }

    public void setEnemigo2(ImageIcon enemigo2) {
        this.enemigo2 = enemigo2;
    }

    //Colisiones del enemigo
    public void moverEnemigo() {
        int nuevaX = posX;
        int nuevaY = posY;
        Random aleatorio = new Random(); //Mueve el enemigo de forma aleatoria. rango 1 a 4
        int direccion = aleatorio.nextInt(4) + 1;
        switch (direccion) {
            case 1: //Arriba
                nuevaY = posY - 1;
                break;
            case 2: //Abajo
                nuevaY = posY + 1;
                break;
            case 3: //Derecha
                nuevaX = posX + 1;
                break;
            case 4: //Izquierda
                nuevaX = posX - 1;
                break;
        }

        int valorLab = new Bounds().getLimites()[nuevaY][nuevaX];

        if (valorLab == 0) {
            posX = nuevaX;
            posY = nuevaY;
        }
    }

}
