import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Janela extends JFrame
{
    ImageIcon image = new ImageIcon("C:/Users/Lucas/Downloads/zull/zull/final.jpeg");
    JLabel imagelabel = new JLabel(image);
    
    public Janela () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        add(imagelabel);
    }
}
