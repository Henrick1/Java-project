public abstract class Pessoa {
    protected String nome;       // Atributo protegido que armazena o nome da pessoa
    protected String sobrenome;  // Atributo protegido que armazena o sobrenome da pessoa
    protected int idade;         // Atributo protegido que armazena a idade da pessoa
    protected String tipo;       // Atributo protegido que armazena o tipo da pessoa

    // Construtor da classe Pessoa que recebe o nome, idade e tipo da pessoa
    public Pessoa(String nome, int idade, String tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    public abstract void falar();  // Método abstrato que será implementado pelas subclasses
}
