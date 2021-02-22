package GUI;

/**
 * 5th window
*/

import DAO.ReservationDAO;
import Database.CaException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reservation extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    private JLabel lblRoomImage;
    private JLabel lblNumber;
    private JLabel lblType;
    private JLabel lblDescription;
    private JLabel lblPrice;
    private JLabel lblDiscount;
    
    private JTextField txtDate;
    private JTextField txtDays;
    private JTextField txtGuests;
    
    private JButton btnProfile;
    private JButton btnReservate;
    
    /* Logic variables */
    private Profile window2;
    private ReservationDAO reserveDAO;
    private Logic.Reservation reservation;
    private String start_date;
    private short days;
    private short guests;
    private String discountText;
    
    /* Constructor */
    public Reservation() {
        
        reserveDAO = new ReservationDAO();
        reservation = new Logic.Reservation();
        discountText = Short.toString(Start.hotel.getT_descuento()); 
                
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        lblRoomImage = new JLabel();
        lblNumber = new JLabel(ClientStart.roomSelected.getK_numero(), SwingConstants.CENTER);
        lblType = new JLabel(ClientStart.typeConversion, SwingConstants.CENTER);
        lblDescription = new JLabel(ClientStart.typeSelected.getN_descripcion(), SwingConstants.CENTER);
        lblPrice = new JLabel("$" + ClientStart.typeSelected.getV_precio(), SwingConstants.CENTER);
        lblDiscount = new JLabel(discountText + "%", SwingConstants.CENTER);
        
        txtDate = new JTextField();
        txtDays = new JTextField();
        txtGuests = new JTextField();
        
        btnProfile = new JButton();
        btnReservate = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        this.setResizable(false);
        
        lblBackground.setIcon(new ImageIcon(("./Images/Reservation/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblRoomImage.setIcon(new ImageIcon(("./Images/Reservation/Lbl Room Image.png"))); 
        lblRoomImage.setBounds(74, 165, 245, 222);
        
        lblNumber.setBounds(210, 429, 150, 30);
        lblNumber.setBorder(null); 
        lblNumber.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblNumber.setForeground(new Color(24, 24, 24)); 
	lblNumber.setOpaque(false);
        
        lblType.setBounds(105, 479, 255, 30);
        lblType.setBorder(null);
        lblType.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblType.setForeground(new Color(24, 24, 24)); 
	lblType.setOpaque(false);
        
        lblDescription.setBounds(195, 529, 165, 30);
        lblDescription.setBorder(null);
        lblDescription.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblDescription.setForeground(new Color(24, 24, 24)); 
	lblDescription.setOpaque(false);
        
        lblPrice.setBounds(195, 579, 165, 30);
        lblPrice.setBorder(null);
        lblPrice.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblPrice.setForeground(new Color(24, 24, 24)); 
	lblPrice.setOpaque(false);
        
        lblDiscount.setBounds(875, 350, 242, 30);
        lblDiscount.setBorder(null); 
        lblDiscount.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lblDiscount.setForeground(new Color(24, 24, 24)); 
	lblDiscount.setOpaque(false);
        
        txtDate.setBounds(622, 195, 154, 40);
        txtDate.setBorder(null);
        txtDate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDate.setForeground(new Color(24, 24, 24)); 
	txtDate.setOpaque(false);
        
        txtDays.setBounds(622, 292, 154, 40);
        txtDays.setBorder(null);
        txtDays.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtDays.setForeground(new Color(24, 24, 24)); 
	txtDays.setOpaque(false);
        
        txtGuests.setBounds(622, 397, 154, 40);
        txtGuests.setBorder(null);
        txtGuests.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtGuests.setForeground(new Color(24, 24, 24)); 
	txtGuests.setOpaque(false);
        
        btnProfile.setIcon(new ImageIcon(("./Images/Reservation/Btn Profile.png"))); 
        btnProfile.setBounds(20, 24, 210, 85);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);
        btnProfile.setOpaque(false); 
        btnProfile.setFocusable(false);
        btnProfile.addActionListener(this);
        
        btnReservate.setIcon(new ImageIcon(("./Images/Reservation/Btn Reservate.png"))); 
        btnReservate.setBounds(712, 525, 210, 85);
        btnReservate.setContentAreaFilled(false);
        btnReservate.setBorderPainted(false);
        btnReservate.setOpaque(false); 
        btnReservate.setFocusable(false);
        btnReservate.addActionListener(this);
        
        // Add components 
        add(btnProfile);
        add(btnReservate);
        
        add(txtDate);
        add(txtDays);
        add(txtGuests);
        
        add(lblDiscount);
        add(lblPrice);
        add(lblType);
        add(lblDescription);
        add(lblNumber);
        add(lblRoomImage);
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToProfile() {
        this.dispose();
        window2 = new Profile();  
    }
    
    /*Make reservation*/
    public void reserve() throws CaException{
        //k_codigo = "a";//hacerlo autoincremental
        start_date = txtDate.getText();
        days = Short.valueOf(txtDays.getText());
        guests = Short.valueOf(txtGuests.getText());
        
        reservation.setF_inicio(start_date);
        reservation.setQ_duracion(days);
        reservation.setQ_cantPersonas(guests);
        reservation.setI_estado("a");
        
        
        switch (Integer.toString(reserveDAO.getAllReservations()+ 1).length()) {
            case 1:
                reservation.setK_codigo("R00" + Integer.toString(reserveDAO.getAllReservations() + 1));
                break;
            case 2:
                reservation.setK_codigo("R0" + Integer.toString(reserveDAO.getAllReservations() + 1));
                break;
            case 3:
                reservation.setK_codigo("R" + Integer.toString(reserveDAO.getAllReservations() + 1));
                break;
            default:
                break;
        }
        reserveDAO.setReservation(reservation);
        reserveDAO.setBill(null);
        reserveDAO.setHotel(Start.hotel);
        reserveDAO.setPerson(LogIn.person);
        
        reserveDAO.insertReservation();
       
        
    }
    
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnProfile) {
            goToProfile();
        }
        if(event.getSource() == btnReservate){
            try {
                reserve();
                System.out.println("se realizo la reserva");
            } catch (CaException ex) {
                Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
