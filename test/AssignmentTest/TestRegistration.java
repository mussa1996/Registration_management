/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTest;

import assignment.controller.GeneralDao;
import assignment.model.Course;
import assignment.model.Department;
import assignment.model.Faculty;
import static assignment.model.Gender.Male;
import assignment.model.Registration;
import assignment.model.Student;
import assignment.util.HibernateUtil;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Mussa
 */
public class TestRegistration extends AbstractTestCase{
    GeneralDao<Faculty> fac=new GeneralDao<>(Faculty.class);
    GeneralDao<Department> dep=new GeneralDao<>(Department.class);
    GeneralDao<Course> cou=new GeneralDao<>(Course.class);
    GeneralDao<Student> stu=new GeneralDao<>(Student.class);
    GeneralDao<Registration> reg=new GeneralDao<>(Registration.class);
    @Test
    public void testCreateFaculty(){
        Faculty faculty=new Faculty("Marketing");
       Faculty facul=fac.create(faculty);
        Assert.assertTrue(facul != null);
        System.out.println("Faculty created");
    }
     @Test
    public void testCreateDepartment(){
        Faculty faculty=fac.findById("IT");
         Department depart=new Department("Communication");
         depart.setFaculty(faculty);
         Department depa=dep.create(depart);
         Assert.assertTrue(depa !=null);
         System.out.println("Department created");
    }
     @Test
    public void testCreateCourse(){
       Department depar=dep.findById("Accounting");
         Course course=new Course("SENG222", "Software",3);
         course.setDepartment(depar);
         Course cour=cou.create(course);
         Assert.assertTrue(cour !=null);
         System.out.println("Course created");
    }
      @Test
    public void testCreateStudent(){
        Department depar=dep.findById("Information Management");
         Student student=new Student("22012", "Mugisha Eli", Male, Date.valueOf(LocalDate.of(1999, Month.MARCH, 20)), "078298776", "mugisha@gmail.com");
         student.setDepartment(depar);
        Student stud=stu.create(student);
         Assert.assertTrue(stud !=null);
         System.out.println("Student created");
    }
    @Test
    public void testFindFaculty(){
     List<Faculty> list= fac.findbyall(); 
      Assert.assertEquals(list.size(), 4);
        System.out.println("select faculty");
    }
    @Test
    public void testFindDepartment(){
        List<Department> list=dep.findbyall();
        Assert.assertEquals(list.size(), 4);
        System.out.println("select department");
    }
    @Test
     public void testFindCourse(){
        List<Course> list=cou.findbyall();
        Assert.assertEquals(list.size(), 4);
        System.out.println("select course");
    }
     @Test
      public void testFindStudent(){
        List<Student> list=stu.findbyall();
        Assert.assertEquals(list.size(), 4);
        System.out.println("select student");
    }
      @Test
      public void updateCourse(){
          Department depar=dep.findById("Accounting");
         Course course=new Course("INSY426", "Web Tech",3);
         course.setDepartment(depar);
         Course cour=cou.update(course);
         Assert.assertTrue(cour !=null);
         System.out.println("Course Updated");
      }
      @Test
      public void updateStudent(){
          Department depar=dep.findById("Information Management");
         Student student=new Student("22089", "Niyodusenga", Male,Date.valueOf(LocalDate.of(2000, Month.MARCH, 20)), "078298776", "mugisha@gmail.com");
         student.setDepartment(depar);
        Student stud=stu.update(student);
         Assert.assertTrue(stud !=null);
         System.out.println("Student Updated");
      }
      @Test
      public void deleteCourse(){
          Course cour=cou.findById("STAT223");
         Course course=cou.delete(cour);
          Assert.assertTrue(course!=null);
         System.out.println("Course deleted");
      }
       @Test
      public void deleteStudent(){
          Student stud=stu.findById("22052");
          Student student=stu.delete(stud);
          Assert.assertTrue(stud !=null);
         System.out.println("Student deleted");
      }
      @Test
      public void testCreateRegistration(){
         Registration register=new Registration();
        Student listStudent=stu.findById("22089");
        Course listCourse= cou.findById("INSY426");
       register.setReg_course(listCourse);
       register.setReg_student(listStudent);
         Registration regi=reg.create(register);
        Assert.assertTrue(regi!=null);
          System.out.println("Registration success!!!!");
      }
    @BeforeMethod
    public void initialization(){
        execute(GeneralOperation.INSERT_FACULTY);
         execute(GeneralOperation.INSERT_DEPARTMENT);
          execute(GeneralOperation.INSERT_COURSE);
          execute(GeneralOperation.INSERT_STUDENT);
          
    }
    @AfterMethod
    public void clean(){
        execute(GeneralOperation.DELETE_REGISTRATION);
        execute(GeneralOperation.DELETE_STUDENT);
        execute(GeneralOperation.DELETE_COURSE);
        execute(GeneralOperation.DELETE_DEPARTMENT);
        execute(GeneralOperation.DELETE_FACULTY);
    }
      @BeforeTest
    public void init(){
        System.out.println("Create Tables");
          HibernateUtil.getSessionFactory();

    }
}
