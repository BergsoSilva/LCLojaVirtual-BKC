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
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Cliente cliente){
        
        Cliente clienteSalvar = clienteService.save(cliente);
         
    }
}
