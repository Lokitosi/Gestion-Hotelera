package GUI;

/**
 * 3rd window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.CaException;
import DAO.PersonDAO;
import Logic.Person;

public class LogIn extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtDocument;
    
    private JButton btnLogIn;
    private JButton btnGoToBack;
    
    /* Logic variables */
    private Ads adWindow;
    private Start window2;
    private ClientStart window3;
    private RoomList window4;
    
    private PersonDAO personDAO;
    public static Person person;
    
    private String nameText;
    private String surnameText;
    private long documentText;
    
    private boolean canLogIn;
    
    /* Constructor */
    public LogIn() {
        person = new Person();
        
        canLogIn = false;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtDocument = new JTextField();
        
        btnLogIn = new JButton();
        btnGoToBack = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        this.setResizable(false);
        
        lblBackground.setIcon(new ImageIcon(("./Images/Log In/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        txtName.setBounds(271, 296, 297, 35);
        txtName.setBorder(null);
        txtName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName.setForeground(new Color(24, 24, 24)); 
	txtName.setOpaque(false);
        
        txtSurname.setBounds(852, 296, 297, 35);
        txtSurname.setBorder(null);
        txtSurname.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtSurname.setForeground(new Color(24, 24, 24)); 
	txtSurname.setOpaque(false);
        
        txtDocument.setBounds(395, 414, 625, 35);
        txtDocument.setBorder(null);
        txtDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocument.setForeground(new Color(24, 24, 24)); 
	txtDocument.setOpaque(false);
        
        btnLogIn.setIcon(new ImageIcon(("./Images/Log In/Btn Log In.png"))); 
        btnLogIn.setBounds(860, 545, 330, 80);
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
        
        add(txtSurname);
        add(txtName);    
        add(txtDocument); 
        
        add(lblBackground);
        
        this.setVisible(true);
    }

    /* Getters */
    public static Person getPerson() {
        return person;
    }

    /* Setters */
    public static void setPerson(Person person) {
        LogIn.person = person;
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
    
    public void goToRoomList() {
        this.dispose();
        window4 = new RoomList(); 
    }
    
    /* Verify text fields */
    public void verify() {
        if((!txtName.getText().equals("")) && (!txtDocument.getText().equals(""))) {
            try {               
                checkLogIn();
            } catch (CaException e) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            adWindow = new Ads("./Images/Log In/Ad Empty Field.png");
            canLogIn = false;
        }
    }
    
    /* Log in */
    public void checkLogIn() throws CaException {
        personDAO = new PersonDAO();
        
        nameText = txtName.getText();
        surnameText = txtSurname.getText();
        documentText = Long.parseLong(txtDocument.getText());
        
        personDAO.getPersonByID(documentText, nameText, surnameText);

        if(personDAO.getPerson().getK_numeroid() != 0) {
            person = personDAO.getPerson();
            canLogIn = true;
        } else {
            adWindow = new Ads("./Images/Log In/Ad Unregistered Person.png");
        }
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnLogIn) {
            verify();
            
            if(person.getK_numeroid() == 1234 && person.getN_nombre1().equals("Admin")) {
                goToRoomList();
            } else if(canLogIn == true) {
                goToClientStart(); 
            } 
        }
        
        if(event.getSource() == btnGoToBack) {
            goToStart();
        }
    }
}
