#include "Box.hpp"

int main() {
    Box* A = new Box(2);
    Box B;
    Box C(1);
    B = *A;
    Box D(C);
    B.peek();
    C.peek();
    delete A;
    return 0;
}