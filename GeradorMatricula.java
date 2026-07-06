package lpoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class GeradorMatricula {

    public static String gerarMatricula(
            String prefixo,
            ArrayList<Aluno> alunos,
            ArrayList<Professor> professores,
            ArrayList<Recepcionista> recepcionistas) {

        LocalDate dataAtual = LocalDate.now();

        String dia = String.format("%02d", dataAtual.getDayOfMonth());
        String mes = String.format("%02d", dataAtual.getMonthValue());

        Random random = new Random();

        String matricula;

        do {
            int numeroAleatorio = random.nextInt(100);
            String parteAleatoria = String.format("%02d", numeroAleatorio);

            matricula = prefixo + dia + mes + parteAleatoria;

        } while (Validador.matriculaJaExiste(
                matricula,
                alunos,
                professores,
                recepcionistas));

        return matricula;
    }
    public static String gerarIdTurma(RepositorioAcademia repositorio) {
        return "TR" + String.format("%03d",
                repositorio.getTurmas().size() + 1);
    }
    
}