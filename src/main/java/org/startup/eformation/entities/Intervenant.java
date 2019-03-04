package org.startup.eformation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the intervenant database table.
 * 
 */
@Entity
@NamedQuery(name="Intervenant.findAll", query="SELECT i FROM Intervenant i")
public class Intervenant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_interv", unique=true, length=15)
	private String idInterv;
	
	@Column(length=255)
	private String email;

	@Column(name="grade_court", length=50)
	private String gradeCourt;

	@Column(name="grade_long", length=100)
	private String gradeLong;
	
	@Column(length=50)
	private String nationalite;
	
	@Column(length=100)
	private String nom;
	
	@Column(length=100)
	private String prenom;
	
	@Column(length=50)
	private String role;

	@Column(name="taux_horaire")
	private double tauxHoraire;

	@Column(name="taux_jour")
	private double tauxJour;

	private String tel;

	//bi-directional many-to-many association to Session
	@ManyToMany(mappedBy="intervenants")
	private List<Session> sessions;

	//bi-directional many-to-one association to Diplome
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_diplome")
	private Diplome diplome;

	public Intervenant() {
	}

	public String getIdInterv() {
		return this.idInterv;
	}

	public void setIdInterv(String idInterv) {
		this.idInterv = idInterv;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGradeCourt() {
		return this.gradeCourt;
	}

	public void setGradeCourt(String gradeCourt) {
		this.gradeCourt = gradeCourt;
	}

	public String getGradeLong() {
		return this.gradeLong;
	}

	public void setGradeLong(String gradeLong) {
		this.gradeLong = gradeLong;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getTauxHoraire() {
		return this.tauxHoraire;
	}

	public void setTauxHoraire(double tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}

	public double getTauxJour() {
		return this.tauxJour;
	}

	public void setTauxJour(double tauxJour) {
		this.tauxJour = tauxJour;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Diplome getDiplome() {
		return this.diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

}