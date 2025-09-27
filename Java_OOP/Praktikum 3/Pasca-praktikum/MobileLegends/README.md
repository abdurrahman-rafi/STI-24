#Evaluasi dari 60 - 90 - 100
(Skor 60 -> 90)
1. Miss satu ! di Hero.attack

2. Miss tidak mengupdate stealth di backstab()

3. Tidak clamp effective damage pada takeDamage(), jadinya damage bisa negatif. Harusnya clamp min ke 0. (bisa pake math max)

(Skor 90 -> 100)
4. Penghitungan damage assassin harusnya tidak di rounding, cukup truncate/casting. Kalau dilihat angkanya (187) itu 1.5 * 125 jadinya 187.5 -> 187. Kalau rounding jadi 188 tidak sesuai contoh.

Disini aku gak konsisten kadang pake println terus String.format atau println terus pake ("" dan +), sesuaikan saja gimana enaknya.

