#include "Bank.hpp"

int main() {
    Bank b;
    try {
        Bank b;
        b.getAccount(0).setNumber("10");
        b.getAccount(0).add(100);
        b.getAccount(1).setNumber("20");
        b.getAccount(1).add(120);

        b.transfer("10", "20", 150);
    } catch (BaseException* e) {
        e -> printMessage();
    }
    return 0;
}