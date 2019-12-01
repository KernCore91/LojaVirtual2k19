package LojaVirtual.com.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import LojaVirtual.com.model.GrupoProduto;
import LojaVirtual.com.repository.GrupoProdutoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/grupoproduto")
public class GrupoProdutoResource {
	@Autowired
	private GrupoProdutoRepository grupoprodutoRepository;
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<GrupoProduto> list()
	{
		return grupoprodutoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<GrupoProduto> findById(@PathVariable Long id)
	{
		return grupoprodutoRepository.findById(id);
	}
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<GrupoProduto> create(@RequestBody GrupoProduto grupoproduto, HttpServletResponse response)
	{
		GrupoProduto save = grupoprodutoRepository.save(grupoproduto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@CrossOrigin(origins = "http://localhost:4200")
	public void delete(@PathVariable Long id)
	{
		grupoprodutoRepository.deleteById(id);
		//Desafio - retornar corretamente o Status
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<GrupoProduto> update(@PathVariable Long id, @RequestBody GrupoProduto grupoproduto)
	{
		Optional<GrupoProduto> grupoprodutoBanco = grupoprodutoRepository.findById(id);
		BeanUtils.copyProperties(grupoproduto, grupoprodutoBanco.get(), "id");
		grupoprodutoRepository.save(grupoprodutoBanco.get());
		return ResponseEntity.ok(grupoproduto);
	}
}