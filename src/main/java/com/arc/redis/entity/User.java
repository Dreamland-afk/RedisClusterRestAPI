package com.arc.redis.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	@Id
	@Column(name = "username",unique = true)
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isenable")
	private int isEnable;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Roles roles;

	public User(String userName, String password, int isEnable) {
		super();
		this.userName = userName;
		this.password = password;
		this.isEnable = isEnable;
	}
	
	public void addRoles(Roles roles)
	{
		if(this.roles == null)
			this.roles = roles;
		roles.setUser(this);
	}
	
	
	
}
