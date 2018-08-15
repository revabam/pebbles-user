package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="BAM_USER")
@SequenceGenerator(name="bam_user_seq", sequenceName="bam_user_seq", allocationSize=1)
public class BamUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="bam_user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bam_user_seq")
	private Integer id;
	
	@NotNull
	@Column(name="firstname")
	private String firstname;
	
	@NotNull
	@Column(name="lastname")
	private String lastname;
	
	@Email
	@NotNull
	@Column(name="email", unique=true)
	private String email;
	
	@NotNull
	@Column(name="role_id")
	private Integer role_id;
	
	@NotNull
	@Column(name="status_id")
	private Integer status_id;
	
	public BamUser() {
		
	}

	public BamUser(String firstname, String lastname, String email, int role_id, int status_id) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role_id = role_id;
		this.status_id = status_id;
	}

	public BamUser(int id, String firstname, String lastname, String email, int role_id, int status_id) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role_id = role_id;
		this.status_id = status_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
		result = prime * result + ((status_id == null) ? 0 : status_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BamUser other = (BamUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (status_id == null) {
			if (other.status_id != null)
				return false;
		} else if (!status_id.equals(other.status_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BamUser [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", role_id=" + role_id + ", status_id=" + status_id + "]";
	}
	
}
