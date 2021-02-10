package GUI;

/**
 * 5th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservation extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JTextField txtDate;
    private JTextField txtDays;
    private JTextField txtGuests;
    
    private JButton btnProfile;
    private JButton btnReservate;
    
    /* Logic variables */
    private Profile window2;
    
    /* Constructor */
    public Reservation() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        txtDate = new JTextField();
        txtDays = new JTextField();
        txtGuests = new JTextField();
        
        btnProfile = new JButton();
        btnReservate = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Reservation/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        txtDate.setBounds(622, 195, 154, 40);
        txtDate.setBorder(null);
        txtDate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDate.setForeground(new Color(24, 24, 24)); 
	txtDate.setOpaque(false);
        
        txtDays.setBounds(622, 292, 154, 40);
        txtDays.setBorder(null);
        txtDays.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDays.setForeground(new Color(24, 24, 24)); 
	txtDays.setOpaque(false);
        
        txtGuests.setBounds(622, 397, 154, 40);
        txtGuests.setBorder(null);
        txtGuests.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtGuests.setForeground(new Color(24, 24, 24)); 
	txtGuests.setOpaque(false);
        
        btnProfile.setIcon(new ImageIcon(("./Images/Reservation/Btn Profile.png"))); 
        btnProfile.setBounds(20, 24, 210, 85);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);
        btnProfile.setOpaque(false); 
        btnProfile.setFocusable(false);
        btnProfile.addActionListener(this);
        
        btnReservate.setIcon(new ImageIcon(("./Images/Reservation/Btn Reservate.png"))); 
        btnReservate.setBounds(712, 525, 210, 85);
        btnReservate.setContentAreaFilled(false);
        btnReservate.setBorderPainted(false);
        btnReservate.setOpaque(false); 
        btnReservate.setFocusable(false);
        btnReservate.addActionListener(this);
        
        // Add components 
        add(btnProfile);
        add(btnReservate);
        
        add(txtDate);
        add(txtDays);
        add(txtGuests);
        
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
