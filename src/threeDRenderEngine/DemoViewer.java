package threeDRenderEngine;//Why would you want to build a 3D engine?
// At the very least, it will really help understanding
// how real modern engines do their black magic.
// Also it is sometimes useful to add 3D rendering capabilities
// to your application without calling to huge external dependencies.
// In case of Java, that means that you can build 3D viewer app with
// zero dependencies (apart from Java APIs) that will run almost anywhere - and fit into 50kb!


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

//GUI
public class DemoViewer {
    public static void main(String[] args) {

        // just create 4 triangles and add them to a list:
        List<Triangle> tris = new ArrayList<>();

        tris.add(new Triangle(new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(-100, 100, -100),
                Color.WHITE));
        tris.add(new Triangle(new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, -100),
                Color.RED));
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, 100),
                Color.GREEN));
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(-100, -100, 100),
                Color.BLUE));

        //Resulting shape is centered at origin (0, 0, 0

        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout( new BorderLayout());

        //slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0 , 360 , 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        //slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90,90,0);
        pane.add(pitchSlider, BorderLayout.EAST);

        //panel to display render results
        JPanel renderPanel = new JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0 , 0 , getWidth() , getHeight());

                //rendering will happen here

                g2.translate(getWidth() / 2 , getHeight() / 2);
                g2.setColor(Color.WHITE);
                for (Triangle t : tris) {
                    Path2D path = new Path2D.Double();
                    path.moveTo(t.v1.x, t.v1.y);
                    path.lineTo(t.v2.x, t.v2.y);
                    path.lineTo(t.v3.x, t.v3.y);
                    path.closePath();
                    g2.draw(path);
                }
            }
        };

        pane.add(renderPanel,BorderLayout.CENTER);

        frame.setSize(400 , 400);
        frame.setVisible(true);

    }


}




