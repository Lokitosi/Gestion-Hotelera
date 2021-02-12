package Logic;

/**
 * 
 * @author William Alejandro Ardila Sánchez
*/

public class Room {
    private String k_numero;
    private String i_estado;
    
    /* Constructor */
    public Room() {
        k_numero = "";
        i_estado = "";
    }
    
    /* Setters */
    public void setK_numero(String k_room) {
        this.k_numero = k_room;
    }
    
    public void setI_estado(String i_state) {
        this.i_estado = i_state;
    }
    
    /* Getters */    
    public String getK_numero() {
        return k_numero;
    }
    
    public String getI_estado() {
        return i_estado;
    }
}
