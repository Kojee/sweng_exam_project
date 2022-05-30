package views;

import javax.swing.*;

public class CountryView extends JPanel {
    private JLabel testLabel;

    public CountryView(){
        testLabel = new JLabel("Countries go here");
        add(testLabel);
    }
}
