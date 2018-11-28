package com.silva.lacoscomfitaApp.Resource;




import com.silva.lacoscomfitaApp.model.Cliente;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.silva.lacoscomfitaApp.repository.ClienteRepository;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.findAll();
    }
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente , HttpServletResponse response){
        
        Cliente clienteSalvar = clienteService.save(cliente);
      
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(clienteSalvar.getId()).toUri();

        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(clienteSalvar);
        
    }
}
