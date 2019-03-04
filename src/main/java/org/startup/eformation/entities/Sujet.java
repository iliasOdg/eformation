package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sujet database table.
 * 
 */
@Entity
@NamedQuery(name="Sujet.findAll", query="SELECT s FROM Sujet s")
public class Sujet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sujet", length=15, unique=true)
	private int idSujet;
	
	@Column(length=50)
	private String auteur;

	@Temporal(TemporalType.DATE)
	@Column(name="date_crea")
	private Date dateCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="date_modif")
	private Date dateModif;
	
	@Column(length=50)
	private String libelle;

	//bi-directional many-to-one association to Forum
	@OneToMany(mappedBy="sujet")
	private List<Forum> forums;

	//bi-directional many-to-one association to Message
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_msg")
	private Message message;

	public Sujet() {
	}

	public int getIdSujet() {
		return this.idSujet;
	}

	public void setIdSujet(int idSujet) {
		this.idSujet = idSujet;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateModif() {
		return this.dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Forum> getFaqs() {
		return this.forums;
	}

	public void setFaqs(List<Forum> forums) {
		this.forums = forums;
	}

	public Forum addFaq(Forum forum) {
		getFaqs().add(forum);
		forum.setSujet(this);

		return forum;
	}

	public Forum removeFaq(Forum forum) {
		getFaqs().remove(forum);
		forum.setSujet(null);

		return forum;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}