package dao;

import connection.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO {

    //Método para SALVAR/INSERIR um produto no banco
    public void cadastrar(Produto produto) {

        //Aqui salva no banco os valores tanto do nome tanto quanto o preço
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";


        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //Atribuindo valores para a query
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto.");
            e.printStackTrace();
        }
    }

    //Método para LISTAR todos os produtos do banco
    public void listar() {

        //Lista as entidades no banco
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n ----------- Lista de produtos -----------");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("nome") + " | R$ " +
                    rs.getDouble("preco"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao listar produtos. ");
            e.printStackTrace();
        }
    }

    //Método para atualizar produtos no banco
    public void atualizar(int id, String nome, double preco){

        //Uma query para atualizar o banco de dados pelo ID
        String sql = "UPDATE produtos SET nome=?, preco=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setInt(3, id);

            stmt.executeUpdate();

            System.out.println("Produto finalizado!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar!");
            e.printStackTrace();
        }
    }

    //Método para deletar um produto no banco
    public void excluir(int id) {

        //Uma query para deletar os produtos pelo o ID
        String sql = "DELETE FROM produtos WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Produto excluído!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir produto.");
            e.printStackTrace();
        }
    }

}