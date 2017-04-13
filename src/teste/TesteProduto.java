/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.ProdutoDAO;

/**
 *
 * @author vanes
 */
public class TesteProduto {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        System.out.println(dao.buscar());
    }
}
