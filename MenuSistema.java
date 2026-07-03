package lpoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSistema {
	private Scanner scanner;
	private RepositorioAcademia repositorio;

	    public MenuSistema(
	    		Scanner scanner,
	            RepositorioAcademia repositorio) {

	        this.scanner = scanner;
	        this.repositorio = repositorio;
	    }
	    
	    private int lerOpcao() {

	        try {
	            int opcao = scanner.nextInt();
	            scanner.nextLine();
	            return opcao;
	        }
	        catch(InputMismatchException erro) {

	            System.out.println("Digite apenas números.");
	            scanner.nextLine();

	            return -1;
	        }
	    }
	    
	    public void menuCadastro() {

	        int opcao;

	        do {
	            System.out.println("\n===== CADASTRO =====");
	            System.out.println("1 - Cadastrar Aluno");
	            System.out.println("2 - Cadastrar Professor");
	            System.out.println("3 - Cadastrar Recepcionista");
	            System.out.println("4 - Excluir Aluno");
	            System.out.println("5 - Excluir Professor");
	            System.out.println("6 - Excluir Recepcionista");
	            System.out.println("0 - Voltar");
	            System.out.print("Escolha uma opção: ");
	            
	            

	            opcao = lerOpcao();

	            switch (opcao) {

	                case 1:
	                    CadastroUsuarios.cadastrarAluno(scanner, repositorio);
	                    break;

	                case 2:
	                    CadastroUsuarios.cadastrarProfessor(scanner,  repositorio);
	                    break;

	                case 3:
	                    CadastroUsuarios.cadastrarRecepcionista(scanner,  repositorio);
	                    break;
	                case 4:
	                    CadastroUsuarios.excluirAluno(scanner, repositorio);
	                    break;

	                case 5:
	                    CadastroUsuarios.excluirProfessor(scanner, repositorio);
	                    break;

	                case 6:
	                    CadastroUsuarios.excluirRecepcionista(scanner, repositorio);
	                    break;

	                case 0:
	                    break;

	                default:
	                    System.out.println("Opção inválida.");
	            }

	        } while (opcao != 0);
	    }
	    
	    public void menuRecepcionista(Recepcionista recepcionista) {
            int opcao;

            do {
            	System.out.println("\n=================================");
            	System.out.println("Recepcionista: " + recepcionista.getNome());
            	System.out.println("=================================");
            	System.out.println("1 - Cadastro");
            	System.out.println("2 - Criar turma");
            	System.out.println("3 - Matricular aluno em turma");
            	System.out.println("4 - Recuperar senha");
            	System.out.println("5 - Listar alunos");
            	System.out.println("6 - Listar professores");
            	System.out.println("7 - Relatórios");
                System.out.println("8 - Listar turmas");
                System.out.println("9 - Mensalidades");
                System.out.println("0 - Sair");

                opcao = lerOpcao();

                switch (opcao) {
                    case 1:
                    	 menuCadastro();
                        break;
                  
                    case 2:
                    	 TurmaServico.criarTurma(scanner, repositorio);
                        break;
                    case 3:
                    	TurmaServico.matricularAluno(scanner, repositorio);

                        break;
                    case 4:

                        LoginServico.redefinirSenha(
                                scanner,
                                repositorio
                        );

                        break;
                    case 5:
                    	  if (repositorio.getAlunos().isEmpty()) {

                    	        System.out.println("Nenhum aluno cadastrado.");
                    	        break;
                    	    }

                    	    for (Aluno aluno : repositorio.getAlunos()) {

                    	        System.out.println(aluno);
                    	        System.out.println("------------------------------");
                    	    }
                        break;
                    case 6:
                    	 if (repositorio.getProfessores().isEmpty()) {

                    	        System.out.println("Nenhum professor cadastrado.");
                    	        break;
                    	    }

                    	    for (Professor professor : repositorio.getProfessores()) {

                    	        System.out.println(professor);
                    	        System.out.println("------------------------------");
                    	    }
                        break;
                    case 7:
                        menuRelatorios();
                        break;

                    case 8:
                    	 TurmaServico.listarTurmas(repositorio);
                        
                        break;
                        
                    case 9:
                        menuMensalidade();
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } while (opcao != 0);
        }
	    
	    private void registrarPagamento() {

	        System.out.print("CPF do aluno: ");
	        String cpf = scanner.nextLine();

	        for (Mensalidade mensalidade : repositorio.getMensalidades()) {

	            if (mensalidade.getAluno().getCpf().equals(cpf)) {

	                System.out.println(mensalidade);

	                System.out.print("Data do pagamento: ");
	                String data = scanner.nextLine();

	                mensalidade.registrarPagamento(data);

	                System.out.println("\nPagamento registrado com sucesso!");

	                return;
	            }
	        }

	        System.out.println("Nenhuma mensalidade encontrada para este aluno.");
	    }
	    
	    private void listarMensalidades() {

	        if (repositorio.getMensalidades().isEmpty()) {

	            System.out.println("Nenhuma mensalidade cadastrada.");
	            return;
	        }

	        for (Mensalidade mensalidade : repositorio.getMensalidades()) {

	            System.out.println(mensalidade);
	            System.out.println("--------------------------------");
	        }
	    }
	    
	    public void menuMensalidade() {

	        int opcao;

	        do {

	            System.out.println("\n===== MENSALIDADES =====");
	            System.out.println("1 - Cadastrar Mensalidade");
	            System.out.println("2 - Registrar Pagamento");
	            System.out.println("3 - Listar Mensalidades");
	            System.out.println("0 - Voltar");

	            opcao = lerOpcao();

	            switch (opcao) {

	                case 1:
	                    cadastrarMensalidade();
	                    break;

	                case 2:

	                	registrarPagamento();

	                    break;

	                case 3:

	                	 listarMensalidades();

	                    break;

	                case 0:

	                    break;

	                default:

	                    System.out.println("Opção inválida.");
	            }

	        } while (opcao != 0);
	    }
	    private void cadastrarMensalidade() {

	        System.out.print("CPF do aluno: ");
	        String cpf = scanner.nextLine();

	        Aluno aluno = null;

	        for (Aluno a : repositorio.getAlunos()) {

	            if (a.getCpf().equals(cpf)) {
	                aluno = a;
	                break;
	            }
	        }

	        if (aluno == null) {
	            System.out.println("Aluno não encontrado.");
	            return;
	        }

	        Mensalidade.mostrarPlanos();

	        System.out.print("Escolha o plano: ");
	        int opcaoPlano = lerOpcao();

	        System.out.print("Data de vencimento: ");
	        String dataVencimento = scanner.nextLine();

	        Mensalidade mensalidade = new Mensalidade(
	                repositorio.getMensalidades().size() + 1,
	                aluno,
	                dataVencimento
	        );

	        if (!mensalidade.definirPlano(opcaoPlano)) {
	            return;
	        }

	        repositorio.getMensalidades().add(mensalidade);

	        System.out.println("\nMensalidade cadastrada com sucesso!");
	        System.out.println(mensalidade);
	    }
	    
	    public void menuProfessor(Professor professor) {
            int opcao;

            do {
            	System.out.println("\n=================================");
                System.out.println("MENU PROFESSOR - "+professor.getNome());
                System.out.println("=================================");
                System.out.println("1 - Listar turmas");
                System.out.println("2 - Ver dados");
                System.out.println("0 - Sair");

                opcao = lerOpcao();

                switch (opcao) {
                    case 1:
                        System.out.println(professor.listarTurmas());
                        break;
                    case 2:
                        System.out.println(professor);
                        break;
                }

            } while (opcao != 0);
        }
	    
	    public void menuAluno(Aluno aluno) {
            int opcao;

            do {
            	System.out.println("\n=================================");
                System.out.println("MENU ALUNO - "+aluno.getNome());
                System.out.println("=================================");
                System.out.println("1 - Ver dados");
                System.out.println("2 - Ver turma");
                System.out.println("0 - Sair");

                opcao = lerOpcao();

                switch (opcao) {
                    case 1:
                        System.out.println(aluno);
                        break;
                    case 2:
                        System.out.println(aluno.getTurma());
                        break;
                }

            } while (opcao != 0);
        }
	    public void menuRelatorios() {

	        int opcao;

	        do {

	            System.out.println(
	                    "\n===== RELATÓRIOS =====");

	            System.out.println(
	                    "1 - Resumo Geral");

	            System.out.println(
	                    "2 - Alunos por Turma");

	            System.out.println(
	                    "3 - Professores e Turmas");

	            System.out.println(
	                    "0 - Voltar");

	            opcao = lerOpcao();

	            switch (opcao) {

	                case 1:
	                    RelatorioServico.exibirResumo(
	                            repositorio);
	                    break;

	                case 2:
	                    RelatorioServico
	                            .listarAlunosPorTurma(
	                                    repositorio);
	                    break;

	                case 3:
	                    RelatorioServico
	                            .listarProfessoresETurmas(
	                                    repositorio);
	                    break;

	                case 0:
	                    break;

	                default:
	                    System.out.println(
	                            "Opção inválida.");
	            }

	        } while (opcao != 0);
	    }
	    
}
