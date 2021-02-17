package Logic;

/**
 * 
 * @author William Alejandro Ardila Sánchez
*/

public class Reservation {
    private String k_codigo;
    private String f_inicio;
    private short q_duracion;
    private String i_estado;
    private short q_cantPersonas;
     
    /* Constructor */
    public Reservation() {
        k_codigo = "";
        f_inicio = "";
        q_duracion = 0;
        i_estado = "";
        q_cantPersonas = 0;
    }
    
    /* Setters */
    public void setK_codigo(String k_code) {
        this.k_codigo = k_code;
    }
    
    public void setF_inicio(String f_start) {
        this.f_inicio = f_start;
    }
    
    public void setQ_duracion(short q_duration) {
        this.q_duracion = q_duration;
    }
 
    public void setI_estado(String i_state) {
        this.i_estado = i_state;
    }
    
    public void setQ_cantPersonas(short q_peopleQuant) {
        this.q_cantPersonas = q_peopleQuant;
    }
    
    /* Getters */
    public String getK_codigo() {
        return k_codigo;
    }
    
    public String getF_inicio() {
        return f_inicio;
    }
    
    public short getQ_duracion() {
        return q_duracion;
    }

    public String getI_estado() {
        return i_estado;
    }
    
    public short getQ_cantPersonas() {
        return q_cantPersonas;
    }
}
