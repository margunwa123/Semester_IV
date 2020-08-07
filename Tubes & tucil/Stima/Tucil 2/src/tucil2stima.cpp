#include "Polinom.hpp"
#include <iostream>
#include <iomanip>

using namespace std;

void run() {
    bool isRandom;
    char randomChoice;
    int derajat;
    int jumlah_perkalian;
    int jumlah_penjumlahan;
    cout << "Masukan jumlah derajat yang kamu inginkan : ";
    cin >> derajat;
    cout << "Apakah kamu ingin derajat di random ? (Y/N) \n>> ";
    cin >> randomChoice;
    if(randomChoice == 'y' || randomChoice == 'Y') {
        isRandom = RANDOMIZE;
    } else if(randomChoice == 'n' || randomChoice == 'N') {
        isRandom = NOT_RANDOMIZE;
    }
    Polinom A(derajat,isRandom);
    Polinom B(derajat,isRandom);
    Polinom C;
    if(!isRandom) {
        A.getUserInput();
        B.getUserInput();
    }
    
    int index, value;
    int Pilihan;
    clock_t tStart;
    double executing_time;
    while(1) {
        cout << "\nMain Menu : \n"
        << "1. Print Info Polinom \n" 
        << "2. Brute Force A dan B\n"
        << "3. Divide And Conquer A dan B\n"
        << "4. Set Elemen Polinom Pertama di index dengan value\n"
        << "5. Set Elemen Polinom Kedua di index dengan value\n"
        << "6. Masukkan derajat baru\n"
        << "7. Tambahkan kedua Polinom\n"
        << "99. Keluar \n>> ";
        cin >> Pilihan;
        switch(Pilihan) {
            case 1:
                cout<<"A : "; A.PrintInfo();
                cout<<"B : "; B.PrintInfo();
                break;
            case 2:
                C.~Polinom();
                tStart = clock();
                C = Polinom(A.kaliBruteForce(B));
                jumlah_perkalian   = C.getJumlahPerkalian();
                jumlah_penjumlahan = C.getJumlahPenjumlahan();
                executing_time = (double)(clock() - tStart);
                cout << "Hasil Brute Force A dan B : "; C.PrintInfo();
                cout << "Executing Time     : " << executing_time   << " ms" << endl
                     << "Jumlah Perkalian   : " << jumlah_perkalian << endl
                     << "Jumlah Penjumlahan : " << jumlah_penjumlahan;
                break;
            case 3:
                C.~Polinom();
                tStart = clock();
                C = kaliDivideAndConquer(A, B);
                jumlah_perkalian   = C.getJumlahPerkalian();
                jumlah_penjumlahan = C.getJumlahPenjumlahan();
                executing_time   = (double)(clock() - tStart);
                cout << "Hasil Divide And Conquer A dan B : "; C.PrintInfo();
                cout << "Executing Time     : " << executing_time   << " ms" << endl
                     << "Jumlah Perkalian   : " << jumlah_perkalian << endl
                     << "Jumlah Penjumlahan : " << jumlah_penjumlahan;
                break;
            case 4:
                cout << "Masukan Index : "; cin >> index;
                cout << "Masukan Value : "; cin >> value;
                A.setElement(index,value);
                if(index <= A.getMaxDerajat()) {
                    cout << "Value berhasil dimasukan" << endl;
                }
                break;
            case 5:
                cout << "Masukan Index : "; cin >> index;
                cout << "Masukan Value : "; cin >> value;
                B.setElement(index,value);
                if(index <= B.getMaxDerajat()) {
                    cout << "Value berhasil dimasukan" << endl;
                }
                break;
            case 6:
                cout << "Masukan jumlah derajat yang kamu inginkan : ";
                cin >> derajat;
                cout << "Apakah kamu ingin derajat di random ? (Y/N) \n>> ";
                cin >> randomChoice;
                if(randomChoice == 'y' || randomChoice == 'Y') {
                    isRandom = RANDOMIZE;
                } else if(randomChoice == 'n' || randomChoice == 'N') {
                    isRandom = NOT_RANDOMIZE;
                }
                A.reconstruct(derajat, isRandom);
                B.reconstruct(derajat, isRandom);
                if(!isRandom) {
                    A.getUserInput();
                    B.getUserInput();
                }
                break;
            case 7:
                (A+B).PrintInfo();
                break;
            case 99:
                cout << "Memberhentikan program...";
                break;
            default:
                cout << "Komando salah, harap memasukan ulang komando \n";
        }
        if(Pilihan == 99) {
            break;
        }
    }
}

int main() {
    run();
    return 0;
}