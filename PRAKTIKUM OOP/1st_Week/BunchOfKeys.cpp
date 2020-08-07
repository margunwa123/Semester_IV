// BunchOfKeys.cpp
// Mario Gunawan
// 13518114 K03

#include "BunchOfKeys.hpp"
using namespace std;

BunchOfKeys :: BunchOfKeys() {
	this->n_keys = 0;
}

void BunchOfKeys :: add() {
	this->n_keys += 1;
}

void BunchOfKeys :: shake() {
	if( this->n_keys <= 1 ) {
		cout << "Tidak terjadi apa-apa" << endl;
	}
	else{
		for( int i = 1 ; i <= this->n_keys ; i++ ) {
			cout << "krincing" << endl;
		}
	}
}
