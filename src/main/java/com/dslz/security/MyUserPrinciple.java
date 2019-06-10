package com.dslz.security;

import java.util.Collection;

import com.dslz.beans.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Provides core user information. Implementations are not used directly by
 * Spring Security for security purposes. They simply store user information
 * which is later encapsulated into Authentication objects. This allows
 * non-security related user information (such as email addresses, telephone
 * numbers etc) to be stored in a convenient location.
 */
public class MyUserPrinciple implements UserDetails {
    
    private static final long serialVersionUID = 3297037415737310489L;
    
    private User user;

    public MyUserPrinciple(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}