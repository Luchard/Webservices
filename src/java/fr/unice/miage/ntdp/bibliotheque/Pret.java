/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.miage.ntdp.bibliotheque;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edou
 */
@Entity
@NamedQuery(
    name="Pret.findByLivre",
    query="SELECT p FROM Pret p WHERE p.livre.id = :idLivre"
)
@NamedQueries({
    @NamedQuery(name = "Pret.findAll", query = "SELECT p FROM Pret p"),
    @NamedQuery(name = "Pret.findByUtilisateur", query = "SELECT p FROM Pret p WHERE p.user.id = :userId"),
    @NamedQuery(name = "Pret.findByAuteur", query = "SELECT p FROM Pret p WHERE p.livre.ecrit_par.id = :auteurId"),
    @NamedQuery(name = "Pret.findByCategorie", query = "SELECT p FROM Pret p WHERE p.livre.categorie.id =:categorieId"),
    @NamedQuery(name = "Pret.findByLibelle", query = "SELECT p FROM Pret p WHERE p.livre.titre like '%:categorieId%'")
})
@XmlRootElement
public class Pret implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Livre livre; 
    @ManyToOne
    private Users user; 
    private Date debut; 
    private int Duree; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Pret)) {
            return false;
        }
        Pret other = (Pret) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Pret[ id=" + id + " ]";
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int Duree) {
        this.Duree = Duree;
    }

   
    
}
