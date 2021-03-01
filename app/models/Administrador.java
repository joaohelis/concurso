package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Administrador extends Usuario {
	
	@Temporal(TemporalType.DATE)
	public Date dataDeAdmissao;

}
