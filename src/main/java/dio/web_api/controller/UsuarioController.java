package dio.web_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dio.web_api.model.Usuario;
import dio.web_api.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
// @RequestMapping("/users") isso adiciona o prefixo users nos requestmapping assim nao precisando colcoar em cada um deles
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping("/users")
    public List<Usuario> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/users/add-padrao")
    public String adicionandoUsuarioPadrao() {
        Usuario usuario = new Usuario("matheus", "Mp",  "123456");
        repository.save(usuario);
        return new String("usuario add");
    }
    
    @GetMapping("/users/{username}")
    public Optional<Usuario> getOne(@PathVariable("username") String username){
        return repository.findById(Integer.parseInt(username));
    }

    @SuppressWarnings("null")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }
    
    @SuppressWarnings("null")
    @PostMapping("/users")
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
    
}
