// Polinom.cpp
#include "Polinom.hpp"
#include <iostream>
#define max(a,b) a>b ? a : b

int power(int x, int pangkat) {
    int temp;
    if(pangkat == 0) {
        return 1;
    }
    temp = power(x,pangkat/2);
    if (pangkat%2 == 0) {
        return temp*temp;
    } else {
        return x*temp*temp;
    }
}

using namespace std;

Polinom :: Polinom() : Polinom(0) {};
Polinom :: Polinom(int e) { 
    for(int i = 0; i < MAX_LENGTH ; i++) {
        koef[i] = 0;
    }
    derajat = e<19? e : 19;
}
Polinom :: Polinom(const Polinom& P) { 
    derajat = P.derajat;
    for(int i = 0; i < MAX_LENGTH ; i++) {
        koef[i] = P.koef[i];
    }
}
Polinom& Polinom :: operator=(const Polinom& other) {
    *this = Polinom(other);
}
Polinom :: ~Polinom() {
}

int Polinom :: getKoefAt(int idx) const {
    return idx <= derajat ? koef[idx] : 0;
}

int Polinom :: getDerajat() const {
    return derajat;
}

void Polinom :: setKoefAt(int idx, int val) {
    if(idx <= derajat) {
        koef[idx] = val;
    }
}

void Polinom :: setDerajat(int i) {
    derajat = i < 19? i : 19;
}


Polinom operator+(const Polinom& P1, const Polinom& P2) {
    Polinom hasil(max(P1.derajat, P2.derajat));
    for(int i = 0 ; i <= hasil.getDerajat() ; i++) {
        hasil.setKoefAt(i,(P1.getKoefAt(i) + P2.getKoefAt(i)));
    }
    return hasil;
}

Polinom operator-(const Polinom& P1, const Polinom& P2) {
    Polinom hasil(max(P1.derajat, P2.derajat));
    for(int i = 0 ; i <= hasil.getDerajat() ; i++) {
        hasil.setKoefAt(i,(P1.getKoefAt(i) - P2.getKoefAt(i)));
    }
    return hasil;
}

Polinom operator*(const Polinom& P, const int x) {
    Polinom hasil;
    hasil.setDerajat(P.getDerajat());
    for(int i = 0 ; i <= hasil.getDerajat() ; i++) {
        hasil.setKoefAt(i,(P.getKoefAt(i) * x));
    }
    return hasil;
}

Polinom operator*(const int x, const Polinom& P) {
    return P * x;
}

Polinom operator/(const Polinom& P, const int x) {
    Polinom hasil(P);
    for(int i = 0 ; i <= hasil.getDerajat() ; i++) {
        hasil.setKoefAt(i,(P.getKoefAt(i) / x));
    }
    return hasil;
}

void Polinom :: input() {
    for(int i = 0; i <= derajat; i++) {
        cin >> koef[i];
    }
}

void Polinom :: printKoef() {
    for(int i = 0; i <= derajat; i++) {
        cout << koef[i] << endl;
    }
}

int Polinom :: substitute(int x) {
    int hasil = 0;
    if(derajat >= 0) {
        hasil = koef[0];
        for(int i = 1; i <= derajat ; i++) {
            hasil += power(x,i)*koef[i];
        }
    }
    return hasil;
}
    
Polinom Polinom :: derive() {
    int derajatHasil = this->derajat > 0 ? this->derajat - 1 : 0;
    Polinom hasil(derajatHasil);
    if(this->derajat > 0) {
        for(int i = 0; i <= hasil.derajat ; i++) {
            hasil.koef[i] = this->koef[i+1] * (i+1);
        }
    } else {
        hasil.koef[0] = 0;
    }
    return hasil;
}

void Polinom :: print() {
    if(derajat >= 0) {
        cout<<koef[0];
    }
    for(int i = 1; i <= derajat; i++) {
        if(koef[i] > 0) {
            cout<<"+"<<koef[i]<<"x^"<<i;
        } else if(koef[i] < 0){
            cout<<koef[i]<<"x^"<<i;
        }
    }
    cout<<endl;
}