package org.example;

//import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Robot {
    private int[][] map;
    private int size;
    private boolean penDown;
    private DirectionEnum direction;
    private int x, y;
    private RobotUI ui;


//    public Robot(int size) {
//        this.size = size;
//        x = 0;
//        y = 0;
//        direction = DirectionEnum.NORTH;
//        penDown = false;
//        map = new int[size][size];
//        ui = new RobotUI(this, size);
//    }
    
    //added
    public Robot() {
        this.size = 5; // Set default size as 5 (or any default value you'd prefer)
        this.x = 0;
        this.y = 0;
        this.direction = DirectionEnum.NORTH;
        this.penDown = false;
        this.map = new int[size][size];
        this.ui = new RobotUI(this, size);
    }

    //added
    public Robot(int size) {
        this.size = size;
        this.x = 0;
        this.y = 0;
        this.direction = DirectionEnum.NORTH;
        this.penDown = false;
        this.map = new int[size][size];
        this.ui = new RobotUI(this, size);
    }

    public int getSize() {
        return size;
    }
    
    //added
    public void setSize(int size) {
        this.size = size;
        this.map = new int[size][size]; // Reset the map based on new size
    }

    public boolean isPenDown() {
        return penDown;
    }
    
    //added
    public void setPenDown(boolean penDown) {
        this.penDown = penDown;
    }

    public int[][] getMap() {
        return map;
    }

    public int getX() {
        return x;
    }

    //added
    public void setX(int x) {
        this.x = x;
    }
    
    public DirectionEnum getDirection() {
        return direction;
    }
    
    //added
    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public int getY() {
        return y;
    }
    
//    //added
//    public void setY(int y) {
//        this.y = y;
//    }

    public void downPen() {
        penDown = true;
    }

    public void upPen() {
        penDown = false;
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }
    
    //added
    public int getMapValue(int x, int y) {
        return map[y][x];
    }
    
    public void showStatus() {
        String statusResult = "Position: " + x + ", " + y + " - Pen: " + (penDown ? "down" : "up")
                + " - Facing: " + direction.getDescription();
        System.out.println(statusResult);
    }

    public void printMap() {
        IntStream.range(0, size)
                .mapToObj(y -> IntStream.range(0, size)
                        .mapToObj(x -> map[size - 1 - y][x] == 1 ? "*" : " ")
                        .collect(Collectors.joining("")))
                .forEach(System.out::println);
    }


    public void move(int steps) {
        if (penDown) map[y][x] = 1;
        IntStream.range(0, steps).forEach(i -> {
            switch (direction) {
                case NORTH:
                    if (y + 1 < size) y++;
                    break;
                case EAST:
                    if (x + 1 < size) x++;
                    break;
                case SOUTH:
                    if (y - 1 >= 0) y--;
                    break;
                case WEST:
                    if (x - 1 >= 0) x--;
                    break;
            }
            if (penDown) {
                map[y][x] = 1;
            }
        });
    }

    //added
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void updateUI() {
        ui.updateUI();
    }


}