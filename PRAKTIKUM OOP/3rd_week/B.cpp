#include "B.hpp"
#include <iostream>

using namespace std;

B::B() : A() {
    cout << "Boom B!" << endl;
}

void B::sing() {
    cout << "Do B Do B Do B..." << endl;
}