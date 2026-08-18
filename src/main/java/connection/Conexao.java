package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //Configurações de acesso ao MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; //Troque pela sua senha

    //Método para obter conexão
    public static Connection conectar() {

        try {
            //Tenta entrar no banco de dados, com as informações dada, se não entrar, mostre os dados do erro
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados!");
            e.printStackTrace();
            return null;
        }
    }
}