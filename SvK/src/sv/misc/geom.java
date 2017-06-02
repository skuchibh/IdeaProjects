package sv.misc;
import java.awt.*;
import java.awt.geom.*;
/**
 * Created by Surya Vamsi on 18-Jul-15.
 */
public class geom extends Frame{
    @Override
    public void paint(Graphics g) {
        Rectangle2D shape=new Rectangle2D.Float();
        shape.setFrame(100,150,200,100);
        //Graphics2D gg= (Graphics2D) g;
        //gg.draw(shape);
        ((Graphics2D) g).draw(shape);

    }

    public static void main(String[] args) {
    geom g=new geom();
        g.setVisible(true);
        g.setSize(400,400);
    }
}
