import java.util.ArrayList;

public class Detetive extends Pessoa {
    private ArrayList<String> pistas = new ArrayList<String>(); // Lista de pistas encontradas pelo detetive
    private Criminoso crim; // Referência a um objeto do tipo Criminoso
    private String suspeito; // Nome do suspeito

    public Detetive(String nome, int idade, String tipo){
        super(nome, idade, tipo); // Chama o construtor da superclasse Pessoa para definir o nome, idade e tipo do detetive
    }

    public int pistas_encontradas(){
        return pistas.size(); // Retorna o número de pistas encontradas pelo detetive
    }

    public void falar() {
        System.out.println("Pistas encontradas:");
        int i = 0; // Inicializa o contador
        for (String pista : pistas) {
            System.out.println("- " + pista);
            i++; // Incrementa o contador a cada pista encontrada
            if (i >= 5) {
                System.out.println("Misterio resolvido, Bob assassinou o guarda");
                break; // Encerra o loop quando o mistério for resolvido
            }
        }
    }

    public void interrogar(Criminoso criminoso){
        crim = criminoso; // Atribui o criminoso fornecido ao atributo crim
        System.out.println("O motivo de prisao foi: ");
        crim.motivo(); // Chama o método motivo() do objeto criminoso para imprimir o motivo da prisão
    }

    public void adicionar_pista(String pista){
        if (!pistas.contains(pista)) {
            pistas.add(pista); // Adiciona a pista à lista de pistas, caso ainda não tenha sido adicionada
            System.out.println("Pista adicionada: " + pista);
        } else {
            System.out.println("Esta pista ja foi adicionada!");
        }
    }

    public void setSuspeito(String nomeSuspeito) {
        this.suspeito = nomeSuspeito; // Define o nome do suspeito
    }

    public String getSuspeito() {
        return suspeito; // Retorna o nome do suspeito
    }
}

