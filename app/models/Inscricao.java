package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Inscricao extends Model {
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date dataInscricao;
	
	@JoinColumn(name="usuario_id")
	@ManyToOne	
	public Usuario usuario;
	
	@JoinColumn(name="cargo_id")
	@ManyToOne
	public Cargo cargo;
	
	@JoinColumn(name="concurso_id")
	@ManyToOne
	public Concurso concurso;
	
}