/* 
* Objek berinteraksi dengan objek lain melalui message, bukan fungsi
* Message mirip procedure call

Class
* Sebagai blueprint atau template objek
* Sepeda x adalah instance dari class sepeda X. class sepeda adalah blueprint dari sepeda x 
*/

/*
Nama kelas konvensi selalu diawali huruf besar, lalu setiap Class dibuat dalam 1 file dan file tersebut
dinamakan sesuai nama class

Compiler java = javac

cmd javac point.java seperti make, menghasilkan Point.class
*/
// public class Point {
//     public int x = 0;
//     public int y = 0;
//     // konstruktor untuk point otomatis jalan ketika memangiil class
//     public Point(int a, int b){
//         // if (a < 0){
//         //     a = 0;
//         // }

//         // if (b < 0){
//         //     b = 0;
//         // }
//         x = a; y= b;
//     }
// }

/*
new artinya menginisiasi sebuah instance objek

Point originOne;
originOne = new Point(1,1)
*/