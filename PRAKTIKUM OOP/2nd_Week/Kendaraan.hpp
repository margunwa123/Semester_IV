#ifndef _Kendaraan_H_
#define _Kendaraan_H_

#include <iostream>
using namespace std;

class Kendaraan {
    private:
        int no_Kendaraan;
        int tahun_keluaran;
        string merk;
    public:
        Kendaraan();
        Kendaraan(int no_Kendaraan, int tahun_keluaran, string merk);
        // Kendaraan(const Kendaraan&);
        // ~Kendaraan();
        virtual void PrintInfo();
        virtual long BiayaSewa(int) = 0;
};

class Minibus : public Kendaraan {
    private:
        int kapasitas;
    public:
        long BiayaSewa(int) const;
        long CalculateDiscount(int lamaSewa) const;
};

#endif