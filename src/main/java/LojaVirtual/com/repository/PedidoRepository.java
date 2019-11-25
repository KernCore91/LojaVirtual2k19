package LojaVirtual.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import LojaVirtual.com.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}