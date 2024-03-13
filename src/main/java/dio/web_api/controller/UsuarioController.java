package dio.web_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dio.web_api.exceptions.NullFieldException;
import dio.web_api.exceptions.UserNotFoundException;
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
    
    @GetMapping("/users/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id") String id){
        int idUsuario = Integer.parseInt(id);

        repository.findById(idUsuario)
        .orElseThrow(UserNotFoundException::new);

        return repository.findById(idUsuario);
    }


    @SuppressWarnings("null")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        repository.findById(id)
        .orElseThrow(UserNotFoundException::new);
        
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/users")
    public ResponseEntity<Void> postUser(@RequestBody Usuario usuario) {
        if(usuario.getId() == null ){
            throw new NullFieldException("O campo id esta vazio");
        }
        if(usuario.getName() == null || usuario.getName().isEmpty()){
            throw new NullFieldException("O campo nome esta vazio");
        }
        if(usuario.getUsername() == null || usuario.getUsername().isEmpty()){
            throw new NullFieldException("O campo UserName esta vazio");
        }
        if(usuario.getPassword() == null || usuario.getPassword().isEmpty()){
            throw new NullFieldException("O campo senha  esta vazio");
        }

        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
