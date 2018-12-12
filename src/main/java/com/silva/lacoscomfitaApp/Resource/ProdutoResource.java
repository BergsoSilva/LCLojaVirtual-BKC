package com.silva.lacoscomfitaApp.Resource;




import com.silva.lacoscomfitaApp.event.RecursoCriadoEvent;
import com.silva.lacoscomfitaApp.model.Produto;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.silva.lacoscomfitaApp.repository.ProdutoRepository;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Bergson Silva - bergson.silva@itbam.org.br
 */
@Api(value = "Produto controller", description = "Produtos")
@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;
   
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto , HttpServletResponse response){
        Produto produtoSalvo = produtoRepository.save(produto);
        publisher.publishEvent(new  RecursoCriadoEvent(this, response, produtoSalvo.getId()) );
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Produto> buscarPeloId(@PathVariable("id") Long id){
        Produto produto = produtoRepository.findById(id).get();
        return produto!=null?ResponseEntity.ok(produto):ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
