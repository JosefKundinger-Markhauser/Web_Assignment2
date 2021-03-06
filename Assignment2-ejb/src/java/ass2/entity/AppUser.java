package ass2.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joey Kundinger-Markhauser
 * @author Patrick Czermak
 * @version 1.0
 * 
 * This class is an entity that represents an app user.
 */
@Entity
@Table(name = "appuser")
@XmlRootElement
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    //Properties
    @Column
    private String userId;
    
    @Column
    private String password;
    
    @Column
    private String groupName; 

    /**
     * 
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @return Nothing
     */
    public String getPassword() {
        return null;
    }

    /**
     * 
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 
     * @param userId The userId to be set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This function takes a string password value and encrypts it for storage.
     * 
     * @param password The new password that is being set.
     */
    public void setPassword(String password) {
        
        if(password == null || password.length() == 0){
            return;
        }

        Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
        PasswordHash passwordHash = instance.get();

        passwordHash.initialize(new HashMap<String,String>());
        
        this.password = passwordHash.generate(password.toCharArray());
    }

    /**
     * 
     * @param groupName The group name to be set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.lab4.AppUser[ id=" + id + " ]";
    }
    
}
