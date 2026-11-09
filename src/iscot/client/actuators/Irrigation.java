package iscot.client.actuators;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

import iscot.client.gui.ACIcon;
import iscot.client.gui.IrrigationIcon;
import iscot.client.gui.VentilatorIcon;
import iscot.enums.Areas;

public class Irrigation {

    /**
     *
     * @param server address and port
     * @param roomName: string
     * @throws IOException
     * @throws UnknownHostException
     * @throws NumberFormatException
     * @throws InterruptedException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws NumberFormatException, UnknownHostException, IOException, InterruptedException, ClassNotFoundException {
        if(args.length!=3) {
            System.err.println("Invalid arguments!");
        }
        else {
            // TODO connect to server

            // TODO register with the server
            Areas area=Areas.valueOf(args[2]);

            JFrame janela = new JFrame("AC em "+area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Criar os componentes gráficos
            JPanel painel=new JPanel();
            painel.setLayout(new BorderLayout());
            IrrigationIcon irrigation = new IrrigationIcon();
            painel.add(irrigation,BorderLayout.CENTER);

            JTextArea textArea = new JTextArea(6, 25);
            textArea.setEditable(false);

            JScrollPane scroll = new JScrollPane(textArea);
            scroll.setBorder(BorderFactory.createTitledBorder("Histórico de ações"));
            painel.add(scroll,BorderLayout.SOUTH);

            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.setMinimumSize(janela.getSize());
            janela.pack();
            janela.setVisible(true);

            Thread.sleep(5000);
            irrigation.setAtivo(true);

            // TODO: receive and handle messages from server

            // TODO: for first phase: create an appropriate event hardcoded locally and change the GUI accordingly
        }
    }

    private static void addActionToHistory(JTextArea textArea, String acction) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime date = LocalTime.parse(LocalTime.now().format(formatter));
        textArea.append(acction + " " + date);
    }
}
