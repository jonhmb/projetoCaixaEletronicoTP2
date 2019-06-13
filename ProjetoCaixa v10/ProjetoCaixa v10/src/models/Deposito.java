/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Tainah e Leo
 */
public class Deposito {
    int id_deposito; 
    float valor; 
    int id_contaFK; 

    public Deposito() {
    }

    public int getId_deposito() {
        return id_deposito;
    }

    public void setId_deposito(int id_deposito) {
        this.id_deposito = id_deposito;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId_contaFK() {
        return id_contaFK;
    }

    public void setId_contaFK(int id_contaFK) {
        this.id_contaFK = id_contaFK;
    }
    
    
}
