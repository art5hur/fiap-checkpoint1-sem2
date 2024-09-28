package br.com.fiap.ecommerce.controller;


import br.com.fiap.ecommerce.dtos.ClienteRequestCreateDto;
import br.com.fiap.ecommerce.dtos.ClienteRequestUpdateDto;
import br.com.fiap.ecommerce.dtos.ClienteResponseDto;

import br.com.fiap.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> list() {
        List<ClienteResponseDto> dtos = clienteService.list()
            .stream()
            .map(e -> new ClienteResponseDto().toDto(e))
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create(@RequestBody ClienteRequestCreateDto dto) {
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			new ClienteResponseDto().toDto(
        					clienteService.save(dto.toModel()))
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponseDto> update(
                        @PathVariable Long id, 
                        @RequestBody ClienteRequestUpdateDto dto) {
        if (! clienteService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			new ClienteResponseDto().toDto(
        				clienteService.save(dto.toModel(id)))
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! clienteService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        clienteService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id) {
    	return ResponseEntity.ok()
    			.body(
    				clienteService
    					.findById(id)
    					.map(e -> new ClienteResponseDto().toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);
    	  		     
    }

}
