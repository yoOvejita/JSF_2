/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.proyectojsf2.beans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author rusok-pro
 */
@ManagedBean(name = "frijolacerca", eager=true)
@SessionScoped
public class AcercaBean implements Serializable {

    /**
     * Creates a new instance of AcercaBean
     */
    public AcercaBean() {
    }
    
    public String index(){
        System.out.println("Llama a la vista de acerca");
        return "acerca?faces-redirect=true";
    }
    
}
