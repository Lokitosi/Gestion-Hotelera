package Logic;

/**
 *
 * @author Julian Sanchez
*/

public class RegisterCI {
    
    private String k_registro = "";
    private String f_inicio = "";
    private String f_salida = "";
    
    //CONSTRUCTOR 

    public RegisterCI() {
    
    }

    //GETTERS

    public String getF_inicio() {
        return f_inicio;
    }

    public String getF_salida() {
        return f_salida;
    }

    public String getK_registro() {
        return k_registro;
    }
    
    //SETTERS 

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public void setF_salida(String f_salida) {
        this.f_salida = f_salida;
    }

    public void setK_registro(String k_registro) {
        this.k_registro = k_registro;
    }     
}
