/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.proyecto.proyectojsf2.beans;

import com.proyecto.proyectojsf2.modelo.Empleado;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author rusok-pro
 */
@SessionScoped
@ManagedBean(name = "emplea")
public class EmpleadoBean implements Serializable{
    private Empleado empleado;
    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
        empleado = new Empleado();//Inicializamos el objeto
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public String registrar(){
        return "registrar?faces-redirect=true";
    }
    public void validadorPass(FacesContext contexto, UIComponent componente, Object valor){
        String password = (String) valor;
        if(password.length()<6 || password.length()>20){
            ((UIInput)componente).setValid(false);
            FacesMessage mensaje = new FacesMessage("El password no tiene la longitud correcta");
            contexto.addMessage(componente.getClientId(contexto), mensaje);
        }
    }
}
