package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nomDomaine database table.
 * 
 */
@Entity
@NamedQuery(name="Domaine.findAll", query="SELECT d FROM Domaine d")
public class Domaine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_domaine", length=15, unique=true)
	private String idDomaine;

	@Temporal(TemporalType.DATE)
	@Column(name="date_crea")
	private Date dateCrea;

	@Temporal(TemporalType.DATE)
	@Column(name="date_dern_modif")
	private Date dateDernModif;
	
	@Column(length=50)
	private String nomDomaine;

	//bi-directional many-to-one association to ModuleFormation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_mod")
	private ModuleFormation moduleFormation;

	public Domaine() {
	}

	public String getIdDomaine() {
		return this.idDomaine;
	}

	public void setIdDomaine(String idDomaine) {
		this.idDomaine = idDomaine;
	}

	public Date getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public Date getDateDernModif() {
		return this.dateDernModif;
	}

	public void setDateDernModif(Date dateDernModif) {
		this.dateDernModif = dateDernModif;
	}

	public String getDomaine() {
		return this.nomDomaine;
	}

	public void setDomaine(String domaine) {
		this.nomDomaine = domaine;
	}

	public ModuleFormation getModuleFormation() {
		return this.moduleFormation;
	}

	public void setModuleFormation(ModuleFormation moduleFormation) {
		this.moduleFormation = moduleFormation;
	}

}