#include "Kendaraan.hpp"

class Minibus : public Kendaraan {
    private:
        int kapasitas;
    public:
        Minibus();
        void printInfo();
};