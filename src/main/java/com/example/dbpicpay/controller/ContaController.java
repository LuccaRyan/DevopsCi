//package com.example.dbpicpay.controller;
//
//import com.example.dbpicpay.models.Conta;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.validation.Validator;
//import com.example.dbpicpay.service.ContaService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/contas")
//public class ContaController {
//    private final ContaService contaService;
//    private final Validator validator;
//    @Autowired
//    public ContaController(ContaService contaService, Validator validator) {
//        this.contaService = contaService;
//        this.validator = validator;
//    }
//    @GetMapping("/selecionar")
//    public List<Conta> buscarTodasContas() {
//        return contaService.buscarTodasContas();
//    }
//    @GetMapping("/selecionar/{numeroConta}")
//    public Conta buscarPorNumero(String numeroConta) {
//        return contaService.buscarPorNumero(numeroConta);
//    }
//    @PostMapping("/inserir")
//    public void inserirNovaConta(Conta conta) {
//        contaService.salvarConta(conta);
//    }
//    @PostMapping("/excluir/{numeroConta}")
//    public void excluirConta(String numeroConta) {
//        contaService.excluirConta(numeroConta);
//    }
//    @PostMapping("/atualiza/{numeroConta}")
//    public void atualizarConta(String numeroConta) {
//
//    }
//    @PostMapping("/atualizar-parcial/{numeroConta}")
//    public void atualizarParcialmente(String numeroConta) {
//
//    }
//}
