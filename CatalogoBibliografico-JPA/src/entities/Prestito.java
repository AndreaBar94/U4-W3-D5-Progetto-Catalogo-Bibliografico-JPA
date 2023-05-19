package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestito")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "getElementsByIdCard", query = "SELECT e.elementoPrestato FROM Prestito e JOIN e.utente u WHERE u.numeroTessera = :numeroTessera AND e.dataRestituzioneEffettiva IS NULL")
@NamedQuery(name = "getExpired", query = "SELECT p.elementoPrestato FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL")
public class Prestito {
	
	@Id 
	@GeneratedValue 
	private UUID id;
	
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Editoria elementoPrestato;
	private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;
    
	public Prestito(Utente utente, Editoria elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzioneEffettiva = dataRestituzionePrevista;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
	}
    
    
}
