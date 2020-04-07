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
        setPreferredSize(new Dimension(12, 100));
        setFont(new Font("Serif", Font.BOLD, 10));
        setCellInfo(jobNo);
        setOpaque(true);
    }
    
    public void setCellInfo(int jobNo){
        setForeground(Color.WHITE);   // view job number in white on the label
        setHorizontalAlignment(CENTER);  // view job number in the center of the label
        switch(jobNo)
        {   
            case 0: setText(" "); break;
            case 1: setBackground(Color.decode("#ffab00")); setText("1"); break;
            case 2: setBackground(Color.decode("#2e7d32")); setText("2"); break;
            case 3: setBackground(Color.decode("#304ffe")); setText("3"); break;
            case 4: setBackground(Color.decode("#0091ea")); setText("4"); break;
            case 5: setBackground(Color.decode("#00bfa5")); setText("5"); break;
            case 6: setBackground(Color.decode("#64dd17")); setText("6"); break;
            case 7: setBackground(Color.decode("#ffd600")); setText("7"); break;
            case 8: setBackground(Color.decode("#ff6d00")); setText("8"); break;
            case 9: setBackground(Color.decode("#212121")); setText("9"); break;
            case 10: setBackground(Color.decode("#263238")); setText("10"); break;
            
            case 11: setBackground(Color.WHITE);  setText(" "); break; // empty job 
            //case 12: setBackground(Color.BLACK); break;// 10 jobs mark
            
        }
    }
}
