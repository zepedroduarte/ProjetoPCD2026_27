package iscot.client.actuators;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.*;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.ACIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AirConditioner {

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
            Areas area;

            try {
                area = Areas.valueOf(args[2]);
            } catch (IllegalArgumentException e) {
                return;
            }

            JFrame janela = new JFrame("AC em "+area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Criar os componentes gráficos
            JPanel painel=new JPanel();
            painel.setLayout(new BorderLayout());
            ACIcon ac = new ACIcon();
            painel.add(ac,BorderLayout.CENTER);

            HistoryPanel historico = new HistoryPanel();
            painel.add(historico,BorderLayout.SOUTH);

            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.setMinimumSize(janela.getSize());
            janela.pack();
            janela.setVisible(true);

            Thread.sleep(5000);
            ac.setModo(AirConditioningMode.Aquecimento);
            historico.registar("AC ligado em modo Aquecimento");


            // TODO: receive and handle messages from server

            // TODO: for first phase: create an appropriate event hardcoded locally and change the GUI accordingly
        }
    }

}
