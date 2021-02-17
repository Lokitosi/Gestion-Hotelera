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
public class Bill_Consumption {
    
    private String f_consumo;
    private short q_cantidadPedida;
    
    
    /* Constructor */
    public Bill_Consumption(){
        f_consumo = "";
        q_cantidadPedida = 0;
    }
    
    /* Getters */

    public String getF_consumo() {
        return f_consumo;
    }
    
    public short getQ_cantidadPedida() {
        return q_cantidadPedida;
    }
    
    /* Setters */
    public void setF_consumo(String f_consumo) {
        this.f_consumo = f_consumo;
    }
    
    public void setQ_cantidadPedida(short q_cantidadPedida) {
        this.q_cantidadPedida = q_cantidadPedida;
    }
    
}
