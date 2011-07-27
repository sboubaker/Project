package org.groupid.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails {

	@Id
	@GeneratedValue
	private Long id;
	
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String pwd;
	@NotEmpty
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		list.add(new GrantedAuthorityImpl(getRole()));
		return list;
	}
	public String getPassword() {
		return getPwd();
	}
	public String getUsername() {
		return getEmail();
	}
	public boolean isAccountNonExpired() {
		
		return true;
	}
	public boolean isAccountNonLocked() {
		
		return true;
	}
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	public boolean isEnabled() {
		
		return true;
	}
	
	
}
