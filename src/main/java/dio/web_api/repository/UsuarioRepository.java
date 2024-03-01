package dio.web_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.web_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
