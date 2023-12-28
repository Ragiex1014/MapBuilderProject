package io.codeforall.heapsforall;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GridPosition {

    private int x;

    private int y;

    private Grid grid;

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public boolean isPainted() {
        return isPainted;
    }

    private boolean isPainted;
    public  Rectangle rectangle;

    public GridPosition(int x,int y,int size){
        Rectangle painted = new Rectangle(x,y,size,size);
        painted.setColor(Color.MAGENTA);
        painted.draw();
        painted.fill();
    }
    public GridPosition(int x, int y, Grid grid){
        this.grid = grid;
        this.x = x;
        this.y = y;
        rectangle = new Rectangle((x*Grid.PIXEL_SIZE)+ Grid.PADDING ,(y*Grid.PIXEL_SIZE) + Grid.PADDING,Grid.PIXEL_SIZE,Grid.PIXEL_SIZE);
        rectangle.draw();
    }


    public  Rectangle getRectangle() {
        return rectangle;
    }
}
