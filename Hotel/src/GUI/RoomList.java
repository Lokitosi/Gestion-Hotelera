package GUI;

/**
 * 9th window
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomList extends JFrame implements ActionListener {
    /* Graphic variables */
    private JLabel lblBackground;
    
    private JButton btnSearch;
    private JButton btnReport;
    private JButton btnCheckOut;
    private JButton btnExit;
    
    /* Logic variables */
    private Searches window2;
    private Report window3;
    private CheckOut window4;
    private Start window5;
    
    /* Constructor */
    public RoomList() {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components
        lblBackground = new JLabel();
        
        btnSearch = new JButton();
        btnReport = new JButton();
        btnCheckOut = new JButton();
        btnExit = new JButton();
        
        // Configure components 
        this.setSize(1215, 758);
        this.getContentPane().setLayout(null); 
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        
        lblBackground.setIcon(new ImageIcon(("./Images/Room List/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        btnSearch.setIcon(new ImageIcon(("./Images/Room List/Btn Search.png"))); 
        btnSearch.setBounds(892, 182, 220, 70);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setBorderPainted(false);
        btnSearch.setOpaque(false); 
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(this);
        
        btnReport.setIcon(new ImageIcon(("./Images/Room List/Btn Report.png"))); 
        btnReport.setBounds(854, 293, 300, 70);
        btnReport.setContentAreaFilled(false);
        btnReport.setBorderPainted(false);
        btnReport.setOpaque(false); 
        btnReport.setFocusable(false);
        btnReport.addActionListener(this);
        
        btnCheckOut.setIcon(new ImageIcon(("./Images/Room List/Btn Check Out.png"))); 
        btnCheckOut.setBounds(893, 405, 220, 70);
        btnCheckOut.setContentAreaFilled(false);
        btnCheckOut.setBorderPainted(false);
        btnCheckOut.setOpaque(false); 
        btnCheckOut.setFocusable(false);
        btnCheckOut.addActionListener(this);
        
        btnExit.setIcon(new ImageIcon(("./Images/Room List/Btn Exit.png"))); 
        btnExit.setBounds(876, 520, 255, 70);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false); 
        btnExit.setFocusable(false);
        btnExit.addActionListener(this);
        
        // Add components 
        add(btnSearch);
        add(btnReport);
        add(btnCheckOut);
        add(btnExit);
        
        add(lblBackground);
        
        this.setVisible(true);
    }
    
    /* Change windows */
    public void goToSearch() {
        this.dispose();
        window2 = new Searches(); 
    }
    
    public void goToReport() {
        this.dispose();
        window3 = new Report(); 
    }
    
    public void goToCheckOut() {
        this.dispose();
        window4 = new CheckOut(); 
    }
    
    public void goToStart() {
        this.dispose();
        window5 = new Start(); 
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == btnSearch) {
            goToSearch();
        }
        
        if(event.getSource() == btnReport) {
            goToReport();
        }
        
        if(event.getSource() == btnCheckOut) {
            goToCheckOut();
        }
        
        if(event.getSource() == btnExit) {
            goToStart();
        }
    }
}
