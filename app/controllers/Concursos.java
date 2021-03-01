package controllers;

import java.util.Date;
import java.util.List;

import models.Cargo;
import models.Concurso;
import models.Inscricao;
import models.Usuario;
import play.mvc.Controller;

public class Concursos extends Controller {
	
	public static void listarConcursos() {
		
		Long idUsuario = Long.parseLong(session.get("usuarioID"));		
		Usuario usuarioLogado = Usuario.findById(idUsuario);
		
		List<Concurso> concursos = Concurso.findAll();
				
		renderTemplate("Concursos/listar.html", concursos, usuarioLogado);		
	}
	
	public static void detalhes(Long id) {
		Concurso concurso = Concurso.findById(id);
		render(concurso);
	}
		
	public static void realizarInscricao(Long idCargo, Long idConcurso) {
		
		Long idUsuario = Long.parseLong(session.get("usuarioID"));
		
		Usuario usuarioLogado = Usuario.findById(idUsuario);
		Concurso concurso = Concurso.findById(idConcurso);
		Cargo cargo = Cargo.findById(idCargo);
		
		Inscricao inscricao = new Inscricao();
		inscricao.cargo = cargo;
		inscricao.concurso = concurso;
		inscricao.dataInscricao = new Date();
		inscricao.usuario = usuarioLogado;
		inscricao.save();
		
		listarConcursos();		
	}
	
	public static void listarInscricoesDoUsuarioLogado() {
		
		Long idUsuario = Long.parseLong(session.get("usuarioID"));		
		Usuario usuarioLogado = Usuario.findById(idUsuario);
		
		List<Inscricao> inscricoes = Inscricao.find("usuario = ?", usuarioLogado).fetch();
		
		renderTemplate("Concursos/listagemDeInscricoes.html", inscricoes);
	}

}
