# -Notes
https://www.callicoder.com/java-executor-service-and-thread-pool-tutorial/

MicroService (used redis database )
https://github.com/RainbowForest/e-commerce-microservices/blob/master/order-service/src/main/java/com/rainbowforest/orderservice/redis/CartRedisRepositoryImpl.java

@Embeded
https://www.javaguides.net/2020/10/jpa-hibernate-embeddable-and-embedded.html

Object serialization is the process of converting Java objects into byte streams. We can then transfer these byte streams over the wire or store them in persistent memory. Deserialization is the reverse process, where we take byte streams and convert them back into Java objects. To allow object serialization (or deserialization), a class must implement the Serializable interface.

@JoinColumn
https://www.geeksforgeeks.org/when-to-use-joincolumn-annotation-in-hibernate/
@OneToOne
https://www.javatpoint.com/hibernate-one-to-one-example-using-annotation
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

 

CascadeType.ALL – Propagates all operations from parent to target entity.
CascadeType.PERSIST – Propagates persist from parent to target entity.
CascadeType.MERGE – Propagates merge from parent to target entity.
CascadeType.REMOVE – Propagates remove from parent to target entity.
CascadeType.REFRESH – Propagates refresh from parent to target entity.
CascadeType.DETACH – Propagates detach from parent to target entity.
