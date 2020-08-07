// Program Complex.cpp
// Mario Gunawan
// 13518114 K03
#include "Complex.h"
#include <iostream>

using namespace std;

Complex :: Complex() {
	real     = 0;
	imaginer = 0;
}
Complex :: Complex(int re, int im) {
	real     = re;
	imaginer = im;
}

Complex :: Complex(const Complex &comp) {
	real     = comp.real;
	imaginer = comp.imaginer;
}

Complex :: ~Complex() {
}

int Complex :: getReal() {
	return real;
}

int Complex :: getImaginer() {
	return imaginer;
}

void Complex :: setReal(int re) {
	real = re;
}

void Complex :: setImaginer(int im) {
	imaginer = im;
}

Complex Complex :: operator+(Complex const &comp) {
	Complex hasil;
	hasil.real     = real + comp.real;
	hasil.imaginer = imaginer + comp.imaginer;
	return hasil;
}

Complex Complex :: operator-(Complex const &comp) {
	Complex hasil;
	hasil.real     = real - comp.real;
	hasil.imaginer = imaginer - comp.imaginer;
	return hasil;
}

Complex Complex :: operator * (Complex const &comp) {
	Complex hasil;
	hasil.real     = (real * comp.real) - (imaginer * comp.imaginer);
	hasil.imaginer = (real * comp.imaginer) + (imaginer * comp.real);
	return hasil;
};

