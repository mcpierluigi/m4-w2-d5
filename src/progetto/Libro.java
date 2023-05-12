package progetto;

public class Libro extends Elemento {
	String autore, genere;
	
	Libro(String codice, String titolo, Integer anno, Integer pagine, String autore, String genere) {
		super(codice, titolo, anno, pagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public static String toString(Libro libro) {
		String s = System.lineSeparator();
		return "#" + libro.codiceISBN + s + 
				"#" + libro.titolo + s + 
				"#" + libro.annoPubblicazione + s +
				"#" + libro.numeroPagine + s +
				"#" + libro.autore + s +
				"#" + libro.genere + s;
	}
}
