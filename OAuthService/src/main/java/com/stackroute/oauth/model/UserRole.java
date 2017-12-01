package com.stackroute.oauth.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name="userroles")
public class UserRole {

    @Override
	public String toString() {
		return "UserRole [roleid=" + roleid + ", rolename=" + rolename + "]";
	}

	@Id
    @GeneratedValue
    private Long roleid;
    
    @NotNull(message="user role cannot be null")
    @Pattern(regexp="ROLE_[A-Z]*", message="role must have ROLE_ prefix")
    private String rolename;

    public UserRole() {};
    
    public UserRole(String rolename) {
        this.rolename = rolename;
    }

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
