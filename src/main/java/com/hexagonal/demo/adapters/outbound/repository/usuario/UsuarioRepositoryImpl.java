package com.hexagonal.demo.adapters.outbound.repository.usuario;

import com.hexagonal.demo.adapters.outbound.entity.JpaUsuarioEntity;
import com.hexagonal.demo.domain.usuario.Usuario;
import com.hexagonal.demo.domain.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UsuarioRepositoryImpl  implements UsuarioRepository {

    private final JpaUsuarioRepository jpaUsuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        JpaUsuarioEntity jpaUsuarioEntity = new JpaUsuarioEntity(usuario);
        JpaUsuarioEntity usuarioSalvo = this.jpaUsuarioRepository.save(jpaUsuarioEntity);
        return new Usuario(usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getSenha(),
                usuarioSalvo.getDataCadastro());
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        Optional<JpaUsuarioEntity> jpaUsuarioEntity = this.jpaUsuarioRepository.findById(id);

        return jpaUsuarioEntity.map(jpaUsuario ->
                new Usuario(jpaUsuario.getId(),
                        jpaUsuario.getNome(),
                        jpaUsuario.getEmail(),
                        jpaUsuario.getSenha(),
                        jpaUsuario.getDataCadastro())
        );
    }

    @Override
    public List<Usuario> findAll(){
        return this.jpaUsuarioRepository.findAll()
                .stream()
                .map(jpaUsuario ->
                        new Usuario(jpaUsuario.getId(),
                                jpaUsuario.getNome(),
                                jpaUsuario.getEmail(),
                                jpaUsuario.getSenha(),
                                jpaUsuario.getDataCadastro())
                ).toList();
    }

    @Override
    public void deleteById(Long id){
        this.jpaUsuarioRepository.deleteById(id);
    }
}
