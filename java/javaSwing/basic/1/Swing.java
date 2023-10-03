import javax.swing.JFrame;
import javax.swing.JLabel;

public class Swing {

    private static void createAndShowGUI() {
        JFrame jFrame = new JFrame("Hello P");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel("Hello P");
        jFrame.getContentPane().add(jLabel);

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}