package io.codeforall.heapsforall;


import org.academiadecodigo.simplegraphics.graphics.Color;


import java.io.*;
import java.util.LinkedList;

public class Grid {
    public static final int PADDING = 10;

    private static int cols;

    private GridPosition[][] cells;
    private static int rows;

    public static final int PIXEL_SIZE = 30;

    public Grid(int cols,int rows){
        this.cols = cols;
        this.rows = rows;
        init();
    }





    public void init(){
        cells = new GridPosition[this.cols][this.rows];

      for(int i = 0; i < this.cols;i++){
          for(int j = 0; j < this.rows;j++){
              cells[i][j] = new GridPosition(i,j,this);
              cells[i][j].getRectangle().draw();
          }
      }
    }


    public void saveFile(){
        LinkedList<String> rectanglesPainted = new LinkedList<>();
        for(int i = 0 ; i<cols; i++) {
            for(int j = 0; j<rows; j++) {
                if(cells[i][j].getRectangle().isFilled()) {
                    rectanglesPainted.add(i+":"+j);
                }
            }
        }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("files/saveFile.txt"));
                    for(String str:rectanglesPainted){
                        writer.write(str + "\n");
                    }
                    writer.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
    }

    public void loadFile(){
        clearGrid();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("files/saveFile.txt"));
            String line = "";
            Integer colNum;
            Integer rowNum;
            while((line = reader.readLine()) != null ){
                colNum = Integer.valueOf(line.split(":")[0]);
                rowNum = Integer.valueOf(line.split(":")[1]);
                cells[colNum][rowNum].getRectangle().setColor(Color.DARK_GRAY);
                cells[colNum][rowNum].getRectangle().fill();
            }
        } catch (IOException e) {
            System.out.println("Problem with the Load");
        }

    }

    public void clearGrid(){
        for(int i = 0 ; i<cols; i++) {
            for(int j = 0; j<rows; j++) {
                if(cells[i][j].getRectangle().isFilled()) {
                    cells[i][j].getRectangle().draw();
                    getCells()[i][j].setPainted(false);
                }
            }
        }
    }



    public static int getRows() {
        return rows;
    }

    public static int getCols() {
        return cols;
    }

    public GridPosition[][] getCells(){
        return cells;
    }






}
