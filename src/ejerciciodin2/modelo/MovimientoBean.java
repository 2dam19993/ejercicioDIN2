/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodin2.modelo;

import java.beans.*;
import java.io.Serializable;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 2dam
 */
public class MovimientoBean  {
    private final SimpleStringProperty fecha;
    private final SimpleFloatProperty balance;
    private final SimpleFloatProperty cantidad;
    private final SimpleStringProperty descripcion;
    
    public MovimientoBean(String fecha, float balance, float cantidad, String descripcion){
        this.fecha= new SimpleStringProperty (fecha);
        this.balance= new SimpleFloatProperty (balance);
        this.cantidad= new SimpleFloatProperty (cantidad);
        this.descripcion= new SimpleStringProperty (descripcion);
        
    }
    public String getFecha(){
        return this.fecha.get();
    }
    public void setFecha(String fecha){
        this.fecha.set(fecha);
    }
      public float getBalance(){
        return this.balance.get();
    }
    public void setBalance(float balance){
        this.balance.set(balance);
    }
      public float getCantidad(){
        return this.cantidad.get();
    }
    public void setCantidad(float cantidad){
        this.cantidad.set(cantidad);
    }
      public String getDescripcion(){
        return this.descripcion.get();
    }
    public void setDescripcion(String descripcion){
        this.descripcion.set(descripcion);
    }
}
