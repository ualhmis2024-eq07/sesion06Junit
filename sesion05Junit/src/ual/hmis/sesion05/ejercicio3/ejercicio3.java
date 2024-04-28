package ual.hmis.sesion05.ejercicio3;

public class ejercicio3 {
	
	public String devuelvePassword(String password){
		int longitud = password.length();
		
		if (longitud<5)
			return "password demasiado corto";
		else if(longitud >=5 && longitud <=8)
			return "********";
		else if (longitud >=12 && longitud <=40)
			return "************";
		else if (longitud >40)
			return "password demasiado largo";
	
		return "*".repeat(longitud);
	}

}
