package GUI;

/**
 * 11th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateIntake extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JTextField txtQuantity;
    private JTextField txtProductName;
    private JTextField txtPrice;
    private JTextField txtStock;
    
    private JButton btnGoToBack;
    private JButton btnIntake;
    private JButton btnCheck1;
    private JButton btnCheck2;
    
    /* Logic variables */
    private Searches window2;
            
    /* Constructor */
    public GenerateIntake() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        txtQuantity = new JTextField("", SwingConstants.CENTER);
        txtProductName = new JTextField();
        txtPrice = new JTextField();
        txtStock = new JTextField();
        
        btnGoToBack = new JButton();
        btnIntake = new JButton();
        btnCheck1 = new JButton();
        btnCheck2 = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Generate Intake/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        txtQuantity.setBounds(1100, 171, 54, 40);
        txtQuantity.setBorder(null);
        txtQuantity.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtQuantity.setForeground(new Color(24, 24, 24)); 
	txtQuantity.setOpaque(false);
        
        txtProductName.setBounds(813, 291, 247, 40);
        txtProductName.setBorder(null);
        txtProductName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtProductName.setForeground(new Color(24, 24, 24)); 
	txtProductName.setOpaque(false);
        
        txtPrice.setBounds(813, 371, 247, 40);
        txtPrice.setBorder(null);
        txtPrice.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtPrice.setForeground(new Color(24, 24, 24)); 
	txtPrice.setOpaque(false);
        
        txtStock.setBounds(813, 450, 247, 40);
        txtStock.setBorder(null);
        txtStock.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtStock.setForeground(new Color(24, 24, 24)); 
	txtStock.setOpaque(false);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(30, 27, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnIntake.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Intake.png"))); 
        btnIntake.setBounds(521, 542, 340, 80);
        btnIntake.setContentAreaFilled(false);
        btnIntake.setBorderPainted(false);
        btnIntake.setOpaque(false); 
        btnIntake.setFocusable(false);
        btnIntake.addActionListener(this);
        
        btnCheck1.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Check 1.png"))); 
        btnCheck1.setBounds(537, 166, 53, 53);
        btnCheck1.setContentAreaFilled(false);
        btnCheck1.setBorderPainted(false);
        btnCheck1.setOpaque(false); 
        btnCheck1.setFocusable(false);
        btnCheck1.addActionListener(this);
        
        btnCheck2.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Check 1.png"))); 
        btnCheck2.setBounds(810, 166, 53, 53);
        btnCheck2.setContentAreaFilled(false);
        btnCheck2.setBorderPainted(false);
        btnCheck2.setOpaque(false); 
        btnCheck2.setFocusable(false);
        btnCheck2.addActionListener(this);
        
        // Add components 
        add(btnGoToBack);
        add(btnIntake);
        add(btnCheck1);
        add(btnCheck2);
        
        add(txtQuantity);
        add(txtProductName);
        add(txtPrice);
        add(txtStock);
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToSearches() {
        this.dispose();
        window2 = new Searches(); 
    }
    
    /* Select product or service */
    public void selectType(int option) {
        if(option == 1) {
            btnCheck1.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Check 2.png"))); 
            btnCheck2.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Check 1.png"))); 
        } else {
            btnCheck1.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Check 1.png"))); 
            btnCheck2.setIcon(new ImageIcon(("./Images/Generate Intake/Btn Check 2.png"))); 
        }
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnGoToBack) {
            goToSearches();
        }
        
        if(event.getSource() == btnCheck1) {
            selectType(1);
        } else if(event.getSource() == btnCheck2) {
            selectType(2);
        }
    }
}
