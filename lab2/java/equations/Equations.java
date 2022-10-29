package equations;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Equations {
    private final double a, b, c, d, e, f;

    public Equations(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public String toString() {
        return a + "x + " + b + "y = " + c + "\n" + d + "x + " + e + "y = " + f;
    }

    public void print() {
        List<Double> solution = solve();
        System.out.println(this);
        if (solution == null) {
            System.out.println("No or infinitely many solutions.");
        } else {
            System.out.println("x = " + solution.get(0) + "  y = " + solution.get(1));
        }
    }

    public Double detW() {
        return a * e - b * d;
    }

    public Double detWx() {
        return c * e - b * f;
    }

    public Double detWy() {
        return a * f - c * d;
    }

    public List<Double> solve() {
        if (detW() != 0) {
            return List.of(detWx() / detW(), detWy() / detW());
        } else {
            return null;
        }
    }

    public void graph(String filename, int width, int height) {
        List<Double> solution = solve();
        if (solution == null) {
            return;
        }

        BufferedImage myPicture = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        // draw background
        g.setColor(Color.WHITE);
        g.fillRect(0,0, myPicture.getWidth(), myPicture.getHeight());

        // draw coordinates
        g.setColor(Color.BLACK);
        g.drawLine(myPicture.getWidth() / 2, myPicture.getHeight(), myPicture.getWidth() / 2,0);
        g.drawLine(0, myPicture.getHeight() / 2, myPicture.getWidth(),myPicture.getHeight() / 2);

        // draw a solution
        g.setColor(Color.RED);
        int x = solution.get(0).intValue() + myPicture.getWidth() / 2;
        int y = -solution.get(1).intValue() + myPicture.getHeight() / 2;
        g.drawRect(x , y, 1, 1);

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }
    }
}
