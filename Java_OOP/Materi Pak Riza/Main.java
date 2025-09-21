public class Main{
    public static void main(String[] args){
        System.out.println("Hello World!");
        PointRafi originOne = new PointRafi(1,1);
        RectangleRafi rectOne = new RectangleRafi(originOne,100,200);
        //Untuk panggil method, ternyata buka dulu objek lalu cari method, tidak langsung call methodnya. Karena methodnya ada di dalem class objectnya
        originOne.printPoint(originOne);
        rectOne.printRect(rectOne);

        rectOne.move(10, 10);
        originOne.printPoint(originOne);

        rectOne.edit(rectOne, 50, 20);

        rectOne.printRect(rectOne);
        
    }
    // originOne = reference, point berarti isi yang di refer oleh originOne

}