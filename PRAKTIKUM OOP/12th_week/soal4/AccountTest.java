// File AccountTest.java
public class AccountTest {
  public AccountTest() {
     // Tidak melakukan apa-apa
  }

  public void test() {
     // Melakukan tes terhadap method transfer.
     // Asumsikan method lainnya benar.
     Account accountA = AccountFactory.withBalance(20);
     Account accountB = AccountFactory.withBalance(20);
     Account accountC = AccountFactory.withBalance(10);
     try {
       accountA.transfer(accountB, 10); // balance A 10, B 30
       accountB.transfer(accountA, 20); // balance B 10, A 30
     }
     catch (Exception E) {
       assert false;
     }
     try {
       accountC.transfer(accountA, 10);
     }
     catch (Exception E) {
        assert false;
     }
    try {
        accountC.transfer(accountA, 10);
        assert false;
    }
    catch (Exception E) {
        assert true;
    }
     
     assert accountA.getBalance() == 40;
     assert accountB.getBalance() == 10;
     assert accountC.getBalance() == 0;
     
     assert accountA.getNumOfTransaction() == 3;
     assert accountB.getNumOfTransaction() == 2;
     assert accountC.getNumOfTransaction() == 1;
     
  }
}