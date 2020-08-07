#include <iostream>


template <class T>
T MinArray(T Array[]) {
    T min = Array[0];
    int i = 0;
    while(Array[i] != '\0') {
        if(Array[i] < min) {
            min = Array[i];
        }
        i++;
    }
    return min;
}

template <class T>
void PrintArray(T Array[]) {
    int i = 0;
    bool isEmpty = Array[0] ? false : true;
    while(Array[i] != '\0') {
        std::cout << Array[i] << std::endl;
        i++;
    }
    if(isEmpty) {
        std::cout << "ARRAY KOSONG";
    }
}

class Point {
    public:
        int x;
        int y;
        Point() {
            x = 5;
            y = 5;
        }
        Point(int x, int y) {
            this->x = x;
            this->y = y;
        }
};