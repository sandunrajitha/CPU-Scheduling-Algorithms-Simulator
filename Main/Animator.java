/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JButton;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandun Rajitha
 */
public class Animator extends Thread {

    JButton btn;
    public boolean allJobsDone = false;
    
    public Animator() {
    }

    public Animator(JButton btn) {
        this.btn = btn;
    }

    public void setAllJobsDone(boolean allJobsDone) {
        this.allJobsDone = allJobsDone;
    }
    
    

    @Override
    public void run(){
        try {

            while (!allJobsDone) {
                btn.doClick();
                Thread.sleep(500);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Animator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
