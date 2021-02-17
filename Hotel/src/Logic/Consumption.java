/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Santiago Galindo
 */
public class Consumption {
 
    private String k_id_consumo;
    private String n_nombre;
    private String i_tipo;       
    private String i_unidad;
    private short q_stock;       
    private double v_valor;
    
    
    // Constructor
    
    public Consumption(){
        
        k_id_consumo = "";
        n_nombre = "";
        i_tipo = "";
        i_unidad = "";
        q_stock = 0;
        v_valor = 0;
    }

    /* Getters */
    
    public String getK_id_consumo() {
        return k_id_consumo;
    }

    public String getI_tipo() {
        return i_tipo;
    }

    public String getN_nombre() {
        return n_nombre;
    }
    
    public String getI_unidad() {
        return i_unidad;
    }
    
    public short getQ_stock() {
        return q_stock;
    }
    
    public double getV_valor() {
        return v_valor;
    }
    /* Setters */
    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }
    
    public void setK_id_consumo(String k_id_consumo) {
        this.k_id_consumo = k_id_consumo;
    }   

    public void setI_tipo(String i_tipo) {
        this.i_tipo = i_tipo;
    }

    public void setI_unidad(String i_unidad) {
        this.i_unidad = i_unidad;
    }

    public void setQ_stock(short q_stock) {
        this.q_stock = q_stock;
    }

    public void setV_valor(double v_valor) {
        this.v_valor = v_valor;
    }
    
}
