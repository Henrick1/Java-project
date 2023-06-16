public class Criminoso extends Pessoa {
    // Atributos da classe Criminoso
    protected String dataPrisao;
    protected String MotivoPrisao;

    // Construtor da classe Criminoso que recebe os dados do criminoso e chama o construtor da superclasse Pessoa
    public Criminoso(String nome, int idade, String tipo, String dataPrisao, String MotivoPrisao){
        super(nome, idade, tipo);
        this.dataPrisao = dataPrisao;
        this.MotivoPrisao = MotivoPrisao;
    }

    // Método falar() que imprime uma declaração genérica para todos os criminosos
    public void falar(){
        System.out.println("DAR TEXTO ÚNICO PARA CADA CRIMINOSO.");
    }



    // Método motivo() que imprime o motivo da prisão do criminoso
    public void motivo(){
        System.out.println(MotivoPrisao);
    }

    // Método pista() que retorna uma pista genérica para todos os criminosos
    public String pista(){
        String p = "DAR PISTA ÚNICA PARA CADA CRIMINOSO.";
        return p;
    }
}
