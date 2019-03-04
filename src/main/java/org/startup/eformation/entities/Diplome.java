package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the diplome database table.
 * 
 */
@Entity
@NamedQuery(name="Diplome.findAll", query="SELECT d FROM Diplome d")
public class Diplome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_diplome", length=15, unique=true)
	private int idDiplome;
	
	@Column(name="nom_diplome",length=200)
	private String nomDiplome;
	
	@Column(length=100)
	private String equivalence;

	//bi-directional many-to-one association to Intervenant
	@OneToMany(mappedBy="diplome")
	private List<Intervenant> intervenants;

	public Diplome() {
	}

	public int getIdDiplome() {
		return this.idDiplome;
	}

	public void setIdDiplome(int idDiplome) {
		this.idDiplome = idDiplome;
	}

	public String getEquivalence() {
		return this.equivalence;
	}

	public void setEquivalence(String equivalence) {
		this.equivalence = equivalence;
	}

	public List<Intervenant> getIntervenants() {
		return this.intervenants;
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}

	public Intervenant addIntervenant(Intervenant intervenant) {
		getIntervenants().add(intervenant);
		intervenant.setDiplome(this);

		return intervenant;
	}

	public Intervenant removeIntervenant(Intervenant intervenant) {
		getIntervenants().remove(intervenant);
		intervenant.setDiplome(null);

		return intervenant;
	}

}