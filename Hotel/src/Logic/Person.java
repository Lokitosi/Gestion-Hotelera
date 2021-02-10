/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Main;

/**
 *
 * @author Julian Sanchez
 */
public class Person {
 
    //ATRIBUTOS
    private int k_numeroid = 0;
    private String k_tipo = "";
    private String n_nombre1 = "";
    private String n_nombre2 = "";
    private String n_apellido1 = "";
    private String n_apellido2= "";
    private int q_telefono = 0;

    //CONSTRUCTOR

    public Person() {
    }

    //GETTERS
    public int getK_numeroid() {
        return k_numeroid;
    }

    public String getK_tipo() {
        return k_tipo;
    }

    public String getN_apellido1() {
        return n_apellido1;
    }

    public String getN_apellido2() {
        return n_apellido2;
    }

    public String getN_nombre1() {
        return n_nombre1;
    }

    public String getN_nombre2() {
        return n_nombre2;
    }

    public int getQ_telefono() {
        return q_telefono;
    }
    
    //SETTERS 

    public void setK_numeroid(int k_numeroid) {
        this.k_numeroid = k_numeroid;
    }

    public void setK_tipo(String k_tipo) {
        this.k_tipo = k_tipo;
    }

    public void setN_apellido1(String n_apellido1) {
        this.n_apellido1 = n_apellido1;
    }

    public void setN_apellido2(String n_apellido2) {
        this.n_apellido2 = n_apellido2;
    }

    public void setN_nombre1(String n_nombre1) {
        this.n_nombre1 = n_nombre1;
    }

    public void setN_nombre2(String n_nombre2) {
        this.n_nombre2 = n_nombre2;
    }

    public void setQ_telefono(int q_telefono) {
        this.q_telefono = q_telefono;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
