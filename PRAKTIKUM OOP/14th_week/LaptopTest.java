public class LaptopTest {
  private Class class1;
  // Anda boleh menambahkan atribut yang diperlukan

  public LaptopTest(String className) {
      /**
       * Memeriksa apakah ada kelas dengan nama className.
       * Jika tidak, tuliskan "Tidak ada kelas dengan nama yang diberikan" (tanpa petik) ke layar
       */
      try {
        this.class1 = Class.forName(className);
      }
      catch(Exception e) {
        System.out.println("Tidak ada kelas dengan nama yang diberikan");
      }
  }

  public boolean testMethods() {
      if (class1.getMethods().length == 1) {
          // Jika nama method bukan getRamSize, tuliskan "Nama method harus getRamSize" (tanpa petik) ke layar
          // Jika tipe return bukan Integer, tuliskan "Tipe return method harus Integer" (tanpa petik) ke layar
          try {
            if(class1.getDeclaredMethod("getRamSize") == null) {
                throw new Exception();
            }
            try {
              if(class1.getDeclaredMethod("getRamSize").getReturnType() == Integer.class) {
                return true;
              }
              throw new Exception();
            }
            catch(Exception e) {
              System.out.println("Tipe return method harus Integer");
            }
          }
          catch(Exception e) {
            System.out.println("Nama method harus getRamSize");
          }
      } else {
          // Menuliskan "Banyaknya method hanya boleh 1" (tanpa petik) ke layar
          System.out.println("Banyaknya method hanya boleh 1");
      }
      // Return true jika semua tes berhasil
      // Jika ada 1 yang salah, return false
      return false;
  }

  public boolean testFields() {
      if (class1.getFields().length == 1) {
          // Jika nama field bukan serialNumber, tuliskan "Nama field harus serialNumber" (tanpa petik) ke layar
          // Jika tipe return bukan String, tuliskan "Tipe field harus String" (tanpa petik) ke layar
          try {
            if(class1.getDeclaredField("serialNumber") == null) {
              throw new Exception();
            }
            if(class1.getDeclaredField("serialNumber").getType() == String.class) {
              return true;
            }
            else {
              System.out.println("Tipe field harus String");
            }
          }
          catch(Exception e) {
            System.out.println("Nama field harus serialNumber");
          }
      } else {
        System.out.println("Banyaknya field hanya boleh 1");
          // Menuliskan "Banyaknya field hanya boleh 1" (tanpa petik) ke layar
      }
      // Return true jika semua tes berhasil
      // Jika ada 1 yang salah, return false
      return false;
  }
}