/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.project.session;

import co.edu.unipiloto.arquitectura.project.entity.Project;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juann
 */
@Local
public interface ProjectFacadeLocal {

    void create(Project project);

    void edit(Project project);

    void remove(Project project);

    Project find(Object id);

    List<Project> findAll();

    List<Project> findRange(int[] range);

    int count();
    
}
