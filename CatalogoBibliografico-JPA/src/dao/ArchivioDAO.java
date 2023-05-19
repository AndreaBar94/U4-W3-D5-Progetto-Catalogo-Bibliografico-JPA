package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import application.Archivio;
import entities.Editoria;

public class ArchivioDAO {
	
	private final EntityManager em;

	public ArchivioDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Editoria s) {
		em.persist(s);
		System.out.println("Elemento salvato!");
	}
	
}
