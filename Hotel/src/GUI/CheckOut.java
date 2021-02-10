package GUI;

/**
 * 13th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOut extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    private JLabel lblTotalPrice;
    
    private JTextField txtName;
    private JTextField txtDocument;
    
    private JButton btnGoToBack;
    private JButton btnSearch;
    private JButton btnCheckOut;
    
    /* Logic variables */
    private RoomList window2;
    
    /* Constructor */
    public CheckOut() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        lblTotalPrice = new JLabel("", SwingConstants.CENTER);
        
        txtName = new JTextField();
        txtDocument = new JTextField();
        
        btnGoToBack = new JButton();
        btnSearch = new JButton();
        btnCheckOut = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Check Out/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblTotalPrice.setBounds(530, 593, 260, 50);
        lblTotalPrice.setBorder(null);
        lblTotalPrice.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        lblTotalPrice.setForeground(new Color(24, 24, 24));
        
        txtName.setBounds(316, 39, 217, 35);
        txtName.setBorder(null);
        txtName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName.setForeground(new Color(24, 24, 24)); 
	txtName.setOpaque(false);
        
        txtDocument.setBounds(738, 39, 217, 35);
        txtDocument.setBorder(null);
        txtDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocument.setForeground(new Color(24, 24, 24)); 
	txtDocument.setOpaque(false);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Check Out/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(31, 27, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnSearch.setIcon(new ImageIcon(("./Images/Check Out/Btn Search.png"))); 
        btnSearch.setBounds(539, 95, 122, 52);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setBorderPainted(false);
        btnSearch.setOpaque(false); 
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(this);
        
        btnCheckOut.setIcon(new ImageIcon(("./Images/Check Out/Btn Check Out.png"))); 
        btnCheckOut.setBounds(927, 589, 185, 60);
        btnCheckOut.setContentAreaFilled(false);
        btnCheckOut.setBorderPainted(false);
        btnCheckOut.setOpaque(false); 
        btnCheckOut.setFocusable(false);
        btnCheckOut.addActionListener(this);
        
        // Add components 
        add(btnGoToBack);
        add(btnSearch);
        add(btnCheckOut);
        
        add(txtName);    
        add(txtDocument);
        
        add(lblTotalPrice);
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
