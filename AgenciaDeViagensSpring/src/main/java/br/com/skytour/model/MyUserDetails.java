/*package br.com.skytour.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails implements UserDetails {
	
	private Passageiro passageiro;

    public MyUserDetails(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
	

	private String userName;
	private String password;
	private boolean active; 
	private List<GrantedAuthority> authorities;

	public MyUserDetails(Passageiro passageiro) {
		this.userName = passageiro.getUserName();
		this.password = passageiro.getPassword();
		this.active = passageiro.isActive();
		this.authorities = Arrays.stream(passageiro.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	
    @Override
    public String getPassword() {
        return passageiro.getSenha();
    }

    @Override
    public String getUsername() {
        return passageiro.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    	// TODO Auto-generated method stub
    	return false;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	/*

	public MyUserDetails() {
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
		return userName;
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
		return active;
	}
	
	

}
*/