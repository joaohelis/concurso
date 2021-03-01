package controllers;

import java.util.List;

import models.Inscricao;
import models.Participante;
import models.Usuario;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;

public class Participantes extends Controller{
	
	@Before
	static void checarUsuarioLogado() {
		if(session.get("usuarioID") == null) {
			flash.error("Acesso negado!");
			Login.login();
		}
	}
	
	public static void form() {
		render();
	}
	
	public static void salvar(@Valid Participante part) {		
		
		if(validation.hasErrors()) {
			
			validation.keep();			
			params.flash();
						
			form();
		}
		
		part.save();		
		listar();
	}
	
	public static void listar() {
		List<Participante> participantes = Participante.findAll();
				
		Long idUsuario = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(idUsuario);
		
//		List<Inscricao> inscricoesUsuario = Inscricao.find("usuario = ?", usuarioLogado).fetch();
		
		render(participantes, usuarioLogado);
	}
	
	public static void remover(Long id) {
		Participante part = Participante.findById(id);
		part.delete();
		
		session.clear();
		Login.login();
		
//		listar();
	}

}
