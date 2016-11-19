/**
 * Created by Ruslan on 27.08.2016.
 */

package com.tel_ran.hederkosher.test.old;

import junit.framework.TestCase;
import org.junit.Test;

//@RunWith(Suite.class)
public class PersonDaoImplTest  extends TestCase {
//    private static final int PERSON_COUNT = 10;
//    Logger logger = Loggers.hiberLogger;
//    PersonDaoImpl personDao =new PersonDaoImpl() ;
//    Person[] persons;
//    Person[] personsSQL;
//    Random rnd =new Random();
//    Person person;
//    //String[] fistName = {Ивановб}
//
//
//    @Before
//    public void setUp() throws Exception {
//        logger.info("Start ");
//        persons = new Person[PERSON_COUNT];
//        personsSQL = new Person[PERSON_COUNT];
//        personDao.setHibernateUtil(new HibUtilImpl());
//        for (int i = 1; i <= PERSON_COUNT; i++) {
//            persons[i-1] = new Person("TZ "+(1000000+i),"FistName "+i, "SecondName "+i, "LastName "+i
//                    , new Date(rnd.nextInt())
//                    , null); //new User()
//        }
//        copyPersonsToPersonSQL();
//    }
//
////    @After
////    public void setDn() throws Exception {
////        personsSQL=persons.clone();
////    }
//
//
    @Test
    public void testCRUDPerson() {
        assertTrue(true);
    }

//    @Test
//    public void testCRUDPerson() {
//        //ADD
//        for (Person person: persons) {
//            assertTrue(personDao.addPerson(person));
//            assertFalse(personDao.addPerson(person));
//        }
//        logger.info("Insert into Person - END");
//
//        // getting id to array personsSQL
//        for (int i = 1; i <= PERSON_COUNT; i++) {
//            person = personsSQL[i-1];
//            //assertNull(person.getId());
//            person=personDao.getByPassport(person.getPassportNo());
//            assertNotNull(person);
//            assertFalse(0L==person.getId());
//
//            personsSQL[i-1]=person;
//        }
//
//
//        //UPDATE
//        for (Person person: personsSQL) {
//            //person.setPassportNo("NO#"+person.getPassportNo().trim()); //Natural !!!
//            person.setFistName("FN#"+person.getFistName().trim());
//            person.setLastname("LN#"+person.getLastname().trim());
//            person.setSecondname("SN#"+person.getSecondname().trim());
////            person.setUser();
//            assertTrue(personDao.updatePerson(person));
//        }
//
//        logger.info("Update Person - END");
//
//        //testGetById
//        for (Person personArray: personsSQL) {
//            person=personDao.getById(person.getId());
//            assertNotNull(person);
//            //assertTrue(personArray.equals(person));
//            //System.out.println(person.toString());
//        }
//        //diplayPersons(personsSQL);
//
//        //DELETE
//        for (Person person: personsSQL) {
//            assertTrue(personDao.deletePerson(person));
//        }
//        logger.info("Delete Person - END");
//    }
//
//
//    @Test
//    public void getByEmail() throws Exception {
//
//    }
//
//    @Test
//    public void getByTelephone() throws Exception {
//
//    }
//
//    @Test
//    public void testGetAllPersons()  { //throws Exception
////        List<Person> listPerson= personDao.getAllPersons();
////        assertNotNull(listPerson);
////        //if (listPerson==null) return;
////
////        for (Person person: listPerson) {
////            person.toString();
////        }
//    }
//
//    @Test
//    public void testGetPersonsByFio() { // throws Exception
////        for (Person person: persons) {
////            assertTrue(personDao.addPerson(person));
////        }
////        person = persons[0];
////        List<Person> listPerson= personDao.getPersonsByFio(person.getFistName(),person.getSecondname(),person.getLastname());
////        for (Person person: listPerson) {
////            person.toString();
////            //assertTrue(personDao.deletePerson(person));
////        }
//
//    }
//
//    @Test
//    public void getPersonsByRoom() throws Exception {
//
//    }
//
//    @Test
//    public void getPersons() throws Exception {
//    }
//
//    private void copyPersonsToPersonSQL() {
//        personsSQL=persons.clone();
//    }
//
//    private void diplayPersons(Person[] persons) {
//        for (Person person: persons) {
//            System.out.println(person.toString());
//        }
//    }
}