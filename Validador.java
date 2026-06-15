package lpoo;

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
}
