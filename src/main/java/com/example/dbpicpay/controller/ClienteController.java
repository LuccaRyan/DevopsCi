package com.example.dbpicpay.controller;

import com.example.dbpicpay.models.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Validator;
import com.example.dbpicpay.service.ClienteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final Validator validator;
    @Autowired
    public ClienteController(ClienteService clienteService, Validator validator) {
        this.clienteService = clienteService;
        this.validator = validator;
    }
    @GetMapping("/selecionar")
    public List<Cliente> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }
    @GetMapping("/selecionar/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) {
        return clienteService.buscarPorCpf(cpf);
    }
    @PostMapping("/inserir")
    public ResponseEntity<String> inserirNovoCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if(!result.hasErrors()){
            try{
                clienteService.salvarCliente(cliente);
                return ResponseEntity.ok("Cliente inserido com sucesso");
            } catch (DataIntegrityViolationException e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }else{
            StringBuilder erro = new StringBuilder("Erros ao inserir o cliente");
            for(FieldError error : result.getFieldErrors()) {
                erro.append("\n- ").append(error.getDefaultMessage()).append(";");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro.toString());
        }
    }
    @DeleteMapping("/excluir/{cpf}")
    public void excluirCliente(@PathVariable String cpf) {
        clienteService.excluirCliente(cpf);
    }
    @PutMapping("/atualiza/{cpf}")
    public ResponseEntity<String> atualizarCliente(@PathVariable String cpf, @Valid @RequestBody Cliente cliente, BindingResult result) {
        if(!result.hasErrors()){
            Cliente clienteExistente = clienteService.buscarPorCpf(cpf);
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setTelefone(cliente.getTelefone());
            clienteService.salvarCliente(clienteExistente);
            return ResponseEntity.ok("Cliente atualizado com sucesso");
        }else{
            StringBuilder erro = new StringBuilder("Erros ao atualizar cliente");
            for(FieldError error : result.getFieldErrors()) {
                erro.append("\n- ").append(error.getDefaultMessage()).append(";");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro.toString());
        }
    }
    @PutMapping("/atualizar-parcial/{cpf}")
    public ResponseEntity<?> atualizarParcialmente(@PathVariable String cpf, @RequestBody Map<String, String> updates) {
        try{
            Cliente cliente = clienteService.buscarPorCpf(cpf);
            if(updates.containsKey("nome")){
                cliente.setNome((String) updates.get("nome"));
            }
            if(updates.containsKey("email")){
                cliente.setNome((String) updates.get("email"));
            }
            if(updates.containsKey("telefone")){
                cliente.setNome((String) updates.get("telefone"));
            }

            DataBinder binder = new DataBinder(cliente);
            binder.addValidators(validator);
            binder.validate();
            BindingResult resultado = binder.getBindingResult();
            if(resultado.hasErrors()){
                Map erros = validarCliente(resultado);
                return ResponseEntity.badRequest().body(erros);
            }
            Cliente clienteAlterado = clienteService.salvarCliente(cliente);
            return ResponseEntity.ok(clienteAlterado.toString());
        }catch (RuntimeException re){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException re) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
    }
    public Map<String,String> validarCliente(BindingResult result){
        Map<String,String> erros = new HashMap<>();
        for(FieldError error : result.getFieldErrors()){
            erros.put(error.getField(), error.getDefaultMessage());
        }
        return erros;
    }
}
