package br.com.fiap.ecommerce.dtos;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import br.com.fiap.ecommerce.model.Produto;

public class ProdutoRequestCreateDto {
    private String nome;
    private BigDecimal valor;
    private static final ModelMapper modelMapper = new ModelMapper();

    
    public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto toModel() {
        return modelMapper.map(this, Produto.class);
    }
    
}
