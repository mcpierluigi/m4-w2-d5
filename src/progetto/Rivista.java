package progetto;

public class Rivista extends Elemento {
	Periodicità periodicità;
	
	Rivista(String codice, String titolo, Integer anno, Integer pagine, Periodicità periodo) {
		super(codice, titolo, anno, pagine);
		this.periodicità = periodo;
	}
	
	public static String toString(Rivista rivista) {
		return "Rivista"  + "#" + rivista.codiceISBN + "#" + rivista.titolo + "#" + rivista.annoPubblicazione
				+ "#" + rivista.numeroPagine + "#" + rivista.periodicità;
	}
	
}
