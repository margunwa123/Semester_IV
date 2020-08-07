#include "Complex.h"

int main() {
    Complex A(5,5);
    Complex B(3,3);
    Complex C = B - A;
    C.print();
    // B.print();
    // A.print();
    // A.setImaginer(12);
    // A.print();
}