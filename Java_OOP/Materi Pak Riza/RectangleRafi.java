public class RectangleRafi{
    public int height = 0;
    public int width = 0;
    public PointRafi origin;

    public RectangleRafi(){
        origin = new PointRafi(0,0);
    }

    public RectangleRafi(PointRafi p){
        origin = p;
    }

    public RectangleRafi(int w, int h){
        width = w;
        height = h;

    }

    public RectangleRafi(PointRafi p, int w, int h){
        width = w;
        height = h;
        origin = p;
    }

    public void move(int x, int y){
        origin.x = x;
        origin.y = y;
    }

    public void edit(RectangleRafi r, int w, int h){
        r.height = h;
        r.width = w;
        System.out.println("Width and height changed\n");
    }

    public int getarea(){
        return width * height;
    }

    public void printRect(RectangleRafi r){
        System.out.println("Origin point:");
        origin.printPoint(origin);
        System.out.println("Width: "+ width + "\nHeight: " + height + "\nArea: " + getarea() + "\n");

    }
}