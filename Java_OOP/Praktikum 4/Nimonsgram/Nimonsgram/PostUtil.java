/**
 * PostUtil.java
 * 
 * Utility class untuk membandingkan engagement antar postingan.
 * Memanfaatkan interface Engageable sebagai type.
 */
public class PostUtil{

    /**
     * Membandingkan dua objek Engageable dan mengembalikan objek dengan engagement lebih tinggi.
     *
     * HINT: Manfaatkan compareEngagement dari interface Engageable tiap objeknya
     * Asumsikan bahwa a dan b adalah objek yang memiliki method compareEngagement yang sama
     * 
     * @param a objek pertama
     * @param b objek kedua
     * @return objek dengan engagement lebih tinggi (a atau b)
     */
    public static Engageable findHigher(Engageable a, Engageable b) {
      int comp = a.compareEngagement(b);

      if(comp > 0){
        return a;
      }else{
        return b;
      }
    }
  
    /**
     * Mengecek apakah dua objek Engageable memiliki engagement yang sama.
     *
     * HINT: Manfaatkan compareEngagement dari interface Engageable tiap objeknya
     * Asumsikan bahwa a dan b adalah objek yang memiliki method compareEngagement yang sama
     * 
     * @param a objek pertama
     * @param b objek kedua
     * @return true jika sama, false jika berbeda
     */
    public static boolean isEqual(Engageable a, Engageable b) {
        return (a.compareEngagement(b) == 0);
    }
  }