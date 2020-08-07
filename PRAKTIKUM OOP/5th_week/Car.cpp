#include <iostream>
#include "Car.h"

using namespace std;

	// private:
	// 	Fuel fuel;
	// 	int gear;
	// 	int ac_power;
	// 	bool on;
// Ctor
// Menginisiasi jenis fuel dengan t_fuel, gear = 0, ac_power = 0 dan on = false.
Car::Car(Fuel t_fuel) : fuel(t_fuel), gear(0), ac_power(0), on(false) {}

Fuel Car::getFuel() {
    return this->fuel;
}
int Car::getGear() {
    return this->gear;
}
int Car::getAcPower() {
    return this->ac_power;
}
bool Car::getOn() {
    return this->on;
}

/* 
    Melakukan isi bensin terhadap mobil
    Melakukan pengecekan jenis bensin masukan apakah sesuai dengan jenis bensin mobil.
    Bila tidak sesuai lakukan throw jenis bensin masukan (t_fuel)
    Bila sesuai, akan menghasilkan keluaran "Berhasil isi bensin sebanyak (nilai amount_in_liter) liter" diakhiri newline dan abaikan tanda '()'
*/
void Car::fillingFuel(Fuel t_fuel, int amount_in_liter) {
    if(this->fuel != t_fuel) {
        throw t_fuel;
    }
    else {
        cout << "Berhasil isi bensin sebanyak " << amount_in_liter << "liter" << endl;
    }
}

/* 
    Melakukan pergantian gigi mobil
    Melakukan pengecekan t_gear sebagai masukan gigi apakah berada pada range MIN_GEAR<=X<=MAX_GEAR.
    Bila tidak sesuai range lakukan throw gigi masukan (t_gear).
    Bila sesuai, akan merubah nilai gear si mobil dan
    menghasilkan keluaran "Berhasil mengubah gigi menjadi gigi (nilai t_gear)" diakhiri newline dan abaikan tanda '()'.
*/
void Car::changeGear(int t_gear) {
    
}

/* 
    Melakukan pergantian power ac pada mobil
    Melakukan pengecekan t_ac_power sebagai masukan power ac apakah berada pada range MIN_AC<=X<=MAX_AC.
    Bila tidak sesuai range lakukan throw power ac masukan (t_ac_power).
    Bila sesuai, akan merubah nilai ac_power si mobil dan
    menghasilkan keluaran "Berhasil mengubah power ac menjadi (nilai t_ac_power)" diakhiri newline dan abaikan tanda '()'.
*/
void changeAcPower(int t_ac_power);

/* 
    Melakukan starter/ menyalakan mobil
    Melakukan pengecekan apakah mobil sudah dalam kondisi menyala atau belum ketika fungsi start dipanggil.
    Bila mobil sudah menyala lakukan throw nilai on mobil.
    Bila mobil belum menyala akan merubah nilai on mobil menjadi true dan
    menghasilkan keluaran "Berhasil melakukan starter mobil" diakhiri newline.
*/
void start();

/* 
    Melakukan pergantian pengecekan seluruh fitur pada mobil
    Pengecekan fitur dilakukan dengan cara pemanggilan fungsi dengan urutan
    start -> fillingFuel dengan menggunakan parameter masukan pertama dan kedua 
    -> changeGear dengan menggunakan parameter masukan ketiga
    -> changeAcPower dengan menggunakan parameter masukan keempat.
    Implementasikan prosedur ini menggunakan try catch, dengan multiple catch, total tiga jenis catch.
    Catch tipe boolean, akan menghasilkan keluaran "Mobil sudah menyala" diakhiri newline
    Catch tipe integer, akan menghasilkan keluaran "Input angka diluar range" diakhiri newline
    Catch tipe Fuel, akan menghasilkan keluaran "Bensin tidak sesuai" diakhiri newline
*/
void service(Fuel t_fuel, int amount_in_liter, int t_gear, int t_ac_power);