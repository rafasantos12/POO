import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PessoaInserir pessoaInserir = new PessoaInserir(); 
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("João");
        pessoa1.setIdade(25);
        pessoa1.setEmail("joao@example.com");
        pessoa1.setTelefone("(11) 98765-4321");
        pessoa1.setEndereco("Rua A, 123");
        try {
            pessoaInserir.criarPessoa(pessoa1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        try {
            List<Pessoa> pessoas = pessoaInserir.listarPessoas();
            for (Pessoa pessoa : pessoas) {
                System.out.println("ID: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println("Email: " + pessoa.getEmail());
                System.out.println("Telefone: " + pessoa.getTelefone());
                System.out.println("Endereço: " + pessoa.getEndereco());
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(1); 
        pessoa2.setNome("Maria");
        pessoa2.setIdade(30);
        pessoa2.setEmail("maria@example.com");
        pessoa2.setTelefone("(11) 12345-6789");
        pessoa2.setEndereco("Rua B, 456");
        try {
            pessoaInserir.atualizarPessoa(pessoa2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Exclusão de uma pessoa
        try {
            pessoaInserir.excluirPessoa(1); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
