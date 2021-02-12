package Logic;

/**
 * 
 * @author William Alejandro Ardila Sánchez
*/

public class Reservation {
    private String k_codigo;
    private String f_inicio;
    private int q_duracion;
    private String i_estado;
    private int q_cantPersonas;
     
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
    
    public void setQ_duracion(int q_duration) {
        this.q_duracion = q_duration;
    }
 
    public void setI_estado(String i_state) {
        this.i_estado = i_state;
    }
    
    public void setQ_cantPersonas(int q_peopleQuant) {
        this.q_cantPersonas = q_peopleQuant;
    }
    
    /* Getters */
    public String getK_codigo() {
        return k_codigo;
    }
    
    public String getF_inicio() {
        return f_inicio;
    }
    
    public int getQ_duracion() {
        return q_duracion;
    }

    public String getI_estado() {
        return i_estado;
    }
    
    public int getQ_cantPersonas() {
        return q_cantPersonas;
    }
}
