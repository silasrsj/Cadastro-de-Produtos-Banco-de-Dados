package org.example.teste.principal;

import org.example.teste.database.ProdutoDAO;
import org.example.teste.model.Produto;


import java.util.Scanner;
import java.util.ArrayList;

public class PrincipalProduto {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner teclado = new Scanner(System.in);

        System.out.println("----- LISTA DE PRODUTOS -----");
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Remover Produto");
            System.out.println("5 - Sair");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1: {
                    Produto produto = lerDados(teclado);
                    produtoDAO.adicionarProduto(produto);
                    break;
                }
                case 2: {
                    ArrayList<Produto> produtos = produtoDAO.listarProdutos();
                    for (Produto p: produtos) {
                        System.out.println(p);
                    }
                    break;
                }
                case 3: {
                    Produto produto = atualizarProduto(teclado);
                    produtoDAO.atualizarProduto(produto);
                    break;
                }
                case 4: {
                    System.out.println("Informe o ID do produto que deseja remover: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    produtoDAO.removerProduto(id);
                    break;
                }
                case 5: {
                    sair = true;
                    System.out.println("Programa encerrado!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida, tente novamente");
                }
            }
        }
    }

    public static Produto lerDados(Scanner teclado) {
        System.out.println("Informe o nome do produto: ");
        String nome = teclado.nextLine();
        System.out.println("Informe o valor do produto: ");
        float preco = teclado.nextFloat();
        teclado.nextLine();
        return new Produto(nome, preco);
    }

    public static Produto atualizarProduto(Scanner teclado) {
        System.out.println("Informe o ID do produto que deseja atualizar: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        Produto produto = lerDados(teclado);
        produto.setId(id);

        return produto;
    }
}