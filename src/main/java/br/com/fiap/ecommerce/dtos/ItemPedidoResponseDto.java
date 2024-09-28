package br.com.fiap.ecommerce.dtos;

import br.com.fiap.ecommerce.model.ItemPedido;
import org.modelmapper.ModelMapper;



public class ItemPedidoResponseDto {

	private Long id;
	private Long idPedido;
	private Long idProduto;
	private static final ModelMapper modelMapper = new ModelMapper();

	public ItemPedidoResponseDto toDto(ItemPedido itemPedido) {
		return modelMapper.map(itemPedido, ItemPedidoResponseDto.class);

		// ProdutoResponseDto result = new ProdutoResponseDto();
		// result.setId(produto.getId());
		// result.setNome(produto.getNome());

		// return result;
	}

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
}
