package parcinfo;


public class Salle {
	
	int idS;
	int numero;

	/* Constructeur */
	public Salle(int numero){
		this.numero = numero;
		this.idS=(int) System.currentTimeMillis(); // Recuperation du timestamp pour generer l'identifant
	}
	
	public int getIdS() {
		return idS;
	}

	public int getNumero() {
		return numero;
	}

	
	
}
