package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	@Required(message="O email é obrigatório")
	@Email(message="Informe um email válido")
	@Unique(message="Já existe um usuário cadastrado com o e-mail informado")
	public String email;
	
	@Required(message="A senha é obrigatória")
	@MinSize(value=3, message="A senha deve ter no mínimo 3 caracteres")
	public String senha;
	
	@OneToMany(mappedBy="usuario")
	public List<Inscricao> inscricoes;

}
