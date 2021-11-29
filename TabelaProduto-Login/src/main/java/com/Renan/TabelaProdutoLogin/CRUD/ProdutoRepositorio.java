package com.Renan.TabelaProdutoLogin.CRUD;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer>{

	//Produto findByTag(String tag);
	Optional<Produto> findByTag(String tag);

} 

