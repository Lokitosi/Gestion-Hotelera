package GUI;

/**
 * 8th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

import DAO.HostDAO;
import DAO.PersonDAO;
import DAO.PhoneDAO;
import DAO.RegisterCIDAO;
import DAO.ReservationDAO;
import Database.CaException;
import Logic.Host;
import Logic.Person;
import Logic.Phone;
import Logic.Reservation;
import Logic.RegisterCI;

public class CheckIn extends JFrame implements ActionListener {
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
    private JTextField txtDirection;
    private JTextField txtBornDate;
    private JTextField txtReservationCode;
    private JTextField txtDate; 
    private JTextField txtReserverDocument; 
    private JTextField txtDays; 
    
    private JButton btnCheckIn;
    private JButton btnGoToBack;
    private JButton btnGoForward;
    
    private JPanel pnlScreen1;
    private JPanel pnlScreen2;
    
    /* Logic variables */
    private Ads adWindow;
    private Start window2;
    
    private PersonDAO personDAO;
    private PhoneDAO phoneDAO;
    private ReservationDAO reservationDAO;
    private RegisterCIDAO registerCIDAO;
    private HostDAO hostDAO;
    
    private Person person;
    private Person reserver;
    private Phone phone;
    private Reservation reservation;
    private RegisterCI registerci;
    private Host host;
    
    private String name1Text;
    private String name2Text;
    private String surname1Text;
    private String surname2Text;
    private long phone1Text;
    private long phone2Text;
    private long documentText;
    private String documentTypeText;
    private String directionText;
    private String bornDateText;
    private String reservationCodeText;
    private String dateText;
    private long reserverDocumentText;
    private long daysText;
    
    private boolean makeCheckIn;
    private boolean canPass; 
    
    
    /* Constructor */
    public CheckIn() {
        personDAO = new PersonDAO();
        phoneDAO = new PhoneDAO();
        reservationDAO = new ReservationDAO();
        registerCIDAO = new RegisterCIDAO();
        hostDAO = new HostDAO();
        person = new Person();
        reserver = new Person();
        phone = new Phone();
        reservation = new Reservation();
        registerci = new RegisterCI();
        host = new Host();
        
        makeCheckIn = false;
        canPass = false;
        
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
        txtDirection = new JTextField();
        txtReservationCode = new JTextField();
        txtBornDate = new JTextField();
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
        this.setResizable(false);
        
        lblBackground.setIcon(new ImageIcon(("./Images/Check In/Background 1.png"))); 
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
        
        txtDirection.setBounds(253, 195, 320, 35);
        txtDirection.setBorder(null);
        txtDirection.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDirection.setForeground(new Color(24, 24, 24)); 
	txtDirection.setOpaque(false);
        
        txtBornDate.setBounds(253, 432, 320, 35);
        txtBornDate.setBorder(null);
        txtBornDate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtBornDate.setForeground(new Color(24, 24, 24));
        txtBornDate.setOpaque(false);
        
        txtReservationCode.setBounds(848, 432, 320, 35);
        txtReservationCode.setBorder(null);
        txtReservationCode.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtReservationCode.setForeground(new Color(24, 24, 24));
        txtReservationCode.setOpaque(false);
        
        txtDate.setBounds(848, 195, 320, 35);
        txtDate.setBorder(null);
        txtDate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDate.setForeground(new Color(24, 24, 24)); 
	txtDate.setOpaque(false);
        
        txtReserverDocument.setBounds(253, 312, 320, 35);
        txtReserverDocument.setBorder(null);
        txtReserverDocument.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtReserverDocument.setForeground(new Color(24, 24, 24)); 
	txtReserverDocument.setOpaque(false);
        
        txtDays.setBounds(847, 312, 85, 35);
        txtDays.setBorder(null);
        txtDays.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDays.setForeground(new Color(24, 24, 24)); 
	txtDays.setOpaque(false);
        
        btnCheckIn.setIcon(new ImageIcon(("./Images/Check In/Btn Check In.png"))); 
        btnCheckIn.setBounds(957, 545, 220, 80);
        btnCheckIn.setContentAreaFilled(false);
        btnCheckIn.setBorderPainted(false);
        btnCheckIn.setOpaque(false); 
        btnCheckIn.setFocusable(false);
        btnCheckIn.addActionListener(this);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Check In/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(30, 26, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnGoForward.setIcon(new ImageIcon(("./Images/Check In/Btn Go Forward.png"))); 
        btnGoForward.setBounds(970, 545, 220, 80);
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
        pnlScreen2.add(txtBornDate);
        pnlScreen2.add(txtReservationCode);
        pnlScreen2.add(txtDate);
        pnlScreen2.add(txtReserverDocument);
        pnlScreen2.add(txtDays);
        
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
        btnCheckIn.addActionListener(this);
    }
    
    public void goBackward() {
        lblBackground.setIcon(new ImageIcon(("./Images/Check In/Background 1.png")));
        pnlScreen1.setVisible(true);
        pnlScreen1.setEnabled(true);
        pnlScreen2.setVisible(false);
        pnlScreen2.setEnabled(false);
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
        txtDirection.setText("");
        txtBornDate.setText("");
        txtDate.setText("");
        txtReserverDocument.setText("");
        txtDays.setText("");
    }
    
    /* Verify text fields in the Backward */
    public void verifyInformation() {
        if((!txtName1.getText().equals("")) && (!txtSurname1.getText().equals("")) && (!txtSurname2.getText().equals("")) && 
                (!txtPhone1.getText().equals("")) && (!txtDocument.getText().equals("")) && (!txtDocumentType.getText().equals(""))) {
            canPass = true;
        } else {
            canPass = false;
            adWindow = new Ads("./Images/Check In/Ad Empty Field.png");
        }
    }
    
    /* Verify text fields in the Forward */
    public void verifyReservation(){    
        if ((!txtDirection.getText().equals("")) && (!txtDate.getText().equals(""))
            && (!txtDays.getText().equals("")) && (!txtReserverDocument.getText().equals("")) 
            && (!txtBornDate.getText().equals(""))){
            
            try {
                checkAssociaton();
            } catch (CaException e) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            makeCheckIn = false;
            adWindow = new Ads("./Images/Check In/Ad Empty Field.png");
        }
    }    
    
    /* "Check in", on Backward */
    public void checkInFirstPart() throws CaException {
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
        
        host.setK_numeroid(documentText);
        host.setK_tipo(documentTypeText);
        
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
    
    /* "Check in" on Forward */
    public void checkInLastPart() throws CaException {
        directionText = txtDirection.getText();
        dateText = txtDate.getText();
        reserverDocumentText = Long.parseLong(txtReserverDocument.getText());
        daysText = Long.parseLong(txtDays.getText());
        bornDateText = txtBornDate.getText();
        reservationCodeText = txtReservationCode.getText();
        
        host.setF_nacimiento(bornDateText);
        host.setN_direccion(directionText);
        
        hostDAO.setHost(host);
        hostDAO.insertHost();
        
        reserver.setK_numeroid(reserverDocumentText);
        reservation.setK_codigo(reservationCodeText);
        
        reservationDAO.setPerson(reserver);
        reservationDAO.setReservation(reservation);
        
        switch (Integer.toString(registerCIDAO.getAllRegisters()+ 1).length()) {
            case 1:
                registerci.setK_registro("RC00" + Integer.toString(registerCIDAO.getAllRegisters() + 1));
                break;
            case 2:
                registerci.setK_registro("RC0" + Integer.toString(registerCIDAO.getAllRegisters() + 1));
                break;
            case 3:
                registerci.setK_registro("RC" + Integer.toString(registerCIDAO.getAllRegisters() + 1));
                break;
            default:
                break;
        }
        
        registerci.setF_inicio(dateText);
        registerci.setF_salida(calculeDate(dateText, daysText));
        
        registerCIDAO.setHost(host);
        registerCIDAO.setReservation(reservation);
        registerCIDAO.setRegisterCI(registerci);
        registerCIDAO.insertRegisterCI();    
    }
    
    /* Found reserve*/
    public void checkAssociaton() throws CaException{
        reservationDAO = new ReservationDAO();
        
        reserverDocumentText = Long.parseLong(txtReserverDocument.getText());
        
        reservationDAO.getCodeReservation(reserverDocumentText);
        
        if(!reservationDAO.getReservation().getK_codigo().equals("")){
            reservation = reservationDAO.getReservation();
            makeCheckIn = true;
        }
    }
    
    /* Give date from his out */
    public String calculeDate (String date, long days){
        
        char[] dateArray;
        dateArray = date.toCharArray();
        String dayString, monthString, yearString;
        
        //01/02/2020
        int day, month, year;
        int d=0, m=0, y=0;
        
        char[] dayChar = new char[2];
        char[] monthChar = new char[2];
        char[] yearChar = new char[4];
        
        for (int i = 0 ; i < date.length(); i++){
            if ( i < 2 ){
                dayChar[d] = dateArray[i];
                d++;
            } else if ( i > 2 && i < 5){
                monthChar[m] = dateArray[i];
                m++;
            } else if (i > 5){
                yearChar[y] = dateArray[i];
                y++;
            }
        }
        //Se coonvierten las cadenas de caracteres en String
        dayString = String.valueOf(dayChar);
        monthString = String.valueOf(monthChar);
        yearString = String.valueOf(yearChar);
        //Convertimos dichas String en Enteros para operar
        day = Integer.valueOf(dayString);
        month = Integer.valueOf(monthString);
        year = Integer.valueOf(yearString);
        //LocalDate, se encarga de representar la fecha actua
        LocalDate dateIn = LocalDate.of(year,month,day);
        //Calcula la fecha siguiente
        LocalDate dateOut = dateIn.plus(4,ChronoUnit.DAYS);
        //Aplicamos un formato y luego convertimos a string para poder retornar 
        DateTimeFormatter formatDateSQL = DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy");
        String dateOutString = dateOut.format(formatDateSQL);
        
        return dateOutString;
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btnGoForward) {
            verifyInformation();
            
           if (canPass == true){       
                goForward();      
            }
        }
        
        if(event.getSource() == btnGoToBack && pnlScreen1.isEnabled()== true) {
            clear();
            goToStart();    
        } 
        
        if(event.getSource() == btnGoToBack && pnlScreen2.isEnabled() == true) {
            goBackward();
        }
        
        if(event.getSource() == btnCheckIn) {
            verifyReservation();
            
            if (makeCheckIn == true){
                try {
                    checkInFirstPart();
                    checkInLastPart();
                    adWindow = new Ads("./Images/Check In/Ad Successful Check In.png");
                    clear();
                    goBackward();
                } catch (CaException e ) {
                    Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, e);
                    adWindow = new Ads("./Images/Check In/Ad Incorrect Date.png");
                }
            } else {
                adWindow = new Ads("./Images/Check In/Ad Non Existent Reservation.png");
            }
            
            event.setSource(null);
        }
    }
}
