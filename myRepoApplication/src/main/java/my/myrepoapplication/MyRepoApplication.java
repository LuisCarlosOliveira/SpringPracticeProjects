package my.myrepoapplication;
import my.myrepoapplication.model.Person;
import my.myrepoapplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class MyRepoApplication implements CommandLineRunner {

    private PersonRepository personRepository;

    @Autowired
    public MyRepoApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyRepoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Person p1 = new Person();
        p1.setName("Luis");
        p1.setAge(32);
        p1.setAddress("Porto, Portugal");

        personRepository.save(p1);

        Person p2 = new Person();
        p2.setName("Carlos");
        p2.setAge(30);
        p2.setAddress("Porto, Portugal");

        personRepository.save(p2);

        Person resultPerson = personRepository.findByName("Luis");

        List<Person> persons = personRepository.findByAddressAndAge("Porto, Portugal", 32);

        personRepository.deleteOneByName("Carlos");

    }
}
