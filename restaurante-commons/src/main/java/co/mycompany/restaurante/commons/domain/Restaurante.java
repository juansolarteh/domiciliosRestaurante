package co.mycompany.restaurante.commons.domain;

import java.util.Date;
import java.util.ArrayList;
/**
 * Cliente de la agencia de viajes
 *
 * @author Libardo, Julio
 */
public class Restaurante {

    private String atrNombre;
    private int atrNit;
    private String atrDirecccion;
    private ArrayList<Plato> atrMenuSemanal;
    private ArrayList<Plato> atrMenuEspecial;
  
    public Restaurante(int prmNit, String prmDireccion, String prmNombre) {
        this.atrNit = prmNit;
        this.atrDirecccion = prmDireccion;
        this.atrNombre = prmNombre;
        this.atrMenuSemanal= new ArrayList<Plato>();
        this.atrMenuEspecial= new ArrayList<Plato>();
    }

    public ArrayList<Plato> getAtrMenuEspecial() {
        return atrMenuEspecial;
    }

    public void setAtrMenuEspecial(ArrayList<Plato> atrMenuEspecial) {
        this.atrMenuEspecial = atrMenuEspecial;
    }
    
    
    public Restaurante() {

    }

    public String getAtrNombre() {
        return atrNombre;
    }

    public void setAtrNombre(String atrNombre) {
        this.atrNombre = atrNombre;
    }

    public int getAtrNit() {
        return atrNit;
    }

    public void setAtrNit(int atrNit) {
        this.atrNit = atrNit;
    }

    public String getAtrDirecccion() {
        return atrDirecccion;
    }

    public void setAtrDirecccion(String atrDirecccion) {
        this.atrDirecccion = atrDirecccion;
    }

    public ArrayList<Plato> getAtrMenuSemanal() {
        return atrMenuSemanal;
    }

    public void setAtrMenuSemanal(ArrayList<Plato> atrMenuSemanal) {
        this.atrMenuSemanal = atrMenuSemanal;
    }

   
}
