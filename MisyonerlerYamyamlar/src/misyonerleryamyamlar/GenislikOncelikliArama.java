package misyonerleryamyamlar;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Burakcan Timuçin
 */

public class GenislikOncelikliArama {
    
    /*  3 boyutlu ZiyaretEdilen değişkeninin amacı
        misyoner, canavar ve botun alabileceği
        her türlü durumu kontrol edebilmek içindir.
    */
    
    static boolean[][][] ZiyaretEdilen = new boolean[4][4][2];
    
    /*  Başlangıçta (3, 3, L) olan durumdan (0, 0, R) durumuna gelmek için
        en düşük mesafeyi kullanarak ulaşmak adına Genişlik Öncelikli Arama
        yöntemini kullanacağız. Mesafe, nehir geçişlerinin sayısıdır.
    */
    
    static int GenislikOncelikliArama()
    {
        Queue<Durum> Kuyruk;
        Kuyruk = new LinkedList<>();
        Durum Basla = new Durum(3, 3, 0);
        Kuyruk.add(Basla);
        while (Kuyruk.peek() != null) {  // Kuyruk boş değil iken
            Durum Sonraki = Kuyruk.poll();  // Kuyruktaki eleman silinir
            /*
                İstenilirse çıktı olarak yansıtılabilir.
                System.out.print("Çıkarılan "); Sonraki.Cikti();
            */
            
            //En kısa olanı bulmak için
            if(Sonraki.m == 0 && Sonraki.y == 0 && Sonraki.b == 1) {
               Durum d;
               int adet = 0;
               for(d = Sonraki; d != null; d = d.p) { 
                   d.Cikti(); ++adet; 
               }
               return adet - 1;
            }
            
            // Komşular oluştur ve ziyaret edilmeyen komşular ekle
            for(int i=0; i<=2; i++) {
               for(int j=0; i+j<=2; j++) {
                   if(i == 0 && j == 0) continue; // Sıraya girme zorunluluğu
                   Durum p = Sonraki.Hareket(i, j);
                   if(!p.Dogruluk()) continue;
                   if(ZiyaretEdilen[p.m][p.y][p.b]) continue;
                   ZiyaretEdilen[p.m][p.y][p.b] = true;
                   /*
                       İstenilirse çıktı olarak yansıtılabilir.
                       System.out.print("Eklenen "); p.Cikti();
                   */
                   Kuyruk.add(p);
               } 
            }
       }
       // Çözüm olmadığı durumda buraya gelinecektir ki çözüme ulaşacaktır.
       System.out.println("Program başarısızlığa uğradı!");
       return -1; // Buraya gelemeyiz
    }
    
    public static void main(String[] args) {
        int TekneSeferi = GenislikOncelikliArama();
        System.out.println(TekneSeferi + " defa tekne seferi gerekiyordu.");
    }
}
