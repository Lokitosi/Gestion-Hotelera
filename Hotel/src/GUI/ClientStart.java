package GUI;

/**
 * 4th window
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.CaException;
import DAO.TypeDAO;
import DAO.RoomDAO;
import Logic.RoomType;
import Logic.Room;

public class ClientStart extends JFrame implements ActionListener {
    /* Graphic variables */ 
    private ImageIcon imgScrollBar;
    
    private JLabel lblBackground;
    private JLabel lblFilterName;
    
    private JButton btnProfile;
    private JButton btnFilter;
    private JButton btnSimple;
    private JButton btnDouble;
    private JButton btnTriple;
    private ArrayList<JButton> btnReservateList;
    
    private JPanel pnlAllRooms;
    
    private JScrollBar scbRoomsBar;
    private JScrollPane scpRooms;
    
    /* Logic variables */
    private Profile window2;
    private Reservation window3;
    
    private TypeDAO typeDAO;
    private RoomDAO roomDAO;
    private ArrayList<RoomType> typeList;
    private ArrayList<Room> roomList;
    public static RoomType typeSelected;
    public static Room roomSelected;
    
    private String roomTypeText;
    public static String typeConversion;
    private int roomCant;
    private int roomNumStart;
    private int filterState;
    private int roomPanelPos;
    
    /* Constructor */
    public ClientStart() { 
        typeDAO = new TypeDAO();
        roomDAO = new RoomDAO();
        typeList = new ArrayList<>(); 
        roomList = new ArrayList<>(); 

        filterState = 1;
        roomPanelPos = 5;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        
        // Create components  
        imgScrollBar = new ImageIcon("./Images/Client Start/Btn Slider.png");
        
        lblBackground = new JLabel();
        lblFilterName = new JLabel("        Tipo de habitación", SwingConstants.CENTER);
        
        btnProfile = new JButton();
        btnFilter = new JButton();
        btnSimple = new JButton();
        btnDouble = new JButton();
        btnTriple = new JButton();
        btnReservateList = new ArrayList<>(); 
        
        pnlAllRooms = new JPanel();
        
        scbRoomsBar = new JScrollBar();
        scpRooms = new JScrollPane(null, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Configure components 
        this.setSize(1215, 758);
        this.setLocationRelativeTo(null);
        this.isDisplayable();
        this.setResizable(false);
        
        lblBackground.setIcon(new ImageIcon(("./Images/Client Start/Background.png"))); 
        lblBackground.setBounds(0, 0, 1200, 720);
        
        lblFilterName.setBounds(280, 24, 555, 58);
        lblFilterName.setBorder(null);  
        lblFilterName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        lblFilterName.setForeground(new Color(24, 24, 24));   
        
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
        
        pnlAllRooms.setBounds(13, 257, 1174, 400);
        pnlAllRooms.setPreferredSize(new Dimension(roomCant * 700, 400));
        pnlAllRooms.setLayout(null);
        pnlAllRooms.setOpaque(false);
        
        scbRoomsBar.setPreferredSize(new Dimension(0, 42));
        scbRoomsBar.setOrientation(0);
        
        scpRooms.setBounds(13, 257, 1174, 400);
        scpRooms.setBorder(null);
        scpRooms.setHorizontalScrollBar(scbRoomsBar);
        scpRooms.setOpaque(false);
        scpRooms.setViewportView(pnlAllRooms);
        scpRooms.getViewport().setOpaque(false);
        
        // Add components
        add(scpRooms);
        
        add(btnProfile);
        add(btnTriple);
        add(btnDouble);
        add(btnSimple);
        add(btnFilter);
        
        add(lblFilterName);
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
    
    /* Manage filters */
    public void addFilter(String filterName) {
        roomCant = 0;
        lblFilterName.setText("         " + filterName);
        deleteRooms();
        
        try {
            for(int i = roomNumStart; i < (roomNumStart + roomDAO.getAllRoomsByType(roomTypeText)); i++) {
                switch (Integer.toString(i).length()) {
                    case 1:
                        addRoomInfo("H00" + Integer.toString(i));
                        break;
                        
                    case 2:
                        addRoomInfo("H0" + Integer.toString(i));
                        break;
                        
                    case 3: 
                        addRoomInfo("H" + Integer.toString(i));
                        break;
                        
                    default:
                        break;
                }
                
                roomCant += 1;
            }
            
        } catch (CaException e) {
            Logger.getLogger(ClientStart.class.getName()).log(Level.SEVERE, null, e);
        }
            /*System.out.println(roomList.get(1).getK_numero());
            System.out.println(roomList.get(2).getK_numero());
            System.out.println(roomList.get(3).getK_numero());*/
        
        pnlAllRooms.setPreferredSize(new Dimension(roomCant * 700, 400));
    }
    
    /* Manage rooms */
    public void addRoomInfo(String roomNumber) throws CaException {
        TypeDAO typeDAOTemp = new TypeDAO();
        RoomDAO roomDAOTemp = new RoomDAO();
        
        typeDAOTemp.getTypeByID(roomTypeText);
        roomDAOTemp.getRoomByID(roomNumber);
        
        RoomType roomType = new RoomType();
        roomType = typeDAOTemp.getType();
        Room room = new Room(); 
        room = roomDAOTemp.getRoom();
        
        typeList.add(roomType);
        roomList.add(room);
        
        createRoom(roomType, room);
    }
    
    public void createRoom(RoomType type, Room room) {
        if(type.getK_idTipo().equals("T001")) {
            typeConversion = "Simple";
        } else if(type.getK_idTipo().equals("T002")) {
            typeConversion = "Doble";
        } else if(type.getK_idTipo().equals("T003")) {
            typeConversion = "Triple";
        }
        
        // Create components
        JLabel lblRoomImage = new JLabel();
        JLabel lblRoomInfo = new JLabel();
        JLabel lblNumber = new JLabel(room.getK_numero(), SwingConstants.CENTER);
        JLabel lblType = new JLabel(typeConversion, SwingConstants.CENTER);
        JLabel lblDescription = new JLabel(type.getN_descripcion(), SwingConstants.CENTER);
        JLabel lblPrice = new JLabel("$" + type.getV_precio(), SwingConstants.CENTER);
        
        JButton btnReservate = new JButton(); 
        
        JPanel pnlRoomInfo = new JPanel();
        JPanel pnlRoom = new JPanel();
        
        // Configure components 
        lblRoomImage.setIcon(new ImageIcon(("./Images/Client Start/Lbl Room Image.png"))); 
        lblRoomImage.setBounds(-3, 0, 245, 222);
        
        lblRoomInfo.setIcon(new ImageIcon(("./Images/Client Start/Lbl Room Info.png"))); 
        lblRoomInfo.setBounds(-5, 0, 355, 222);
        
        lblNumber.setBounds(190, 25, 150, 30);
        lblNumber.setBorder(null);
        lblNumber.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblNumber.setForeground(new Color(24, 24, 24)); 
	lblNumber.setOpaque(false);
        
        lblType.setBounds(85, 75, 255, 30);
        lblType.setBorder(null);
        lblType.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblType.setForeground(new Color(24, 24, 24)); 
	lblType.setOpaque(false);
        
        lblDescription.setBounds(175, 125, 165, 30);
        lblDescription.setBorder(null);
        lblDescription.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblDescription.setForeground(new Color(24, 24, 24)); 
	lblDescription.setOpaque(false);
        
        lblPrice.setBounds(175, 175, 165, 30);
        lblPrice.setBorder(null);
        lblPrice.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 19));
        lblPrice.setForeground(new Color(24, 24, 24)); 
	lblPrice.setOpaque(false);
        
        btnReservate.setIcon(new ImageIcon(("./Images/Client Start/Btn Reservate.png"))); 
        btnReservate.setBounds(157, 240, 210, 85);
        btnReservate.setContentAreaFilled(false);
        btnReservate.setBorderPainted(false);
        btnReservate.setOpaque(false); 
        btnReservate.setFocusable(false);
        btnReservate.addActionListener(this);
        
        pnlRoomInfo.setBounds(295, 0, 350, 222);
        pnlRoomInfo.setLayout(null);
        pnlRoomInfo.setOpaque(false);
        
        pnlRoom.setBounds(roomPanelPos, 15, 645, 335);
        pnlRoom.setLayout(null);
        pnlRoom.setOpaque(false);     
        
        // Add components 
        pnlRoomInfo.add(lblPrice);
        pnlRoomInfo.add(lblDescription);
        pnlRoomInfo.add(lblType);
        pnlRoomInfo.add(lblNumber); 
        pnlRoomInfo.add(lblRoomInfo);
        
        pnlRoom.add(pnlRoomInfo);
        pnlRoom.add(lblRoomImage);
        pnlRoom.add(btnReservate);  
        
        pnlAllRooms.add(pnlRoom);
        
        scpRooms.setViewportView(pnlAllRooms);
        scpRooms.getViewport().setOpaque(false);
        
        btnReservateList.add(btnReservate);
        
        roomPanelPos += 700;
    }
    
    public void deleteRooms() {
        btnReservateList.removeAll(btnReservateList);
        typeList.removeAll(typeList);
        roomList.removeAll(roomList);
        
        pnlAllRooms.removeAll();
        pnlAllRooms.revalidate();
        
        roomPanelPos = 5;
    }
    
    /* Button actions */
    public void actionPerformed(ActionEvent event) { 
        if(event.getSource() == btnProfile) {
            goToProfile();
        }
        
        if(event.getSource() == btnFilter) {
            showFilters();
        }
        
        if(event.getSource() == btnSimple) {
            roomNumStart = 1;
            roomTypeText = "T001";
            showFilters();
            addFilter("Simple");
        } else if(event.getSource() == btnDouble) {
            roomNumStart = 5;
            roomTypeText = "T002";
            showFilters();
            addFilter("Doble");
        } else if(event.getSource() == btnTriple) {
            roomNumStart = 9;
            roomTypeText = "T003";
            showFilters();
            addFilter("Triple");
        }
        
        for(int i = 0; i < btnReservateList.size(); i++) {
            if(event.getSource() == btnReservateList.get(i)) {
                roomSelected = roomList.get(i);
                typeSelected = typeList.get(i);
                goToReservation();
            }
        }      
    }
}
