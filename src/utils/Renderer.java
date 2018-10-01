package utils;

import java.awt.image.BufferedImage;

public class Renderer {

    private int color;
    private BufferedImage img;

    public Renderer (BufferedImage img){
        this.img = img;
        color = color.RED.getRGB();
    }


    private void drawPixel( int x, int y) {
        img.setRGB(x, y, color);
    }

    private void lineTrivial(int x1, int y1, int x2, int y2 ){

    }
}
