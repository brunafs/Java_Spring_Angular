package io.github.brunafs.clientes.rest;

import io.github.brunafs.clientes.model.entity.Cliente;
import io.github.brunafs.clientes.model.entity.ServicoPrestado;
import io.github.brunafs.clientes.model.repository.ClienteRepository;
import io.github.brunafs.clientes.model.repository.ServicoPrestadoRepository;
import io.github.brunafs.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.brunafs.clientes.util.BigDecimalConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    public ServicoPrestadoController(ClienteRepository clienteRepository, ServicoPrestadoRepository repository, BigDecimalConverter bigDecimalConverter) {
        this.clienteRepository = clienteRepository;
        this.repository = repository;
        this.bigDecimalConverter = bigDecimalConverter;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Integer idCliente = dto.getIdCliente();
        Cliente cliente =
                clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( bigDecimalConverter.converter(dto.getPreco()));

        return repository.save(servicoPrestado);
    }
}
