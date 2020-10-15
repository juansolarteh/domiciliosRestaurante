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
    private int atrId;
    private String atrDirecccion;
    private int atrTelefono;
    private ArrayList<Plato> atrMenuSemanal;
    private ArrayList<Plato> atrMenuEspecial;
  
    public Restaurante(int prmId, String prmDireccion, String prmNombre, int prmTelefono) {
        this.atrId = prmId;
        this.atrDirecccion = prmDireccion;
        this.atrNombre = prmNombre;
        this.atrMenuSemanal= new ArrayList<Plato>();
        this.atrMenuEspecial= new ArrayList<Plato>();
        this.atrTelefono = prmTelefono;
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

    public int getAtrId() {
        return atrId;
    }

    public void setAtrNit(int atrId) {
        this.atrId = atrId;
    }

    public String getAtrDirecccion() {
        return atrDirecccion;
    }

    public int getAtrTelefono() {
        return atrTelefono;
    }
    
    public void setAtrDirecccion(String atrDirecccion) {
        this.atrDirecccion = atrDirecccion;
    }

    public void setAtrTelefono(int prmTelefono) {
        this.atrTelefono = prmTelefono;
    }
    
    public ArrayList<Plato> getAtrMenuSemanal() {
        return atrMenuSemanal;
    }

    public void setAtrMenuSemanal(ArrayList<Plato> atrMenuSemanal) {
        this.atrMenuSemanal = atrMenuSemanal;
    }

   
}
