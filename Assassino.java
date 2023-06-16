public class Assassino extends Criminoso {
    // Construtor da classe Assassino que recebe os dados do assassino e chama o construtor da superclasse Criminoso
    public Assassino(String nome, int idade, String tipo, String dataPrisao, String MotivoPrisao){
        super(nome, idade, tipo, dataPrisao, MotivoPrisao);
    }

    // Método falar() que imprime uma declaração do assassino alegando inocência e sugerindo outras possibilidades
    public void falar(){
        System.out.println("Eu sou inocente! Eu conhecia a vítima, mas isso não significa que eu a matei. Nós tínhamos algumas desavenças no passado, mas isso não significa que eu seria capaz de matá-la. Há outras pessoas que podem querer vê-la morta. Vocês precisam procurar em outro lugar!");
    }

    // Método pista() que retorna uma pista relacionada ao assassino
    public String pista(){
        String p = "Parece que Bob estava na cela quando o assassinato ocorreu.";
        return p;
    }
}


// Atributos herdados da classe criminoso: nome, idade, tipo, dataPrisao, motivoPrisao
// Metodos: falar, pista
