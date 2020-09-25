package facades;

import dto.PersonDTO;
import dto.PersonsDTO;
import utils.EMF_Creator;
import entities.Person;
import exceptions.PersonNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;
    private static Person p1, p2;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        p1 = new Person("Harry", "Potter", "11223344");
        p2 = new Person("Hermione", "Granger", "55667788");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(p1);
            em.persist(p2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testGetPersonCount() {
        assertEquals(2, facade.getPersonCount(), "Expects two rows in the database");
    }

    @Test
    public void testGetAllPersons() {
        // Not sure how to do this one...
    }

    @Test
    public void testGetPerson() throws PersonNotFoundException {
        PersonDTO personDTO = facade.getPerson(p1.getId());
        assertEquals(p1.getfName(), personDTO.getfName());
    }

    @Test
    public void testAddPerson() {
        String fName = "Albus";
        String lName = "Dumbledore";
        String phone = "66446611";
        facade.addPerson(fName, lName, phone);
        assertEquals(3, facade.getPersonCount());
    }

    @Test
    public void testDeletePerson() throws PersonNotFoundException {
        facade.deletePerson(p1.getId());
        assertEquals(1, facade.getPersonCount());
    }

    @Test
    public void testEditPerson() throws PersonNotFoundException {
        PersonDTO personDTO = new PersonDTO(p2);
        personDTO.setlName("Potter");
        facade.editPerson(personDTO);
        PersonDTO editedPersonDTO = facade.getPerson(p2.getId());
        assertTrue(editedPersonDTO.getlName().equals("Potter"));
    }
}
