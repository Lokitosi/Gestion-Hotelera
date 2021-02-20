package GUI;

/**
 * 5th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.CaException;
import DAO.BillDAO;
import Logic.Bill;

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
    
    private BillDAO billDAO;
    private Bill bill;
    
    private String discountText;
    
    /* Constructor */
    public Reservation() {
        billDAO = new BillDAO();
        bill = new Bill();
        
        //discountText = Short.toString(Start.hotel.getT_descuento()); 
        discountText = "20";
                
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        lblRoomImage = new JLabel();
        lblNumber = new JLabel("", SwingConstants.CENTER);
        lblType = new JLabel("", SwingConstants.CENTER);
        lblDescription = new JLabel("", SwingConstants.CENTER);
        lblPrice = new JLabel("", SwingConstants.CENTER);
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
        lblNumber.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        lblNumber.setForeground(new Color(24, 24, 24)); 
	lblNumber.setOpaque(false);
        
        lblType.setBounds(105, 479, 255, 30);
        lblType.setBorder(null);
        lblType.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        lblType.setForeground(new Color(24, 24, 24)); 
	lblType.setOpaque(false);
        
        lblDescription.setBounds(195, 529, 165, 30);
        lblDescription.setBorder(null);
        lblDescription.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        lblDescription.setForeground(new Color(24, 24, 24)); 
	lblDescription.setOpaque(false);
        
        lblPrice.setBounds(195, 579, 165, 30);
        lblPrice.setBorder(null);
        lblPrice.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
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
    
    /* Create DAO's */
    public void createBill() throws CaException {
        if(Integer.toString(billDAO.getAllBills() + 1).length() == 1) {
            bill.setK_cuenta("C00" + Integer.toString(billDAO.getAllBills() + 1));
        } else if(Integer.toString(billDAO.getAllBills() + 1).length() == 2) {
            bill.setK_cuenta("C0" + Integer.toString(billDAO.getAllBills() + 1));
        } else if(Integer.toString(billDAO.getAllBills() + 1).length() == 3) {
            bill.setK_cuenta("C" + Integer.toString(billDAO.getAllBills() + 1));
        }
        
        billDAO.setBill(bill);
        billDAO.insertBill();
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnProfile) {
            goToProfile();
        }
        
        if(event.getSource() == btnReservate) {
            try {
                createBill();
            } catch (CaException e) {
                Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
