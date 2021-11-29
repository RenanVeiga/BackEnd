/*package com.Renan.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired()
	private ProdutoRepositorio repository;
	
	public Produto saveProduct(Produto produto) {
		return repository.save(produto);
	}
	
	public List<Produto> saveProducts(List<Produto> produtos){
		return repository.saveAll(produtos);
	}
	
	public List<Produto> getProdutos(){
		return repository.findAll();
	}
	
	public Produto getProdutoPorID(int id) {
		return repository.findById(id).orElse(null);
	}
	public Produto getProdutoPorTag(String tag) {
		return repository.findByTag(tag);
	}
	
	public String deleteProduto(int id) {
		repository.deleteById(id);
		return "Deletado!";
	}
	
	public Produto updateProduto(Produto produto) {
		Produto produtoAntigo = repository.findById(produto.getId()).orElse(null);
		produtoAntigo.setNome(produto.getNome());
		produtoAntigo.setPreco(produto.getPreco());
		produtoAntigo.setDescricao(produto.getDescricao());
		produtoAntigo.setTag(produto.getTag());
		return repository.save(produtoAntigo);
	}
	
}	




/*

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
		public Iterable<Produto> get(@PathVariable String tag){
			return repositorio.findByTag(tag);
		}
		
		//salvar
		
		@PostMapping
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
		}*/

