package org.example.teste.database;

import org.example.teste.model.Produto;

import java.sql.*;
import java.util.ArrayList;


public class ProdutoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/mercado";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";

    // inserir
    public void adicionarProduto(Produto produto) {

        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";

        try {

            Connection database = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement stmt = database.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());

            stmt.executeUpdate();

            System.out.println("Produto adicionado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto");
        }
    }

    // listar
    public ArrayList<Produto> listarProdutos() {
        String sql = "SELECT * FROM produto";

        try {

            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            ArrayList<Produto> listaDeProdutos = new ArrayList<>();

            while (resultado.next()) {

                Produto produto = new Produto();

                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                float preco = resultado.getFloat("preco");

                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setId(id);

                listaDeProdutos.add(produto);
            }
            return listaDeProdutos;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar produto.");
            return new ArrayList<>();
        }
    }

    // atualizar
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";

        try {

            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());
            stmt.setInt(3, produto.getId());

            stmt.executeUpdate();

            System.out.println("Produto atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("O ID do produto não existe.");
        }
    }

    // deletar
    public void removerProduto(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try {

            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            System.out.println("O ID informado não foi encontrado");
        }
    }
}