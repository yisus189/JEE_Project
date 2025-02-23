/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.project.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juann
 */
@Entity
@Table(name = "PROJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByProjectid", query = "SELECT p FROM Project p WHERE p.projectid = :projectid"),
    @NamedQuery(name = "Project.findByProjectname", query = "SELECT p FROM Project p WHERE p.projectname = :projectname"),
    @NamedQuery(name = "Project.findByProjectdesc", query = "SELECT p FROM Project p WHERE p.projectdesc = :projectdesc"),
    @NamedQuery(name = "Project.findByProjectplace", query = "SELECT p FROM Project p WHERE p.projectplace = :projectplace"),
    @NamedQuery(name = "Project.findByProjectbudget", query = "SELECT p FROM Project p WHERE p.projectbudget = :projectbudget"),
    @NamedQuery(name = "Project.findByProjectpop", query = "SELECT p FROM Project p WHERE p.projectpop = :projectpop")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECTID")
    private Integer projectid;
    @Size(max = 50)
    @Column(name = "PROJECTNAME")
    private String projectname;
    @Size(max = 250)
    @Column(name = "PROJECTDESC")
    private String projectdesc;
    @Size(max = 50)
    @Column(name = "PROJECTPLACE")
    private String projectplace;
    @Size(max = 50)
    @Column(name = "PROJECTBUDGET")
    private String projectbudget;
    @Column(name = "PROJECTPOP")
    private Integer projectpop;

    public Project() {
    }

    public Project(Integer projectid, String projectname, String projectdesc, String projectplace, String projectbudget, Integer projectpop) {
        this.projectid = projectid;
        this.projectname = projectname;
        this.projectdesc = projectdesc;
        this.projectplace = projectplace;
        this.projectbudget = projectbudget;
        this.projectpop = projectpop;
    }

    public Project(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdesc() {
        return projectdesc;
    }

    public void setProjectdesc(String projectdesc) {
        this.projectdesc = projectdesc;
    }

    public String getProjectplace() {
        return projectplace;
    }

    public void setProjectplace(String projectplace) {
        this.projectplace = projectplace;
    }

    public String getProjectbudget() {
        return projectbudget;
    }

    public void setProjectbudget(String projectbudget) {
        this.projectbudget = projectbudget;
    }

    public Integer getProjectpop() {
        return projectpop;
    }

    public void setProjectpop(Integer projectpop) {
        this.projectpop = projectpop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectid != null ? projectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectid == null && other.projectid != null) || (this.projectid != null && !this.projectid.equals(other.projectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.project.entity.Project[ projectid=" + projectid + " ]";
    }
    
}
