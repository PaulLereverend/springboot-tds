package sp4.spring.models;

public class Element {
	private String nom="";
	private int evaluation;
	
	public Element(String nom,int evaluation) {
		this.nom = nom;
		this.evaluation = evaluation;
	}
	public Element() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public boolean equals(Element e) {
		return e.getNom()==this.getNom();
	}
	
	
	
}
