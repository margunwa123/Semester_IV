#ifndef __BANK_HPP__
#define __BANK_HPP__

#include <iostream>
#include "Account.hpp"
#include "BaseException.hpp"
using namespace std;
// Definisikan TransactionFailedException di sini
// TransactionFailedException merupakan anak dari kelas BaseException, memiliki:
// - exc bertipe BaseException*
// - constructor menerima argumen exc
// - printMessage yang menuliskan "Transaksi gagal dengan pesan kesalahan:\n"
//   diikuti dengan pemanggilan exc->printMessage()
class TransactionFailedException : public BaseException {
    private:
        BaseException* exc;
    public:
        TransactionFailedException(BaseException* e) {
            int i = 0;
            this->exc = e;
        }

        void printMessage() {
            cout << "Transaksi gagal dengan pesan kesalahan:\n";
            exc -> printMessage();
        }
};
// Definisikan AccountNotFoundException di sini
// AccountNotFoundException merupakan anak dari kelas BaseException, memiliki:
// - number bertipe string
// - constructor menerima argumen number
// - printMessage yang menuliskan "Tidak ditemukan rekening dengan nomor {number}\n"
class AccountNotFoundException : public BaseException {
    private:
        string number;
    public:
        AccountNotFoundException(string number) {
            this->number = number;
        }
        void printMessage() {
            cout << "Tidak ditemukan rekening dengan nomor " << this->number << endl;
        }
};


class Bank {
private:
    Account* accounts;
    static const int maxEl = 100;

public:
    Bank() {
        this->accounts = new Account[Bank::maxEl];
    }

    ~Bank() {
        delete[] this->accounts;
    }

    Account& getAccount(int idx) {
        return this->accounts[idx];
    }

    int findAccountIdx(string number) {
        // Mengembalikan indeks rekening yang memiliki nomor number
        int idx = -1;
        for (int i = 0; i < Bank::maxEl; i++) {
            if (this->accounts[i].getNumber() == number) {
                idx = i;
            }
        }
        if(idx == -1) {
            throw AccountNotFoundException(number);
        }
        return idx;
    }

    void transfer(string fromNumber, string toNumber, int amount) {
        // Mengirimkan uang sebanyak amount dari account dengan nomor
        // fromNumber ke account dengan nomor toNumber
        Account& fromAccount = this->accounts[this->findAccountIdx(fromNumber)];
        Account& toAccount = this->accounts[this->findAccountIdx(toNumber)];
        try {
            fromAccount.withdraw(amount);
            toAccount.add(amount);
        } catch (BaseException* e) {
            throw new TransactionFailedException(e);
        }
        // TODO: Menambah balance dari account tujuan dengan method add
        //       dan mengurangi balance dari account asal dengan method withdraw.
        // TODO: Menangkap semua jenis Exception yang dilempar dan melempar TransactionFailedException*.
        //       Hint: jangan menangkap tiap jenis exception, manfaatkan BaseException.
        //       Jika transaksi gagal, PASTIKAN balance kedua rekening tidak ada yang
        //       berubah.
    }
};

#endif