public class Fruit {
  private FruitType type;
  
  public Fruit(FruitType type) {
    this.type = type;
  }
  
  private void announceFruitType() {
    // Mencetak nama buah dalam bahasa Indonesia sesuai dengan type dan diakhiri new line
    // tanpa tanda kutip
    // Contoh: "Apel"
    String fruitInString = "";
    switch (type) {
      case APPLE:
        fruitInString = "Apel";
        break;
      case ORANGE:
        fruitInString = "Jeruk";
        break;
      case BANANA:
        fruitInString = "Pisang";
        break;
      case WATERMELON:
        fruitInString = "Semangka";
        break;
    }
    
    // Gunakan assert untuk mengetes asumsi bahwa kode tidak akan masuk ke bagian selain
    // FruitType yang telah didefinisikan
    // ...
    assert fruitInString != "";
    
    System.out.println(fruitInString);
  }
  
  private void peel() {
    // Memastikan bahwa FruitType dari objek ini adalah ORANGE atau BANANA
    // ...
    assert (this.type == FruitType.BANANA) || (this.type == FruitType.ORANGE);

    // Mencetak "Peeling " tanpa tanda kutip diikuti dengan type dan new line
    // Contoh: "Peeling BANANA"
    System.out.println("Peeling " + this.type);
  }

  private void press() {
    // Memastikan bahwa FruitType dari objek ini adalah bukan BANANA
    // ...
    assert (this.type != FruitType.BANANA);

    // Mencetak "Peeling " tanpa tanda kutip diikuti dengan type dan new line
    // Contoh: "Pressing WATERMELON"
    System.out.println("Pressing " + this.type);
  }

  private void removeCore() {
    // Memastikan bahwa FruitType dari objek ini adalah APEL
    // ...
    assert (this.type == FruitType.APPLE);

    // Mencetak "Removing core " tanpa tanda kutip diikuti dengan type dan new line
    // Contoh: "Removing core APPLE"
    System.out.println("Removing core " + this.type);
  }

  // Suatu saat, bila ada programmer yang ingin menambahkan method public,
  // Ia sadar kalau tidak semua method dapat dipanggil, tergantung fruitType.
  // Method di atas private, sehingga boleh menggunakan assertion.
  // Bila public, sebaiknya menggunakan exception dibanding assertion.
}