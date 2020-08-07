#include "Polinom.hpp"
#include <iostream>
#include <cstdlib>
#include <ctime>

int Polinom::jumlah_polinom = 0;

// CCtor, Dtor, Ctor
Polinom:: Polinom(int max_derajat, bool isRandom) {
    this->max_derajat = max_derajat;
    int size = this->max_derajat + 1;
    this->koef = new int[size];
    this->jumlah_penjumlahan = 0;
    this->jumlah_perkalian   = 0;
    jumlah_polinom += 1;
    if(isRandom) {
        this->randomize();
    }
    else {
        for(int i = 0; i <= this->max_derajat ; i++) {
            this->setElement(i, 0);
        }
    }
}

Polinom:: Polinom() : Polinom(10,NOT_RANDOMIZE) {}

Polinom:: Polinom(const Polinom& other) {
    jumlah_polinom += 1;
    this->max_derajat = other.max_derajat;
    this->koef = new int[this->max_derajat + 1];
    this->jumlah_penjumlahan = other.jumlah_penjumlahan;
    this->jumlah_perkalian   = other.jumlah_perkalian;
    for(int i = 0; i <= this->max_derajat ; i++) {
        this->setElement(i, other.koef[i]);
    }
}

Polinom:: ~Polinom() {
    jumlah_polinom -= 1;
    delete this->koef;
}

void Polinom::reconstruct(int max_derajat, bool isRandom) {
    delete this->koef;
    this->max_derajat = max_derajat;
    jumlah_polinom += 1;
    this->koef = new int[max_derajat + 1];
    this->jumlah_penjumlahan = 0;
    this->jumlah_perkalian   = 0;
    if(isRandom) {
        this->randomize();
    }
    else {
        for(int i = 0; i <= this->max_derajat ; i++) {
            this->setElement(i, 0);
        }
    }
} 

//Operator
Polinom::operator=(const Polinom& other) {
    jumlah_polinom += 1;
    this->max_derajat = other.max_derajat;
    this->koef = new int[this->max_derajat + 1];
    for(int i = 0; i <= this->max_derajat ; i++) {
        this->setElement(i, other.koef[i]);
    }
    this->jumlah_penjumlahan += other.jumlah_penjumlahan;
    this->jumlah_perkalian   += other.jumlah_perkalian;
}

Polinom Polinom::operator-(const Polinom& other) {
    int max_derajat = this->max_derajat > other.max_derajat ? this->max_derajat : other.max_derajat;
    Polinom res(max_derajat,NOT_RANDOMIZE);
    for(int i = 0 ; i <= res.max_derajat ; i++) {
        if(i <= this->max_derajat) {
            res.koef[i] += this->koef[i];
        }
        if(i <= other.max_derajat) {
            this->jumlah_penjumlahan++;
            res.koef[i] -= other.koef[i];
        }
    }
    this->jumlah_penjumlahan += other.jumlah_penjumlahan;
    this->jumlah_perkalian   += other.jumlah_perkalian;
    return res;
}

Polinom Polinom::operator+(const Polinom& other) {
    int max_derajat = this->max_derajat > other.max_derajat ? this->max_derajat : other.max_derajat;
    Polinom res(max_derajat,NOT_RANDOMIZE);
    for(int i = 0 ; i <= res.max_derajat ; i++) {
        if(i <= this->max_derajat) {
            res.koef[i] += this->koef[i];
        }
        if(i <= other.max_derajat) {
            this->jumlah_penjumlahan++;
            res.koef[i] += other.koef[i];
        }
    }
    this->jumlah_penjumlahan += other.jumlah_penjumlahan;
    this->jumlah_perkalian   += other.jumlah_perkalian;
    return res;
}

//Setter
void Polinom::setElement(int derajat, int value) {
    if(derajat <= this->max_derajat) {
        this->koef[derajat] = value;
    }
}

void Polinom::addElement(int derajat, int value) {
    if(derajat <= this->max_derajat) {
        this->koef[derajat] += value;
        this->jumlah_penjumlahan++;
    }
}

// Getter
int Polinom::getJumlahPerkalian() {
    int temp = this->jumlah_perkalian;
    this->jumlah_perkalian = 0; //RESET
    return temp;
}
int Polinom::getJumlahPenjumlahan() {
    int temp = this->jumlah_penjumlahan;
    this->jumlah_penjumlahan = 0; //RESET
    return temp;
}

