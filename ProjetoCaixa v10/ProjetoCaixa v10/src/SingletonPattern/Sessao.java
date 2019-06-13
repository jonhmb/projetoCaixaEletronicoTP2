/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingletonPattern;

/**
 *
 * @author Jonathan
 */
public class Sessao {
    public static Sessao instancia; 
    String nome; 
    Float saldo; 
    int id; 

    public int getId() {
        return instancia.id;
    }

    public void setId(int id) {
        instancia.id = id;
    }
    
    
     
    //Construtor
    public Sessao(){
        
    }
    
    //Get para nome que é pego no Login
    public String getNome() {
        return instancia.nome;
    }
    
    //Set para nome que é pego no login ser setado em outras telas
    public void setNome(String nome) {
        instancia.nome = nome; 
    }

    public Float getSaldo() {
        return instancia.saldo;
    }

    public void setSaldo(Float saldo) {
        instancia.saldo = saldo;
    }
    
    
    
    //Instancia a variavel ao fazer login
    public static synchronized Sessao getSessao(){ 
        if(instancia == null)
            instancia = new Sessao(); 
        
        return instancia; 
    }
    
   
    
}
