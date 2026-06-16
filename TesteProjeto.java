package lpoo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteProjeto {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Aluno> alunos = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();
    static ArrayList<Recepcionista> recepcionistas = new ArrayList<>();
    static ArrayList<Turma> turmas = new ArrayList<>();

    public static void main(String[] args) {

        if (recepcionistas.isEmpty()) {
            configurarSistemaInicial();
        }

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
                    loginRecepcionista();
                    break;
                case 2:
                    loginProfessor();
                    break;
                case 3:
                    loginAluno();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // ================= LOGIN =================

    public static void loginRecepcionista() {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Recepcionista recepcionista = Login.buscarRecepcionistaPorCpf(
                cpf,
                recepcionistas
        );

        if (recepcionista == null) {
            System.out.println(
                    "Cadastro não encontrado."
            );
            return;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        recepcionista = Login.autenticarRecepcionista(
                cpf,
                senha,
                recepcionistas
        );

        if (recepcionista == null) {
            System.out.println("Senha incorreta.");
            return;
        }

        if (recepcionista.isPrimeiroAcesso()) {
            trocarSenhaRecepcionista(recepcionista);
        }

        menuRecepcionista(recepcionista);
    }

    public static void loginProfessor() {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Professor professor = Login.buscarProfessorPorCpf(
                cpf,
                professores
        );

        if (professor == null) {
            System.out.println(
                    "Cadastro não existe. Dirija-se à recepcionista."
            );
            return;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        professor = Login.autenticarProfessor(
                cpf,
                senha,
                professores
        );

        if (professor == null) {
            System.out.println("Senha incorreta.");
            return;
        }

        if (professor.isPrimeiroAcesso()) {
            trocarSenhaProfessor(professor);
        }

        menuProfessor(professor);
    }

    public static void loginAluno() {

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Aluno aluno = Login.buscarAlunoPorCpf(
                cpf,
                alunos
        );

        if (aluno == null) {
            System.out.println(
                    "Cadastro não existe. Dirija-se à recepcionista."
            );
            return;
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        aluno = Login.autenticarAluno(
                cpf,
                senha,
                alunos
        );

        if (aluno == null) {
            System.out.println("Senha incorreta.");
            return;
        }

        if (aluno.isPrimeiroAcesso()) {
            trocarSenhaAluno(aluno);
        }

        menuAluno(aluno);
    }

    
    // ================= CADASTROS =================

    public static void cadastrarAluno() {

        try {
            String matricula = GeradorMatricula.gerarMatricula(
                    "AL",
                    alunos,
                    professores,
                    recepcionistas
            );

            System.out.println("Matrícula gerada: " + matricula);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Peso: ");
            double peso = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Nascimento: ");
            String nascimento = scanner.nextLine();

            System.out.print("Graduação: ");
            String graduacao = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                throw new IllegalArgumentException("CPF inválido.");
            }

            if (Validador.cpfJaExiste(
                    cpf,
                    alunos,
                    professores,
                    recepcionistas)) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            alunos.add(new Aluno(
                    matricula,
                    nome,
                    peso,
                    email,
                    nascimento,
                    graduacao,
                    cpf
            ));

            System.out.println("Aluno cadastrado com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Erro de entrada.");
            scanner.nextLine();
        }
        catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public static void cadastrarProfessor() {

        try {
            String matricula = GeradorMatricula.gerarMatricula(
                    "PR",
                    alunos,
                    professores,
                    recepcionistas
            );

            System.out.println("Matrícula gerada: " + matricula);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Agência: ");
            String agencia = scanner.nextLine();

            System.out.print("Conta: ");
            String conta = scanner.nextLine();

            System.out.print("Experiência: ");
            int experiencia = scanner.nextInt();
            scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                throw new IllegalArgumentException("CPF inválido.");
            }

            if (Validador.cpfJaExiste(
                    cpf,
                    alunos,
                    professores,
                    recepcionistas)) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            System.out.print("Nascimento: ");
            String nascimento = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Graduação: ");
            String graduacao = scanner.nextLine();

            System.out.print("Especialidade: ");
            String especialidade = scanner.nextLine();

            System.out.print("Carga horária: ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            professores.add(new Professor(
                    matricula,
                    nome,
                    agencia,
                    conta,
                    experiencia,
                    cpf,
                    nascimento,
                    email,
                    graduacao,
                    especialidade,
                    cargaHoraria
            ));

            System.out.println("Professor cadastrado com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Erro de entrada.");
            scanner.nextLine();
        }
        catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public static void cadastrarRecepcionista() {

        try {
            String matricula = GeradorMatricula.gerarMatricula(
                    "RE",
                    alunos,
                    professores,
                    recepcionistas
            );

            System.out.println("Matrícula gerada: " + matricula);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Agência: ");
            String agencia = scanner.nextLine();

            System.out.print("Conta: ");
            String conta = scanner.nextLine();

            System.out.print("Experiência: ");
            int experiencia = scanner.nextInt();
            scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                throw new IllegalArgumentException("CPF inválido.");
            }

            if (Validador.cpfJaExiste(
                    cpf,
                    alunos,
                    professores,
                    recepcionistas)) {
                throw new IllegalArgumentException("CPF já cadastrado.");
            }

            System.out.print("Nascimento: ");
            String nascimento = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Turno: ");
            String turno = scanner.nextLine();

            recepcionistas.add(new Recepcionista(
                    matricula,
                    nome,
                    agencia,
                    conta,
                    experiencia,
                    cpf,
                    nascimento,
                    email,
                    turno
            ));

            System.out.println("Recepcionista cadastrada com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Erro de entrada.");
            scanner.nextLine();
        }
        catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    // ================= TROCA DE SENHA =================

    public static void trocarSenhaAluno(Aluno aluno) {
    	String novaSenha;

    	do {
    	    System.out.print("Digite a nova senha: ");
    	    novaSenha = scanner.nextLine();

    	    if (novaSenha.isBlank()) {
    	        System.out.println("Senha não pode ficar vazia.");
    	    }

    	} while (novaSenha.isBlank());

    	aluno.setSenha(novaSenha);
        aluno.setPrimeiroAcesso(false);
    }

    public static void trocarSenhaProfessor(Professor professor) {
    	String novaSenha;

    	do {
    	    System.out.print("Digite a nova senha: ");
    	    novaSenha = scanner.nextLine();

    	    if (novaSenha.isBlank()) {
    	        System.out.println("Senha não pode ficar vazia.");
    	    }

    	} while (novaSenha.isBlank());

    	professor.setSenha(novaSenha);
        professor.setPrimeiroAcesso(false);
    }

    public static void trocarSenhaRecepcionista(Recepcionista recepcionista) {
    	String novaSenha;

    	do {
    	    System.out.print("Digite a nova senha: ");
    	    novaSenha = scanner.nextLine();

    	    if (novaSenha.isBlank()) {
    	        System.out.println("Senha não pode ficar vazia.");
    	    }

    	} while (novaSenha.isBlank());

    	recepcionista.setSenha(novaSenha);
        recepcionista.setPrimeiroAcesso(false);
    }

    // ================= CONFIGURAÇÃO INICIAL =================

    public static void configurarSistemaInicial() {

        System.out.println("===== PRIMEIRO ACESSO =====");

        String matricula = GeradorMatricula.gerarMatricula(
                "RE",
                alunos,
                professores,
                recepcionistas
        );

        System.out.print("Nome do gestor(a): ");
        String nome = scanner.nextLine();

        String cpf;

        do {
            System.out.print("CPF do gestor(a): ");
            cpf = scanner.nextLine();

            if (!Validador.validarCpf(cpf)) {
                System.out.println("CPF inválido. Deve conter 11 dígitos.");
            }

        } while (!Validador.validarCpf(cpf));

        System.out.print("Senha do gestor(a): ");
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

        recepcionistas.add(administrador);

        System.out.println("Administrador(a) cadastrado com sucesso.");
        
    }
    
 // ================= CRIAR TURMA =================

    public static void criarTurma() {

        try {

            System.out.print("Identificador da turma: ");
            int identificador = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nível da turma: ");
            String nivel = scanner.nextLine();

            System.out.print("Horário da turma: ");
            String horario = scanner.nextLine();

            if (professores.isEmpty()) {
                System.out.println("Nenhum professor cadastrado.");
                return;
            }

            System.out.println("\n===== PROFESSORES DISPONÍVEIS =====");

            for (int indice = 0; indice < professores.size(); indice++) {
                System.out.println(
                        indice + " - " +
                        professores.get(indice).getNome()
                );
            }

            System.out.print("Escolha o professor: ");
            int indiceProfessor = scanner.nextInt();
            scanner.nextLine();

            if (indiceProfessor < 0 || indiceProfessor >= professores.size()) {
                System.out.println("Professor inválido.");
                return;
            }

            Professor professorEscolhido =
                    professores.get(indiceProfessor);

            Turma turma = new Turma(
                    identificador,
                    nivel,
                    horario,
                    professorEscolhido
            );

            turmas.add(turma);

            System.out.println("Turma criada com sucesso.");

        } catch (InputMismatchException erro) {
            System.out.println("Entrada inválida.");
            scanner.nextLine();
        }
    }
        
        // ================= MENUS =================

        public static void menuRecepcionista(Recepcionista recepcionista) {
            int opcao;

            do {
            	System.out.println("\n=================================");
            	System.out.println("Recepcionista: " + recepcionista.getNome());
            	System.out.println("=================================");
                System.out.println("1 - Cadastrar aluno");
                System.out.println("2 - Cadastrar professor");
                System.out.println("3 - Cadastrar recepcionista");
                System.out.println("4 - Criar turma");
                System.out.println("5 - Listar alunos");
                System.out.println("6 - Listar professores");
                System.out.println("7 - Listar turmas");
                System.out.println("0 - Sair");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        cadastrarProfessor();
                        break;
                    case 3:
                        cadastrarRecepcionista();
                        break;
                    case 4:
                        criarTurma();
                        break;
                    case 5:
                        for (Aluno aluno : alunos) {
                            System.out.println(aluno);
                        }
                        break;
                    case 6:
                        for (Professor professor : professores) {
                            System.out.println(professor);
                        }
                        break;
                    case 7:
                        for (Turma turma : turmas) {
                            System.out.println(turma);
                        }
                        break;
                }

            } while (opcao != 0);
        }

        public static void menuProfessor(Professor professor) {
            int opcao;

            do {
            	System.out.println("\n=================================");
                System.out.println("MENU PROFESSOR - "+professor.getNome());
                System.out.println("=================================");
                System.out.println("1 - Listar turmas");
                System.out.println("2 - Ver dados");
                System.out.println("0 - Sair");

                opcao = scanner.nextInt();
                scanner.nextLine();

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

        public static void menuAluno(Aluno aluno) {
            int opcao;

            do {
            	System.out.println("\n=================================");
                System.out.println("MENU ALUNO - "+aluno.getNome());
                System.out.println("=================================");
                System.out.println("1 - Ver dados");
                System.out.println("2 - Ver turma");
                System.out.println("0 - Sair");

                opcao = scanner.nextInt();
                scanner.nextLine();

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
}
