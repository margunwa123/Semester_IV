import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Injector {
    private List<Object> dependencies;

    public Injector() {
        this.dependencies = new ArrayList<>();
    }
    // Menerima sebuah definisi dependencies
    // yang berupa sebuah instansiasi kelas
    // Catatan: Injector bisa menampung lebih dari 1 dependency,
    //          jadi injector bisa menginject banyak sekaligus.
    //          Jika ada 2 objek dengan kelas yang sama,
    //          inject dengan object terakhir yang di add ke daftar dependency
    public void addDependencies(Object object) {
        this.dependencies.add(object);
    }
    /*
      Menginjeksi dependencies yang telah dibuat ke dalam objek
      Injeksi dilakukan dengan mengacu pada dependencies yang ditambah
      pada method addDependencies.
  
      Setiap field di object yang diinject, bila kelasnya
      sudah ditambahkan sebagai dependency, maka akan diset sebagai
      object yang sudah di add didependency.
    */
    public void inject(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            for(Object dependency : this.dependencies) {
                if (field.getType().equals(dependency.getClass())) {
                    field.set(object, dependency);
                }
            }
        }
    }
  }