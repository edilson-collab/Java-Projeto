package tabica;

import Entidade.Aluno;
import Entidade.Banco;
import Entidade.Funcionarios;
import Entidade.Mensalidade;
import Entidade.Modalidade;
import Entidade.Professor;
import Entidade.Recepcionista;
import Entidade.ServicoGerais;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcademiaTeste {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== OBJETOS BASE =====
        Banco banco = new Banco("001", "12345-6");

        Modalidade modalidade = new Modalidade(
                "M01",
                "Musculação",
                "Iniciante",
                "Educação Física",
                "Treinamento de Força"
        );

        List<String> telefonesFuncionario = new ArrayList<>();
        telefonesFuncionario.add("8199999-0000");

        Recepcionista recepcionista = new Recepcionista(
                "R001",
                "123.456.789-00",
                "Maria",
                "10/05/1995",
                banco,
                "maria@academia.com",
                telefonesFuncionario,
                1,
                "Manhã"
        );

        boolean executando = true;

        while (executando) {

            System.out.println("\n===== MENU ACADEMIA =====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Cadastrar Professor");
            System.out.println("4 - Cadastrar Funcionário Serviços Gerais");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.println("\n--- Cadastro de Aluno ---");

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Peso: ");
                    double peso = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Data de Nascimento: ");
                    String dataNasc = sc.nextLine();

                    Mensalidade mensalidade = new Mensalidade(
                            "MEN001",
                            120.00,
                            "05/10/2025",
                            "PAGA",
                            null,
                            modalidade
                    );

                    recepcionista.cadastrarAluno(
                            cpf,
                            matricula,
                            nome,
                            peso,
                            email,
                            telefone,
                            modalidade,
                            dataNasc,
                            mensalidade
                    );

                    System.out.println("✅ Aluno cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Alunos ---");

                    if (recepcionista.getAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        for (Aluno a : recepcionista.getAlunos()) {
                            a.exibirInformacoes();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Cadastro de Professor ---");

                    List<String> telProfessor = new ArrayList<>();
                    telProfessor.add("8198888-7777");

                    Professor professor = new Professor(
                            "P001",
                            "987.654.321-00",
                            "Carlos",
                            "15/03/1980",
                            banco,
                            "carlos@academia.com",
                            telProfessor,
                            "PROF01",
                            "Educação Física",
                            "Musculação",
                            "40h",
                            null
                    );

                    System.out.println("Professor cadastrado: " + professor.getNome());
                    break;

                case 4:
                    System.out.println("\n--- Cadastro Serviços Gerais ---");

                    ServicoGerais sg = new ServicoGerais(
                            "SG001",
                            "111.222.333-44",
                            "João",
                            "20/07/1990",
                            banco,
                            "joao@academia.com",
                            telefonesFuncionario,
                            10,
                            "Noite"
                    );

                    System.out.println("Funcionário Serviços Gerais cadastrado: " + sg.getNome());
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("❌ Opção inválida!");
            }
        }

        sc.close();
    }
}
