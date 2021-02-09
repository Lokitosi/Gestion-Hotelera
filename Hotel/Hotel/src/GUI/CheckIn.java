package GUI;

/**
 * 8th window
 * 
 * @author William Alejandro Ardila Sánchez
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckIn extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    private JLabel lblReservationCode;
    
    private JTextField txtName1;
    private JTextField txtName2;
    private JTextField txtSurname1;
    private JTextField txtSurname2;
    private JTextField txtPhone1;
    private JTextField txtPhone2;
    private JTextField txtDocument;
    private JTextField txtDocumentType; 
    private JTextField txtDirection; 
    private JTextField txtDate; 
    private JTextField txtReserverDocument; 
    private JTextField txtDays; 
    
    private JButton btnCheckIn;
    private JButton btnGoToBack;
    private JButton btnGoForward;
    
    private JPanel pnlScreen1;
    private JPanel pnlScreen2;
    
    /* Logic variables */
    private Start window2;
    
    /* Constructor */
    public CheckIn() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();  
        lblReservationCode = new JLabel();
        
        txtName1 = new JTextField();
        txtName2 = new JTextField();
        txtSurname1 = new JTextField();
        txtSurname2 = new JTextField();
        txtPhone1 = new JTextField();
        txtPhone2 = new JTextField();
        txtDocument = new JTextField();
        txtDocumentType = new JTextField();
        txtDirection = new JTextField();
        txtDate = new JTextField();
        txtReserverDocument = new JTextField();
        txtDays = new JTextField();
        
        btnCheckIn = new JButton();
        btnGoToBack = new JButton();
        btnGoForward = new JButton();
        
        pnlScreen1 = new JPanel();
        pnlScreen2 = new JPanel();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Check In/Background 1.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblReservationCode.setBounds(250, 432, 322, 35);
        lblReservationCode.setBorder(null);
        lblReservationCode.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        lblReservationCode.setForeground(new Color(24, 24, 24));
        
        txtName1.setBounds(250, 195, 322, 35);
        txtName1.setBorder(null);
        txtName1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName1.setForeground(new Color(24, 24, 24)); 
	txtName1.setOpaque(false);
        
        txtName2.setBounds(845, 195, 322, 35);
        txtName2.setBorder(null);
        txtName2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName2.setForeground(new Color(24, 24, 24)); 
	txtName2.setOpaque(false);
        
        txtSurname1.setBounds(250, 312, 322, 35);
        txtSurname1.setBorder(null);
        txtSurname1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtSurname1.setForeground(new Color(24, 24, 24)); 
	txtSurname1.setOpaque(false);
        
        txtSurname2.setBounds(845, 312, 322, 35);
        txtSurname2.setBorder(null);
        txtSurname2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtSurname2.setForeground(new Color(24, 24, 24)); 
	txtSurname2.setOpaque(false);
        
        txtPhone1.setBounds(250, 432, 322, 35);
        txtPhone1.setBorder(null);
        txtPhone1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtPhone1.setForeground(new Color(24, 24, 24)); 
	txtPhone1.setOpaque(false);
        
        txtPhone2.setBounds(845, 432, 322, 35);
        txtPhone2.setBorder(null);
        txtPhone2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtPhone2.setForeground(new Color(24, 24, 24)); 
	txtPhone2.setOpaque(false);
        
        txtDocument.setBounds(250, 549, 322, 35);
        txtDocument.setBorder(null);
        txtDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocument.setForeground(new Color(24, 24, 24)); 
	txtDocument.setOpaque(false);
        
        txtDocumentType.setBounds(708, 551, 85, 35);
        txtDocumentType.setBorder(null);
        txtDocumentType.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocumentType.setForeground(new Color(24, 24, 24)); 
	txtDocumentType.setOpaque(false);
        
        txtDirection.setBounds(250, 195, 322, 35);
        txtDirection.setBorder(null);
        txtDirection.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDirection.setForeground(new Color(24, 24, 24)); 
	txtDirection.setOpaque(false);
        
        txtDate.setBounds(845, 195, 322, 35);
        txtDate.setBorder(null);
        txtDate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDate.setForeground(new Color(24, 24, 24)); 
	txtDate.setOpaque(false);
        
        txtReserverDocument.setBounds(250, 312, 322, 35);
        txtReserverDocument.setBorder(null);
        txtReserverDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtReserverDocument.setForeground(new Color(24, 24, 24)); 
	txtReserverDocument.setOpaque(false);
        
        txtDays.setBounds(845, 312, 88, 35);
        txtDays.setBorder(null);
        txtDays.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDays.setForeground(new Color(24, 24, 24)); 
	txtDays.setOpaque(false);
        
        btnCheckIn.setIcon(new ImageIcon(("./Images/Check In/Btn Check In.png"))); 
        btnCheckIn.setBounds(956, 545, 220, 80);
        btnCheckIn.setContentAreaFilled(false);
        btnCheckIn.setBorderPainted(false);
        btnCheckIn.setOpaque(false); 
        btnCheckIn.setFocusable(false);
        btnCheckIn.setVisible(false);
        btnCheckIn.setEnabled(false); 
        btnCheckIn.addActionListener(this);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Check In/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(30, 26, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnGoForward.setIcon(new ImageIcon(("./Images/Check In/Btn Check In.png"))); 
        btnGoForward.setBounds(956, 545, 220, 80);
        btnGoForward.setContentAreaFilled(false);
        btnGoForward.setBorderPainted(false);
        btnGoForward.setOpaque(false); 
        btnGoForward.setFocusable(false);
        btnGoForward.addActionListener(this);
        
        pnlScreen1.setBounds(0, 0, 1215, 758);
        pnlScreen1.setLayout(null);
        pnlScreen1.setOpaque(false);
        pnlScreen1.setVisible(true);
        pnlScreen1.setEnabled(true);
        
        pnlScreen2.setBounds(0, 0, 1215, 758);
        pnlScreen2.setLayout(null);
        pnlScreen2.setOpaque(false);
        pnlScreen2.setVisible(false);
        pnlScreen2.setEnabled(true);
        
        // Add components
        pnlScreen1.add(btnGoForward);
        pnlScreen1.add(txtName1);
        pnlScreen1.add(txtName2);
        pnlScreen1.add(txtSurname1);
        pnlScreen1.add(txtSurname2);
        pnlScreen1.add(txtPhone1);
        pnlScreen1.add(txtPhone2);
        pnlScreen1.add(txtDocument);
        pnlScreen1.add(txtDocumentType);
        
        pnlScreen2.add(btnCheckIn);
        pnlScreen2.add(txtDirection);
        pnlScreen2.add(txtDate);
        pnlScreen2.add(txtReserverDocument);
        pnlScreen2.add(txtDays);
        pnlScreen2.add(lblReservationCode);
        
        add(btnGoToBack);
        
        add(pnlScreen1);
        add(pnlScreen2);
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToStart() {
        this.dispose();
        window2 = new Start(); 
    }
    
    /* Change screens */
    public void goForward() {
        lblBackground.setIcon(new ImageIcon(("./Images/Check In/Background 2.png")));
        pnlScreen1.setVisible(false);
        pnlScreen1.setEnabled(false);
        pnlScreen2.setVisible(true);
        pnlScreen2.setEnabled(true);
    }
    
    public void goBackward() {
        lblBackground.setIcon(new ImageIcon(("./Images/Check In/Background 1.png")));
        pnlScreen1.setVisible(true);
        pnlScreen1.setEnabled(true);
        pnlScreen2.setVisible(false);
        pnlScreen2.setEnabled(false);
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnGoForward) {
            goForward();
        }
        
        if(event.getSource() == btnGoToBack && pnlScreen1.isEnabled()== true) {
            goToStart();
        } 
        
        if(event.getSource() == btnGoToBack && pnlScreen2.isEnabled() == true) {
            goBackward();
        }
        
        if(event.getSource() == btnCheckIn) {
            
        }
    }
}
