public class Fruit {
    private FruitType type;
    
    public Fruit(FruitType type) {
      this.type = type;
    }
    
    private void announceFruitType() {
      // Mencetak nama buah dalam bahasa Indonesia sesuai dengan type dan diakhiri new line
      // tanpa tanda kutip
      // Contoh: "Apel"
      switch(this.type) {
          case APPLE:
            System.out.println("Apel");
            break;
        case ORANGE:
            System.out.println("Jeruk");
            break;
        case BANANA:
            System.out.println("Pisang");
            break;
        case WATERMELON:
            System.out.println("Semangka");
            break;
        default:
            assert false;
            break;
      }
      
      // Gunakan assert untuk mengetes asumsi bahwa kode tidak akan masuk ke bagian selain
      // FruitType yang telah didefinisikan
      // ...
    }

    
    private void peel() {
      // Memastikan bahwa FruitType dari objek ini adalah ORANGE atau BANANA
      // ...
      assert (this.type.equals(FruitType.BANANA) || this.type.equals(FruitType.ORANGE));
      System.out.println("Peeling " + this.type);
  
      // Mencetak "Peeling " tanpa tanda kutip diikuti dengan type dan new line
      // Contoh: "Peeling BANANA"
    }
  
    private void press() {
        // Memastikan bahwa FruitType dari objek ini adalah bukan BANANA
        // ...
        assert !this.type.equals(FruitType.BANANA);
        System.out.println("Pressing " + this.type);
        // Mencetak "Peeling " tanpa tanda kutip diikuti dengan type dan new line
        // Contoh: "Pressing WATERMELON"
    }
  
    private void removeCore() {
      // Memastikan bahwa FruitType dari objek ini adalah APEL
      // ...
        assert this.type == FruitType.APPLE;
        System.out.println("Removing core " + this.type);
      // Mencetak "Removing core " tanpa tanda kutip diikuti dengan type dan new line
      // Contoh: "Removing core APPLE"
    }
  
    // Suatu saat, bila ada programmer yang ingin menambahkan method public,
    // Ia sadar kalau tidak semua method dapat dipanggil, tergantung fruitType.
    // Method di atas private, sehingga boleh menggunakan assertion.
    // Bila public, sebaiknya menggunakan exception dibanding assertion.
  }