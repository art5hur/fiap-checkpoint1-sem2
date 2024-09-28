package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.ItemPedido;

import org.modelmapper.ModelMapper;


public class ItemPedidoRequestCreateDto {

	private Long id;
	private Long idPedido;
	private Long idProduto;

	private static final ModelMapper modelMapper = new ModelMapper();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public ItemPedido toModel() {
		return modelMapper.map(this, ItemPedido.class);
	}

}
