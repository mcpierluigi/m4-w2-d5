package progetto;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Archivio {
	//Logger
	public static Logger logger = LoggerFactory.getLogger(Archivio.class);
	
	//Map of Key,Element
	Map<String, Elemento> archivio;
	//
	public Archivio() {
		this.archivio = new HashMap<String, Elemento>();
	}
	
	//Save/Read Archive on/from Disk
	File file = new File("archivio.txt");
	
	public void saveArchivio() throws IOException {
		String fileStringa = "";
		
			for (Elemento elemento : archivio.values()) {
				if (fileStringa.length() != 0) {
					fileStringa += "#";
				}
				if (elemento instanceof Libro) {
					fileStringa += Libro.toString((Libro) elemento);
				} else if (elemento instanceof Rivista) {
					fileStringa += Rivista.toString((Rivista) elemento);
				}
			}

		FileUtils.writeStringToFile(file, fileStringa, "UTF-8", false);
		logger.info("Dati salvati correttamente sul file");
	}
	
	public static String readFileFromDisk() throws IOException {
		File file = new File("archivio.txt");
		if (file.exists()) {
			String content = FileUtils.readFileToString(file, "UTF-8");
			return content;
		} else {
			logger.info("File non trovato!");
			return "";
		}
	}
	
	//Main
	public static void main(String[] args) {
		
		Archivio mainArchivio = new Archivio();
		
		//Book and Magazine
		Libro libro1 = new Libro("12345", "Maze Runner", 2012, 346, "Dashmer", "Romanzo" );
		Libro libro2 = new Libro("34562", "Harry Potter", 1997, 248, "Rowling", "Romanzo" );
		Libro libro3 = new Libro("63256", "Il Signore degli Anelli", 1970, 128, "Tolkien", "Romanzo" );
		
		Rivista rivista1 = new Rivista("67890", "Focus" , 2023, 50, Periodicità.MENSILE);
		Rivista rivista2 = new Rivista("84637", "National Geographic" , 2023, 50, Periodicità.SEMESTRALE);
		Rivista rivista3 = new Rivista("95726", "Vogue" , 2023, 50, Periodicità.SETTIMANALE);
		
		//Tests
		mainArchivio.aggiungi(libro1);
		mainArchivio.aggiungi(libro2);
		mainArchivio.aggiungi(libro3);
		mainArchivio.aggiungi(rivista1);
		mainArchivio.aggiungi(rivista2);
		mainArchivio.aggiungi(rivista3);
		
		
		mainArchivio.rimuovi("95726");
		
		Elemento ricercaPerISBN = mainArchivio.ricercaPerISBN("12345");
		System.out.println(ricercaPerISBN.getTitolo());
		
		List<Elemento> ricercaPerAnno = mainArchivio.ricercaPerAnno(1997);
		ricercaPerAnno.forEach(e -> System.out.println(e.getTitolo()));
		
		List<Libro> ricercaPerAutore = mainArchivio.ricercaPerAutore("Tolkien");
		ricercaPerAutore.forEach(e -> System.out.println("Titolo: " + e.getTitolo()));
		
		try {
			mainArchivio.saveArchivio();
		} catch (IOException e) {
			logger.error("Errore durante la lettura/scrittura",e);
		}
		
		try {
			logger.info(System.lineSeparator());
			logger.info(System.lineSeparator() + "ECCO IL CONTENUTO DEL FILE:");
			logger.info(System.lineSeparator() +  readFileFromDisk());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Methods
	public void aggiungi(Elemento elemento) {
		archivio.put(elemento.getCodiceISBN(), elemento);
	}
	
	public void rimuovi(String codice) {
		Elemento elementoRimosso = archivio.remove(codice);
		System.out.println("elemento " + elementoRimosso.titolo + " rimosso");
	}
	
	public Elemento ricercaPerISBN(String codice) {
		return archivio.get(codice);
	}
	
	//Da capire perchè con (e -> e.getAnnoPubblicazion() == anno) non funziona :(
	public List<Elemento> ricercaPerAnno(Integer anno) {
		return archivio.values().stream().filter(e -> anno.equals(e.getAnnoPubblicazione())).toList();
	}
	
	public List<Libro> ricercaPerAutore(String autore) {
		return archivio.values().stream().filter(elem -> elem instanceof Libro).map(e -> (Libro) e)
				.filter(e -> e.getAutore() == autore).toList();
	}
	
}
