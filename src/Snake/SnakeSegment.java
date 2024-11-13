package Snake;

public class SnakeSegment {
    public static int size = 35;
    int x;
    int y;
    int right_x;
    int bottom_y;

    public SnakeSegment(int x, int y, int right_x, int bottom_y){
        this.x = x;
        this.y = y;
        this.bottom_y = bottom_y;
        this.right_x = right_x;

    }

    public SnakeSegment(){}
}
