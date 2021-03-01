package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Concurso extends Model{
	
	public String titulo;
	
	@Temporal(TemporalType.DATE)
	public Date dataRealizacao;
		
	@OneToMany(mappedBy="concurso")
	public List<Cargo> cargos;
	
	@OneToMany(mappedBy="concurso")
	public List<Inscricao> inscricoes;
	
	public boolean verificarInscricaoUsuario(Usuario usuario) {		
		for(Inscricao inscricao: inscricoes) {
			if(inscricao.usuario.equals(usuario)) 
				return true;			
		}		
		return false;		
	}

}
