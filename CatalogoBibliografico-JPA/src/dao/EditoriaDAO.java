package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.LoggerFactory;

import application.Archivio;
import ch.qos.logback.classic.Logger;
import entities.Editoria;
import entities.Libri;
import entities.Prestito;
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

	public Editoria findByISBN(String id) {
		Editoria found = em.find(Editoria.class, UUID.fromString(id));
		return found;
	}
	
	public void delete(String id) {
		Editoria found = em.find(Editoria.class, UUID.fromString(id));
		if (found != null) {
			em.remove(found);
			System.out.println("Elemento con id " + id + " eliminato!");
		}
	}
	
	public List<Editoria> getByYear(long annoPub){
		TypedQuery<Editoria> getAllQuery = em.createNamedQuery("findByYear", Editoria.class);
		getAllQuery.setParameter("annoPub", annoPub);
		List<Editoria> resultList = getAllQuery.getResultList();
		log.info("Ricerca per anno: {}", resultList);
		return getAllQuery.getResultList();
	}
	
	public List<Libri> getByAuthor(String autore){
		TypedQuery<Libri> getAllQuery = em.createNamedQuery("findByAuthor", Libri.class);
		getAllQuery.setParameter("autore", autore);
		List<Libri> resultList = getAllQuery.getResultList();
		StringBuilder logMessage = new StringBuilder("Ricerca per autore: \n");
		 for (Libri libro : resultList) {
			    logMessage.append(libro.toString()).append("\n");
			  }
			  log.info(logMessage.toString());
		return getAllQuery.getResultList();
	}
	
	public List<Editoria> getByTitle(String titolo) {
		TypedQuery<Editoria> getAllQuery = em.createNamedQuery("getByTitle", Editoria.class);
		getAllQuery.setParameter("titolo", titolo);
		List<Editoria> resultList = getAllQuery.getResultList();
		StringBuilder logMessage = new StringBuilder("Ricerca per titolo: \n");
		 for (Editoria search : resultList) {
			    logMessage.append(search.toString()).append("\n");
			  }
			  log.info(logMessage.toString());
		return getAllQuery.getResultList();
	}
	
	public List<Editoria> getElementsByIdCard(String numeroTessera){
		TypedQuery<Editoria> getAllQuery = em.createNamedQuery("getElementsByIdCard", Editoria.class);
		getAllQuery.setParameter("numeroTessera", UUID.fromString(numeroTessera));
		List<Editoria> resultList = getAllQuery.getResultList();
		StringBuilder logMessage = new StringBuilder("Ricerca prestiti non restituiti con questa tessera: \n");
		 for (Editoria search : resultList) {
			    logMessage.append(search.toString()).append("\n");
			  }
			  log.info(logMessage.toString());
		return getAllQuery.getResultList();
	}
	
	public List<Editoria> getExpired(){
		TypedQuery<Editoria> getAllQuery = em.createNamedQuery("getExpired", Editoria.class);
		List<Editoria> resultList = getAllQuery.getResultList();
		StringBuilder logMessage = new StringBuilder("Ricerca prestiti scaduti non restituiti: \n");
		 for (Editoria search : resultList) {
			    logMessage.append(search.toString()).append("\n");
			  }
			  log.info(logMessage.toString());
		return getAllQuery.getResultList();
	}
}
