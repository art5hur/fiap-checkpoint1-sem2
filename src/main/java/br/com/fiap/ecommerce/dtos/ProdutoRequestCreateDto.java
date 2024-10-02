package br.com.fiap.ecommerce.dtos;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

import java.math.BigDecimal;

public class ProdutoRequestCreateDto {
    private String nome;
    private BigDecimal valor;
    private static final ModelMapper modelMapper = new ModelMapper();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Produto toModel() {
        return modelMapper.map(this, Produto.class);
    }
    
}