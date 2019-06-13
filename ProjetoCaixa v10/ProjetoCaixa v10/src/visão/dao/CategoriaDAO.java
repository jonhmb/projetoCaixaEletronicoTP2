/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visão.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import visão.TelaCadastrar;

/**
 * CRUD
 * @author jonhm
 */
public class CategoriaDAO {
    
    private Connection con = null; 

    public CategoriaDAO() {
        con = ConnectionFactory.getConnection(); 
    } 
    
    public boolean save(TelaCadastrar telaCadastro) { 
      
        String sql = "INTERT INTO conta (dados) VALUES (txt)  "; 
        
        PreparedStatement stmt = null; 
        
        try {
            stmt = con.prepareCall(sql);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    
}
