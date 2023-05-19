package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Riviste extends Editoria{
	
	@Enumerated(EnumType.STRING)
	private Periodicità periodicità;
	
	
	
	public Riviste(String titolo, long annoPub, long pagine, Periodicità periodicità) {
		super(titolo, annoPub, pagine);
		this.periodicità = periodicità;
	}




	@Override
	public String toString() {
	    return super.toString() + ", Periodicità " + periodicità ;
	}
	
	
}
