package GUI;

/**
 * 3rd window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JTextField txtName;
    private JTextField txtDocument;
    
    private JButton btnLogIn;
    private JButton btnGoToBack;
    
    /* Logic variables */
    private Start window2;
    private ClientStart window3;
    
    /* Constructor */
    public LogIn() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        txtName = new JTextField();
        txtDocument = new JTextField();
        
        btnLogIn = new JButton();
        btnGoToBack = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Log In/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        txtName.setBounds(420, 296, 628, 35);
        txtName.setBorder(null);
        txtName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName.setForeground(new Color(24, 24, 24)); 
	txtName.setOpaque(false);
        
        txtDocument.setBounds(420, 414, 628, 35);
        txtDocument.setBorder(null);
        txtDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocument.setForeground(new Color(24, 24, 24)); 
	txtDocument.setOpaque(false);
        
        btnLogIn.setIcon(new ImageIcon(("./Images/Log In/Btn Log In.png"))); 
        btnLogIn.setBounds(872, 545, 330, 80);
        btnLogIn.setContentAreaFilled(false);
        btnLogIn.setBorderPainted(false);
        btnLogIn.setOpaque(false); 
        btnLogIn.setFocusable(false);
        btnLogIn.addActionListener(this);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Log In/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(28, 27, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        // Add components 
        add(btnLogIn);
        add(btnGoToBack);
        
        add(txtName);    
        add(txtDocument); 
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToStart() {
        this.dispose();
        window2 = new Start(); 
    }
    
    public void goToClientStart() {
        this.dispose();
        window3 = new ClientStart(); 
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnLogIn) {
            goToClientStart();
        }
        
        if(event.getSource() == btnGoToBack) {
            goToStart();
        }
    }
}
