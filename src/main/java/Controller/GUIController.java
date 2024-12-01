/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Protagonista;
import View.FrameHistoria;
import View.FrameInstrucciones;
import View.FrameLaberinto;
import View.FrameMenu;
import View.Laberinto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Ricardo
 */
public class GUIController implements ActionListener, KeyListener {

    private FrameMenu frameMenu;
    private Personajes personajes;
    private Laberinto laberinto;

    public GUIController() {

        frameMenu = new FrameMenu();

        laberinto = new Laberinto();

        personajes = new Personajes();

        frameMenu.setVisible(true);

        this.frameMenu.listenerButton(this);
        this.frameMenu.playPanel().listenKey(this);

    }

    public FrameMenu getFrameMenu() {
        return frameMenu;
    }

    public void setFrameMenu(FrameMenu frameMenu) {
        this.frameMenu = frameMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Play":
                frameMenu.playPanel().setVisible(true);
                frameMenu.setVisible(false);
                frameMenu.playPanel().panelLab().setFocusable(true);
                break;

            case "Instrucciones":
                frameMenu.instruccionesPanel().setVisible(true);
                frameMenu.setVisible(false);
                break;

            case "Historia":
                frameMenu.historiaPanel().setVisible(true);
                frameMenu.setVisible(false);
                break;

            case "Salir":
                System.exit(0);
                break;

            case "Regresar":
                frameMenu.historiaPanel().setVisible(false);
                frameMenu.instruccionesPanel().setVisible(false);
                frameMenu.playPanel().setVisible(false);

                frameMenu.setVisible(true);

                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int dx = 0, dy = 0;
        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP -> {
                dy = -1;
                frameMenu.playPanel().panelLab().getProtagonista().setProta(frameMenu.playPanel().panelLab().getProtagonista().getAtras());
                frameMenu.playPanel().getMensajesLabel().setText(frameMenu.playPanel().panelLab().getTxt());

                frameMenu.playPanel().panelLab().getProtagonista().mover(dx, dy);
                frameMenu.playPanel().panelLab().repaint();

            }
            case KeyEvent.VK_DOWN -> {
                dy = 1;

                frameMenu.playPanel().panelLab().getProtagonista().setProta(frameMenu.playPanel().panelLab().getProtagonista().getFrente());
                frameMenu.playPanel().getMensajesLabel().setText(frameMenu.playPanel().panelLab().getTxt());
                frameMenu.playPanel().panelLab().getProtagonista().mover(dx, dy);
                frameMenu.playPanel().repaint();

            }
            case KeyEvent.VK_LEFT -> {
                dx = -1;

                frameMenu.playPanel().panelLab().getProtagonista().setProta(frameMenu.playPanel().panelLab().getProtagonista().getIzquierda());
                frameMenu.playPanel().getMensajesLabel().setText(frameMenu.playPanel().panelLab().getTxt());
                frameMenu.playPanel().panelLab().getProtagonista().mover(dx, dy);
                frameMenu.playPanel().repaint();
            }
            case KeyEvent.VK_RIGHT -> {
                dx = 1;

                frameMenu.playPanel().panelLab().getProtagonista().setProta(frameMenu.playPanel().panelLab().getProtagonista().getDerecha());
                frameMenu.playPanel().getMensajesLabel().setText(frameMenu.playPanel().panelLab().getTxt());
                frameMenu.playPanel().panelLab().getProtagonista().mover(dx, dy);
                frameMenu.playPanel().repaint();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
