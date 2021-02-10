/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author andre
 */
public class Bill {
        private String k_cuenta;
    private String id_Pago;

    public Bill(){
        k_cuenta = "";
        id_Pago = "";
    }
    public String getK_cuenta() {
        return k_cuenta;
    }

    public void setK_cuenta(String k_cuenta) {
        this.k_cuenta = k_cuenta;
    }

    public String getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(String id_Pago) {
        this.id_Pago = id_Pago;
    }
    
    
}
