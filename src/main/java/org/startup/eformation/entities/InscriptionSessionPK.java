package org.startup.eformation.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the apre_sess database table.
 * 
 */
@Embeddable
public class InscriptionSessionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_apprenant",length=15, insertable=false, updatable=false)
	private String idApprenant;

	@Column(name="id_session",length=15, insertable=false, updatable=false)
	private String idSession;

	public InscriptionSessionPK() {
	}
	public String getIdApprenant() {
		return this.idApprenant;
	}
	public void setIdApprenant(String idApprenant) {
		this.idApprenant = idApprenant;
	}
	public String getIdSession() {
		return this.idSession;
	}
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InscriptionSessionPK)) {
			return false;
		}
		InscriptionSessionPK castOther = (InscriptionSessionPK)other;
		return 
			this.idApprenant.equals(castOther.idApprenant)
			&& this.idSession.equals(castOther.idSession);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idApprenant.hashCode();
		hash = hash * prime + this.idSession.hashCode();
		
		return hash;
	}
}