/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Mussa
 */
@Entity
public class Department {
    @Id
    private String name_department;
    @ManyToOne
    @JoinColumn(name="faculty_name")
    private Faculty faculty;
    @OneToMany(mappedBy ="department" )
    private List<Course> course;
    @OneToMany(mappedBy = "department")
   private List<Student> student; 
    public String getName_department() {
        return name_department;
    }

    public void setName_department(String name_department) {
        this.name_department = name_department;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Department(String name_department) {
        this.name_department = name_department;
    }

   

    public Department() {
    }
   

}