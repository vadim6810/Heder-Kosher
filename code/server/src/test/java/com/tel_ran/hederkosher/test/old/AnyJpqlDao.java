package com.tel_ran.hederkosher.test.old;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruslan on 09/11/16.
 */
public class AnyJpqlDao<T> {

//    @PersistenceContext(name = "HederKosherSpringHibernate",type = PersistenceContextType.EXTENDED)
//    @PersistenceContext
//@PersistenceContext(name = "HKSpringHibernate")
    @PersistenceContext
    EntityManager em;

    public AnyJpqlDao() {
    }

    public List<T> AnyJpqlQuery(String jpql) {
        List<T> list=null;
        Query query = em.createQuery(jpql);

        try{
            list = query.getResultList();
        }catch (Exception e){
            System.out.println("Error");
        }
        if ((list==null) || (list.isEmpty())){
            System.out.println("Error");
        }
        return list;
    }

    public T AnyJpqlQueryOne(String jpql) {
        List<T> list=null;
        Query query = em.createQuery(jpql).setMaxResults(1);

        try{
            list= query.getResultList();
        }catch (Exception e){
            System.out.println("Error");
        }
        if ((list==null) || (list.isEmpty())){
            System.out.println("Error");
        }

        return list.get(0);
    }


    private String[] displayResult(List resultList) {
        int size= resultList.size();
        String[] res = new String[size];
        int i=0;
        boolean type=false;
        for (Object obj : resultList) {
            if (i==0) type = obj.getClass().isArray();

            if (type)
                res[i]= Arrays.deepToString((Object[]) obj);
            else
                res[i]=obj.toString();

            System.out.println(res[i]);
            i++;
        }
        return res;
    }
}
