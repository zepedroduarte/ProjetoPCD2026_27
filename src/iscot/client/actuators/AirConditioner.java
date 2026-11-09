package iscot.client.actuators;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.*;

import iscot.client.gui.HistoryPanel;
import iscot.client.gui.ACIcon;
import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;
import iscot.events.order.AreaTemperatureOrderEvent;
import iscot.events.order.AreaVentilationOrderEvent;
import iscot.events.order.HighLevelOrderEvent;

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

            HighLevelOrderEvent[] ordens = {
                    new AreaTemperatureOrderEvent(area, AirConditioningMode.Aquecimento, 24),
                    new AreaTemperatureOrderEvent(area, AirConditioningMode.Desligado, 24),
            };

            for (HighLevelOrderEvent ordem : ordens) {
                Thread.sleep(3000);
                System.out.println(ordem);

                if (ordem instanceof AreaTemperatureOrderEvent t) {
                    ac.setModo(t.getMode());
                    if (t.getMode() == AirConditioningMode.Desligado) {
                        historico.registar("AC desligado");
                    } else {
                        ac.setTemperatura(t.getTemperature());
                        historico.registar("AC em modo " + t.getMode() + " a " + t.getTemperature() + " °C");
                    }
                }
            }


            // TODO: receive and handle messages from server

            // TODO: for first phase: create an appropriate event hardcoded locally and change the GUI accordingly
        }
    }

}
