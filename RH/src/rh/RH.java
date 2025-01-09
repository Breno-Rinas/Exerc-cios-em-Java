package rh;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RH {

    public static void main(String[] args) {
        geraDb();
        consultaDb();
        //criaTabela();

    }

    public static void geraDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "&reCH1m");
            Statement st = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS recursohumanos";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Banco de dados criado com sucesso");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado");
        }
    }

    public static void criaTabela() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recursohumanos", "root", "&reCH1m");
            Statement st = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS empregados" + "(codigo int(5) primary key," + "nome varchar(50)," + "endereco varchar(40)," + "idade int(2)," + "telefone varchar(15)," + "salario float)";
            st.executeUpdate(sql);

            String sql2 = "INSERT INTO empregados VALUES(1, 'Maria Helena Albuquerque' , 'Rua Bento GOnçalves, 400', 30, '54 999433724', 2000.05)";
            String sql3 = "INSERT INTO empregados VALUES(2, 'Pedro Henrique Almeida' , 'Av.Brasil, 32', 18, '54 98222121', 3400.55)";

            st.executeUpdate(sql3);
            JOptionPane.showMessageDialog(null, "Criou uma tabela e incluiu um registro corretamente!");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado");
        }
    }

    public void consultaDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root", "");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, nome FROM recursohumanos");
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nom = rs.getString("nome");
                System.out.println(codigo + " " + nom);
            }
            JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso");
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte de dados");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado!");
        }
    }
}
