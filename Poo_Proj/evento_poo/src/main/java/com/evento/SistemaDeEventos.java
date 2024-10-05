package com.evento;

public class SistemaDeEventos {
    private Evento[] eventos = new Evento[10];
    private int contadorDeEventos = 0;

    public boolean cadastrarEvento(String nome, String data, String local, int capacidadeMaxima, String categoria) {
        if (contadorDeEventos < eventos.length) {
            eventos[contadorDeEventos] = new Evento(nome, data, local, capacidadeMaxima, categoria);
            contadorDeEventos++;
            return true;
        }
        return false;
    }

    public void listarEventos() {
        for (int i = 0; i < contadorDeEventos; i++) {
            System.out.println(eventos[i].getInformacoesDoEvento());
        }
    }

    public boolean inscreverParticipante(String nomeDoEvento) {
        for (int i = 0; i < contadorDeEventos; i++) {
            if (eventos[i].getNome().equalsIgnoreCase(nomeDoEvento)) {
                return eventos[i].inscreverParticipante();
            }
        }
        return false;
    }

    public Evento buscarEventoPorNome(String nomeDoEvento) {
        for (int i = 0; i < contadorDeEventos; i++) {
            if (eventos[i].getNome().equalsIgnoreCase(nomeDoEvento)) {
                return eventos[i];
            }
        }
        return null;
    }
}
