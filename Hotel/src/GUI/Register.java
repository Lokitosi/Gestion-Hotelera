package GUI;

/**
 * 2nd window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.CaException;
import DAO.PersonDAO;
import DAO.PhoneDAO;
import Logic.Person;
import Logic.Phone;

public class Register extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JTextField txtName1;
    private JTextField txtName2;
    private JTextField txtSurname1;
    private JTextField txtSurname2;
    private JTextField txtPhone1;
    private JTextField txtPhone2;
    private JTextField txtDocument;
    private JTextField txtDocumentType; 
    
    private JButton btnRegister;
    private JButton btnGoToBack;
    
    /* Logic variables */
    private Ads adWindow;
    private Start window2;
    
    private PersonDAO personDAO;
    private PhoneDAO phoneDAO;
    private Person person;
    private Phone phone; 
    
    private String name1Text;
    private String name2Text;
    private String surname1Text;
    private String surname2Text;
    private long phone1Text;
    private long phone2Text;
    private long documentText;
    private String documentTypeText;
    
    private boolean canRegister;
    
    /* Constructor */
    public Register() {
        personDAO = new PersonDAO();
        phoneDAO = new PhoneDAO();
        person = new Person();
        phone = new Phone();
        
        canRegister = false;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();    
        
        txtName1 = new JTextField();
        txtName2 = new JTextField();
        txtSurname1 = new JTextField();
        txtSurname2 = new JTextField();
        txtPhone1 = new JTextField();
        txtPhone2 = new JTextField();
        txtDocument = new JTextField();
        txtDocumentType = new JTextField();
        
        btnRegister = new JButton();
        btnGoToBack = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        this.setResizable(false);
        
        lblBackground.setIcon(new ImageIcon(("./Images/Register/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        txtName1.setBounds(253, 195, 320, 35);
        txtName1.setBorder(null);
        txtName1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName1.setForeground(new Color(24, 24, 24)); 
	txtName1.setOpaque(false);
        
        txtName2.setBounds(848, 195, 320, 35);
        txtName2.setBorder(null);
        txtName2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName2.setForeground(new Color(24, 24, 24)); 
	txtName2.setOpaque(false);
        
        txtSurname1.setBounds(253, 312, 320, 35);
        txtSurname1.setBorder(null);
        txtSurname1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtSurname1.setForeground(new Color(24, 24, 24)); 
	txtSurname1.setOpaque(false);
        
        txtSurname2.setBounds(848, 312, 320, 35);
        txtSurname2.setBorder(null);
        txtSurname2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtSurname2.setForeground(new Color(24, 24, 24)); 
	txtSurname2.setOpaque(false);
        
        txtPhone1.setBounds(253, 432, 320, 35);
        txtPhone1.setBorder(null);
        txtPhone1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtPhone1.setForeground(new Color(24, 24, 24)); 
	txtPhone1.setOpaque(false);
        
        txtPhone2.setBounds(848, 432, 320, 35);
        txtPhone2.setBorder(null);
        txtPhone2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtPhone2.setForeground(new Color(24, 24, 24)); 
	txtPhone2.setOpaque(false);
        
        txtDocument.setBounds(253, 549, 320, 35);
        txtDocument.setBorder(null);
        txtDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocument.setForeground(new Color(24, 24, 24)); 
	txtDocument.setOpaque(false);
        
        txtDocumentType.setBounds(711, 551, 83, 35);
        txtDocumentType.setBorder(null);
        txtDocumentType.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDocumentType.setForeground(new Color(24, 24, 24)); 
	txtDocumentType.setOpaque(false);
        
        btnRegister.setIcon(new ImageIcon(("./Images/Register/Btn Register.png"))); 
        btnRegister.setBounds(956, 545, 220, 80);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setOpaque(false); 
        btnRegister.setFocusable(false);
        btnRegister.addActionListener(this);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Register/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(30, 26, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        // Add components
        add(btnRegister);
        add(btnGoToBack);
        
        add(txtName1);    
        add(txtName2); 
        add(txtSurname1); 
        add(txtSurname2); 
        add(txtPhone1);    
        add(txtPhone2); 
        add(txtDocument); 
        add(txtDocumentType); 
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToStart() {
        this.dispose();
        window2 = new Start(); 
    }
    
    /* Clear text fields */
    public void clear() {
        txtName1.setText("");
        txtName2.setText("");
        txtSurname1.setText("");
        txtSurname2.setText("");
        txtPhone1.setText("");
        txtPhone2.setText("");
        txtDocument.setText("");
        txtDocumentType.setText("");
    }
    
    /* Verify text fields */
    public void verify() {
        if((!txtName1.getText().equals("")) && (!txtSurname1.getText().equals("")) && (!txtSurname2.getText().equals("")) && 
                (!txtPhone1.getText().equals("")) && (!txtDocument.getText().equals("")) && (!txtDocumentType.getText().equals(""))) {
            canRegister = true;
        } else {
            canRegister = false;
        }
    }
    
    /* Register */
    public void register() throws CaException {
        name1Text = txtName1.getText();
        name2Text = txtName2.getText();
        surname1Text = txtSurname1.getText();
        surname2Text = txtSurname2.getText(); 
        phone1Text = Long.parseLong(txtPhone1.getText());
        documentText = Long.parseLong(txtDocument.getText());
        documentTypeText = txtDocumentType.getText();
        
        person.setN_nombre1(name1Text);
        person.setN_nombre2(name2Text);
        person.setN_apellido1(surname1Text);
        person.setN_apellido2(surname2Text);
        person.setK_numeroid(documentText); 
        person.setK_tipo(documentTypeText);
        
        personDAO.setPerson(person);
        personDAO.insertPerson();
        
        phone.setK_telefono(phone1Text);
        phoneDAO.setPerson(person); 
        phoneDAO.setPhone(phone);
        phoneDAO.insertPhone();
        
        if(!txtPhone2.getText().equals("")) {
            phone2Text = Long.parseLong(txtPhone2.getText());
            phone.setK_telefono(phone2Text);  
            phoneDAO.setPhone(phone);
            phoneDAO.insertPhone();
        }
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnRegister) {
            verify();
            
            if(canRegister == true) {
                try {
                    register();
                    adWindow = new Ads("./Images/Register/Ad Successful Register.png");
                    clear();
                } catch (CaException e) {
                    adWindow = new Ads("./Images/Register/Ad Existing Register.png");
                } catch(NumberFormatException e) {
                    adWindow = new Ads("./Images/Register/Ad Incorrect Data.png");
                }
            } else {
                adWindow = new Ads("./Images/Register/Ad Empty Field.png");
            }     
        }
        
        if(event.getSource() == btnGoToBack) {
            goToStart();
        }
    }
}
