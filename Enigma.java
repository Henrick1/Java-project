import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Enigma {

    public static class ArquivoNaoEncontradoException extends Exception {
        public ArquivoNaoEncontradoException(String mensagem) {
            super(mensagem);
        }
    }

    public void enigmas(String nomeArquivo) throws ArquivoNaoEncontradoException {
        try {
            // O enigma
            String enigma = "V wypzvulpyv I mvp v clykhklpyv tvuzayv!";

            // Criamos o arquivo
            File file = new File(nomeArquivo + ".txt");

            // Criamos o arquivo
            file.createNewFile();

            // Preparamos para escrever
            FileWriter writer = new FileWriter(file);

            // Escreve o conteúdo
            writer.write(enigma);
            writer.flush();
            writer.close();

            // Agora o usuário deve resolver a questão
            JOptionPane.showMessageDialog(null, "Parece que um enigma foi entregue a voce. Resolva-o para continuar.");

            boolean resolvido = false;

            // LOOP até o usuário resolver o enigma
            while (!resolvido) {
                String input = JOptionPane.showInputDialog("Digite o nome do arquivo .txt com a resposta (não precisa incluir o .txt no final): ");
                String output = input + ".txt";

                // Tentamos verificar se o arquivo existe
                try {
                    // Agora vemos o arquivo
                    File arquivo = new File(output);
                    FileReader fileReader = new FileReader(arquivo);
                    BufferedReader buffer = new BufferedReader(fileReader);

                    // Variável para pegar o que há dentro do arquivo
                    String str;
                    String resposta = "";

                    // Pegamos o que há no arquivo
                    while ((str = buffer.readLine()) != null) {
                        resposta += str;
                    }

                    // Agora, se a resposta está correta, vá para o próximo passo.
                    if (resposta.equals("O prisoneiro B foi o verdadeiro monstro!")) {
                        JOptionPane.showMessageDialog(null, "O enigma foi resolvido!");
                        resolvido = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Parece que a resposta está errada. Melhor tentar novamente...");
                    }
                    buffer.close();
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Ocorreu algum erro ao ler o arquivo!");
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu algum erro com o arquivo!");
            e.printStackTrace();
        }
    }
}
