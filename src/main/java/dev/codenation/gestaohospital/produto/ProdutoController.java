package dev.codenation.gestaohospital.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoResource>> listar() {
		return ResponseEntity.ok(produtoService.listar());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoResource> cadastrar(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.cadastrar(produto));
	}
}
