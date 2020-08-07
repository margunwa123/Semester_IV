#include "PrioQueue.hpp"

int main() {
    PrioQueue A(15);
    A.push(PQElmt(10,5));
    A.push(PQElmt(10,6));
    A.push(PQElmt(10,7));
    A.printInfo();
    return 0;
}