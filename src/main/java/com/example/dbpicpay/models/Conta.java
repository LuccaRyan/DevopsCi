//package com.example.dbpicpay.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//@Entity
//public class Conta {
//    @Id
//    @Size(min = 5, max = 5, message = "O numero da conta deve ter 5 digitos")
//    @Column(name = "numero_conta")
//    @NotNull(message = "O numero da conta não pode ser vazio")
//    private String numeroConta;
//    @NotNull(message = "O saldo da conta não pode ser vazio")
//    private double saldo;
//    @NotNull(message = "O limite especial do cliente não pode ser vazio")
//    @Column(name = "limite_especial")
//    private double limiteEspecial;
//    @NotNull(message = "O cpf do cliente não pode ser vazio")
//    @Column(name = "cpf_cliente")
//    private String clienteCpf;
//
//    public Conta() {}
//
//    public Conta(String numero_conta, double saldo, double limite_especial, String cliente_cpf) {
//        this.numeroConta = numero_conta;
//        this.saldo = saldo;
//        this.limiteEspecial = limite_especial;
//        this.clienteCpf = cliente_cpf;
//    }
//
//    public String getNumeroConta() {
//        return numeroConta;
//    }
//
//    public double getSaldo() {
//        return saldo;
//    }
//    public void setSaldo(double saldo) {
//        this.saldo = saldo;
//    }
//    public double getLimiteEspecial() {
//        return limiteEspecial;
//    }
//    public void setLimiteEspecial(double limiteEspecial) {
//        this.limiteEspecial = Conta.this.limiteEspecial;
//    }
//    public String getClienteCpf() {
//        return clienteCpf;
//    }
//    public void setClienteCpf(String clienteCpf) {
//        this.clienteCpf = Conta.this.clienteCpf;
//    }
//
//    @Override
//    public String toString() {
//        return "Conta" + "\nnumeroConta:" + numeroConta + "\nsaldo:" + saldo + "\nlimiteEspecial:" + limiteEspecial + "\nclienteCpf:" + clienteCpf;
//    }
//}
