package Logic;

/**
 *
 * @author Santiago Galindo
*/

public class Intake {
 
    private String k_id_consumo;
    private String n_nombre;
    private char i_tipo;       
    private char i_unidad;
    private short q_stock;       
    private double v_valor;
    
    
    // Constructor
    
    public Intake(){
        
        k_id_consumo = "";
        n_nombre = "";
        i_tipo = 0;
        i_unidad = 0;
        q_stock = 0;
        v_valor = 0;
    }

    //Setter and getter
    
    public String getK_id_consumo() {
        return k_id_consumo;
    }

    public void setK_id_consumo(String k_id_consumo) {
        this.k_id_consumo = k_id_consumo;
    }

    public String getN_nombre() {
        return n_nombre;
    }

    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }

    public char getI_tipo() {
        return i_tipo;
    }

    public void setI_tipo(char i_tipo) {
        this.i_tipo = i_tipo;
    }

    public char getI_unidad() {
        return i_unidad;
    }

    public void setI_unidad(char i_unidad) {
        this.i_unidad = i_unidad;
    }

    public short getQ_stock() {
        return q_stock;
    }

    public void setQ_stock(short q_stock) {
        this.q_stock = q_stock;
    }

    public double getV_valor() {
        return v_valor;
    }

    public void setV_valor(double v_valor) {
        this.v_valor = v_valor;
    } 
}
