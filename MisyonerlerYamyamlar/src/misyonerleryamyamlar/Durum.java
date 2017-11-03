package misyonerleryamyamlar;

/**
 * @author Burakcan Timuçin
 */

public class Durum {
    int m;  // Sol kıyıdaki misyonerlerin sayısı
    int y;  // Sol kıyıdaki canavarların sayısı
    int b;  // Botun sadece sağ kıyıda olma durumu
    Durum p;  // Önce gelen, hangi durumdan gelindiği
    
    // Oyunun başlangıç durumu
    Durum(){ m = 3; y = 3; b = 0; }
    
    Durum(Durum s){ m = s.m; y = s.y; b = s.b; }
    
    Durum(int m, int y, int b){ this.m = m; this.y = y; this.b = b; }
    
    boolean Dogruluk(){
        /* Değişkenlerin doğruluğunu test etmek */
        if (m < 0 || m > 3 || y < 0 || y > 3) return false;
        if (3-m < 0 || 3-m > 3 || 3-y < 0 || 3-y > 3) return false;
        if (m > 0 && y > m) return false;
        if (3-m >0 && 3-y > 3-m) return false;
        return true;
    }
    
    /* Nehir boyunca hareket eden misyonerler ve yamyamların
       ulaştıkları sonucu döndürmek için kullanılan metot
     */
    
    Durum Hareket(int Mis, int Yam)
    { Durum ans = new Durum(this);
      if (b == 0) { ans.m = m - Mis; ans.y = y - Yam; ans.b = 1; }
      else { ans.m = m + Mis; ans.y = y + Yam; ans.b = 0; }
      ans.p = this;
      return ans;
    }
    
    /* Konsol ekranda gösterilecek çıktıları sağlar */
    void Cikti() { System.out.println(m + " " + y + " " + (b == 0 ? 'L' : 'R')); }
}
