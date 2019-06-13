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
public class Saque {
    int id_saque; 
    float valor; 
    int id_contaFK; 

    public Saque() {
    }

    public int getId_saque() {
        return id_saque;
    }

    public void setId_saque(int id_saque) {
        this.id_saque = id_saque;
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
