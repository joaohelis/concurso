package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Cargo extends Model{
	
	public String descricao;
	
	@JoinColumn(name="concurso_id")
	@ManyToOne
	public Concurso concurso;
	
	@OneToMany(mappedBy="cargo")
	public List<Inscricao> inscricoes;
	
	public Cargo() {
		this.inscricoes = new ArrayList<>();
	}

}
