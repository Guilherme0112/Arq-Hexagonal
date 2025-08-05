package com.hexagonal.demo.adapters.outbound.repository.pedido;

import com.hexagonal.demo.adapters.outbound.entity.JpaPedidoEntity;
import com.hexagonal.demo.adapters.outbound.mapper.PedidoMapper;
import com.hexagonal.demo.domain.pedido.Pedido;
import com.hexagonal.demo.domain.pedido.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PedidoRepositoryImpl implements PedidoRepository {

  private final JpaPedidoRepository jpaPedidoRepository;
  private final PedidoMapper pedidoMapper;

  @Override
  public Pedido save(Pedido pedido){
    JpaPedidoEntity jpaPedidoEntity = new JpaPedidoEntity(pedido);
    JpaPedidoEntity pedidoSalvo = this.jpaPedidoRepository.save(jpaPedidoEntity);
    return pedidoMapper.toDomain(pedidoSalvo);
  }

  @Override
  public Optional<Pedido> findById(Long id){
    Optional<JpaPedidoEntity> jpaPedidoEntity = this.jpaPedidoRepository.findById(id);
    return jpaPedidoEntity
            .map(pedidoMapper::toDomain
    );
  }

  @Override
  public List<Pedido> findAll(){
    List<JpaPedidoEntity> jpaPedidoEntities = this.jpaPedidoRepository.findAll();
    return jpaPedidoEntities
            .stream()
            .map(pedidoMapper::toDomain)
            .toList();
  }

  @Override
  public void deleteById(Long id){
    this.jpaPedidoRepository.deleteById(id);
  }
}
