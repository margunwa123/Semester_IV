#ifndef __POLINOM_HPP__
#define __POLINOM_HPP__

#define RANDOMIZE       true
#define NOT_RANDOMIZE   false
#define MAX_KOEF_RANDOM 100

class Polinom {
    private:
        int max_derajat;
        int* koef;
        static int jumlah_polinom;
        int jumlah_perkalian;
        int jumlah_penjumlahan;
    public:
        //ctor, dtor, cctor
        Polinom(int max_derajat, bool isRandom); // boolean isRandom? kalo true, randomisasi semua elemen senarai
        Polinom();
        Polinom(const Polinom& other);
        ~Polinom();
        void reconstruct(int max_derajat, bool isRandom);
        // Operator
        operator=(const Polinom& other);
        Polinom operator-(const Polinom &other);
        Polinom operator+(const Polinom &other);
        Polinom operator*(const Polinom &other);
        // Setter
        void setElement(int derajat, int value);
        void addElement(int derajat, int value);
        void getUserInput();
        void randomize();
        // Getter
        int getJumlahPerkalian();
        int getJumlahPenjumlahan();
        int getMaxDerajat();
        int getElement(int index);
        // Print
        void PrintInfo();
        // Solverk
        Polinom kaliBruteForce(const Polinom& other);
        friend Polinom kaliDivideAndConquer(Polinom&, Polinom&);
};

#endif