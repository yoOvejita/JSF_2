/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.proyectojsf2.beans.plantilla;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author rusok-pro
 */
@ManagedBean(name = "inicio2", eager = true)
@SessionScoped
public class InicioBean implements Serializable {

    /**
     * Creates a new instance of InicioBean
     */
    public InicioBean() {
    }
    public String index(){
        return "/inicio/index?faces-redirect=true";
    }
    
}
