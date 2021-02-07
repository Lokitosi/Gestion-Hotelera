package GUI;

/**
 * 2nd window
 * 
 * @author William Alejandro Ardila Sánchez
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {
    private JLabel lblBackground;
    
    /* Constructor */
    public Register() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Register/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        // Add components 
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        
    }
}