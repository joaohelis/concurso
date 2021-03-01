package jobs;

import java.util.Date;

import models.Administrador;
import models.Cargo;
import models.Concurso;
import models.Participante;
import play.db.jpa.JPA;
import play.jobs.Job;
import play.jobs.OnApplicationStart;


@OnApplicationStart
public class Inicializador extends Job{
	
	@Override
	public void doJob() throws Exception {
				
		if(Participante.count() == 0) {			
			
			Participante participante = new Participante();
			participante.nome = "João Helis";
			participante.email = "joao.helis@ifrn.edu.br";
			participante.senha = "123";
			participante.nota = 90.0f;
			participante.save();
			
			Participante participante2 = new Participante();
			participante2.nome = "Maria Rita";
			participante2.email = "maria.rita@ifrn.edu.br";
			participante2.senha = "123";
			participante2.nota = 90.0f;
			participante2.save();
			
			Participante participante3 = new Participante();
			participante3.nome = "Ester";
			participante3.email = "ester@ifrn.edu.br";
			participante3.senha = "123";
			participante3.nota = 90.0f;
			participante3.save();
			
			Administrador admin = new Administrador();
			admin.email = "admin@admin.com";
			admin.senha = "123";
			admin.save();
			
			
			Concurso concurso = new Concurso();
			concurso.dataRealizacao = new Date();
			concurso.titulo = "Concurso Público - IFRN";
			concurso.save();
			
			Concurso concurso2 = new Concurso();
			concurso2.dataRealizacao = new Date();
			concurso2.titulo = "Concurso Público - UFRN";
			concurso2.save();
			
			
			Cargo cargo = new Cargo();
			cargo.descricao = "Desenvolvedor de Software";
			cargo.concurso = concurso;
			cargo.save();
			
			Cargo cargo3 = new Cargo();
			cargo3.descricao = "Professor";
			cargo3.concurso = concurso;
			cargo3.save();
						
			Cargo cargo2 = new Cargo();
			cargo2.descricao = "Testador de Software";
			cargo2.concurso = concurso2;
			cargo2.save();						
			
		}		
	}
}
