package com.hexagonal.demo.adapters.outbound.repository;

import com.hexagonal.demo.adapters.outbound.entity.JpaUsuarioEntity;
import com.hexagonal.demo.domain.usuario.Usuario;
import com.hexagonal.demo.domain.usuario.UsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl  implements UsuarioRepository {

    private final JpaUsuarioRepository jpaUsuarioRepository;

    public UsuarioRepositoryImpl(JpaUsuarioRepository jpaUsuarioRepository) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        JpaUsuarioEntity jpaUsuarioEntity = new JpaUsuarioEntity(usuario);
        this.jpaUsuarioRepository.save(jpaUsuarioEntity);
        return new Usuario(jpaUsuarioEntity.getId(), jpaUsuarioEntity.getNome(), jpaUsuarioEntity.getEmail(), jpaUsuarioEntity.getSenha());
    }

    @Override
    public Usuario findById(Long id){
        Optional<JpaUsuarioEntity> jpaUsuarioEntity = this.jpaUsuarioRepository.findById(id);
        return jpaUsuarioEntity.map(jpaUsuario ->
            new Usuario(jpaUsuario.getId(),
                        jpaUsuario.getNome(),
                        jpaUsuario.getEmail(),
                        jpaUsuario.getSenha())
        ).orElse(null);
    }

    @Override
    public List<Usuario> findAll(){
        return this.jpaUsuarioRepository.findAll()
                .stream()
                .map(jpaUsuario ->
                        new Usuario(jpaUsuario.getId(),
                                jpaUsuario.getNome(),
                                jpaUsuario.getEmail(),
                                jpaUsuario.getSenha())
                ).toList();
    }

    @Override
    public void deleteById(Long id){
        this.jpaUsuarioRepository.deleteById(id);
    }
}
