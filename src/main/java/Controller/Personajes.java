/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bounds;
import Model.Enemigo;
import Model.Premio;
import Model.Protagonista;

/**
 *
 * @author Ricardo
 */
public class Personajes {

    private Protagonista protagonista;
    private Bounds bounds;
    private Enemigo enemigo;
    private Premio premio;

    public Personajes() {
        bounds = new Bounds();
        protagonista = new Protagonista(1, 2);
        
        premio = new Premio();

        enemigo = new Enemigo();
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;
    }

    public Protagonista getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Protagonista protagonista) {
        this.protagonista = protagonista;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }
    

}
