package GUI;

/**
 * 14th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntakenList extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    private JLabel lblIntaken;
    
    private JButton btnGoToBack;
    private JButton btnAccept;
    
    /* Logic variables */
    private CheckOut window2;
    
    /* Constructor */
    public IntakenList() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        lblIntaken = new JLabel("", SwingConstants.CENTER);
        
        btnGoToBack = new JButton();
        btnAccept = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Intaken List/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblIntaken.setBounds(922, 301, 240, 40);
        lblIntaken.setBorder(null);
        lblIntaken.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        lblIntaken.setForeground(new Color(24, 24, 24)); 
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Intaken List/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(31, 27, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnAccept.setIcon(new ImageIcon(("./Images/Intaken List/Btn Accept.png"))); 
        btnAccept.setBounds(955, 433, 190, 80);
        btnAccept.setContentAreaFilled(false);
        btnAccept.setBorderPainted(false);
        btnAccept.setOpaque(false); 
        btnAccept.setFocusable(false);
        btnAccept.addActionListener(this);
        
        // Add components 
        add(btnGoToBack);
        add(btnAccept);
        
        add(lblIntaken);
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToCheckOut() {
        this.dispose();
        window2 = new CheckOut(); 
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnGoToBack) {
            goToCheckOut();
        }
    }
}
