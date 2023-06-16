import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaInserir {
    static {
        try {
            String driverPath = "C:\\Users\\rafael.santos\\PROJETO\\trabalho\\lib\\sqlite-jdbc-1.4.jar";
            Class.forName("org.sqlite.JDBC");
            System.setProperty("jdbc.driver.path", driverPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void criarPessoa(Pessoa pessoa) throws SQLException {
        Connection connection = SQLiteConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO pessoas (nome, idade, email, telefone, endereco) VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, pessoa.getNome());
        statement.setInt(2, pessoa.getIdade());
        statement.setString(3, pessoa.getEmail());
        statement.setString(4, pessoa.getTelefone());
        statement.setString(5, pessoa.getEndereco());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Pessoa> listarPessoas() throws SQLException {
        Connection connection = SQLiteConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM pessoas");
        ResultSet resultSet = statement.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();
        while (resultSet.next()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(resultSet.getInt("id"));
            pessoa.setNome(resultSet.getString("nome"));
            pessoa.setIdade(resultSet.getInt("idade"));
            pessoa.setEmail(resultSet.getString("email"));
            pessoa.setTelefone(resultSet.getString("telefone"));
            pessoa.setEndereco(resultSet.getString("endereco"));
            pessoas.add(pessoa);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return pessoas;
    }

    public void atualizarPessoa(Pessoa pessoa) throws SQLException {
        Connection connection = SQLiteConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE pessoas SET nome = ?, idade = ?, email = ?, telefone = ?, endereco = ? WHERE id = ?");
        statement.setString(1, pessoa.getNome());
        statement.setInt(2, pessoa.getIdade());
        statement.setString(3, pessoa.getEmail());
        statement.setString(4, pessoa.getTelefone());
        statement.setString(5, pessoa.getEndereco());
        statement.setInt(6, pessoa.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void excluirPessoa(int id) throws SQLException {
        Connection connection = SQLiteConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM pessoas WHERE id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
