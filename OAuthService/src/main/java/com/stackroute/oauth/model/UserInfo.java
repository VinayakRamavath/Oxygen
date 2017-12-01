package com.stackroute.oauth.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="UserInfo")
public class UserInfo {
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid +   ", username=" + username + ", password=" + password
				+ ", email=" + email + ", roles=" + roles + "]";
	}

	@Id
	@GeneratedValue
	private Integer userid;
	

	
	@Column
	@NotNull(message="username cannot be null")
	@Size(min=1, message="username cannot be empty")
	private String username;
	
	@Column
	@NotNull(message="password cannot be null")
//	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#$@!%&*?])[A-Za-z0-9#$@!%&*?]{7,}",
//			message="password must have atleast one uppercase, atleast one lowercase, atleast one numeric digit and atleast one special character")
	private String password;
	
	@Column
	@NotNull(message="email cannot be null")
	@Pattern(regexp = "[a-z0-9.]+@cgi.com", message="email must be @cgi.com domain")
	private String email;

	@NotNull(message="roles cannot be empty")
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<UserRole> roles;
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
}
