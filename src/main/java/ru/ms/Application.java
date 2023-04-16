package ru.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ms.repository.PersonRepository;
import ru.ms.entity.PersonEntity;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        /*ApplicationContext context = SpringApplication.run(Application.class, args);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        List<PersonEntity> list = personRepository.findAll();
        list.forEach(System.out::println);*/
    }

}
