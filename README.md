# -Notes


String sql = "SELECT * FROM products WHERE product_name = ? AND brand = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, productName);
preparedStatement.setString(2, brand);

ResultSet resultSet = preparedStatement.executeQuery();



Resilence4J circuit breaker



https://javatechonline.com/how-to-implement-fault-tolerance-in-microservices-using-resilience4j/


To create jar file run as->maven build (2nd option) ->goal(write package)
To run Jar File

java -jar accountService-0.0.1-SNAPSHOT.jar --spring.config.location=C:\Users\ashis\Downloads\application.properties

https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/

MicroService (used redis database )
https://github.com/RainbowForest/e-commerce-microservices/blob/master/order-service/src/main/java/com/rainbowforest/orderservice/redis/CartRedisRepositoryImpl.java

@Embeded
https://www.javaguides.net/2020/10/jpa-hibernate-embeddable-and-embedded.html

Object serialization is the process of converting Java objects into byte streams. We can then transfer these byte streams over the wire or store them in persistent memory. Deserialization is the reverse process, where we take byte streams and convert them back into Java objects. To allow object serialization (or deserialization), a class must implement the Serializable interface.

@JoinColumn
https://www.geeksforgeeks.org/when-to-use-joincolumn-annotation-in-hibernate/
@OneToOne
https://www.geeksforgeeks.org/hibernate-one-to-one-mapping/
https://www.baeldung.com/jpa-one-to-one

 Student student = new Student("Vyom", "Yadav",
                                          "vyom@gmail.com");
 
            StudentGfgDetail studentGfgDetail
                = new StudentGfgDetail("GFG College", 20);
 
            student.setStudentGfgDetail(studentGfgDetail);
 
            // Begin the transaction
            session.beginTransaction();
 
            // Save the student object.
            // This will also save the StudentGfgDetail
            // object as we have used CascadeType.ALL
            session.save(student);
We add a single object of StudentGfgDetail inside the Student class which is annotated with @OneToOne annotation which specifies the one-to-one mapping. This annotation contains an element called cascade which specifies the cascading strategy. Cascading is a feature that is used to manage the state of the target entity whenever the state of the parent entity changes.  Basic Hibernate cascade types are-

 https://www.geeksforgeeks.org/hibernate-one-to-one-mapping/

CascadeType.ALL – Propagates all operations from parent to target entity.
CascadeType.PERSIST – Propagates persist from parent to target entity.
CascadeType.MERGE – Propagates merge from parent to target entity.
CascadeType.REMOVE – Propagates remove from parent to target entity.
CascadeType.REFRESH – Propagates refresh from parent to target entity.
CascadeType.DETACH – Propagates detach from parent to target entity.
Many To Many
https://www.javaguides.net/2019/12/hibernate-5-many-to-many-annotation-mapping-example.html

@Many To @Many
https://www.javaguides.net/2019/12/hibernate-5-many-to-many-annotation-mapping-example.html
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YourServiceOrController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void saveEmployeeAndProjects() {
        // Create an employee
        Employee employee = new Employee();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");

        // Create projects
        Project project1 = new Project();
        project1.setTitle("Employee Management System");

        Project project2 = new Project();
        project2.setTitle("Content Management System");

        // Set up relationships
        employee.getProjects().add(project1);
        employee.getProjects().add(project2);

        project1.getEmployees().add(employee);
        project2.getEmployees().add(employee);

        // Save entities using repositories
        employeeRepository.save(employee);
        projectRepository.saveAll(List.of(project1, project2));
    }
}

