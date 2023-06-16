import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.event.*;
import java.util.ArrayList;

public class Interface {
    // Requisito 10: O programa utiliza uma coleção de objetos (ArrayList)
    private static ArrayList<String> casos = new ArrayList<>();

    // Atributos estáticos da classe principal
    private static Detetive detetive;
    private static JTextField inputTextField;
    private static JTextArea consoleTextArea;


    public static void main(String[] args) { // metodo 1
        detetive = new Detetive("Antonio", 41, "Detetive Forense");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() { // metodo 2 atributos:detetive, frame, root
        JFrame frame = new JFrame("Swing App");
        // Configurações do JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        // Painel principal
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        root.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.setContentPane(root);

        // Painel superior com o campo de entrada e botão enviar
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        root.add(topPanel, BorderLayout.NORTH);

        // Campo de texto para inserir o input
        JTextField inputTextField = new JTextField(20);
        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();
                processInput(input);
            }
        });
        topPanel.add(inputTextField);
        topPanel.add(sendButton);

        // Painel principal para exibir os grupos de suspeitos e opções
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        root.add(mainPanel, BorderLayout.CENTER);

        // Criação dos retângulos com texto para representar os grupos de suspeitos
        JPanel group1 = createRectangleWithText("Bob", Color.RED);
        group1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(frame, "Eu sou inocente! Eu conhecia a vítima, mas isso não significa que eu a matei.\nNós tínhamos algumas desavenças no passado, mas isso não significa que \neu seria capaz de matá-la. Há outras pessoas que podem querer vê-la morta. \nVocês precisam procurar em outro lugar!", "Bob", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel group2 = createRectangleWithText("Rafa", Color.BLUE);
        group2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(frame, "Eu sou inocente! Eu estava no trabalho durante o horário do assassinato. \nTenho um álibi sólido e várias testemunhas que podem confirmar isso. \nAlém disso, eu não tinha nenhum motivo para cometer esse crime terrível. \nPor favor, acredite em mim!", "Rafa", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel group3 = createRectangleWithText("Leo", Color.GREEN);
        group3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(frame, "Eu juro por tudo o que é sagrado que não sou o assassino. Eu estava em casa\n na noite do assassinato, sozinho. Não tenho nenhuma conexão com a\n vítima, e não tenho motivos para tirar a vida de alguém. Peço que\n investiguem e encontrem o verdadeiro culpado!", "Leo", JOptionPane.PLAIN_MESSAGE);
            }
        });

        mainPanel.add(group1);
        mainPanel.add(group2);
        mainPanel.add(group3);

        // Painel de opções
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(5, 1, 0, 10)); // 5 linhas, 1 coluna, espaçamento vertical de 10 pixels
        mainPanel.add(optionsPanel);

        // Labels das opções
        JLabel label1 = new JLabel("1 - Resolver um enigma");
        JLabel label2 = new JLabel("2 - Restaurar uma pista queimada");
        JLabel label3 = new JLabel("3 - Interrogar prisioneiros");
        JLabel label4 = new JLabel("4 - Falar pistas encontradas");
        JLabel label5 = new JLabel("5 - Suspeitos falar");
        JLabel label6 = new JLabel("6 - Encerrar programa");

        optionsPanel.add(label1);
        optionsPanel.add(label2);
        optionsPanel.add(label3);
        optionsPanel.add(label4);
        optionsPanel.add(label5);
        optionsPanel.add(label6);

        frame.setVisible(true);

        // Área de texto para exibir a saída do console
        JTextArea consoleTextArea = new JTextArea(10, 50);
        consoleTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleTextArea);
        root.add(scrollPane, BorderLayout.SOUTH);

        // Redireciona a saída padrão e de erro para a área de texto do console
        PrintStream printStream = new PrintStream(new CustomOutputStream(consoleTextArea));
        System.setOut(printStream);
        System.setErr(printStream);

        System.out.println("Bem-vindo ao jogo de detetive!");

        inputTextField.requestFocus();
    }
    private static void processInput(String input) { // metodo 3
        // Cria uma instância do detetive
        Detetive det = new Detetive("Antonio", 41, "Detetive Forense"); // atributos det,bob,leo,rafa
        // Cria instâncias dos suspeitos
        Assassino bob = new Assassino("Bob", 24, "Intimidador", "26/10/2007", " Bob foi preso e acusado do assassinato em questao...");
        Ladrao leo = new Ladrao("Leonardo", 18, "Mentiroso", "10/04/2023", " Leo foi preso por um crime nao relacionado ao assassinato...");
        ManInTheMiddle rafa = new ManInTheMiddle("Rafael", 31, "Inteligente", "30/12/2010", "Rafa foi preso por atividades ilegais de hacking...");

        switch (input) {
            case "1":
                // Verifica se o enigma já foi resolvido
                if (casos.contains("1")) {
                    System.out.println("O Enigma ja foi resolvido!");
                    break;
                } else {
                    casos.add("1");
                }

                // Solicita o nome do arquivo de enigma ao usuário
                String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo Enigma (sem a extensao .txt): ");
                if (nomeArquivo != null && !nomeArquivo.isEmpty()) {
                    // Cria um SwingWorker para executar a resolução do enigma em segundo plano
                    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            Enigma enigma = new Enigma();
                            try {
                                enigma.enigmas(nomeArquivo);
                                // Adiciona uma pista ao detetive após a resolução do enigma
                                detetive.adicionar_pista("O enigma revela que alguem com 'B' era o verdadeiro monstro.");
                            } catch (Enigma.ArquivoNaoEncontradoException e) {
                                System.out.println("Ocorreu um erro: " + e.getMessage());
                            }
                            return null;
                        }
                    };
                    worker.execute();
                } else {
                    System.out.println("Nome do arquivo invalido!");
                }
                break;

            case "2":
                // Solicita ao usuário se deseja restaurar a pista queimada
                System.out.println("Deseja restaurar a pista queimada? (s/n)");
                String opcao = JOptionPane.showInputDialog("Deseja restaurar a pista queimada? (s/n)");
                if (opcao != null && opcao.equalsIgnoreCase("s")) {
                    Queima pistaRecuperada;
                    try {
                        // Abre a pista queimada e exibe sua descrição
                        pistaRecuperada = Queima.abrir("Pista_queimada.ser");
                        System.out.println("A pista queimada e:");
                        pistaRecuperada.exibir();
                        // Adiciona a descrição da pista ao detetive
                        detetive.adicionar_pista(pistaRecuperada.getDescricao());
                    } catch (Exception e) {
                        System.out.println("Excecao ao abrir a pista queimada: " + e.getMessage());
                    }
                } else {
                    // Cria uma nova pista queimada e a salva em um arquivo
                    Queima pistaNova = new Queima("Uma faca danificada com as iniciais B.O.B");
                    try {
                        pistaNova.salvar("Pista_queimada.ser");
                        System.out.println("Pista queimada criada e salva com sucesso!");
                        // Verifica se a pista queimada já foi restaurada
                        if (casos.contains("2")) {
                            System.out.println("A pista queimada ja foi resolvida!");
                            break;
                        } else {
                            casos.add("2");
                        }
                    } catch (Exception e) {
                        System.out.println("Excecao de I/O ao salvar a pista queimada: " + e.getMessage());
                    }
                }
                break;

            case "3":
                // Verifica se os criminosos já foram investigados
                if (casos.contains("3")) {
                    System.out.println("Os criminosos ja foram investigados.");
                    break;
                } else {
                    casos.add("3");
                }

                // Interroga os suspeitos
                detetive.interrogar(bob);
                detetive.interrogar(leo);
                detetive.interrogar(rafa);

                // Adiciona pistas do interrogatório ao detetive
                detetive.adicionar_pista(bob.pista());
                detetive.adicionar_pista(leo.pista());
                detetive.adicionar_pista(rafa.pista());
                break;

            case "4":
                // Fala as pistas encontradas pelo detetive
                detetive.falar();
                break;
            case "5":
                Pessoa[] pessoas = {bob, rafa, leo};
                for (Pessoa pessoa : pessoas) {
                    if (pessoa instanceof Criminoso) {
                        Criminoso criminoso = (Criminoso) pessoa;
                        criminoso.falar();
                    }
                }
                break;

            case "6":
                // Encerra o programa
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }
    }
        // metodos: createRectangWithText, mouseEntered, write, mousePresses, etc...
    // atributos: message, suspeito, textArea
    private static JPanel createRectangleWithText(String text, Color color) {
        // Cria um painel JPanel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(color);

        // Cria um rótulo JLabel com o texto fornecido
        JLabel label = new JLabel(text);

        // Adiciona o rótulo ao painel
        panel.add(label);

        // Retorna o painel criado
        return panel;
    }

    private static class MouseClickListener implements java.awt.event.MouseListener {
        private String message;
        private String suspeito;

        public MouseClickListener(String message, String suspeito) {
            this.message = message;
            this.suspeito = suspeito;
        }

        public void mouseClicked(java.awt.event.MouseEvent e) {
            // Imprime a mensagem fornecida
            System.out.println(message);

            // Define o suspeito no detetive
            detetive.setSuspeito(suspeito);
        }

        public void mouseEntered(java.awt.event.MouseEvent e) {
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
        }

        public void mousePressed(java.awt.event.MouseEvent e) {
        }

        public void mouseReleased(java.awt.event.MouseEvent e) {
        }
    }

    private static class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            // Escreve o caractere no final da JTextArea
            textArea.append(String.valueOf((char) b));

            // Define a posição do cursor para o final do texto
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
