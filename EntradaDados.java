package lpoo;

import java.util.Scanner;

public class EntradaDados {
	public static String lerGraduacao(Scanner scanner) {

	    while (true) {

	        System.out.println("\n=== GRADUAÇÃO ===");
	        System.out.println("1 - Iniciante");
	        System.out.println("2 - Básico");
	        System.out.println("3 - Intermediário");
	        System.out.println("4 - Avançado");
	        System.out.print("Escolha uma opção: ");

	        switch (scanner.nextLine().trim()) {

	            case "1":
	                return "Iniciante";

	            case "2":
	                return "Básico";

	            case "3":
	                return "Intermediário";

	            case "4":
	                return "Avançado";

	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static String lerHorario(Scanner scanner) {

	    while (true) {

	        System.out.println("\n=== HORÁRIO DA TURMA ===");
	        System.out.println("1 - 07:00 às 09:00");
	        System.out.println("2 - 09:00 às 11:00");
	        System.out.println("3 - 14:00 às 16:00");
	        System.out.println("4 - 16:00 às 18:00");
	        System.out.print("Escolha uma opção: ");

	        switch (scanner.nextLine().trim()) {

	            case "1":
	                return "07:00 às 09:00";

	            case "2":
	                return "09:00 às 11:00";

	            case "3":
	                return "14:00 às 16:00";

	            case "4":
	                return "16:00 às 18:00";

	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static String lerNome(Scanner scanner) {

	    while (true) {

	        System.out.print("Nome: ");
	        String nome = scanner.nextLine().trim();

	        if (nome.isEmpty()) {
	            System.out.println("O nome não pode ficar vazio.");
	            continue;
	        }

	        return nome;
	    }
	}
	
	public static double lerPeso(Scanner scanner) {

	    while (true) {

	        System.out.print("Peso (kg): ");

	        try {

	            double peso = Double.parseDouble(
	                    scanner.nextLine().replace(",", "."));

	            if (peso <= 0) {
	                System.out.println("O peso deve ser maior que zero.");
	                continue;
	            }

	            if (peso > 500) {
	                System.out.println("Peso inválido.");
	                continue;
	            }

	            return peso;

	        } catch (NumberFormatException e) {

	            System.out.println("Digite apenas números.");

	        }
	    }
	}
	
	public static String lerDataNascimento(Scanner scanner) {

	    return Validador.validarData(scanner, 14, 90);

	}
	
	public static String lerCpf(
	        Scanner scanner,
	        RepositorioAcademia repositorio) {

	    while (true) {

	        System.out.print("CPF: ");
	        String cpf = scanner.nextLine().trim();

	        if (!Validador.validarCpf(cpf)) {

	            System.out.println("CPF inválido.");
	            continue;
	        }

	        if (Validador.cpfJaExiste(
	                cpf,
	                repositorio.getAlunos(),
	                repositorio.getProfessores(),
	                repositorio.getRecepcionistas())) {

	            System.out.println("CPF já cadastrado.");
	            continue;
	        }

	        return cpf;
	    }
	}
	public static String lerEmail(Scanner scanner) {

	    while (true) {

	        System.out.print("Email: ");
	        String email = scanner.nextLine().trim();

	        if (email.isBlank()) {
	            System.out.println("O email não pode ficar vazio.");
	            continue;
	        }

	        if (!email.contains("@") || !email.contains(".")) {
	            System.out.println("Email inválido.");
	            continue;
	        }

	        return email;
	    }
	}
	public static String lerConta(Scanner scanner) {

	    while (true) {

	        System.out.print("Conta: ");
	        String conta = scanner.nextLine().trim();

	        if (conta.isBlank()) {
	            System.out.println("A conta não pode ficar vazia.");
	            continue;
	        }

	        return conta;
	    }
	}
	public static String lerAgencia(Scanner scanner) {

	    while (true) {

	        System.out.print("Agência: ");
	        String agencia = scanner.nextLine().trim();

	        if (agencia.isBlank()) {
	            System.out.println("A agência não pode ficar vazia.");
	            continue;
	        }

	        return agencia;
	    }
	}
	
	public static Modalidade lerModalidade(Scanner scanner) {

	    while (true) {

	        System.out.println("\n=== MODALIDADE ===");

	        for (Modalidade modalidade : Modalidade.criarModalidadesPadrao()) {

	            System.out.println(
	                    modalidade.getIdModalidade() +
	                    " - " +
	                    modalidade.getNome());
	        }

	        System.out.print("Escolha uma modalidade: ");

	        try {

	            int opcao = Integer.parseInt(scanner.nextLine().trim());

	            for (Modalidade modalidade : Modalidade.criarModalidadesPadrao()) {

	                if (modalidade.getIdModalidade() == opcao) {
	                    return modalidade;
	                }
	            }

	            System.out.println("Modalidade inválida.");

	        } catch (NumberFormatException e) {

	            System.out.println("Digite apenas números.");

	        }
	    }
	}
	
	public static String lerTurno(Scanner scanner) {

	    while (true) {

	        System.out.print("Turno: ");
	        String turno = scanner.nextLine().trim();

	        if (turno.isBlank()) {
	            System.out.println("O turno não pode ficar vazio.");
	            continue;
	        }

	        return turno;
	    }
	    
	}
	public static int lerExperiencia(Scanner scanner) {

		 while (true) {

		        System.out.println("\n=== EXPERIÊNCIA ===");
		        System.out.println("1 - Até 2 anos");
		        System.out.println("2 - De 3 a 5 anos");
		        System.out.println("3 - De 6 a 10 anos");
		        System.out.println("4 - Mais de 10 anos");
		        System.out.print("Escolha uma opção: ");

		        String opcao = scanner.nextLine().trim();

		        switch (opcao) {

		            case "1":
		                return 2;

		            case "2":
		                return 5;

		            case "3":
		                return 10;

		            case "4":
		                return 11;

		            default:
		                System.out.println("Opção inválida! Tente novamente.");
		        }
		    }
		}
	public static int lerCargaHoraria(Scanner scanner) {

	    while (true) {

	        System.out.print("Carga horária: ");

	        try {

	            int cargaHoraria =
	                    Integer.parseInt(scanner.nextLine());

	            if (cargaHoraria <= 0) {
	                System.out.println("A carga horária deve ser maior que zero.");
	                continue;
	            }

	            if (cargaHoraria > 80) {
	                System.out.println("Carga horária inválida max menor ou igual a 80.");
	                continue;
	            }

	            return cargaHoraria;

	        } catch (NumberFormatException e) {

	            System.out.println("Digite apenas números inteiros.");

	        }
	    }
	}
	
	public static String lerTelefone(Scanner scanner) {

		 while (true) {

		        System.out.print("Telefone: ");
		        String telefone = scanner.nextLine().trim();

		        telefone = telefone.replace("(", "")
		                           .replace(")", "")
		                           .replace("-", "")
		                           .replace(" ", "");

		        if (telefone.isEmpty()) {
		            System.out.println("O telefone não pode ficar vazio.");
		            continue;
		        }

		        boolean somenteNumeros = true;

		        for (int i = 0; i < telefone.length(); i++) {

		            if (!Character.isDigit(telefone.charAt(i))) {
		                somenteNumeros = false;
		                break;
		            }
		        }

		        if (!somenteNumeros) {
		            System.out.println("O telefone deve conter apenas números.");
		            continue;
		        }

		        if (telefone.length() != 10 && telefone.length() != 11) {
		            System.out.println("Telefone inválido. Digite DDD + número.");
		            continue;
		        }

		        return telefone;
		    }
		}
}
