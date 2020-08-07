// main.cpp
#include "A.hpp"
#include "B.hpp"

void funcA(A& a, int value) {
	a.setValue(value);
}

void funcB(B& b, int value) {
	b.setValue(value);
}

int main() {
  B b; /** ANDA HARUS MENGGUNAKAN DEFAULT CONSTRUCTOR */
  funcA(b, 888);
  funcB(b, 10888);
  b.print(); // OUTPUT: (888, 10888)
  return 0;
}
