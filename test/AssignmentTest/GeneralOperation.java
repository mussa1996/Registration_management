/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTest;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;




/**
 *
 * @author Mussa
 */
public class GeneralOperation {
   public static Operation INSERT_FACULTY=
           Operations.insertInto("faculty")
           .columns("nfaculty")
           .values("IT")
           .values("Business")
           .values("Theology")
           .values("MIT")
           .build();
   public static Operation INSERT_DEPARTMENT=
           Operations.insertInto("department")
           .columns("name_department","faculty_name")
           .values("Software Engineering","IT")
           .values("Information Management","IT")
           .values("Accounting","Business")
           .values("Bible","Theology")
           .build();
   public static Operation INSERT_COURSE=
           Operations.insertInto("course")
           .columns("code","credits","name","department_name")
           .values("INSY314",3,"OOP","Software Engineering")
           .values("INSY426",4,"WEB","Software Engineering")
           .values("STAT223",3,"Prob","Information Management")
           .values("ACC222",3,"Account","Accounting")
           .build();
   public static Operation INSERT_STUDENT=
           Operations.insertInto("student")
           .columns("student_id","dob","email","gender","name",
                   "phonenumber","department_name")
           .values("22089",Date.valueOf(LocalDate.of(2000, Month.MARCH, 20)),"niyo@gmail.com","Male","Niyodusenga mussa","0781992878","Software Engineering")
           .values("22052",Date.valueOf(LocalDate.of(1997, Month.FEBRUARY, 07)),"niyo@gmail.com","Male","Mazina dan","0781992878","Accounting")
           .values("22065",Date.valueOf(LocalDate.of(1998, 8, 14)),"niyo@gmail.com","Female","Shumbusho Edgar","0781992878","Software Engineering")
           .values("22354",Date.valueOf(LocalDate.of(1993, 6, 12)),"niyo@gmail.com","Male","Cyusa Ayman","0781992878","Information Management")
           .build();
   
   public static Operation DELETE_FACULTY=
           Operations.deleteAllFrom("faculty");
   public static Operation DELETE_DEPARTMENT=
           Operations.deleteAllFrom("department");
   public static Operation DELETE_COURSE=
           Operations.deleteAllFrom("course");
   public static Operation DELETE_STUDENT=
           Operations.deleteAllFrom("student");
      public static Operation DELETE_REGISTRATION=
           Operations.deleteAllFrom("registration");
        
}
