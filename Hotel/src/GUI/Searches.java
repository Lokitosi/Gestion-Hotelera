package GUI;

/**
 * 10th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Searches extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    private JLabel lblFilterName;
    
    private JTextField txtName;
    
    private JButton btnGoToBack;
    private JButton btnFilter;
    private JButton btnReservationName;
    private JButton btnRoomName;
    private JButton btnRoomNumber;
    private JButton btnSearch;
    
    /* Logic variables */
    private RoomList window2;
    
    private int filterState;
    
    /* Constructor */
    public Searches() {
        filterState = 1;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        lblFilterName = new JLabel("Búsquedas", SwingConstants.CENTER);
        
        txtName = new JTextField();
        
        btnGoToBack = new JButton();
        btnFilter = new JButton();
        btnReservationName = new JButton();
        btnRoomName = new JButton();
        btnRoomNumber = new JButton();
        btnSearch = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Searches/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblFilterName.setBounds(206, 18, 205, 50);
        lblFilterName.setBorder(null);  
        lblFilterName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        lblFilterName.setForeground(new Color(24, 24, 24));
        
        txtName.setBounds(522, 20, 413, 40);
        txtName.setBorder(null);
        txtName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        txtName.setForeground(new Color(24, 24, 24)); 
	txtName.setOpaque(false);
        
        btnGoToBack.setIcon(new ImageIcon(("./Images/Searches/Btn Go To Back.png"))); 
        btnGoToBack.setBounds(30, 27, 115, 85);
        btnGoToBack.setContentAreaFilled(false);
        btnGoToBack.setBorderPainted(false);
        btnGoToBack.setOpaque(false); 
        btnGoToBack.setFocusable(false);
        btnGoToBack.addActionListener(this);
        
        btnFilter.setIcon(new ImageIcon(("./Images/Searches/Btn Filter Down.png"))); 
        btnFilter.setBounds(393, 15, 90, 58);
        btnFilter.setContentAreaFilled(false);
        btnFilter.setBorderPainted(false);
        btnFilter.setOpaque(false); 
        btnFilter.setFocusable(false);
        btnFilter.addActionListener(this);
        
        btnReservationName.setIcon(new ImageIcon(("./Images/Searches/Btn Reservation Name.png"))); 
        btnReservationName.setBounds(203, 62, 265, 50);
        btnReservationName.setContentAreaFilled(false);
        btnReservationName.setBorderPainted(false);
        btnReservationName.setOpaque(false); 
        btnReservationName.setFocusable(false);
        btnReservationName.setVisible(false);
        btnReservationName.setEnabled(false);
        btnReservationName.addActionListener(this);

        btnRoomName.setIcon(new ImageIcon(("./Images/Searches/Btn Room Name.png"))); 
        btnRoomName.setBounds(203, 101, 265, 50);
        btnRoomName.setContentAreaFilled(false);
        btnRoomName.setBorderPainted(false);
        btnRoomName.setOpaque(false); 
        btnRoomName.setFocusable(false);
        btnRoomName.setVisible(false);
        btnRoomName.setEnabled(false);
        btnRoomName.addActionListener(this);

        btnRoomNumber.setIcon(new ImageIcon(("./Images/Searches/Btn Room Number.png"))); 
        btnRoomNumber.setBounds(203, 137, 265, 50);
        btnRoomNumber.setContentAreaFilled(false);
        btnRoomNumber.setBorderPainted(false);
        btnRoomNumber.setOpaque(false); 
        btnRoomNumber.setFocusable(false);
        btnRoomNumber.setVisible(false);
        btnRoomNumber.setEnabled(false);
        btnRoomNumber.addActionListener(this);
        
        btnSearch.setIcon(new ImageIcon(("./Images/Searches/Btn Search.png"))); 
        btnSearch.setBounds(679, 94, 122, 52);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setBorderPainted(false);
        btnSearch.setOpaque(false); 
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(this);
        
        // Add components 
        add(btnSearch);
        add(btnGoToBack);
        add(btnRoomNumber);
        add(btnRoomName);
        add(btnReservationName);
        add(btnFilter);
        
        add(txtName);
        
        add(lblFilterName);
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToRoomList() {
        this.dispose();
        window2 = new RoomList(); 
    }
    
    /* Show filters */
    public void showFilters() {
        if(filterState == 1) {
            btnFilter.setIcon(new ImageIcon(("./Images/Searches/Btn Filter Up.png"))); 
            
            btnReservationName.setVisible(true);
            btnReservationName.setEnabled(true);

            btnRoomName.setVisible(true);
            btnRoomName.setEnabled(true);

            btnRoomNumber.setVisible(true);
            btnRoomNumber.setEnabled(true);
        
            filterState = 2;
        } else {
            btnFilter.setIcon(new ImageIcon(("./Images/Searches/Btn Filter Down.png"))); 
            
            btnReservationName.setVisible(false);
            btnReservationName.setEnabled(false);

            btnRoomName.setVisible(false);
            btnRoomName.setEnabled(false);

            btnRoomNumber.setVisible(false);
            btnRoomNumber.setEnabled(false);
            
            filterState = 1;
        }
    }
    
    /* Manage filters */
    public void addFilter(String filterName) {
        lblFilterName.setText(filterName);
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnGoToBack) {
            goToRoomList();
        }
        
        if(event.getSource() == btnFilter) {
            showFilters();
        }
        
        if(event.getSource() == btnReservationName) {
            showFilters();
            addFilter("Reserva - Nombre");
        } else if(event.getSource() == btnRoomName) {
            showFilters();
            addFilter("Habitación - Nombre");
        } else if(event.getSource() == btnRoomNumber) {
            showFilters();
            addFilter("Habitación - Número");
        }
    }
}
