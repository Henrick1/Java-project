public class Ladrao extends Criminoso{
    public Ladrao(String nome, int idade, String tipo, String dataPrisao, String MotivoPrisao){
        super(nome,idade,tipo, dataPrisao, MotivoPrisao);
    }

    public void falar(){
        System.out.println("Eu juro por tudo o que e sagrado que não sou o assassino. Eu estava em casa na noite do assassinato, sozinho. Nao tenho nenhuma conexao com a vitima, e nao tenho motivos para tirar a vida de alguem. Peco que investiguem e encontrem o verdadeiro culpado!");
    }

    public String pista(){
        String p = "Parece que Leonardo estava no refeitorio quando o assasinato ocorreu.";
        return p;
    }

}
