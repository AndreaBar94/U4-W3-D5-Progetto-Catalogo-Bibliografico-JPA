package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Utente;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtenteDAO {
	
	private final EntityManager em;
	
	public UtenteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Utente a) {
//		EntityTransaction t = em.getTransaction();
//		t.begin();
		em.persist(a);
//		t.commit();
		log.info("Utente salvato!");
	}

	public Utente findById(String id) {
		Utente found = em.find(Utente.class, UUID.fromString(id));
		return found;
	}
}
