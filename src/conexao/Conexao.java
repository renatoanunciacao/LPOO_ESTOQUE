/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vanes
 */
public class Conexao {
    public Conexao(){
         try{
            Class.forName("org.postgresql.Driver");
         }catch(Exception e){
             System.err.println("Erro ao carregar o Driver");
         }
    }
    
    public Connection getConexao(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/LPOO_Estoque", 
                    "postgres", 
                    "armagedom");
        }catch(Exception e){
            System.err.println("Erro ao conectar ao Banco: \n"+e);
        }
        return con;
    }
}
