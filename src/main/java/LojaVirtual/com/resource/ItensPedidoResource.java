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

import LojaVirtual.com.model.ItensPedido;
import LojaVirtual.com.repository.ItensPedidoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/itenspedido")
public class ItensPedidoResource {
	@Autowired
	private ItensPedidoRepository itenspedidoRepository;
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<ItensPedido> list()
	{
		return itenspedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<ItensPedido> findById(@PathVariable Long id)
	{
		return itenspedidoRepository.findById(id);
	}
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ItensPedido> create(@RequestBody ItensPedido itenspedido, HttpServletResponse response)
	{
		ItensPedido save = itenspedidoRepository.save(itenspedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@CrossOrigin(origins = "http://localhost:4200")
	public void delete(@PathVariable Long id)
	{
		itenspedidoRepository.deleteById(id);
		//Desafio - retornar corretamente o Status
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<ItensPedido> update(@PathVariable Long id, @RequestBody ItensPedido itenspedido)
	{
		Optional<ItensPedido> itenspedidoBanco = itenspedidoRepository.findById(id);
		BeanUtils.copyProperties(itenspedido, itenspedidoBanco.get(), "id");
		itenspedidoRepository.save(itenspedidoBanco.get());
		return ResponseEntity.ok(itenspedido);
	}
}