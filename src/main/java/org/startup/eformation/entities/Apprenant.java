package org.startup.eformation.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the apprenant database table.
 * 
 */
@Entity
@NamedQuery(name="Apprenant.findAll", query="SELECT a FROM Apprenant a")
public class Apprenant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_apprenant", length=15, unique=true, insertable=true, updatable=true)
	private String idApprenant;

	private String avatar;

	@Temporal(TemporalType.DATE)
	@Column(name="date_insc_platf")
	private Date dateInscPlatf;

	@Temporal(TemporalType.DATE)
	@Column(name="dern_con")
	private Date dernCon;
	
	@Column(length=50)
	private String email;
	
	@Column(length=50)
	private String login;
	
	@Column(length=100)
	private String nom;
	
	@Column(length=255)
	private String passw;
	
	@Column(length=100)
	private String prenom;
	
	@Column(length=50)
	private String tel;

	//bi-directional many-to-one association to InscriptionSession
	@OneToMany(mappedBy="apprenant")
	private List<InscriptionSession> apreSesses;

	public Apprenant() {
	}

	public Apprenant(String idApprenant, String avatar, Date dateInscPlatf, Date dernCon, String email, String login,
			String nom, String passw, String prenom, String tel, List<InscriptionSession> apreSesses) {
		super();
		this.idApprenant = idApprenant;
		this.avatar = avatar;
		this.dateInscPlatf = dateInscPlatf;
		this.dernCon = dernCon;
		this.email = email;
		this.login = login;
		this.nom = nom;
		this.passw = passw;
		this.prenom = prenom;
		this.tel = tel;
		this.apreSesses = apreSesses;
	}

	

	public Apprenant(String idApprenant, String avatar, Date dateInscPlatf, Date dernCon, String email, String login,
			String nom, String passw, String prenom, String tel) {
		super();
		this.idApprenant = idApprenant;
		this.avatar = avatar;
		this.dateInscPlatf = dateInscPlatf;
		this.dernCon = dernCon;
		this.email = email;
		this.login = login;
		this.nom = nom;
		this.passw = passw;
		this.prenom = prenom;
		this.tel = tel;
	}

	public String getIdApprenant() {
		return this.idApprenant;
	}

	public void setIdApprenant(String idApprenant) {
		this.idApprenant = idApprenant;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getDateInscPlatf() {
		return this.dateInscPlatf;
	}

	public void setDateInscPlatf(Date dateInscPlatf) {
		this.dateInscPlatf = dateInscPlatf;
	}

	public Date getDernCon() {
		return this.dernCon;
	}

	public void setDernCon(Date dernCon) {
		this.dernCon = dernCon;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassw() {
		return this.passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<InscriptionSession> getApreSesses() {
		return this.apreSesses;
	}

	public void setApreSesses(List<InscriptionSession> apreSesses) {
		this.apreSesses = apreSesses;
	}

	public InscriptionSession addApreSess(InscriptionSession inscriptionSession) {
		getApreSesses().add(inscriptionSession);
		inscriptionSession.setApprenant(this);

		return inscriptionSession;
	}

	public InscriptionSession removeApreSess(InscriptionSession inscriptionSession) {
		getApreSesses().remove(inscriptionSession);
		inscriptionSession.setApprenant(null);

		return inscriptionSession;
	}

}