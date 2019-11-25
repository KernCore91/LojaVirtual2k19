package LojaVirtual.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import LojaVirtual.com.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}