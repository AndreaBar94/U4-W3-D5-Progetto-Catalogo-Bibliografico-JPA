package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "findByYear", query = "SELECT y FROM Editoria y WHERE y.annoPub = :annoPub")
@NamedQuery(name = "getByTitle", query = "SELECT t FROM Editoria t WHERE t.titolo LIKE CONCAT('%', :titolo, '%')")
public abstract class Editoria {
	
	@Id
	@GeneratedValue
	protected UUID ISBN;
	protected String titolo;
	protected long annoPub;
	protected long pagine;
	
	public Editoria(String titolo, long annoPub, long pagine) {

		this.titolo = titolo;
		this.annoPub = annoPub;
		this.pagine = pagine;
	}
	
	
		
		@Override
		public String toString() {
		    return "ISBN: " + ISBN + ", Titolo: " + titolo + ", Anno di pubblicazione: " + annoPub + ", Pagine: " + pagine;
		}

}
