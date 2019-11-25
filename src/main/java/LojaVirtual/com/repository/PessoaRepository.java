package LojaVirtual.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import LojaVirtual.com.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}