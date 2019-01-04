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
import com.silva.lacoscomfitaApp.service.ClienteService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Bergson Silva - bergson.silva@itbam.org.br
 */
@Api(value = "Cliente controller", description = "Clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTE')")
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CRIAR_CLIENTE')")
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvar = clienteRepository.save(cliente);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvar.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvar);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_FILTRAR_CLIENTE')")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable("id") Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CLIENTE')")
    public ResponseEntity<Cliente> atualizar(@PathVariable  Long id, @Valid @RequestBody Cliente Cliente){
        Cliente cliente = clienteService.atualizar(id, Cliente);
        return ResponseEntity.ok(cliente);
    }
}
