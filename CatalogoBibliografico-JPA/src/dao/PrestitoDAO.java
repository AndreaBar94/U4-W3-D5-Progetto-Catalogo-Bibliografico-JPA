package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Prestito;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrestitoDAO {

	private final EntityManager em;
	
	public PrestitoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Prestito a) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(a);
		t.commit();
		log.info("Prestito salvato!");
	}

	public Prestito findById(String id) {
		Prestito found = em.find(Prestito.class, UUID.fromString(id));
		return found;
	}
}
