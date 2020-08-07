// PQElmt.cpp
#include "PQElmt.hpp"
#include <iostream>

PQElmt::PQElmt() {
  this->value = 0;
  this->prio = 0;
}

PQElmt::PQElmt(int value, int prio) {
  this->value = value;
  this->prio = prio;
}

PQElmt::PQElmt(const PQElmt& other) {
  this->value = other.value;
  this->prio = other.prio;
}

PQElmt::~PQElmt() {
  //
}

int PQElmt::getValue() const {
  return this->value;
}

int PQElmt::getPrio() const {
  return this->prio;
}

bool PQElmt::operator==(const PQElmt& other) {
    return ((this->value == other.value ) && (this->prio == other.prio));
}

bool PQElmt::operator<(const PQElmt& other) {
    bool check = false;
    if(this->prio < other.prio) {
        check = true;
    } else if(this->prio == other.prio) {
        check = this->value > other.value;
    }
    return check;
}

bool PQElmt::operator>(const PQElmt& other) {
    bool check = false;
    if(this->prio > other.prio) {
        check = true;
    } else if(this->prio == other.prio) {
        check = this->value < other.value;
    }
    return check;
}
