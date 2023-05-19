package application;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PrestitoDAO;
import dao.UtenteDAO;
import entities.Libri;
import entities.Periodicità;
import entities.Prestito;
import entities.Riviste;
import entities.Utente;
import utils.JpaUtil;



public class Archivio {

	public static Logger logger = LoggerFactory.getLogger(Archivio.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		UtenteDAO uDAO = new UtenteDAO(em);
		PrestitoDAO pDAO = new PrestitoDAO(em);
		
		//CREAZIONE LIBRI
		Libri libro1 = new Libri( "Harry Potter 1", 1997, 304, "J. K. Rowling", "Fantasy");  
		Libri libro2 = new Libri("Harry Potter 2", 1998, 224, "J. K. Rowling", "Fantasy");  
		Libri libro3 = new Libri("Il Signore degli anelli", 1955, 500, "J. R. R. Tolkien", "Fantasy");  
		Libri libro4 = new Libri("Il Signore degli anelli", 2000, 600, "J. R. R. Tolkien", "Fantasy");  
		
		//CREAZIONE RIVISTE
		Riviste rivista1 = new Riviste("Focus", 1992, 130, Periodicità.Mensile);
		Riviste rivista2 = new Riviste("Vanity Fair", 1913, 120,Periodicità.Settimanale);
		Riviste rivista3 = new Riviste("L'Indice dei libri del mese", 1984, 160, Periodicità.Semestrale);
		Riviste rivista4 = new Riviste("Foreign Policy", 1970, 120, Periodicità.Semestrale);
		
		//CREAZIONE UTENTI
		Utente mario = new Utente("Mario", "Rossi", LocalDate.of(1990, 3, 12));
		Utente maria = new Utente("Maria", "Bianchi", LocalDate.of(1992, 12, 1));
		Utente giovanni= new Utente("Giovanni", "Verdi", LocalDate.of(1994, 9, 30));
		Utente sofia = new Utente("Sofia", "Blu", LocalDate.of(1996, 6, 17));
		
		//CREAZIONE PRESTITI
		Prestito prestito1 = new Prestito(mario, rivista2, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15));
		Prestito prestito2 = new Prestito(maria, libro3, LocalDate.of(2023, 3, 15), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 4, 2));
		Prestito prestito3 = new Prestito(giovanni, libro1, LocalDate.of(2023, 6, 20), LocalDate.of(2023, 6, 20), LocalDate.of(2023, 6, 22));
		Prestito prestito4 = new Prestito(sofia, rivista1, LocalDate.of(2023, 9, 28), LocalDate.of(2023, 9, 28), LocalDate.of(2023, 3, 12));
		
		//TRANSACTION BEGIN
		em.getTransaction().begin();
		
		//PERSIST RIVISTE
		em.persist(rivista1);
		em.persist(rivista2);
		em.persist(rivista3);
		em.persist(rivista4);
		
		//PERSIST LIBRI
		em.persist(libro1);
		em.persist(libro2);
		em.persist(libro3);
		em.persist(libro4);
		
		//PERSIST UTENTI
		uDAO.save(sofia);
		uDAO.save(mario);
		uDAO.save(maria);
		uDAO.save(giovanni);
		
		
		//PERSIST PRESTITI
		pDAO.save(prestito1);
		pDAO.save(prestito2);
		pDAO.save(prestito3);
		pDAO.save(prestito4);
		
		//TRANSACTION COMMIT
		em.getTransaction().commit();

		//CLOSING EM
		em.close();
		emf.close();
	}
	

}
