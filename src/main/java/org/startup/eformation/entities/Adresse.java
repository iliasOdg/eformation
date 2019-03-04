package org.startup.eformation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adr", length=15, unique=true)
	private int idAdr;

	private String adresse;

	@Column(name="code_postale", length=8)
	private int codePostale;

	private int rue;

	@Column(name="ville_adr", length=30)
	private String villeAdr;

	//bi-directional many-to-one association to Session
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_session")
	private Session session;

	public Adresse() {
	}

	public int getIdAdr() {
		return this.idAdr;
	}

	public void setIdAdr(int idAdr) {
		this.idAdr = idAdr;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostale() {
		return this.codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public int getRue() {
		return this.rue;
	}

	public void setRue(int rue) {
		this.rue = rue;
	}

	public String getVilleAdr() {
		return this.villeAdr;
	}

	public void setVilleAdr(String villeAdr) {
		this.villeAdr = villeAdr;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}