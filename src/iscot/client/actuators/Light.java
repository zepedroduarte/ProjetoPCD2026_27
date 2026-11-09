package iscot.client.actuators;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.*;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.LightIcon;
import iscot.enums.Areas;
import iscot.events.order.AreaLightingOrderEvent;

public class Light {

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

            JFrame janela = new JFrame("Luz em "+area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Criar os componentes gráficos
            JPanel painel=new JPanel();
            painel.setLayout(new BorderLayout());
            LightIcon light = new LightIcon();
            painel.add(light,BorderLayout.CENTER);

            HistoryPanel historico = new HistoryPanel();
            painel.add(historico,BorderLayout.SOUTH);

            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.setMinimumSize(janela.getSize());
            janela.pack();
            janela.setVisible(true);

            AreaLightingOrderEvent[] ordens = {
                    new AreaLightingOrderEvent(area, true),
                    new AreaLightingOrderEvent(area, false),
                    new AreaLightingOrderEvent(area, true)
            };
            for (AreaLightingOrderEvent ordem : ordens) {
                Thread.sleep(3000);
                System.out.println(ordem);
                light.setLigada(ordem.getState());
                historico.registar(ordem.getState() ? "Lâmpada ligada" : "Lâmpada desligada");
            }

            // TODO: receive and handle messages from server

            // TODO: for first phase: create an appropriate event hardcoded locally and change the GUI accordingly
        }
    }

}
