package progetto;

public class Rivista extends Elemento {
	Periodicità periodicità;
	
	Rivista(String codice, String titolo, Integer anno, Integer pagine, Periodicità periodo) {
		super(codice, titolo, anno, pagine);
		this.periodicità = periodo;
	}
	
	public static String toString(Rivista rivista) {
		String s = System.lineSeparator();
		return "#" + rivista.codiceISBN + s +
				"#" + rivista.titolo + s +
				"#" + rivista.annoPubblicazione + s +
				"#" + rivista.numeroPagine + s +
				"#" + rivista.periodicità + s;
	}
}
