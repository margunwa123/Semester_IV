// File AccountTest.java
public class AccountTest {
    public AccountTest() {
       // Tidak melakukan apa-apa
    }
  
    public void test() {
        // Melakukan tes terhadap method transfer.
        // Asumsikan method lainnya benar.
        Account a = AccountFactory.withBalance(20);
        Account b = AccountFactory.withBalance(20);
        Account c = AccountFactory.withBalance(0);
        try {
            a.transfer(b, 10);
            // a = 10, b = 30, c = 0
            b.transfer(c, 20);
            // a = 10, b = 10, c = 20
        }
        catch (Exception e) {
            assert (false);
        }
        

        try {
            a.transfer(c, 20);
            // a = 10, b = 10, c = 20
            assert false;
        }
        catch (Exception e) {
            assert true;
        }
        try {
            c.transfer(a, 20);
            // a = 30, b = 10, c = 0
            c.transfer(a, 10);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }
        assert (a.getBalance() == 30);
        assert (b.getBalance() == 10);
        assert (c.getBalance() == 0);
        assert (a.getNumOfTransaction() == 2);
        assert (b.getNumOfTransaction() == 2);
        assert (c.getNumOfTransaction() == 2);
    }
  }