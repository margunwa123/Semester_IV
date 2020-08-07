import java.lang.reflect.Field;

class Person {
  @JSONField
  private String name;

  @JSONField
  private String address;

  private String gender;

  public Person(String name, String address, String gender) {
      this.name = name;
      this.address = address;
      this.gender = gender;
  }

  public static void main(String[] args) {
      Person p1 = new Person("Hojun", "Cisitu", "Male");
      Person p2 = new Person("Qila", "Tubis", "Male");
      System.out.println(new JSONWriter(p1).toString());
      System.out.println(new JSONWriter(p2).toString());
      try {
        Field field = p1.getClass().getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(p1));
      }
      catch (Exception e) {
        System.out.println("hoho");
      }

      // menuliskan
      // {"address":"Cisitu","name":"Hojun"}
      // {"address":"Tubis","name":"Qila"}
      // perhatikan kalau:
      // - gender tidak dituliskan, karena tidak ada anotasi @JSONField
      // - kedua field private, tapi bisa diakses
      // asumsikan semua field merupakan string
  }
}