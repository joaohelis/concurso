package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {
	
	@Before
	static void checarUsuarioLogado() {
		if(session.get("usuarioID") == null) {
			flash.error("Acesso negado!");
			Login.login();
		}
	}

    public static void index() {
    	System.out.println("Método index");
    	String emailUsuario = session.get("emailUsuario");    	
        render(emailUsuario);
    }

}