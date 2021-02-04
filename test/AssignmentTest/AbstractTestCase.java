/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssignmentTest;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

/**
 *
 * @author Mussa
 */
 public class AbstractTestCase {
    public void execute(Operation operation){
         try {
            DbSetup dbsetup=new DbSetup(new DriverManagerDestination(
                    "jdbc:postgresql://localhost:5432/bank_db_test",
                    "postgres","mussa"), operation);
            dbsetup.launch();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("initiazation test data");
    }
    }
 

