package my.myrepoapplication.repository;

import my.myrepoapplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Person findByName(String name);
    List<Person> findByAddressAndAge(String address, int age);
    List<Person> findByAgeAndNameIn(int age, List<String> name);
    Long deleteOneByName(String name);

}
