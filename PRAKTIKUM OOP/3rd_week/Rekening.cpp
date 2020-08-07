#include <iostream>
#include "Rekening.h"
using namespace std;

Rekening::Rekening(double value) {
    this->saldo = value>0? value : 0;
}

void Rekening::setSaldo(double value) {
    this->saldo = value;
}
double Rekening::getSaldo() const {
    return this->saldo;
}

void Rekening::simpanUang(double value) {
    this->saldo += value;
} 

bool Rekening::tarikUang(double value) {
    if (value <= this->saldo) {
        this->saldo -= value;
        return true;
    }
    return false;
}