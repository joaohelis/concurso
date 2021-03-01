package controllers;

import models.Administrador;
import models.Participante;
import models.Usuario;
import play.mvc.Controller;

public class Login extends Controller{
	
	public static void login() {
		render();
	}
	
	public static void autenticar(String email, String senha) {
		
		Usuario usuario = Usuario.find("email = ? and senha = ?", email, senha).first();		
		
		if(usuario != null) {
			
			if(usuario instanceof Participante) {
				System.out.println("O usuário logado é do tipo 'Participante'");
				System.out.println("Executar uma ação de redirecionar para a tela do participante");
			}else if (usuario instanceof Administrador) {
				System.out.println("O usuário logado é do tipo 'Administrador'");
			}
			session.put("usuarioID", usuario.id);
			session.put("emailUsuario", usuario.email);
			Application.index();			
		}
		else {
			flash.error("Usuário ou senha incorretos.");
			login();
		}
	}
	
	public static void logout() {
		session.clear();
		login();
	}

	
	
}
