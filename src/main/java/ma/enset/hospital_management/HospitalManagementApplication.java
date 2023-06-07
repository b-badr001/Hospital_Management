package ma.enset.hospital_management;

import ma.enset.hospital_management.entities.Patient;
import ma.enset.hospital_management.repository.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class HospitalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            Stream.of("Mohamed", "Hassan", "Najat")
                    .forEach(name -> {
                        Patient patient=Patient.builder()
                                .name(name)
                                .dateofbirth(new Date())
                                .sick(true)
                                .score(115)
                                .build();
                        patientRepository.save(patient);
                    });
        };

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
