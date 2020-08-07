#include <iostream>
#include "RekeningTabungan.h"
using namespace std;

// Konstruktor menginisialisi saldo (parameter 1) dan biaya transaksi (parameter 2)
// Set biaya transaksi 0.0 apabila biaya transaksi bernilai negatif
RekeningTabungan::RekeningTabungan(double saldo, double biaya_transaksi): Rekening(saldo) {
    this->biayaTransaksi = biaya_transaksi;
}

// Getter, Setter
void RekeningTabungan::setBiayaTransaksi(double biaya_transaksi) {
    this->biayaTransaksi = biaya_transaksi;
}
double RekeningTabungan::getBiayaTransaksi() const {
    return (this->biayaTransaksi);
}

// Member Function
// Panggil fungsi simpanUang dari parent class
// Kurangkan saldo dengan biaya transaksi
void RekeningTabungan::simpanUang(double value) {
    this->simpanUang(value - this->biayaTransaksi);
}

// Panggil fungsi tarikUang dari parent class
// Kurangkan saldo dengan biaya transaksi hanya jika penarikan uang berhasil
// Saldo mungkin saja menjadi negatif apabila setelah penarikan, saldo < biaya transaksi
// Kembalikan boolean yang mengindikasikan apakah uang berhasil ditarik atau tidak
bool RekeningTabungan::tarikUang(double value) {
    if(Rekening::tarikUang(value)) {
        Rekening::simpanUang(-this->biayaTransaksi);
        return true;
    }
    return false;
}