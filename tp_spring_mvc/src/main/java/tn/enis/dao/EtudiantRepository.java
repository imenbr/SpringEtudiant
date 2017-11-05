package tn.enis.dao;

import tn.enis.entities.Etudiant;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EtudiantRepository 
		extends JpaRepository<Etudiant, Long>{

	public List<Etudiant> findByNom(String n);
	public Page<Etudiant> findByNom(String n, Pageable pageable);
	@Query("select e from Etudiant e where e.nom like :x")
	public Page<Etudiant> ChercherEtudiants(@Param("x")String n, Pageable pageable);
	
	@Query("select e from Etudiant e where e.dateNaissance > :x and e.dateNaissance< :y")
	public List<Etudiant> ChercherEtudiants(@Param("x")Date d1, @Param("y")Date d2);
}