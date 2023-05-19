package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Editoria;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EditoriaDAO {
	
	private final EntityManager em;
	
	public EditoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Editoria a) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(a);
		t.commit();
		log.info("Elemento salvato!");
	}

	public Editoria findById(String id) {
		Editoria found = em.find(Editoria.class, UUID.fromString(id));
		return found;
	}

}
