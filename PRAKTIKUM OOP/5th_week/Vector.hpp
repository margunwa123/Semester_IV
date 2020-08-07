
#ifndef _VECTOR_HPP_
#define _VECTOR_HPP_

#include <iostream>

using namespace std;

template <class T, int N>
class Vector {
private:
    T* elements;

public:
    Vector() {
        this->elements = new T[N];
    }

    Vector(const Vector &other) {
        this->elements = new T[N];
        for( int i = 0 ; i < N ; i++ ) {
			this->elements[i] = other.elements[i];
		}
    }

    ~Vector() {
        delete[] this->elements;
    }

    T& operator[](int idx) {
        return this->elements[idx];
    }

    Vector<T, N> operator+(const Vector<T,N> &other) {
        Vector result;
        for( int i = 0 ; i < N ; i++ ) {
			result.elements[i] = this->elements[i] + other.elements[i];
		}
        return result;
    }

    Vector<T, N> operator-(const Vector<T,N> &other) {
        Vector result;
        for( int i = 0 ; i < N ; i++ ) {
			result.elements[i] = this->elements[i] - other.elements[i];
		}
        return result;
    }

    bool operator<(const Vector<T,N> &other) {
		int last_index = N - 1;
		for( int i = 0 ; i <= last_index ; i++ ) {
			if( this->elements[i] !=  other.elements[i] ) {
				return this->elements[i] < other.elements[i];
			}
		}
		return false;
    }

    bool operator>(const Vector<T,N> &other) {
        int last_index = N - 1;
		for( int i = 0 ; i <=last_index ; i++ ) {
			if( this->elements[i] !=  other.elements[i] ) {
				return this->elements[i] > other.elements[i];
			}
		}
		return false;
    }

    friend ostream& operator<<(ostream& os, Vector<T, N> vector) {
        os << "<";
        int last_index = N - 1;
        for( int i = 0 ; i < last_index ; i++ ) {
			os << vector.elements[i];
			os << ",";
		}
        os << vector.elements[last_index] << ">";
        return os;
    }

    friend istream& operator>>(istream& is, Vector<T, N> &vector) {
		for( int i = 0 ; i < N ; i++) {
			is >> vector.elements[i];
		}
		return is;
    }
};

#endif
