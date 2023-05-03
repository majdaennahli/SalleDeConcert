package salleDeConcert.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@AttributeOverride(name="id",column = @Column(name="admin_id"))
@AttributeOverride( name="login", column = @Column(name="admin_login"))
@AttributeOverride( name="password", column = @Column(name="admin_password"))
@AttributeOverride( name="email", column = @Column(name="admin_email"))
public class Admin extends Compte{

	public Admin() {
	
	}

	

	
}
