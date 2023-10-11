import javax.swing.*;
import java.awt.event.*;

class Main {
    public static void main(String[] args) {
        JFrame j = new JFrame();

        JButton b = new JButton("button");
        b.setBounds(130, 100, 100, 35);

        j.add(b);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("clicked");
            }

        });
        j.setSize(400, 500);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}