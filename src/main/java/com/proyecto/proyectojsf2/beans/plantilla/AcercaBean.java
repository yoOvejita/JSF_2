/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.proyectojsf2.beans.plantilla;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author rusok-pro
 */
@ManagedBean(name = "acerca2", eager = true)
@SessionScoped
public class AcercaBean implements Serializable {

    /**
     * Creates a new instance of AcercaBean
     */
    public AcercaBean() {
    }
    public String index(){
        return "/acerca/acerca?faces-redirect=true";
    }
    public String acerca1(){//personal
        return "/acerca/acerca1?faces-redirect=true";
    }
    public String acerca2(){//infraestructura
        return "/acerca/acerca2?faces-redirect=true";
    }
    
}
