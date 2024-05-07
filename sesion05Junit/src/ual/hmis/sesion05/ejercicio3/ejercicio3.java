package ual.hmis.sesion05.ejercicio3;

public class ejercicio3 {

	public String devuelvePassword(String password) {
		int longitud = password.length();
		String result = "*".repeat(longitud);

		if (longitud < 5)
			result = "password demasiado corto";
		else if (longitud >= 5 && longitud <= 8)
			result = "********";
		else if (longitud >= 12 && longitud <= 40)
			result = "************";
		else if (longitud > 40)
			result = "password demasiado largo";

		return result;
	}

}
