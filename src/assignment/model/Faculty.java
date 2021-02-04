/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Mussa
 */
@Entity
public class Faculty {
    @Id
    private String nfaculty;
    @OneToMany(mappedBy ="faculty" )
    private List<Department> department;
    
    public String getNfaculty() {
        return nfaculty;
    }

    public void setNfaculty(String name_faculty) {
        this.nfaculty = name_faculty;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public Faculty(String nfaculty) {
        this.nfaculty = nfaculty;
    }

   

    public Faculty() {
    }
    
}
