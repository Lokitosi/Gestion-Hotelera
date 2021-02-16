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
public class Cuenta_Consumo {
    
    private String f_consumo;
    private short q_cantidadPedida;
    
    
    public Cuenta_Consumo(){
        
        f_consumo = "";
        q_cantidadPedida = 0;
    }
    
    //Setter and Getter

    public String getF_consumo() {
        return f_consumo;
    }

    public void setF_consumo(String f_consumo) {
        this.f_consumo = f_consumo;
    }

    public short getQ_cantidadPedida() {
        return q_cantidadPedida;
    }

    public void setQ_cantidadPedida(short q_cantidadPedida) {
        this.q_cantidadPedida = q_cantidadPedida;
    }
    
    

}
