package progetto;

public class Elemento {
	String codiceISBN, titolo;
	Integer annoPubblicazione, numeroPagine;
	
	Elemento (String codice, String titolo, Integer anno, Integer pagine) {
		this.codiceISBN = codice;
		this.titolo = titolo;
		this.annoPubblicazione = anno;
		this.numeroPagine = pagine;
	}

	public String getCodiceISBN() {
		return codiceISBN;
	}
	
	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
}
