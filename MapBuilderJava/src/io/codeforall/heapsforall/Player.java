package io.codeforall.heapsforall;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {

     private Rectangle playerRectangle;
     private Grid grid;
    private int x;
    private int y;

    public Player(int x, int y , Grid grid){
        this.grid = grid;
        new Controls(this,grid);
        this.x = x;
        this.y= y;
        playerRectangle = new Rectangle(x + Grid.PADDING,y +Grid.PADDING,Grid.PIXEL_SIZE,Grid.PIXEL_SIZE);
        playerRectangle.draw();
        playerRectangle.setColor(Color.CYAN);
        playerRectangle.fill();
    }

    public void moveUp(){

            if(playerRectangle.getY()>Grid.PADDING) {
                playerRectangle.translate(0, -Grid.PIXEL_SIZE);
                y -= 1;
            }

    }

    public void moveDown(){
        if(playerRectangle.getY()<(Grid.getRows()*Grid.PIXEL_SIZE) - Grid.PIXEL_SIZE) {
            playerRectangle.translate(0, Grid.PIXEL_SIZE);
            y += 1;
        }
    }

    public void moveLeft(){
        if(playerRectangle.getX()>Grid.PADDING) {
            playerRectangle.translate(-Grid.PIXEL_SIZE, 0);
            x -= 1;
        }
    }

    public void moveRight(){
        if(playerRectangle.getX() < (Grid.getCols()*Grid.PIXEL_SIZE)-Grid.PIXEL_SIZE) {
            playerRectangle.translate(Grid.PIXEL_SIZE, 0);
            x += 1;
        }
    }

    public void paint() {
        if (!grid.getCells()[x][y].isPainted()) {
            grid.getCells()[x][y].getRectangle().setColor(Color.DARK_GRAY);
            grid.getCells()[x][y].getRectangle().fill();
            grid.getCells()[x][y].setPainted(true);
        }
    }
        public void erase(){
            if(grid.getCells()[x][y].isPainted()){
                grid.getCells()[x][y].rectangle.draw();
                grid.getCells()[x][y].setPainted(false);
            }
        }

}
