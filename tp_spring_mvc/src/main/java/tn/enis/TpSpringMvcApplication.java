 package tn.enis;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.enis.dao.EtudiantRepository;
import tn.enis.entities.Etudiant;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		 ApplicationContext ctx =SpringApplication.run(TpSpringMvcApplication.class, args);
	     EtudiantRepository etudiantRepository =ctx.getBean(EtudiantRepository.class) ;
	     DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
	     
	     etudiantRepository.save(new Etudiant("imen", df.parse("1994-09-11"), "imen.bradai.ib@gmail.com", "photo imen"));
	     etudiantRepository.save(new Etudiant("amal", df.parse("1994-11-11"), "amal.zouari@gmail.com", "photo amal"));
	     etudiantRepository.save(new Etudiant("amira", df.parse("1980-10-11"), "amira.bradai.ab@gmail.com", "photo amira"));
	     
//	     Page<Etudiant> etds=etudiantRepository.findAll(new PageRequest(0, 5)) ;
//	     etds.forEach(e->System.out.println(e.getNom()));
	     
	     Page<Etudiant> etds1=etudiantRepository.ChercherEtudiants("%A%",new PageRequest(0, 5)) ;
	     etds1.forEach(e->System.out.println(e.getNom()));
	     
	}
}