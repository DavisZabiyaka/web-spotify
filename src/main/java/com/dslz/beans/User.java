package com.dslz.beans;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    private Integer userId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD", columnDefinition = "BLOB")
    private byte[] encryptedPassword;
    @Column(name = "SALT", columnDefinition = "BLOB")
    private byte[] salt;

    public User() {
        super();
    }

    public User(String username, byte[] encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    /**
     * 
     * @return username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return encrypted password for authenticating the user
     */
    public byte[] getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * 
     * @return salt (generated sequence of bits unique to each user that is added to
     *         user's password as part of hashing)
     */
    public byte[] getSalt() {
        return salt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(encryptedPassword);
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        User other = (User) obj;
        if (!Arrays.equals(encryptedPassword, other.encryptedPassword))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [encryptedPassword=" + Arrays.toString(encryptedPassword) + ", username=" + username + "]";
    }

}