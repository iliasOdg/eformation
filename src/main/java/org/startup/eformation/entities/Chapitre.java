package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chapitre database table.
 * 
 */
@Entity
@NamedQuery(name="Chapitre.findAll", query="SELECT c FROM Chapitre c")
public class Chapitre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_chap", length=15, unique=true)
	private String idChap;
	
	@Column(length=100)
	private String libelle;

	//bi-directional many-to-one association to ModuleFormation
	@OneToMany(mappedBy="chapitre")
	private List<ModuleFormation> moduleFormations;

	public Chapitre() {
	}

	public String getIdChap() {
		return this.idChap;
	}

	public void setIdChap(String idChap) {
		this.idChap = idChap;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ModuleFormation> getModuleFormations() {
		return this.moduleFormations;
	}

	public void setModuleFormations(List<ModuleFormation> moduleFormations) {
		this.moduleFormations = moduleFormations;
	}

	public ModuleFormation addModuleFormation(ModuleFormation moduleFormation) {
		getModuleFormations().add(moduleFormation);
		moduleFormation.setChapitre(this);

		return moduleFormation;
	}

	public ModuleFormation removeModuleFormation(ModuleFormation moduleFormation) {
		getModuleFormations().remove(moduleFormation);
		moduleFormation.setChapitre(null);

		return moduleFormation;
	}

}