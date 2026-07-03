package lpoo;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteProjeto {
	
    static Scanner scanner = new Scanner(System.in);

    static RepositorioAcademia repositorio =
            new RepositorioAcademia();

    
    public static void main(String[] args) {

        if (repositorio.getRecepcionistas().isEmpty()) {
            configurarSistemaInicial();
        }
        MenuSistema menuSistema =
                new MenuSistema(
                        scanner,
                        repositorio
                );
       
        int opcao;

        do {
            System.out.println("\n===== LOGIN =====");
            System.out.println("1 - Recepcionista");
            System.out.println("2 - Professor");
            System.out.println("3 - Aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
            	opcao = scanner.nextInt();
            	scanner.nextLine();
            }
            catch (InputMismatchException erro) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                	 Recepcionista recepcionista =
                     LoginServico.loginRecepcionista(scanner, repositorio);

             if (recepcionista != null) {
                 menuSistema.menuRecepcionista(recepcionista);
             }
             break;
                case 2:
                	  Professor professor =
                      LoginServico.loginProfessor(scanner, repositorio);

              if (professor != null) {
                  menuSistema.menuProfessor(professor);
              }

              break;
                case 3:
                	 Aluno aluno =
                     LoginServico.loginAluno(scanner, repositorio);

             if (aluno != null) {
                 menuSistema.menuAluno(aluno);
             }

             break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

   
    // ================= CONFIGURAÇÃO INICIAL =================

    public static void configurarSistemaInicial() {

        System.out.println("===== PRIMEIRO ACESSO =====");

        String matricula = GeradorMatricula.gerarMatricula(
                "RE",
                repositorio.getAlunos(),
                repositorio.getProfessores(),
                repositorio.getRecepcionistas());

        System.out.print("Nome do(a) Recepcionista: ");
        String nome = scanner.nextLine();

        String cpf;

        do {
            System.out.print("CPF do(a) Recepcionista: ");
            cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                System.out.println("CPF inválido. Deve conter 11 dígitos.");
            }

        } while (!Validador.validarCpf(cpf));

        System.out.print("Senha do(a) Recepcionista: ");
        String senha = scanner.nextLine();

        Recepcionista administrador = new Recepcionista(
                matricula,
                nome,
                "0001",
                "0000",
                0,
                cpf,
                "00/00/0000",
                "admin@sistema.com",
                "Integral"
        );

        administrador.setSenha(senha);
        administrador.setPrimeiroAcesso(false);

        repositorio.getRecepcionistas().add(administrador);
        System.out.println("=====-------------------------=====");
        System.out.println("Recepcionista: "+administrador.getNome()+" cadastrado com sucesso.");
        
    }
 
}
