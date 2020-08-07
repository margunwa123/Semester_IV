#ifndef _KOLEKSIKENDARAAN_H_
#define _KOLEKSIKENDARAAN_H_

#include <iostream>
#include "kendaraan.hpp"
using namespace std;

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

#endif