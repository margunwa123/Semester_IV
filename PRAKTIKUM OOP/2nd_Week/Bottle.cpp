// Bottle.cpp
#include <iostream>
#include "Bottle.hpp"
/*
  float height;           // tinggi Bottle
  float radius;           // radius alas Bottle
  float waterHeight;      // tinggi isi Bottle
  const int id;           // nomor urutan Bottle
  static int numOfBottle; // banyaknya Bottle yang telah diciptakan
*/
//const float PI = 3.14;
int Bottle :: numOfBottle = 0;

Bottle::Bottle() : Bottle(10,10) {}
/* Ctor default Bottle kosong dengan tinggi = 10.00 dan radius = 10.00 */
Bottle::Bottle(float height, float radius) : waterHeight(0), id(numOfBottle+1) {
    this->height = height;
    this->radius = radius;
    numOfBottle++;
}
/* Ctor Bottle jika diketahui nilai tinggi dan radius, Bottle kosong*/
Bottle::Bottle(const Bottle& bottle) : id(bottle.id), waterHeight(bottle.waterHeight) {
    height = bottle.height;
    radius = bottle.radius;
} 
/* Cctor Bottle. id juga dicopy dan numOfBottle tidak bertambah */
Bottle::~Bottle() {

}
/* Destruktor Bottle */

int Bottle::getId() const {
    return id;
}
/* Mengembalikan id Bottle */
float Bottle::getWaterVolume() const {
    return PI * radius * radius * waterHeight; 
}
/* Mengembalikan volume air dalam botol */
float Bottle::getBottleVolume() const {
    return PI * radius * radius * height;
}
/* Mengembalikan volume botol */

void Bottle::setHeight(float height) {
    this->height = height;
    if(height < waterHeight) {
        waterHeight = height;
    }
}
/*
* Mengubah tinggi Bottle. Jika tinggi baru kurang dari tinggi air,
* maka tinggi air = tinggi yang baru.
*/

void Bottle::addWater(float waterVolume) {
    float addedWaterHeight = waterVolume / ( PI * radius * radius );
    waterHeight += addedWaterHeight;
    if(waterHeight > height) {
        waterHeight = height;
    }
}
/*
* Menambahkan air ke dalam botol. Jika botol tidak muat, biarkan
* botol penuh.
*/

void Bottle::substractWater(float waterVolume) {
    float substractedWaterHeight = waterVolume / ( PI * radius * radius );
    waterHeight -= substractedWaterHeight;
    if(waterHeight < 0) {
        waterHeight = 0;
    }
}
/*
* Mengurangi air dari botol. Jika air yang tersedia kurang, biarkan
* botol kosong.
*/

float Bottle::getWaterHeightIfVolume(float waterVolume) const {
    return waterVolume / ( PI * radius * radius ); 
}
/*
* Mengembalikan tinggi air dari botol jika diketahui suatu volume air.
* Tinggi botol diabaikan, dianggap tidak akan terlalu penuh.
*/

void Bottle::pourWaterTo(Bottle& other) {
    float neededWaterVolume = other.getBottleVolume() - other.getWaterVolume();
    float neededWaterHeight = this->getWaterHeightIfVolume(neededWaterVolume);
    if(neededWaterHeight > waterHeight) {
        other.waterHeight += this->getWaterVolume() / (PI * other.radius * other.radius);
        waterHeight       =  0;
    }
    else {
        other.waterHeight = other.height;
        waterHeight      -= neededWaterHeight;
    }
}
/*
* Menuang isi botol ini ke botol lain sampai botol ini kosong.
* Jika botol lain penuh sebelum semua air pindah, maka penuangan
* berhenti dan terdapat sisa air di botol ini.
*/
