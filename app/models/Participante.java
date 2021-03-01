package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Participante extends Usuario {
		
	@Required(message="O campo nome é obrigatório")
	@MinSize(value=3, message="O nome deve ter no mínimo 3 caracteres")
	public String nome;
	
	@Required(message="O campo nota é obrigatório")
	@Min(value=0, message="A nota deve ser no mínimo 0")
	@Max(value=100, message="A nota deve ser no máximo 100")
	public Float nota;
	
}
