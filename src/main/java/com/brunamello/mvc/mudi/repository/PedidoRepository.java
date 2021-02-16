package com.brunamello.mvc.mudi.repository;

import com.brunamello.mvc.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


}
