package com.evento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeEventos sistema = new SistemaDeEventos();
        Scanner scanner = new Scanner(System.in);
        
        boolean executando = true;

        while (executando) {
            System.out.println("==== Sistema de Gestão de Eventos ====");
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Inscrever Participante");
            System.out.println("4. Buscar Evento por Nome");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data do evento: ");
                    String data = scanner.nextLine();
                    System.out.print("Local do evento: ");
                    String local = scanner.nextLine();
                    System.out.print("Capacidade máxima: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Categoria (Camarote, VIP, Área Comum, Área Externa): ");
                    String categoria = scanner.nextLine();
                    
                    if (sistema.cadastrarEvento(nome, data, local, capacidade, categoria)) {
                        System.out.println("Evento cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Não foi possível cadastrar o evento (limite atingido).");
                    }
                    break;

                case 2:
                    sistema.listarEventos();
                    break;

                case 3:
                    System.out.print("Nome do evento para inscrição: ");
                    String nomeEvento = scanner.nextLine();
                    if (sistema.inscreverParticipante(nomeEvento)) {
                        System.out.println("Participante inscrito com sucesso!");
                    } else {
                        System.out.println("Erro: Evento não encontrado ou esgotado.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do evento para buscar: ");
                    String buscaNome = scanner.nextLine();
                    Evento evento = sistema.buscarEventoPorNome(buscaNome);
                    if (evento != null) {
                        System.out.println(evento.getInformacoesDoEvento());
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                case 5:
                    executando = false;
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
