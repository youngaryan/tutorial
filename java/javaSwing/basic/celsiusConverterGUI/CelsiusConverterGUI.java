import java.awt.Component;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

public class CelsiusConverterGUI extends JFrame {

    public CelsiusConverterGUI() {
        generateGUI();
    }

    private JTextField tempText;
    private JButton convert;
    private JLabel celsiusLabel;
    private JLabel farenhiteLabel;

    private void generateGUI() {
        tempText = new JTextField();
        convert = new JButton();
        celsiusLabel = new JLabel();
        farenhiteLabel = new JLabel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Celsius Converter");

        celsiusLabel.setText("Celsius");

        convert.setText("Convert");

        convert.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonActionPerformed(e);
            }
        });

        farenhiteLabel.setText("Fahrenheit");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(tempText, GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(celsiusLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(convert)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(farenhiteLabel)))
                                .addContainerGap(27, Short.MAX_VALUE)));

        layout.linkSize(SwingConstants.HORIZONTAL,
                new Component[] { convert, tempText });

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(celsiusLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(convert)
                                        .addComponent(farenhiteLabel))
                                .addContainerGap(21, Short.MAX_VALUE)));
        pack();
    }

    private void convertButtonActionPerformed(ActionEvent e) {
        int tempFar = (int) ((Double.parseDouble(tempText.getText())) * 1.8 + 32);

        farenhiteLabel.setText(tempFar + " Fahrenheit");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CelsiusConverterGUI().setVisible(true);
            }

        });
    }
}