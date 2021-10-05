package Controller;

import Model.ClsReference;
import Model.ClsVideogame;
import View.FrmVideoClub;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 *
 * @author anarvaezgo
 */
public class ControllerAddProduct implements  ActionListener , KeyListener{
    
    private FrmVideoClub frmvideoclub;
    private ClsVideogame videogame;
    private ArrayList<ClsVideogame> arraysvideogame;
    
    
    public ControllerAddProduct(){
        this.frmvideoclub = new FrmVideoClub();
        this.videogame= new ClsVideogame();
        this.arraysvideogame = new ArrayList<ClsVideogame>();
    }
    
    public void startMain(){
        this.frmvideoclub.setTitle("Video Club");
        this.frmvideoclub.setLocationRelativeTo(null);
        this.frmvideoclub.getPanels().setSelectedIndex(1);
        this.frmvideoclub.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
}
