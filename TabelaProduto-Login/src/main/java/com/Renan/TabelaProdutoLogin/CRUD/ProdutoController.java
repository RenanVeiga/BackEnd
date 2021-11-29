package com.Renan.TabelaProdutoLogin.CRUD;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/produtos"})
public class ProdutoController {

	
	private ProdutoRepositorio repositorio;
	
	ProdutoController(ProdutoRepositorio produtoRepositorio){
		this.repositorio = produtoRepositorio;
	}
	
	//pegar tudo guardado
		@GetMapping
		public List<Produto> findAll(){
			return repositorio.findAll();
		}
		
		//buscar pelo id e pela tag
		@GetMapping(path = "/{id}")
		public ResponseEntity<Produto> getById(@PathVariable int id){
			return repositorio.findById(id)
					.map(record -> ResponseEntity.ok().body(record))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping(path = "/{tag}")
		public ResponseEntity<Produto> getByTag(@PathVariable String tag){
			return repositorio.findByTag(tag)
					.map(record -> ResponseEntity.ok().body(record))
					.orElse(ResponseEntity.notFound().build());
		}
		
		//salvar
		
		@PostMapping()
		public Produto salvar(@RequestBody Produto produto) {
			return repositorio.save(produto);
		}
		
		//alterar com id
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Produto> update(@PathVariable("id") int id,
                @RequestBody Produto produto){
					return repositorio.findById(id)
					.map(record -> {
					record.setNome(produto.getNome());
					record.setPreco(produto.getPreco());
					record.setDescricao(produto.getDescricao());
					record.setTag(produto.getTag());
					Produto updated = repositorio.save(record);
					return ResponseEntity.ok().body(updated);
					}).orElse(ResponseEntity.notFound().build());
					}
					

		@DeleteMapping(path ={"/{id}"})
		public ResponseEntity <?> delete(@PathVariable("id") int id) {
		   return repositorio.findById(id)
		           .map(record -> {
		               repositorio.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}

	
	/*@Autowired
	private ProdutoService service;
	
	@PostMapping("/addProduto")
	public Produto addProduto(@RequestBody Produto produto) {
		return service.saveProduct(produto);
	}
	
	@GetMapping("/produtos")
	public List<Produto> findAllProdutos(){
		return service.getProdutos();
	}
	
	@GetMapping("/produtos/{id}")
	public Produto findProdutoPorId(@PathVariable int id) {
		return service.getProdutoPorID(id);
	}
	
	@GetMapping("/produtos/{tag}")
	public Produto findProdutoPorTag(@PathVariable String tag) {
		return service.getProdutoPorTag(tag);
	}
	
	@PutMapping("/updateProduto")
	public Produto updateProduto(@RequestBody Produto produto) {
		return service.updateProduto(produto);
	}
	
	@DeleteMapping("/deletar/{id}")
	public String deleteProduto(@PathVariable int id) {
		return service.deleteProduto(id);
	}*/
}
