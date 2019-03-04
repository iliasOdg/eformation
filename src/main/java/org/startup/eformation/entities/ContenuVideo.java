package org.startup.eformation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the contenu_video database table.
 * 
 */
@Entity
@Table(name="contenu_video")
@NamedQuery(name="ContenuVideo.findAll", query="SELECT c FROM ContenuVideo c")
public class ContenuVideo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_contenu", length=15, unique=true)
	private int idContenu;

	private String contenu;
	
	@Column(length=5)
	private String format;
	
	@Column(length=50)
	private String intitule;

	private int taille;

	//bi-directional many-to-one association to ModuleFormation
	@OneToMany(mappedBy="contenuVideo")
	private List<ModuleFormation> moduleFormations;

	public ContenuVideo() {
	}

	public int getIdContenu() {
		return this.idContenu;
	}

	public void setIdContenu(int idContenu) {
		this.idContenu = idContenu;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<ModuleFormation> getModuleFormations() {
		return this.moduleFormations;
	}

	public void setModuleFormations(List<ModuleFormation> moduleFormations) {
		this.moduleFormations = moduleFormations;
	}

	public ModuleFormation addModuleFormation(ModuleFormation moduleFormation) {
		getModuleFormations().add(moduleFormation);
		moduleFormation.setContenuVideo(this);

		return moduleFormation;
	}

	public ModuleFormation removeModuleFormation(ModuleFormation moduleFormation) {
		getModuleFormations().remove(moduleFormation);
		moduleFormation.setContenuVideo(null);

		return moduleFormation;
	}

}