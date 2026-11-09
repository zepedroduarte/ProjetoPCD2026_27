package iscot.client.gui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Painel com o histórico de ações de um atuador.
 * Cada ação fica numa linha no formato "Ação - HH:mm:ss".
 */
public class HistoryPanel extends JScrollPane {

    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final JTextArea textArea;

    public HistoryPanel() {
        textArea = new JTextArea(6, 25);
        textArea.setEditable(false);
        setViewportView(textArea);
        setBorder(BorderFactory.createTitledBorder("Histórico de ações"));
    }

    public void registar(String acao) {
        String linha = acao + " - " + LocalTime.now().format(FORMATO_HORA) + "\n";
        SwingUtilities.invokeLater(() -> {
            textArea.append(linha);
            textArea.setCaretPosition(textArea.getDocument().getLength());
        });
    }
}
