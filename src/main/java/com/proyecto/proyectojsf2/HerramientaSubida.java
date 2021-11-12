/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyectojsf2;

import javax.faces.application.FacesMessage;
import jakarta.servlet.http.Part;//Usado para el objeto a ser subido
import java.io.File;//Usado para separador de direccion
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.faces.context.FacesContext;

/**
 *
 * @author rusok-pro
 */
public class HerramientaSubida {
        private final int LIMITE_MAXIMO = 1024 * 10000;
        private final String
                DIRECCION = "resources" + File.separator + "imagenes",
                TIPOS_DE_ARCHIVO = "jpeg|jpg|png|gif";
        public String subir(Part archivo){
            String aGuardarse = "nada.jpg";
            try{
                if(archivo.getSize()>0){//Si tiene datos (bytes)
                    String nombreArchivo = obtenerNombreDelArchivo(archivo);
                    if(tieneUnaExtensionSoportada(nombreArchivo)){
                        if(archivo.getSize() > LIMITE_MAXIMO)
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tamaño de archivo excesivo",""));//OJO al import
                        else{
                            String extension = nombreArchivo.substring(
                                    nombreArchivo.lastIndexOf("."),
                                    nombreArchivo.length());
                            Long nombreAleatorio = Calendar.getInstance().getTimeInMillis();//Tiempo actual en milisegundos del servidor
                            aGuardarse = nombreAleatorio + extension;
                            String direccionDeGuardado = FacesContext
                                    .getCurrentInstance()
                                    .getExternalContext()
                                    .getRealPath("") + DIRECCION;
                            
                            //Obtenemos el contenido del archivo en un arreglo
                            byte[] contenido = new byte[(int)archivo.getSize()];//arreglo de bytes de misma longitud de archivo (en bytes)
                            InputStream is = archivo.getInputStream();
                            is.read(contenido);
                            
                            //Preparamos el objeto File para escribirlo en el almacenamiento
                            File archivoServidor = new File(direccionDeGuardado,aGuardarse);
                            File folder = new File(direccionDeGuardado);//El folder donde se guardará
                            if(!folder.exists())
                                folder.mkdirs();
                            //Escribimos
                            FileOutputStream fos = new FileOutputStream(archivoServidor);
                            fos.write(contenido);
                            fos.flush();
                            fos.close();
                        }
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return aGuardarse;
        }

    private String obtenerNombreDelArchivo(Part archivo) {
        for(String elem : archivo.getHeader("content-disposition").split(";")){
            if(elem.trim().startsWith("filename")){
                String nombre = elem.substring(elem.indexOf("=")+1); // "filename=documentos/varios/archivito.jpg"
                return nombre.substring(nombre.lastIndexOf('/') + 1).substring(nombre.lastIndexOf('\\') +1);
            }
        }
        return null;
    }

    private boolean tieneUnaExtensionSoportada(String nombre) {
        if(nombre.length()>0){
            String[] elementos = nombre.split("\\.");
            if(elementos.length > 0){
                String extnsion = elementos[elementos.length - 1];
                return TIPOS_DE_ARCHIVO.contains(extnsion);
            }
        }
        return false;
    }
}
