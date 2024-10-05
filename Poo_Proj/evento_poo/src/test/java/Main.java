
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<Evento> eventos = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Gestão de Eventos");

        // Criação de componentes
        Label welcomeLabel = new Label("Bem-vindo ao Sistema de Gestão de Eventos!");

        // Botões
        Button btnCadastrarEvento = new Button("Cadastrar Evento");
        Button btnListarEventos = new Button("Listar Eventos");
        Button btnBuscarEvento = new Button("Buscar Evento");
        Button btnInscreverParticipante = new Button("Inscrever Participante");

        // Área de texto para exibir eventos
        TextArea textArea = new TextArea();
        textArea.setEditable(false);

        // Campo de texto para busca
        TextField searchField = new TextField();
        searchField.setPromptText("Nome do evento para buscar");

        // Adicionando ações aos botões
        btnCadastrarEvento.setOnAction(e -> {
            cadastrarEvento();
        });

        btnListarEventos.setOnAction(e -> {
            listarEventos(textArea);
        });

        btnBuscarEvento.setOnAction(e -> {
            String nomeEvento = searchField.getText();
            buscarEvento(nomeEvento, textArea);
        });

        btnInscreverParticipante.setOnAction(e -> {
            String nomeEvento = searchField.getText();
            inscreverParticipante(nomeEvento, textArea);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(welcomeLabel, btnCadastrarEvento, btnListarEventos, searchField, btnBuscarEvento, btnInscreverParticipante, textArea);

        // Configuração da cena
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cadastrarEvento() {
        // Simulação de cadastro de evento
        Evento evento = new Evento("Evento Teste", "2024-10-10", "Auditório", 100, "VIP");
        eventos.add(evento);
        System.out.println("Evento cadastrado: " + evento.getNome());
    }

    private void listarEventos(TextArea textArea) {
        StringBuilder sb = new StringBuilder();
        for (Evento evento : eventos) {
            sb.append("Nome: ").append(evento.getNome()).append("\n");
            sb.append("Data: ").append(evento.getData()).append("\n");
            sb.append("Local: ").append(evento.getLocal()).append("\n");
            sb.append("Vagas: ").append(evento.getVagasDisponiveis()).append("\n");
            sb.append("Categoria: ").append(evento.getCategoria()).append("\n\n");
        }
        textArea.setText(sb.toString());
    }

    private void buscarEvento(String nomeEvento, TextArea textArea) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                textArea.setText("Nome: " + evento.getNome() +
                                 "\nData: " + evento.getData() +
                                 "\nLocal: " + evento.getLocal() +
                                 "\nVagas: " + evento.getVagasDisponiveis() +
                                 "\nCategoria: " + evento.getCategoria());
                return;
            }
        }
        textArea.setText("Evento não encontrado.");
    }

    private void inscreverParticipante(String nomeEvento, TextArea textArea) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nomeEvento)) {
                evento.inscreverParticipante();
                textArea.setText("Inscrição realizada para o evento: " + evento.getNome());
                return;
            }
        }
        textArea.setText("Evento não encontrado ou esgotado.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
