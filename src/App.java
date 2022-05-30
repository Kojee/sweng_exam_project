import views.CountryView;
import views.ProviderView;
import views.StatusView;
import views.TypeView;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private JPanel filtersPanel;
    private JPanel servicesPanel;
    private CountryView countryView;
    private ProviderView providerView;
    private StatusView statusView;
    private TypeView typeView;
    public App(){
        setTitle("Trusted Services");
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        countryView = new CountryView();
        providerView = new ProviderView();
        statusView = new StatusView();
        typeView = new TypeView();
        filtersPanel = new JPanel();
        filtersPanel.add(countryView);
        filtersPanel.add(providerView);
        filtersPanel.add(statusView);
        filtersPanel.add(typeView);
        Container pane = getContentPane();
        pane.add(filtersPanel, BorderLayout.PAGE_START);

        servicesPanel = new JPanel();
        servicesPanel.add(new JLabel("Services go here"));
        pane.add(servicesPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var app = new App();
            app.setVisible(true);
        });
    }
}
