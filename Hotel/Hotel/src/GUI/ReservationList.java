package GUI;

/**
 * 6th window
 * 
 * @author William Alejandro Ardila Sánchez
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationList extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JButton btnProfile;
    
    /* Logic variables */
    private Profile window2;
    
    /* Constructor */
    public ReservationList() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        btnProfile = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Reservation List/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        btnProfile.setIcon(new ImageIcon(("./Images/Reservation List/Btn Profile.png"))); 
        btnProfile.setBounds(20, 24, 210, 85);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);
        btnProfile.setOpaque(false); 
        btnProfile.setFocusable(false);
        btnProfile.addActionListener(this);
        
        // Add components 
        add(btnProfile);
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToProfile() {
        this.dispose();
        window2 = new Profile();  
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnProfile) {
            goToProfile();
        }
    }
}
