import java.io.*;
import java.util.Scanner;

public class Queima implements Serializable {
    private String descricao = "";  // Atributo privado que armazena a descrição da pista queimada

    // Construtor da classe Queima que recebe a descrição da pista queimada
    public Queima(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void exibir() {
        System.out.println("A pista e: ");
        System.out.println(descricao);
    }

    // Método para salvar a pista queimada em um arquivo
    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    // Método estático para abrir e recuperar a pista queimada de um arquivo
    public static Queima abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        Queima queima = null;
        try {
            FileInputStream arquivo = new FileInputStream(nome_arquivo);
            ObjectInputStream restaurador = new ObjectInputStream(arquivo);

            queima = (Queima) restaurador.readObject();

            restaurador.close();
            arquivo.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("O arquivo de pista queimada nao existe.");
        }
        return queima;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Deseja restaurar a pista queimada? (s/n)");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("S")) {
                Queima pistaRecuperada;
                try {
                    pistaRecuperada = Queima.abrir("Pista_queimada.ser");
                    System.out.println("Pista Queimada restaurada:");
                    pistaRecuperada.exibir();
                } catch (FileNotFoundException e) {
                    System.out.println("O arquivo de pista queimada nao existe.");
                }
            } else {
                // Criando uma instância de Queima
                Queima pistaQueimada = new Queima("Uma faca danificada com as iniciais B.O.B");

                // Salvando a pista queimada em um arquivo
                pistaQueimada.salvar("Pista_queimada.ser");
                System.out.println("Pista Queimada criada e salva com sucesso!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
