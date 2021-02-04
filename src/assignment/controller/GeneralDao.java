/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.controller;

import assignment.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Mussa
 */
public class GeneralDao<X> {
    private Class<X> type;
    public GeneralDao(Class<X> type){
        this.type=type;
    }
    
    public X create(X obj){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(obj);
        ss.getTransaction().commit();
        ss.close();
        return obj;
    }
      public X update(X obj){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(obj);
        ss.getTransaction().commit();
        ss.close();
        return obj;
    
}
    public X delete(X obj){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(obj);
        ss.getTransaction().commit();
        ss.close();
        return obj;
        
}
    public X findById(String id){
         Session ss=HibernateUtil.getSessionFactory().openSession();
         X obj=(X)ss.get(type, id);
         ss.close();
         return obj;
    }
   
    public List<X>findbyall(){
        Session ss=HibernateUtil.getSessionFactory().openSession();
        Criteria cx=ss.createCriteria(type);
        List<X>list=cx.list();
        return list;  
    }
    }
