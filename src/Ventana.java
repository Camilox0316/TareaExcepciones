import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.* ;

public class Ventana implements ActionListener{
    JFrame ventana;
    JPanel panelBoton;
    static int cantidadBotones = 3;
    int contador = 1;
    JButton arregloBotones[];
    

    public Ventana(){
        ventana = new JFrame("Usando excepciones");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearPanelBoton();
        ventana.setSize(new Dimension (800,800));
        ventana.setMinimumSize(new Dimension(400,400));
        ventana.pack(); ventana.setVisible(true);
    }

    public void crearPanelBoton(){
        arregloBotones = new JButton[cantidadBotones];
        panelBoton = new JPanel(); panelBoton.setLayout(new GridLayout(1,3));
        for (int i=0;i<cantidadBotones;i++){
            arregloBotones[i] = new JButton((i + 1)+"");
            arregloBotones[i].setForeground(Color.white);
            arregloBotones[i].setBackground(Color.red);
            arregloBotones[i].addActionListener(this);
            panelBoton.add(arregloBotones[i], BorderLayout.CENTER);
        }
        ventana.add(panelBoton,  BorderLayout.CENTER);
    }
    public void verificarOrden(int pposicion) {
        try{
        if (pposicion == contador){
            arregloBotones[pposicion-1].setBackground(Color.GREEN);
            contador++;
        }
        else {
            for (int i=0;i<cantidadBotones;i++){arregloBotones[i].setBackground(Color.red);}
            throw new ExcepcionSinOrden(this.ventana);
            
        }
    }
    catch (ExcepcionSinOrden e){
            contador = 1;
    }
    finally{
        if (contador == 4){
            JOptionPane.showMessageDialog(ventana, "¡Felicidades, has descifrado el orden! ¡¡¡Ganaste!!!");
            System.exit(0);
        }
    }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for (int i=0;i<cantidadBotones;i++){
            if (e.getSource().equals((arregloBotones[i]))){
                verificarOrden(Integer.parseInt(arregloBotones[i].getText()));
            }
    }
        
    }

}