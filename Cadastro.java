import java.util.ArrayList;

public class Cadastro {

    private final ArrayList<Pessoa> contatos = new ArrayList<>();
    private int proximoId = 1;

    public Pessoa cadastrar(String nome, int idade, String telefone) {

        for (Pessoa pessoa : contatos) {
            if (pessoa.getTelefone().equals(telefone)) {
                return null;
            }
        }

        Pessoa novaPessoa =
                new Pessoa(proximoId, nome, idade, telefone);

        proximoId++;
        contatos.add(novaPessoa);

        return novaPessoa;
    }

    public ArrayList<Pessoa> getContatos() {
        return new ArrayList<>(contatos);
    }

    public Pessoa buscar(int idBuscado) {
        for (Pessoa pessoa : contatos) {
            if (pessoa.getId() == idBuscado) {
                return pessoa;
            }
        }
        return null;
    }
    
    public boolean excluirPorId(int id) {
        for (Pessoa pessoa : contatos) {
            if (pessoa.getId() == id) {
                contatos.remove(pessoa);
                return true;
            }
        }
        return false;
    }
}