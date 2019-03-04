package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the faq database table.
 * 
 */
@Entity
@NamedQuery(name="Forum.findAll", query="SELECT f FROM Forum f")
public class Forum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_forum", length=15, unique=true)
	private String idForum;
	
	@Column(length=50)
	private String auteur;

	@Temporal(TemporalType.DATE)
	@Column(name="date_crea")
	private Date dateCrea;

	private Boolean etat;

	@Column(name="heure_crea")
	private Time heureCrea;
	
	@Column(length=100)
	private String intitule;

	//bi-directional many-to-one association to Session
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_session")
	private Session session;

	//bi-directional many-to-one association to SujetDAO
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_sujet")
	private Sujet sujet;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="forum")
	private List<Session> sessions;

	public Forum() {
	}

	public String getIdForum() {
		return this.idForum;
	}

	public void setIdForum(String idForum) {
		this.idForum = idForum;
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

	public Boolean getEtat() {
		return this.etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Time getHeureCrea() {
		return this.heureCrea;
	}

	public void setHeureCrea(Time heureCrea) {
		this.heureCrea = heureCrea;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Sujet getSujet() {
		return this.sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setFaq(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setFaq(null);

		return session;
	}

}