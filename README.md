# -Notes


String sql = "SELECT * FROM products WHERE product_name = ? AND brand = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, productName);
preparedStatement.setString(2, brand);
***************************************************************************************
https://www.linkedin.com/pulse/unique-id-generation-distributed-systems-yeshwanth-n-msb0c/?trackingId=8%2F3RhGhHQmuXVfn6n%2BVQPw%3D%3D

***********************************************************************
https://arpitbhayani.me/redis-internals/
********************************************
https://arpitbhayani.me/masterclass
************************************************************

ResultSet resultSet = preparedStatement.executeQuery();
*****************************************************************************
https://github.com/gulbalasalamov/bank-loan-application?tab=readme-ov-file
*******************************************************************************************

https://www.jobrunr.io/en/blog/2023-02-20-moving-from-quartz-scheduler-to-jobrunr/
*************************************

ShedLock Link
****************************************************
https://medium.com/adessoturkey/shedlock-with-spring-75beabf913d6#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjkzYjQ5NTE2MmFmMGM4N2NjN2E1MTY4NjI5NDA5NzA0MGRhZjNiNDMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTUyMDY4NjEzNzQ5Njc4MTA3MjMiLCJlbWFpbCI6ImFzaGlzaGhrcjE0QGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYmYiOjE3MTI1NjQ5MTMsIm5hbWUiOiJBc2hpc2ggS3VtYXIiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUNnOG9jSkVMbktpQ0ozWF9LZlpzZE9IajJpZmphb3dFbTRsWWpZb0E5dkhYT29hSFRRZWl3PXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6IkFzaGlzaCIsImZhbWlseV9uYW1lIjoiS3VtYXIiLCJpYXQiOjE3MTI1NjUyMTMsImV4cCI6MTcxMjU2ODgxMywianRpIjoiNGQ3MzY0ODZjZjNmMzAyNTQ3ZWZlYWIxM2NiOTUzNjM0YjNmMTJlOCJ9.eDDsa2emBHe4gjwa04cUXJcO63p7i2fTUO_5Z7FDSX0thswHrfPInSNcfPRt3s3TKM2OTbnADfaFjNMVqFUj4Zoi7v3McwQQZJHXAVZv-zfirzRoNEcLK0IZSURcq3_yMW9PZ18ruHA_xYXCHlABZYtg_-BhCOKFHb-w4xuNwf41puYH88_QI5u4yYOfUjjMG4mvSn8_TAOh87xk1FycZ3NvmYasca1OhrRKWAdrY_TBeoPYBhyVJcWlhU0agob4GX_zrFoBOdIhVQblb2I1Jcv3WHHCjbkU-pKIMiz12FPU8kLEJ0zqRucG6HRriF16KVHNU8m0fFKilHIpKM3SqA
********************************************************************************************************************************************************************

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

https://dis000000hmr22ag-dev-ed.develop.lightning.force.com/lightning/setup/ObjectManager/home
