/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.DecimalFormat;

/**
 *
 * @author vanes
 */
public class Produto {
    DecimalFormat df = new DecimalFormat("0.00");
    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String toString(){
        return nome +" (R$ "+df.format(valor)+")";
    }
    
    public String exibirDados(){
        String msg = "";
        msg += "Produto: "+nome;
        msg += "\nDescrição: "+descricao;
        msg += "\nQuantidade: "+quantidade;
        msg += "\nValor: R$ "+df.format(valor);
        return msg;
    }
}
