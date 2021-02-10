package Logic;

/**
 *
*/

public class Room {
    private long k_roomNumber;
    private char i_state;
    
    /* Constructor */
    public Room() {
        k_roomNumber = 0;
        i_state = 0;
    }
    
    /* Setters */
    public void setRoomNumber(long k_room) {
        this.k_roomNumber = k_room;
    }
    
    public void setState(char i_state) {
        this.i_state = i_state;
    }
    
    /* Getters */    
    public long getRoomNumber() {
        return k_roomNumber;
    }
}
