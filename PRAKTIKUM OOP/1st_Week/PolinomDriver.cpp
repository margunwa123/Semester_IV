#include "Polinom.hpp"
#include <iostream>

using namespace std;

int main() {
    Polinom P(10);
    for(int i = 0 ; i <= 10 ; i++) {
        P.setKoefAt(i,i);
    }
    Polinom A(P);
    Polinom C(5);

    // Polinom A = P;
    C.setKoefAt(1,4);
    C.setKoefAt(2,5);
    C.setKoefAt(3,7);
    Polinom D = C - A;
    D.print();
    P.print();
    A.print();
    C.print();
    cout << C.substitute(2);
}