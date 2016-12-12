package nl.quintor.jpa;

import nl.quintor.jpa.model.Department;
import nl.quintor.jpa.model.Employee;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * Created by Ron on 04/12/2016.
 */
public class Main {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;

    public static void main(String... args) {
        new Main().run();
        System.exit(0);
    }


    private void run() {
        init();
        execute();
        shutdown();
    }

    private void init() {
        emFactory = Persistence.createEntityManagerFactory("jpa-example");
        entityManager = emFactory.createEntityManager();
    }

    private void shutdown() {
        emFactory.close();
    }

    private void execute() {
        read();
    }


    private void read() {
        Employee employee = entityManager.find(Employee.class, 500001);
        System.out.println(employee.getFirstname() + " " + employee.getLastname());
    }


    private void create() {
        Employee employee = new Employee();
        employee.setEmployeeId(500001);
        employee.setFirstname("Rob");
        employee.setLastname("Smid");
        employee.setBirthdate(Date.from(LocalDate.of(1972, 2, 26).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//        employee.setGender(Gender.M);
        employee.setGender("M");
        employee.setHiredate(Date.from(LocalDate.of(1972, 2, 26).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }




    private void update() {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, 500000);
        employee.setHiredate(Date.from(LocalDate.of(2016, 3, 1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        entityManager.getTransaction().commit();
    }


    private void delete() {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, 499994);
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }


    //  First
    private void findAllDepartmentsNative() {
        Query query = entityManager.createNativeQuery("select * from departments", Department.class);
        List<Department> results = query.getResultList();
        System.out.println(results.get(0).getName());
    }

    //  Second
    private void findAllDepartmentsQuery() {
        Query query = entityManager.createQuery("select d from Department d");
        List departmentList =  query.getResultList();
        System.out.println(departmentList.get(0));
    }


    //  Third
    private void findAllDepartmentsTyped() {
        TypedQuery<Department> query = entityManager.createQuery("select d from Department d", Department.class);
        List<Department> departmentList = query.getResultList();
    }


    //  Fourth
    private void findAllDepartmentsNamed() {

    }



}
