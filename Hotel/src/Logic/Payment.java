/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

public class Payment {
    private String k_idPago;
    private String f_pago;
    
    public Payment(){
        k_idPago = "";
        f_pago = "";
    }

    public String getK_idPago() {
        return k_idPago;
    }

    public void setK_idPago(String k_idPago) {
        this.k_idPago = k_idPago;
    }

    public String getF_pago() {
        return f_pago;
    }

    public void setF_pago(String f_pago) {
        this.f_pago = f_pago;
    }
    
    
}
