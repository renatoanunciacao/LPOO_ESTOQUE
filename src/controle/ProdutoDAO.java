/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 *
 * @author vanes
 */
public class ProdutoDAO {

    Conexao c = new Conexao();
    Connection con = c.getConexao();

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Produto> buscar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "select * from produto";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setNome(rs.getString("pro_nome"));
                p.setDescricao(rs.getString("pro_descricao"));
                p.setId(rs.getInt("pro_id"));
                p.setQuantidade(rs.getInt("pro_qnt"));
                p.setValor(rs.getDouble("pro_valor"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar produtos\n" + e);
        }
        return lista;
    }

    public ArrayList<Produto> buscar(String nome) {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "select * from produto where pro_nome like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setNome(rs.getString("pro_nome"));
                p.setDescricao(rs.getString("pro_descricao"));
                p.setId(rs.getInt("pro_id"));
                p.setQuantidade(rs.getInt("pro_qnt"));
                p.setValor(rs.getDouble("pro_valor"));
                lista.add(p);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar produtos\n" + e);
        }
        return lista;
    }

    public void remover(Produto p) {
        String sql = "delete from produto where pro_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Produto " + p.getNome() + " excluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto "
                    + p.getNome() + "\n" + ex);
        }

    }

    public void inserir(Produto p) {
        String sql = "insert into produto "
                + "(pro_nome, pro_descricao, pro_valor) "
                + "values (?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getValor());
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Produto " + p.getNome() + " incluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto "
                    + p.getNome() + "\n" + ex);
        }

    }

    public void editar(Produto p) {
        String sql = "update produto set "
                + "pro_nome = ?, "
                + "pro_descricao = ?, "
                + "pro_valor = ? "
                + "where pro_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getValor());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Produto " + p.getNome() + " atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto "
                    + p.getNome() + "\n" + ex);
        }

    }
}
