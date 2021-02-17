package Logic;

/**
 *
 * @author andre
*/

public class Bill {
    private String k_cuenta;
    private String id_Pago;

    /* Constructor*/
    public Bill(){
        k_cuenta = "";
        id_Pago = "";
    }

    /* Getters */
    public String getK_cuenta() {
        return k_cuenta;
    }

    public String getId_Pago() {
        return id_Pago;
    }
    
    /* Setters */
    public void setK_cuenta(String k_cuenta) {
        this.k_cuenta = k_cuenta;
    }
    
    public void setId_Pago(String id_Pago) {
        this.id_Pago = id_Pago;
    }  
}
