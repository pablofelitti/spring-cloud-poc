package ar.com.poc.spring.cloud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@Controller
@EnableEurekaClient
@SpringBootApplication
public class UserMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroservice.class, args);
    }

    @Bean
    ApplicationRunner runner(UserRepository userRepository) {
        return args -> {
            Arrays.asList("Pablo Felitti", "Tito Puentes").forEach(name -> userRepository.save(new User(name)));
            userRepository.findAll().forEach(user -> System.out.println("--- Id: " + user.getId() + "Name: " + user.getName()));
        };
    }
}

@RepositoryRestResource
interface UserRepository extends JpaRepository<User, Long> {
}

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    User(String name) {
        this.name = name;
    }

    User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}