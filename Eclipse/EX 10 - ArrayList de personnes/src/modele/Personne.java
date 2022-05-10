package modele;

public class Personne {
	private final int id;
	private final String nom;
	
//	int[] notes;
	
	public Personne(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		
//		this.notes = new int[10];
//		for(int i=0; i<this.notes.length; i++) {
//			this.notes[i] = i;
//		}
	}
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		String res = this.nom + " (#" + this.id + ")";
//		res += "Notes : ";
//		for(int note : this.notes) {
//			res += note + " ";
//		}
//		res += "\n";
		return res;
	}
	
	public static void main(String[] args) {
		Personne p = new Personne(23, "toto");
		System.out.println(p);
	}
}













