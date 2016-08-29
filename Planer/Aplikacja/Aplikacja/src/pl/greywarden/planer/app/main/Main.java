package pl.greywarden.planer.app.main;

import javax.swing.*;
import pl.greywarden.planer.app.gui.OknoGlowne;

public class Main {

    public static void main(String... args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println("Błąd podczas ustawiania L&F");
            System.err.println("Komunikat błędu:" + e.getLocalizedMessage());
            System.err.println("Ustawianie domyślnego L&F");
        } finally {
            SwingUtilities.invokeLater(() -> {
                new OknoGlowne().setVisible(true);
            });
        }
    }

}
