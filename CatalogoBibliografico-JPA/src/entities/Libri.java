package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libri")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "findByAuthor", query = "SELECT a FROM Libri a WHERE a.autore = :autore")
public class Libri extends Editoria{
	
	private String autore;
	private String genere;

	public Libri(String titolo, long annoPub, long pagine, String autore, String genere) {
		super(titolo, annoPub, pagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	@Override
	public String toString() {
	    return super.toString() + ", Autore: " + autore + ", Genere: " + genere;
	}

}
