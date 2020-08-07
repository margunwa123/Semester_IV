#include "B.hpp"
#include <iostream>

using namespace std;

void sing(A* a) {
    a -> sing();
}

int main() {
    B b;
    sing(&b);
}