void Polinom::getUserInput() {
    for(int i = 0; i <= this->max_derajat ; i++) {
        std::cout << "Masukan elemen Array ke " << i <<" : ";
        std::cin  >> this->koef[i];
    }
}

int Polinom::getElement(int index) {
    if(index <= this->max_derajat) {
        return this->koef[index];
    }
    else {
        return 0;
    }
}

void Polinom::randomize() {
    srand(time(NULL));
    for(int i = 0; i <= this->max_derajat; i++) {
        this->setElement(i, ((rand() * jumlah_polinom) % 100 + 1));
    }
}

int Polinom::getMaxDerajat() {
    return this->max_derajat;
}

void Polinom::PrintInfo() {
    int variable = 0;
    if(this->max_derajat >= 0) { //polinom elemen > 0
        std::cout << this->koef[0];
        if(this->max_derajat >= 1) {
            std::cout << " + " << this->koef[1] << "x";
        }
        for(int i = 2; i <= this->max_derajat; i++) {
            std::cout << " + " << this->koef[i] << "x^" << i;
        }
        std::cout << std::endl;
    }
}

Polinom Polinom::kaliBruteForce(const Polinom& other) {
    Polinom res(this->max_derajat+other.max_derajat, NOT_RANDOMIZE);
    int Value;
    for(int i = 0 ; i <= this->max_derajat ; i++) {
        for(int j = 0 ; j <= other.max_derajat ; j++) {
            res.jumlah_perkalian++;
            Value = this->koef[i] * other.koef[j];
            res.addElement(i+j, Value);
        }
    }
    return res;
}

Polinom kaliDivideAndConquer(Polinom &Polinom1, Polinom &Polinom2) {
    // Basis
    int max_size = Polinom1.getMaxDerajat() + 1;
    if(max_size == 1) {
        Polinom temp(0, NOT_RANDOMIZE);
        temp.jumlah_perkalian++;
        temp.setElement(0, Polinom1.getElement(0) * Polinom2.getElement(0));
        return temp;
    }
    else {
        Polinom produk(2 * Polinom1.getMaxDerajat(), NOT_RANDOMIZE);
        // Kalo dia ganjil jml elemennya karena udah di floor, gausah dikurangi 1
        int derajatSetengahPolinom = max_size % 2 == 0 ? max_size/2 - 1 : max_size/2;
        int sizeSetengahPolinom    = derajatSetengahPolinom + 1;
        Polinom A1(derajatSetengahPolinom, NOT_RANDOMIZE);
        Polinom B1(derajatSetengahPolinom, NOT_RANDOMIZE);
        Polinom A0(derajatSetengahPolinom, NOT_RANDOMIZE);
        Polinom B0(derajatSetengahPolinom, NOT_RANDOMIZE);
        Polinom A0plusA1(derajatSetengahPolinom, NOT_RANDOMIZE);
        Polinom B0plusB1(derajatSetengahPolinom, NOT_RANDOMIZE);
        for(int i = 0 ; i <= derajatSetengahPolinom ; i++) {
            A0.setElement(i, Polinom1.getElement(i));
            A1.setElement(i, Polinom1.getElement(i + sizeSetengahPolinom));
            B0.setElement(i, Polinom2.getElement(i));
            B1.setElement(i, Polinom2.getElement(i + sizeSetengahPolinom));
            A0plusA1.setElement(i, A0.getElement(i) + A1.getElement(i));
            produk.jumlah_penjumlahan++;
            B0plusB1.setElement(i, B0.getElement(i) + B1.getElement(i));
            produk.jumlah_penjumlahan++;
        }
        Polinom A0B0         = kaliDivideAndConquer(A0, B0);
        Polinom A1B1         = kaliDivideAndConquer(A1, B1);
        Polinom produkTengah = kaliDivideAndConquer(A0plusA1, B0plusB1) - A0B0 - A1B1;
        for(int i = 0; i <= A0B0.getMaxDerajat() ; i++) {
            produk.addElement(i, A0B0.getElement(i));
            produk.addElement(i + sizeSetengahPolinom, produkTengah.getElement(i));
            produk.addElement(i + sizeSetengahPolinom*2, A1B1.getElement(i));
        }

        return produk;
    }
}
