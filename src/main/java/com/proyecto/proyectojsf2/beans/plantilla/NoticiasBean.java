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
@ManagedBean(name = "noticias2", eager = true)
@SessionScoped
public class NoticiasBean implements Serializable {

    /**
     * Creates a new instance of NoticiasBean
     */
    public NoticiasBean() {
    }
    public String index(){//personal
        return "/noticias/noticias?faces-redirect=true";
    }
    public String noticias1(){//nuevos productos
        return "/noticias/noticias1?faces-redirect=true";
    }
    public String noticias2(){//personal destacado
        return "/noticias/noticias2?faces-redirect=true";
    }
    public String noticias3(){//eventos 
        return "/noticias/noticias3?faces-redirect=true";
    }
}
