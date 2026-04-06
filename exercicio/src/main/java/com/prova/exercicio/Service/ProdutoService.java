package com.prova.exercicio.Service;

import com.prova.exercicio.Entity.Produto;
import com.prova.exercicio.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto altualizarProduto(Long id, Produto produto){
        Produto produtoAtualizado = produtoRepository.findById(id).get();
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setDescrição(produto.getDescrição());
        produtoAtualizado.setPreco(produto.getPreco());
        produtoAtualizado.setStatus(produto.getStatus());
        return produtoRepository.save(produtoAtualizado);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Long id){
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
