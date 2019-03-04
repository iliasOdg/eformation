package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_msg", length=15, unique=true)
	private int idMsg;
	
	@Column(length=50)
	private String auteur;
	
	@Column(length=255)
	private String contenu;

	@Temporal(TemporalType.DATE)
	private Date date;

	private Time heure;

	//bi-directional many-to-one association to SujetDAO
	@OneToMany(mappedBy="message")
	private List<Sujet> sujets;

	public Message() {
	}

	public int getIdMsg() {
		return this.idMsg;
	}

	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure() {
		return this.heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public List<Sujet> getSujets() {
		return this.sujets;
	}

	public void setSujets(List<Sujet> sujets) {
		this.sujets = sujets;
	}

	public Sujet addSujet(Sujet sujet) {
		getSujets().add(sujet);
		sujet.setMessage(this);

		return sujet;
	}

	public Sujet removeSujet(Sujet sujet) {
		getSujets().remove(sujet);
		sujet.setMessage(null);

		return sujet;
	}

}