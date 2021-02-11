/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Julian Sanchez
 */
public class Host extends Person {
    
    /*ATRIBUTOS*/
    private String f_nacimiento;
    private String n_direccion;

    /*CONSTRUCTOR*/
    public Host() {
       f_nacimiento = "";
       n_direccion = "";
    }
    
    /*GETTERS*/

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public String getN_direccion() {
        return n_direccion;
    }

    
     /*SETTERS*/

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public void setN_direccion(String n_direccion) {
        this.n_direccion = n_direccion;
    }
    
    
}
