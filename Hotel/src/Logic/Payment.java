package Logic;

public class Payment {
    private String k_idPago;
    private String f_pago;
    
    /* Constructor*/
    public Payment(){
        k_idPago = "";
        f_pago = "";
    }

    /* Getters */
    public String getK_idPago() {
        return k_idPago;
    }
    
    public String getF_pago() {
        return f_pago;
    }

    /* Setters */
    public void setK_idPago(String k_idPago) {
        this.k_idPago = k_idPago;
    }

    public void setF_pago(String f_pago) {
        this.f_pago = f_pago;
    }  
}
