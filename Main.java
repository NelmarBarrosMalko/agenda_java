    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            int opcao = 0; 
            
            try (Scanner leitor = new Scanner(System.in)) {
                Cadastro cadastro = new Cadastro();
                while (opcao != 4) {
                    
                    System.out.println("Mostrar Menu:");
                    System.out.println("Receber Opção: ");
                    System.out.println("1 - Cadastrar Pessoa");
                    System.out.println("2 - Buscar Pessoa");
                    System.out.println("3 - Excluir Pessoa");
                    System.out.println("4 - Sair");
                    
                    opcao = Integer.parseInt(leitor.nextLine());
                    
                    
                    switch (opcao) {
                        case 1 -> {
                            System.out.println("Digite seu nome: ");
                            String nome = leitor.nextLine();
                            
                            System.out.println("Digite sua idade: ");
                            int idade = Integer.parseInt(leitor.nextLine());
                            
                            System.out.println("Digite seu telefone: ");
                            String telefone = leitor.nextLine();
                            
                            Pessoa pessoaCadastrada = cadastro.cadastrar(nome, idade, telefone);
                            if (pessoaCadastrada == null) {
                                System.out.println("Esse usuário já existe");
                            } else {
                                System.out.println("Usuário cadastrado com sucesso!");
                                System.out.println("ID: " + pessoaCadastrada.getId());
                            }
                        }
                        case 2 -> {
                            System.out.println("Digite o ID da pessoa que deseja buscar: ");
                            int idBuscado = Integer.parseInt(leitor.nextLine());
                            
                            Pessoa pessoaEncontrada = cadastro.buscar(idBuscado);
                            if (pessoaEncontrada == null) {
                                System.out.println("Pessoa não encontrada.");
                            } else {
                                System.out.println("Pessoa encontrada:");
                                System.out.println("ID: " + pessoaEncontrada.getId());
                                System.out.println("Nome: " + pessoaEncontrada.getNome());
                                System.out.println("Idade: " + pessoaEncontrada.getIdade());
                                System.out.println("Telefone: " + pessoaEncontrada.getTelefone());
                            }
                        }
                        case 3 -> {
                            System.out.println("Digite o ID da pessoa que deseja excluir: ");
                            int idParaExcluir = Integer.parseInt(leitor.nextLine());
                            boolean pessoaExcluida = cadastro.excluirPorId(idParaExcluir);
                            if (pessoaExcluida) {
                                System.out.println("Pessoa excluida com sucesso.");
                            } else {
                                System.out.println("Pessoa nao encontrada.");
                            }
                        }
                        case 4 -> System.out.println("Saindo do programa...");
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                    
                    
                    
                    
                }   }
        } 
    }