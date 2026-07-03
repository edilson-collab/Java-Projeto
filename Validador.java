package lpoo;

import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.ArrayList;

public class Validador {
	public static boolean validarCpf(String cpf) {
		if (cpf == null) {
	        return false;
	    }

	    cpf = cpf.replaceAll("[^0-9]", "");

	    return cpf.matches("\\d{11}");
    }

    public static boolean cpfJaExiste(
            String cpf,
            ArrayList<Aluno> alunos,
            ArrayList<Professor> professores,
            ArrayList<Recepcionista> recepcionistas) {

        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return true;
            }
        }

        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return true;
            }
        }

        for (Recepcionista recepcionista : recepcionistas) {
            if (recepcionista.getCpf().equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    public static boolean matriculaJaExiste(
            String matricula,
            ArrayList<Aluno> alunos,
            ArrayList<Professor> professores,
            ArrayList<Recepcionista> recepcionistas) {

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return true;
            }
        }

        for (Professor professor : professores) {
            if (professor.getMatricula().equals(matricula)) {
                return true;
            }
        }

        for (Recepcionista recepcionista : recepcionistas) {
            if (recepcionista.getMatricula().equals(matricula)) {
                return true;
            }
        }

        return false;
    }
    public static String validarData(
            Scanner scanner,
            int idadeMinima,
            int idadeMaxima) {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

        while (true) {

            System.out.print("Nascimento (dd/MM/yyyy): ");
            String nascimento = scanner.nextLine().trim();

            try {

                LocalDate data =
                        LocalDate.parse(nascimento, formato);

                if (data.isAfter(LocalDate.now())) {
                    System.out.println("A data não pode ser futura.");
                    continue;
                }

                int idade =
                        Period.between(data, LocalDate.now()).getYears();

                if (idade < idadeMinima) {
                    System.out.println("Idade mínima permitida: "
                            + idadeMinima + " anos.");
                    continue;
                }

                if (idade > idadeMaxima) {
                    System.out.println("Idade máxima permitida: "
                            + idadeMaxima + " anos.");
                    continue;
                }

                return nascimento;

            } catch (DateTimeParseException e) {

                System.out.println("Data inválida! Utilize o formato dd/MM/yyyy.");

            }
        }
    }
    public static double validarPeso(Scanner scanner) {

        while (true) {

            System.out.print("Peso (kg): ");

            try {

                double peso = scanner.nextDouble();
                scanner.nextLine();

                if (peso <= 0) {
                    System.out.println("O peso deve ser maior que zero.");
                    continue;
                }

                if (peso > 500) {
                    System.out.println("Peso inválido.");
                    continue;
                }

                return peso;

            } catch (InputMismatchException erro) {

                System.out.println("Digite apenas números.");

                scanner.nextLine();
            }
        }
    }
}
