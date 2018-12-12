package com.silva.lacoscomfitaApp.Resource;

import com.silva.lacoscomfitaApp.event.RecursoCriadoEvent;
import com.silva.lacoscomfitaApp.model.Cliente;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.silva.lacoscomfitaApp.repository.ClienteRepository;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Bergson Silva - bergson.silva@itbam.org.br
 */
@Api(value = "Cliente controller", description = "Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    ClienteRepository clienteService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvar = clienteService.save(cliente);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvar.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvar);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.findById(id).get();
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }
}
