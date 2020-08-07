#include <iostream>
#include "RekeningGiro.h"
using namespace std;

// Konstruktor menginisialisi saldo (parameter 1) dan suku bunga (parameter 2)
// Set suku bunga 0.0 apabila suku bunga bernilai negatif
RekeningGiro::RekeningGiro(double saldo, double suku_bunga): Rekening(saldo) {
    this->sukuBunga = (suku_bunga>0) ? suku_bunga : 0;
}

// Getter, Setter
void RekeningGiro::setSukuBunga(double value) {
    this->sukuBunga = value;
}

double RekeningGiro::getSukuBunga() const {
    return (this->sukuBunga);
}

// Member Function
// Bunga dihitung dari saldo dikali suku bunga
double RekeningGiro::hitungBunga() {
    return (Rekening::getSaldo() * this->sukuBunga);
}
	