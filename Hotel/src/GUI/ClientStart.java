package GUI;

/**
 * 4th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientStart extends JFrame implements ActionListener {
    /* Graphic variables */ 
    private ImageIcon imgScrollBar;
    
    private JLabel lblBackground;
    
    private JButton btnProfile;
    private JButton btnFilter;
    private JButton btnSimple;
    private JButton btnDouble;
    private JButton btnTriple;
    private JButton btnReservate;
    private JButton btnReservate2;
    
    private JPanel pnlRooms;
    
    private JScrollBar scbRoomsBar;
    private JScrollPane scpRooms;
    
    /* Logic variables */
    private Profile window2;
    private Reservation window3;
    
    private int filterState;
    
    /* Constructor */
    public ClientStart() {
        filterState = 1;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create component
        imgScrollBar = new ImageIcon("./Images/Client Start/Btn Slider.png");
        
        lblBackground = new JLabel();
        
        btnProfile = new JButton();
        btnFilter = new JButton();
        btnSimple = new JButton();
        btnDouble = new JButton();
        btnTriple = new JButton();
        btnReservate = new JButton();
        btnReservate2 = new JButton();       
        
        pnlRooms = new JPanel();
        
        scbRoomsBar = new JScrollBar();
        scpRooms = new JScrollPane(null, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Configure components 
        this.setSize(1215, 758);
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Client Start/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        btnProfile.setIcon(new ImageIcon(("./Images/Client Start/Btn Profile.png"))); 
        btnProfile.setBounds(20, 23, 210, 85);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setBorderPainted(false);
        btnProfile.setOpaque(false); 
        btnProfile.setFocusable(false);
        btnProfile.addActionListener(this);
        
        btnFilter.setIcon(new ImageIcon(("./Images/Client Start/Btn Filter Down.png"))); 
        btnFilter.setBounds(830, 24, 90, 58);
        btnFilter.setContentAreaFilled(false);
        btnFilter.setBorderPainted(false);
        btnFilter.setOpaque(false); 
        btnFilter.setFocusable(false);
        btnFilter.addActionListener(this);
        
        btnSimple.setIcon(new ImageIcon(("./Images/Client Start/Btn Simple.png"))); 
        btnSimple.setBounds(275, 75, 650, 60);
        btnSimple.setContentAreaFilled(false);
        btnSimple.setBorderPainted(false);
        btnSimple.setOpaque(false); 
        btnSimple.setFocusable(false);
        btnSimple.setVisible(false);
        btnSimple.setEnabled(false);
        btnSimple.addActionListener(this);

        btnDouble.setIcon(new ImageIcon(("./Images/Client Start/Btn Double.png"))); 
        btnDouble.setBounds(275, 120, 650, 60);
        btnDouble.setContentAreaFilled(false);
        btnDouble.setBorderPainted(false);
        btnDouble.setOpaque(false); 
        btnDouble.setFocusable(false);
        btnDouble.setVisible(false);
        btnDouble.setEnabled(false);
        btnDouble.addActionListener(this);

        btnTriple.setIcon(new ImageIcon(("./Images/Client Start/Btn Triple.png"))); 
        btnTriple.setBounds(275, 166, 650, 60);
        btnTriple.setContentAreaFilled(false);
        btnTriple.setBorderPainted(false);
        btnTriple.setOpaque(false); 
        btnTriple.setFocusable(false);
        btnTriple.setVisible(false);
        btnTriple.setEnabled(false);
        btnTriple.addActionListener(this);

        btnReservate.setIcon(new ImageIcon(("./Images/Client Start/Btn Reservate.png"))); 
        btnReservate.setBounds(157, 253, 210, 85);
        btnReservate.setContentAreaFilled(false);
        btnReservate.setBorderPainted(false);
        btnReservate.setOpaque(false); 
        btnReservate.setFocusable(false);
        btnReservate.addActionListener(this);
        
        btnReservate2.setIcon(new ImageIcon(("./Images/Client Start/Btn Reservate.png"))); 
        btnReservate2.setBounds(773, 253, 210, 85);
        btnReservate2.setContentAreaFilled(false);
        btnReservate2.setBorderPainted(false);
        btnReservate2.setOpaque(false); 
        btnReservate2.setFocusable(false);
        btnReservate2.addActionListener(this);
        
        pnlRooms.setBounds(13, 257, 1174, 400);
        pnlRooms.setLayout(null);
        pnlRooms.setOpaque(false);
        
        scbRoomsBar.setPreferredSize(new Dimension(0, 42));
        scbRoomsBar.setOrientation(0);
        
        scpRooms.setBounds(13, 257, 1174, 400);
        scpRooms.setBorder(null);
        scpRooms.setHorizontalScrollBar(scbRoomsBar);
        scpRooms.setOpaque(false);
        scpRooms.setViewportView(pnlRooms);
        scpRooms.getViewport().setOpaque(false);
        
        // Add components
        pnlRooms.add(btnReservate);
        pnlRooms.add(btnReservate2);
        
        add(scpRooms);
        
        add(btnProfile);
        add(btnTriple);
        add(btnDouble);
        add(btnSimple);
        add(btnFilter);
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change window */
    public void goToProfile() {
        this.dispose();
        window2 = new Profile();  
    }
    
    public void goToReservation() {
        this.dispose();
        window3 = new Reservation();  
    }
    
    /* Show filters */
    public void showFilters() {
        if(filterState == 1) {
            btnFilter.setIcon(new ImageIcon(("./Images/Client Start/Btn Filter Up.png"))); 
            btnFilter.setBounds(830, 25, 90, 58);
            
            btnSimple.setVisible(true);
            btnSimple.setEnabled(true);

            btnDouble.setVisible(true);
            btnDouble.setEnabled(true);

            btnTriple.setVisible(true);
            btnTriple.setEnabled(true);
        
            filterState = 2;
        } else {
            btnFilter.setIcon(new ImageIcon(("./Images/Client Start/Btn Filter Down.png"))); 
            btnFilter.setBounds(830, 24, 90, 58);
            
            btnSimple.setVisible(false);
            btnSimple.setEnabled(false);

            btnDouble.setVisible(false);
            btnDouble.setEnabled(false);

            btnTriple.setVisible(false);
            btnTriple.setEnabled(false);
            
            filterState = 1;
        }
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnProfile) {
            goToProfile();
        }
        
        if(event.getSource() == btnFilter) {
            showFilters();
        }
        
        if(event.getSource() == btnReservate || event.getSource() == btnReservate2) {
            goToReservation();
        }
    }
}
