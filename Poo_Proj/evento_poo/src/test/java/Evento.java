
public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidadeMaxima;
    private int vagasDisponiveis;
    private String categoria; // Ex: Camarote, VIP, etc.

    public Evento(String nome, String data, String local, int capacidadeMaxima, String categoria) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.vagasDisponiveis = capacidadeMaxima; // Inicialmente, todas as vagas estão disponíveis
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public String getCategoria() {
        return categoria;
    }

    public void inscreverParticipante() {
        if (vagasDisponiveis > 0) {
            vagasDisponiveis--;
        } else {
            System.out.println("Evento esgotado!");
        }
    }
}
