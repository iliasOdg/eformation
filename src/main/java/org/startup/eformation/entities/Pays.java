package org.startup.eformation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the nomPays database table.
 * 
 */
@Entity
@Table(name="Pays")
@NamedQuery(name="Pays.findAll", query="SELECT p FROM Pays p")
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_iso", length=5, unique=true)
	private String codeIso;
	
	@Column(name="nom_pays",length=50)
	private String nomPays;
	
	@Column(length=50)
	private String ville;

	public Pays() {
	}

	public String getCodeIso() {
		return this.codeIso;
	}

	public void setCodeIso(String codeIso) {
		this.codeIso = codeIso;
	}

	public String getPays() {
		return this.nomPays;
	}

	public void setPays(String pays) {
		this.nomPays = pays;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}