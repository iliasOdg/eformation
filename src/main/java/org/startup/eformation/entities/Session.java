package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_session", length=15, unique=true)
	private String idSession;

	@Temporal(TemporalType.DATE)
	@Column(name="date_dern_modif")
	private Date dateDernModif;

	@Column(name="libelle_session", length=50)
	private String libelleSession;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="session")
	private List<Adresse> adresses;

	//bi-directional many-to-one association to InscriptionSession
	@OneToMany(mappedBy="session")
	private List<InscriptionSession> apreSesses;

	//bi-directional many-to-many association to ModuleFormation
	@ManyToMany
	@JoinTable(
		name="session_module"
		, joinColumns={
			@JoinColumn(name="id_session")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_mod")
			}
		)
	private List<ModuleFormation> moduleFormations;

	//bi-directional many-to-one association to Forum
	@OneToMany(mappedBy="session")
	private List<Forum> forums;

	//bi-directional many-to-many association to Intervenant
	@ManyToMany
	@JoinTable(
		name="intervenant_session"
		, joinColumns={
			@JoinColumn(name="id_session")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_interv")
			}
		)
	private List<Intervenant> intervenants;

	//bi-directional many-to-one association to Forum
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_forum")
	private Forum forum;

	public Session() {
	}

	public String getIdSession() {
		return this.idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public Date getDateDernModif() {
		return this.dateDernModif;
	}

	public void setDateDernModif(Date dateDernModif) {
		this.dateDernModif = dateDernModif;
	}

	public String getLibelleSession() {
		return this.libelleSession;
	}

	public void setLibelleSession(String libelleSession) {
		this.libelleSession = libelleSession;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Adresse addAdress(Adresse adress) {
		getAdresses().add(adress);
		adress.setSession(this);

		return adress;
	}

	public Adresse removeAdress(Adresse adress) {
		getAdresses().remove(adress);
		adress.setSession(null);

		return adress;
	}

	public List<InscriptionSession> getApreSesses() {
		return this.apreSesses;
	}

	public void setApreSesses(List<InscriptionSession> apreSesses) {
		this.apreSesses = apreSesses;
	}

	public InscriptionSession addApreSess(InscriptionSession inscriptionSession) {
		getApreSesses().add(inscriptionSession);
		inscriptionSession.setSession(this);

		return inscriptionSession;
	}

	public InscriptionSession removeApreSess(InscriptionSession inscriptionSession) {
		getApreSesses().remove(inscriptionSession);
		inscriptionSession.setSession(null);

		return inscriptionSession;
	}

	public List<ModuleFormation> getModuleFormations() {
		return this.moduleFormations;
	}

	public void setModuleFormations(List<ModuleFormation> moduleFormations) {
		this.moduleFormations = moduleFormations;
	}

	public List<Forum> getFaqs() {
		return this.forums;
	}

	public void setFaqs(List<Forum> forums) {
		this.forums = forums;
	}

	public Forum addFaq(Forum forum) {
		getFaqs().add(forum);
		forum.setSession(this);

		return forum;
	}

	public Forum removeFaq(Forum forum) {
		getFaqs().remove(forum);
		forum.setSession(null);

		return forum;
	}

	public List<Intervenant> getIntervenants() {
		return this.intervenants;
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}

	public Forum getFaq() {
		return this.forum;
	}

	public void setFaq(Forum forum) {
		this.forum = forum;
	}

}