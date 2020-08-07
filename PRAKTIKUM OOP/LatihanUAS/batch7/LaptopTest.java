import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LaptopTest {
    // Anda boleh menambahkan atribut yang diperlukan
    private String className;

    public LaptopTest(String className) {
        /**
         * Memeriksa apakah ada kelas dengan nama className.
         * Jika tidak, tuliskan "Tidak ada kelas dengan nama yang diberikan" (tanpa petik) ke layar
         */
        this.className = className;
        try{
            Class.forName(className);
        }
        catch(Exception E) {
            System.out.println("Tidak ada kelas dengan nama yang diberikan");
        }
    }

    public boolean testMethods() {
        boolean isCorrect = true;
        try {
            Method[] methods = Class.forName(this.className).getClass().getDeclaredMethods();
            if (methods.length == 1) {
                // Jika nama method bukan getRamSize, tuliskan "Nama method harus getRamSize" (tanpa petik) ke layar
                // Jika tipe return bukan Integer, tuliskan "Tipe return method harus Integer" (tanpa petik) ke layar
                Method getRamSize = methods[0];
                getRamSize.setAccessible(true);
                if(!getRamSize.getName().equals("getRamSize")) {
                    System.out.println("Nama method harus getRamSize");
                    isCorrect = false;
                }
                if(!getRamSize.getReturnType().equals(Integer.class)) {
                    System.out.println("Tipe return method harus Integer");
                    isCorrect = false;
                }
            } else {
                System.out.println("Banyaknya method hanya boleh 1");
                isCorrect = false;
                // Menuliskan "Banyaknya method hanya boleh 1" (tanpa petik) ke l
            }
        } catch (Exception e) {
            isCorrect =  false;
        }
        
        return isCorrect;
        // Return true jika semua tes berhasil
        // Jika ada 1 yang salah, return false
    }

    public boolean testFields() {
        boolean isCorrect = true;
        try {
            Field[] fields = Class.forName(this.className).getClass().getDeclaredFields();
            if (fields.length == 1) {
                // Jika nama field bukan serialNumber, tuliskan "Nama field harus serialNumber" (tanpa petik) ke layar
                // Jika tipe return bukan String, tuliskan "Tipe field harus String" (tanpa petik) ke layar
                
                Field serialNumber = fields[0];
                serialNumber.setAccessible(true);
                if(!serialNumber.getName().equals("serialNumber")) {
                    System.out.println("Nama field harus serialNumber");
                    isCorrect = false;
                }
                if(!serialNumber.getType().equals(String.class)) {
                    System.out.println("Tipe field harus String");
                    isCorrect = false;
                }
            }
            else {
            // Menuliskan "Banyaknya field hanya boleh 1" (tanpa petik) ke layar
                System.out.println("Banyaknya field hanya boleh 1");
                isCorrect = false;
            }
        }
        catch (Exception E) {
            isCorrect = false;
        }
        // Return true jika semua tes berhasil
        // Jika ada 1 yang salah, return false
        return isCorrect;
    }

}