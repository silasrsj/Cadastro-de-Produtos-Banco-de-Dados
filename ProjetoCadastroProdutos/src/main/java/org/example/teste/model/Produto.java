package org.example.teste.model;

public class Produto {
    private int id;
    private String nome;
    private float preco;

    public Produto(String nome, float preco, int id) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }

    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Preço: " + preco + "\n";
    }
}