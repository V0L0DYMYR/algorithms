package geometry.triangulation;

import edu.princeton.cs.introcs.Draw;
import geometry.dto.Point;
import geometry.dto.Segment;
import geometry.dto.Triangle;
import geometry.utils.DrawHelper;

import java.awt.Color;
import java.util.*;

public class IncrementDelaunayTest {
  public static void main(String[] args) {

    List<Point> verteses = new ArrayList();

    verteses.add(new Point(250, 200)); //3
    verteses.add(new Point(375, 25));  //1
    verteses.add(new Point(500, 150)); //2

//
    verteses.add(new Point(400, 225)); //4

    verteses.add(new Point(600, 300)); //5
    verteses.add(new Point(375, 300)); //6
    verteses.add(new Point(270, 300)); //7

    verteses.add(new Point(420, 350)); //8
    verteses.add(new Point(380, 450)); //9

    Collections.shuffle(verteses);

    AbstractTriangulation triangulation = new IncrementDelaunay(verteses);


    Set<Segment> edges = new HashSet();
    for (Triangle T : triangulation.triangles()) {
      for (int i = 0; i < 3; i++) {
        edges.add(T.side(i));
      }
    }

    List<Segment> segments = new ArrayList<>();
    segments.addAll(edges);

    Draw draw = new Draw();
    draw.setCanvasSize(800, 600);
    draw.setXscale(0, 800);
    draw.setYscale(0, 600);
    draw.setPenColor(Color.RED);
    DrawHelper.drawSegments(draw, segments);
    draw.setPenColor(Color.BLUE);
    DrawHelper.drawPoints(draw, verteses, 5.);
  }
}
