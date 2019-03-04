package org.startup.eformation.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the module_formation database table.
 * 
 */
@Entity
@Table(name="module_formation")
@NamedQuery(name="ModuleFormation.findAll", query="SELECT m FROM ModuleFormation m")
public class ModuleFormation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mod", length=15, unique=true)
	private String idMod;

	@Column(name="cout_mod")
	private double coutMod;

	@Temporal(TemporalType.DATE)
	@Column(name="date_crea")
	private Date dateCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="date_maj")
	private Date dateMaj;

	private String description;
	
	@Column(length=200)
	private String resume;
	
	@Column(length=5)
	private String statut;

	private String theme;

	@Column(name="titre_court", length=50)
	private String titreCourt;

	@Column(name="titre_long", length=200)
	private String titreLong;

	//bi-directional many-to-many association to Session
	@ManyToMany(mappedBy="moduleFormations")
	private List<Session> sessions;

	//bi-directional many-to-one association to Domaine
	@OneToMany(mappedBy="moduleFormation")
	private List<Domaine> domaines;

	//bi-directional many-to-one association to ChapitreDAO
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_chap")
	private Chapitre chapitre;

	//bi-directional many-to-one association to ContenuVideoDAO
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_contenu")
	private ContenuVideo contenuVideo;

	//bi-directional many-to-one association to Document
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_doc")
	private Document document;

	public ModuleFormation() {
	}

	public String getIdMod() {
		return this.idMod;
	}

	public void setIdMod(String idMod) {
		this.idMod = idMod;
	}

	public double getCoutMod() {
		return this.coutMod;
	}

	public void setCoutMod(double coutMod) {
		this.coutMod = coutMod;
	}

	public Date getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateMaj() {
		return this.dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitreCourt() {
		return this.titreCourt;
	}

	public void setTitreCourt(String titreCourt) {
		this.titreCourt = titreCourt;
	}

	public String getTitreLong() {
		return this.titreLong;
	}

	public void setTitreLong(String titreLong) {
		this.titreLong = titreLong;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Domaine> getDomaines() {
		return this.domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

	public Domaine addDomaine(Domaine domaine) {
		getDomaines().add(domaine);
		domaine.setModuleFormation(this);

		return domaine;
	}

	public Domaine removeDomaine(Domaine domaine) {
		getDomaines().remove(domaine);
		domaine.setModuleFormation(null);

		return domaine;
	}

	public Chapitre getChapitre() {
		return this.chapitre;
	}

	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}

	public ContenuVideo getContenuVideo() {
		return this.contenuVideo;
	}

	public void setContenuVideo(ContenuVideo contenuVideo) {
		this.contenuVideo = contenuVideo;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}