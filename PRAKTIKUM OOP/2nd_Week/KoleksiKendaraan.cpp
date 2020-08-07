#include "KoleksiKendaraan.hpp"
#include <iostream>
using namespace std;

KoleksiKendaraan:: KoleksiKendaraan(int size) {
    this->size = size;
    this->Neff = 0;
    this->tabKendaraan = new Kendaraan[this->size];
}

KoleksiKendaraan:: KoleksiKendaraan() : KoleksiKendaraan(100) {}


class KoleksiKendaraan {
    private:
        Kendaraan *tabKendaraan;
        int size;
        int Neff;
    public:
        KoleksiKendaraan();
        KoleksiKendaraan(int);
        KoleksiKendaraan(const KoleksiKendaraan&);
        ~KoleksiKendaraan();
        void PrintAll();
        KoleksiKendaraan operator+(const Kendaraan&);
        KoleksiKendaraan operator+(const KoleksiKendaraan&);
};