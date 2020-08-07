#include "Minibus.hpp"
#include <iostream>
using namespace std;

#define MINIBUS "Minibus"

Minibus::Minibus() :Kendaraan(1,2000,"xenia") {
    this->kapasitas = 8;
}

void Minibus::PrintInfo() {
    cout << endl << "bim bim im a minibus with capacity : " << this->kapasitas ;
}