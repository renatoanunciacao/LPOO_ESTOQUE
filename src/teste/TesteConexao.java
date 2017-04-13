/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Produto;

/**
 *
 * @author vanes
 */
public class TesteConexao {
    public static void main(String[] args) {
        try{
            Conexao c = new Conexao();
            Connection con = c.getConexao();
            
            PreparedStatement ps = con.prepareStatement(
                    "select * from produto where pro_nome like ?");
            String x = "n";
            ps.setString(1, x+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produto p = new Produto();
                p.setNome(rs.getString("pro_nome"));
                p.setDescricao(rs.getString("pro_descricao"));
                p.setId(rs.getInt("pro_id"));
                p.setQuantidade(rs.getInt("pro_qnt"));
                p.setValor(rs.getDouble("pro_valor"));
                System.out.println(p);
            }
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }
}
