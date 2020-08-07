#include "Kendaraan.hpp"
#include <iostream>
using namespace std;

Kendaraan:: Kendaraan(int no_Kendaraan, int tahun_keluaran, string merk) {
    this-> no_Kendaraan   = no_Kendaraan;
    this-> tahun_keluaran = tahun_keluaran;
    this-> merk           = merk;
}

Kendaraan:: Kendaraan() : Kendaraan(0,2020,"merci")  {}

void Kendaraan:: PrintInfo() {
    cout << "bermerk "    << this->merk           << " "
         << "keluaran tahun " << this->tahun_keluaran << " "
         << "dengan nomor "   << this->no_Kendaraan   << " ";  
}