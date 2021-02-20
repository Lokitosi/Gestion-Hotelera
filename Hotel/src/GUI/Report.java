package GUI;

/**
 * 12th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Report extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    private JLabel lblTotalIncome;
    
    private JButton btnGoToBack;
    private JButton btnUpdate;
    
    /* Logic variables */
    private RoomList window2;
    
    /* Constructor */
    public Report() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        lblTotalIncome = new JLabel("", SwingConstants.CENTER);
        
        btnGoToBack = new JButton();
        btnUpdate = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        this.setResizable(false);
        
        lblBackground.setIcon(new ImageIcon(("./Images/Report/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblTotalIncome.setBounds(600, 593, 300, 50);
        lblTotalIncome.setBorder(null);
        lblTotalIncome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        lblTotalIncome.setForeground(new Color(24, 24, 24));
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Report/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(31, 27, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnUpdate.setIcon(new ImageIcon(("./Images/Report/Btn Update.png"))); 
        btnUpdate.setBounds(489, 32, 223, 80);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setOpaque(false); 
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(this);
        
        // Add components 
        add(btnGoToBack);
        add(btnUpdate);
        
        add(lblTotalIncome);
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToRoomList() {
        this.dispose();
        window2 = new RoomList(); 
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnGoToBack) {
            goToRoomList();
        }
    }
}
