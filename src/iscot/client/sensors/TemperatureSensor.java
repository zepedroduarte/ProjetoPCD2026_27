package iscot.client.sensors;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iscot.client.gui.SensorControl;
import iscot.enums.Areas;
import iscot.events.sensor.TemperatureSensorEvent;

public class TemperatureSensor {

    /**
     *
     * @param server address and port
     * @param roomName: string
     * @throws IOException
     * @throws UnknownHostException
     * @throws NumberFormatException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        if(args.length!=3) {
            System.err.println("Invalid arguments!");
        }
        else {
            // TODO connect to the server

            // TODO register with the server
            Areas area=Areas.valueOf(args[2]);


            JFrame janela = new JFrame("Temperatura em "+area);
            janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            // Criar os componentes gráficos
            JPanel painel=new JPanel();
            painel.setLayout(new BorderLayout());
            SensorControl sensorControl= new SensorControl( "🌡", "Temperatura - "+area, "°C",
                    0, 40, 1, 20,
                    valor -> {
                        // TODO handle change in sensor
                        System.out.println(new TemperatureSensorEvent(area, valor));
                    });
            painel.add(sensorControl,BorderLayout.CENTER);
            janela.setContentPane(painel);
            janela.setLocation(600, 400);
            janela.setMinimumSize(janela.getSize());
            janela.pack();
            janela.setVisible(true);

        }
    }

}
