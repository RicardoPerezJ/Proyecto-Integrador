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
public class Premio {
    
    private int x,y; 
    private ImageIcon premio;
    private boolean recolectado;

    public Premio() {
        recolectado = false;
        premio = new ImageIcon("./src/main/resources/Premio.png");
    }

    public Premio(int x, int y, ImageIcon premio) {
        this.x = x;
        this.y = y;
        this.premio = premio;
        
    }

    public boolean isRecolectado() {
        return recolectado;
    }

    public void setRecolectado(boolean recolectado) {
        this.recolectado = recolectado;
    }
    
    public void recolectar (){
        
        this.recolectado = true;
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

    public ImageIcon getPremio() {
        return premio;
    }

    public void setPremio(ImageIcon premio) {
        this.premio = premio;
    }
     
    
    
}
