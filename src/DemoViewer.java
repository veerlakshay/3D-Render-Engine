//Why would you want to build a 3D engine?
// At the very least, it will really help understanding
// how real modern engines do their black magic.
// Also it is sometimes useful to add 3D rendering capabilities
// to your application without calling to huge external dependencies.
// In case of Java, that means that you can build 3D viewer app with
// zero dependencies (apart from Java APIs) that will run almost anywhere - and fit into 50kb!

import javax.swing.*;
import java.awt.*;

//GUI
public class DemoViewer {
    public static void main(String[] args) {

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
            }
        };

        pane.add(renderPanel,BorderLayout.CENTER);

        frame.setSize(400 , 400);
        frame.setVisible(true);

    }
}

//Vertex is simply a structure to store our three coordinates (X, Y and Z),
// and triangle binds together three vertices and stores its color.

class Vertex{
    double x;
    double y;
    double z;

    Vertex(double x , double y , double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Trianle {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;

    public Trianle(Vertex v1 , Vertex v2 ,Vertex v3, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
}
