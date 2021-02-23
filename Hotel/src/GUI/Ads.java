package GUI;

/**
 * Ads window
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Ads extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JButton btnAccept;
    
    /* Constructor */
    public Ads(String url) {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        btnAccept = new JButton();
        
        // Configure components 
        this.setSize(662, 272);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        
        lblBackground.setIcon(new ImageIcon((url))); 
        lblBackground.setBounds(-3, 0, 680, 275);
        
        btnAccept.setIcon(new ImageIcon(("./Images/Register/Btn Accept.png"))); 
        btnAccept.setBounds(237, 160, 205, 80);
        btnAccept.setContentAreaFilled(false);
        btnAccept.setBorderPainted(false);
        btnAccept.setOpaque(false); 
        btnAccept.setFocusable(false);
        btnAccept.addActionListener(this);
        
        // Add components 
        add(btnAccept);
        
        add(lblBackground);
        
        this.setVisible(true);
    } 
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnAccept) {
            this.dispose();
        }
    }
}
