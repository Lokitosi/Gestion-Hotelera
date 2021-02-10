package GUI;

/**
 * 7th window
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JButton btnReservations;
    private JButton btnMenu;
    private JButton btnExit;
    
    /* Logic variables */
    private ReservationList window2;
    private ClientStart window3;
    private Start window4;
    
    /* Constructor */
    public Profile() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        btnReservations = new JButton();
        btnMenu = new JButton();
        btnExit = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Profile/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        btnReservations.setIcon(new ImageIcon(("./Images/Profile/Btn Reservations.png"))); 
        btnReservations.setBounds(146, 219, 880, 85);
        btnReservations.setContentAreaFilled(false);
        btnReservations.setBorderPainted(false);
        btnReservations.setOpaque(false); 
        btnReservations.setFocusable(false);
        btnReservations.addActionListener(this);
        
        btnMenu.setIcon(new ImageIcon(("./Images/Profile/Btn Menu.png"))); 
        btnMenu.setBounds(145, 356, 880, 85);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
        btnMenu.setOpaque(false); 
        btnMenu.setFocusable(false);
        btnMenu.addActionListener(this);
        
        btnExit.setIcon(new ImageIcon(("./Images/Profile/Btn Exit.png"))); 
        btnExit.setBounds(145, 496, 880, 85);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false); 
        btnExit.setFocusable(false);
        btnExit.addActionListener(this);
        
        // Add components 
        add(btnReservations);
        add(btnMenu);
        add(btnExit);
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToReservationList() {
        this.dispose();
        window2 = new ReservationList(); 
    }
    
    public void goToClientStart() {
        this.dispose();
        window3 = new ClientStart(); 
    }
    
    public void goToStart() {
        this.dispose();
        window4 = new Start(); 
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnReservations) {
            goToReservationList();
        }
        
        if(event.getSource() == btnMenu) {
            goToClientStart();
        }
        
        if(event.getSource() == btnExit) {
            goToStart();
        }
    }
}
