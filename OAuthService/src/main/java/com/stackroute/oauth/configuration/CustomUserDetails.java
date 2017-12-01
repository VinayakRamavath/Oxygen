package com.stackroute.oauth.configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.stackroute.oauth.model.UserInfo;
import com.stackroute.oauth.model.UserRole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 3407927402760258246L;
	
	
	private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
    
    private List<GrantedAuthority> temp = new ArrayList<GrantedAuthority>();

    public CustomUserDetails(UserInfo userinfo) {
        this.username = userinfo.getUsername();
        this.password = userinfo.getPassword();

        for(UserRole userrole : userinfo.getRoles()) {
        	temp.add(new SimpleGrantedAuthority(userrole.getRolename()));
        }
        
        this.authorities = temp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
