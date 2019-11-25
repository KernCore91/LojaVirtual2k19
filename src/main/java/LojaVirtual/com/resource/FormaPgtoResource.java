package LojaVirtual.com.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import LojaVirtual.com.model.FormaPgto;
import LojaVirtual.com.repository.FormaPgtoRepository;

@RestController
@RequestMapping("/formapgto")
public class FormaPgtoResource {
	@Autowired
	private FormaPgtoRepository formapgtoRepository;
	
	@GetMapping
	public List<FormaPgto> list()
	{
		return formapgtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<FormaPgto> findById(@PathVariable Long id)
	{
		return formapgtoRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<FormaPgto> create(@RequestBody FormaPgto formapgto, HttpServletResponse response)
	{
		FormaPgto save = formapgtoRepository.save(formapgto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id)
	{
		formapgtoRepository.deleteById(id);
		//Desafio - retornar corretamente o Status
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FormaPgto> update(@PathVariable Long id, @RequestBody FormaPgto formapgto)
	{
		Optional<FormaPgto> formapgtoBanco = formapgtoRepository.findById(id);
		BeanUtils.copyProperties(formapgto, formapgtoBanco.get(), "id");
		formapgtoRepository.save(formapgtoBanco.get());
		return ResponseEntity.ok(formapgto);
	}
}