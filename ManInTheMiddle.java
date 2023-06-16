public class ManInTheMiddle extends Criminoso {

    // Construtor da classe ManInTheMiddle que recebe os dados do criminoso e chama o construtor da superclasse Criminoso
    public ManInTheMiddle(String nome, int idade, String tipo, String dataPrisao, String MotivoPrisao) {
        super(nome, idade, tipo, dataPrisao, MotivoPrisao);
    }

    // Método falar() que imprime uma declaração específica para o criminoso ManInTheMiddle
    public void falar() {
        System.out.println("Eu sou inocente! Eu estava no trabalho durante o horário do assassinato. Tenho um álibi sólido e várias testemunhas que podem confirmar isso. Além disso, eu não tinha nenhum motivo para cometer esse crime terrível. Por favor, acredite em mim!");
    }

    // Método pista() que retorna uma pista específica para o criminoso ManInTheMiddle
    public String pista() {
        String p = "Parece que Rafael estava no patio quando o assassinato ocorreu.";
        return p;
    }
}
