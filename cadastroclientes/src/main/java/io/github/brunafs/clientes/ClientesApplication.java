package io.github.brunafs.clientes;

import io.github.brunafs.clientes.model.entity.Cliente;
import io.github.brunafs.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@ComponentScan( //para buscar em outros projetos (dentro do mesmo pacote já é scaneado)
//        basePackages = {
//                "io.github.brunafs.repository",
//                "io.github.brunafs.service"
//        }
//)
@SpringBootApplication
@RestController
public class ClientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }

}
