/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Sandun Rajitha
 */
public class Cell extends JLabel{
    
    public Cell(int jobNo){
        //setLocation(0, y);
        setPreferredSize(new Dimension(11, 100));
        setFont(new Font("Serif", Font.BOLD, 10));
        setCellInfo(jobNo);
        setOpaque(true);
    }
    
    public void setCellInfo(int jobNo){
        setForeground(Color.BLACK);   // view job number in white on the label
        setHorizontalAlignment(CENTER);  // view job number in the center of the label
        switch(jobNo)
        {   
            case 0: setBackground(Color.GRAY); setText("null"); break;
            case 1: setBackground(Color.decode("#F44336")); setText("1"); break;
            case 2: setBackground(Color.decode("#512DA8")); setText("2"); break;
            case 3: setBackground(Color.decode("#3F51B5")); setText("3"); break;
            case 4: setBackground(Color.decode("#03A9F4")); setText("4"); break;
            case 5: setBackground(Color.decode("#4CAF50")); setText("5"); break;
            case 6: setBackground(Color.decode("#FFC107")); setText("6"); break;
            case 7: setBackground(Color.decode("#FF5722")); setText("7"); break;
            case 8: setBackground(Color.decode("#607D8B")); setText("8"); break;
            case 9: setBackground(Color.decode("#CDDC39")); setText("9"); break;
            case 10: setBackground(Color.decode("#E91E63")); setText("10"); break;
            
            case 11: setBackground(Color.WHITE);  setText(" "); break; // empty job 
            case 12: setBackground(Color.BLACK); break;// 10 jobs mark
            
        }
    }
}
