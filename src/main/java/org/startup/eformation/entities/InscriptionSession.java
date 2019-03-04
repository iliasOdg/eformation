package org.startup.eformation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the apre_sess database table.
 * 
 */
@Entity
@Table(name="InscriptionSession")
@NamedQuery(name="InscriptionSession.findAll", query="SELECT a FROM InscriptionSession a")
public class InscriptionSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InscriptionSessionPK id;

	@Column(name="cout_insc")
	private double coutInsc;

	@Temporal(TemporalType.DATE)
	@Column(name="date_insc")
	private Date dateInsc;

	@Column(name="en_ligne")
	private Boolean enLigne;

	@Column(name="en_pres")
	private Boolean enPres;

	//bi-directional many-to-one association to Apprenant
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_apprenant", insertable=false, updatable=false)
	private Apprenant apprenant;

	//bi-directional many-to-one association to Session
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_session", insertable=false, updatable=false)
	private Session session;

	public InscriptionSession() {
	}

	public InscriptionSessionPK getId() {
		return this.id;
	}

	public void setId(InscriptionSessionPK id) {
		this.id = id;
	}

	public double getCoutInsc() {
		return this.coutInsc;
	}

	public void setCoutInsc(double coutInsc) {
		this.coutInsc = coutInsc;
	}

	public Date getDateInsc() {
		return this.dateInsc;
	}

	public void setDateInsc(Date dateInsc) {
		this.dateInsc = dateInsc;
	}

	public Boolean getEnLigne() {
		return this.enLigne;
	}

	public void setEnLigne(Boolean enLigne) {
		this.enLigne = enLigne;
	}

	public Boolean getEnPres() {
		return this.enPres;
	}

	public void setEnPres(Boolean enPres) {
		this.enPres = enPres;
	}

	public Apprenant getApprenant() {
		return this.apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}