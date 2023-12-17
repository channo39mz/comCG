import java.awt.*;
import javax.swing.*;

public class MyNewYeradragon extends JPanel{
    public static void main(String[] args) {
        MyNewYeradragon m = new MyNewYeradragon();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void paintComponent(Graphics g) {
        bresenhamLine(g, 155, 123, 153, 152);
        bresenhamLine(g, 142, 414, 133, 306);
        bresenhamLine(g, 142, 414, 280, 402);
        bresenhamLine(g, 321, 398, 439, 390);
        bresenhamLine(g, 439, 390, 429, 270);
        bresenhamLine(g, 429, 270, 228, 294);

        int[] xPoints = {133, 141, 163, 196, 219, 228 };
        int[] yPoints = {306, 302, 305, 301, 292, 294 };
        g.drawPolyline(xPoints, yPoints, xPoints.length);
    }
    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 2, 2);
    }

    public void bresenhamLine(Graphics g ,int x1 , int y1 , int x2 , int y2){
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;

        if (dy > dx) {
            int temp = dx;
            dx = dy;
            dy = temp;
            isSwap = true;
        }

        int D = 2 * dy - dx;
        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++) {
            plot(g, x, y);

            if (D >= 0) {
                if (isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;
        }
    }
}
