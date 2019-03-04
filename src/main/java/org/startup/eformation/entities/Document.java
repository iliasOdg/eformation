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
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name="documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_doc", length=15, unique=true)
	private int idDoc;
	
	private String contenu;
	
	@Column(length=5)
	private String format;

	@Column(name="nom_doc", length=50)
	private String nomDoc;
	
	private int taille;

	//bi-directional many-to-one association to ModuleFormation
	@OneToMany(mappedBy="document")
	private List<ModuleFormation> moduleFormations;

	public Document() {
	}

	public int getIdDoc() {
		return this.idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
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

	public String getNomDoc() {
		return this.nomDoc;
	}

	public void setNomDoc(String nomDoc) {
		this.nomDoc = nomDoc;
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
		moduleFormation.setDocument(this);

		return moduleFormation;
	}

	public ModuleFormation removeModuleFormation(ModuleFormation moduleFormation) {
		getModuleFormations().remove(moduleFormation);
		moduleFormation.setDocument(null);

		return moduleFormation;
	}

}