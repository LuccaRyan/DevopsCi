//package com.example.dbpicpay.service;
//
//import com.example.dbpicpay.models.Conta;
//import com.example.dbpicpay.repository.ContaRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class ContaService {
//    public final ContaRepository contaRepository;
//    public ContaService(ContaRepository contaRepository) {
//        this.contaRepository = contaRepository;
//    }
//    public List<Conta> buscarTodasContas() {
//        return contaRepository.findAll();
//    }
//    public Conta buscarPorNumero(String numeroConta) {
//        return contaRepository.findById(numeroConta).orElseThrow(() -> new RuntimeException("Conta não encontrada com o número: " + numeroConta));
//    }
//    @Transactional
//    public Conta salvarConta(Conta conta) {
//        return contaRepository.save(conta);
//    }
//    @Transactional
//    public Conta excluirConta(String numeroConta) {
//        Conta conta = buscarPorNumero(numeroConta);
//        contaRepository.delete(conta);
//        return conta;
//    }
//}
