package com.evento;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidadeMaxima;
    private int vagasDisponiveis;
    private String categoria;

    public Evento(String nome, String data, String local, int capacidadeMaxima, String categoria) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.vagasDisponiveis = capacidadeMaxima;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getInformacoesDoEvento() {
        return "Nome: " + nome + ", Data: " + data + ", Local: " + local + 
               ", Vagas Disponíveis: " + vagasDisponiveis + ", Categoria: " + categoria;
    }

    public boolean inscreverParticipante() {
        if (vagasDisponiveis > 0) {
            vagasDisponiveis--;
            return true;
        }
        return false;
    }
}
