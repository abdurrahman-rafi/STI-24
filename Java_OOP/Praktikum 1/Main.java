import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String nama = scanner.next();
        int angka = scanner.nextInt();
        scanner.nextLine();
        String kalimat = scanner.nextLine();

        System.out.println(nama);
        System.out.println(angka);
        System.out.println(kalimat);

    }
}