package lpoo;

import java.util.ArrayList;

public class Login {
	 public static Pessoa autenticar(
	            String cpf,
	            String senha,
	            ArrayList<? extends Pessoa> pessoas) {

	        for (Pessoa pessoa : pessoas) {

	            if (pessoa.getCpf().equals(cpf)
	                    && pessoa.getSenha().equals(senha)) {

	                return pessoa;
	            }
	        }

	        return null;
	    }

	    public static Pessoa buscarPorCpf(
	            String cpf,
	            ArrayList<? extends Pessoa> pessoas) {

	        for (Pessoa pessoa : pessoas) {

	            if (pessoa.getCpf().equals(cpf)) {

	                return pessoa;
	            }
	        }

	        return null;
	    }
}
