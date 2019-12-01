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

import LojaVirtual.com.model.Pedido;
import LojaVirtual.com.repository.PedidoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pedido")
public class PedidoResource {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pedido> list()
	{
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<Pedido> findById(@PathVariable Long id)
	{
		return pedidoRepository.findById(id);
	}
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Pedido> create(@RequestBody Pedido pedido, HttpServletResponse response)
	{
		Pedido save = pedidoRepository.save(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@CrossOrigin(origins = "http://localhost:4200")
	public void delete(@PathVariable Long id)
	{
		pedidoRepository.deleteById(id);
		//Desafio - retornar corretamente o Status
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido)
	{
		Optional<Pedido> pedidoBanco = pedidoRepository.findById(id);
		BeanUtils.copyProperties(pedido, pedidoBanco.get(), "id");
		pedidoRepository.save(pedidoBanco.get());
		return ResponseEntity.ok(pedido);
	}
}