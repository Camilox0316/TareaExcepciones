import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ExcepcionSinOrden extends Exception{
    JDialog mensaje;
    JPanel panel;
    JLabel etiqueta;
    public ExcepcionSinOrden(JFrame pventana){
     mensaje = new JDialog(pventana, "ERROR!");
     panel = new JPanel(new GridLayout(1,1));
     etiqueta = new JLabel("¡Orden incorrecto! Se reinicia el patrón...");
     panel.add(etiqueta, BorderLayout.CENTER); mensaje.add(panel);
     mensaje.setSize(300, 100);
     mensaje.setVisible(true);
}
}
