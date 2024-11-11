package threeDRenderEngine;

import java.awt.*;


//threeDRenderEngine.Vertex is simply a structure to store our three coordinates (X, Y and Z),
// and triangle binds together three vertices and stores its color.


class Triangle {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;

    public Triangle(Vertex v1 , Vertex v2 ,Vertex v3, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
}