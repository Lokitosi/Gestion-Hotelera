package Logic;

/**
 *
 * @author Santiago Galindo
 */
public class Hotel {
    
    private String k_idHotel;
    private short t_descuento;
    private short q_restriccionAforo;

    //Constructor
    
    public Hotel(){
        k_idHotel = "";
        t_descuento = 0;
        q_restriccionAforo = 0;
    }
    
    /* Getters */

    public String getK_idHotel() {
        return k_idHotel;
    }

    public short getT_descuento() {
        return t_descuento;
    }
    
    public short getQ_restriccionAforo() {
        return q_restriccionAforo;
    }
    /* Setters */
    public void setK_idHotel(String k_idHotel) {
        this.k_idHotel = k_idHotel;
    }

    public void setT_descuento(short t_descuento) {
        this.t_descuento = t_descuento;
    }

    public void setQ_restriccionAforo(short q_restriccionAforo) {
        this.q_restriccionAforo = q_restriccionAforo;
    }  
}
    