#include "ArrayFunction.hpp"
#define DEFAULT_SIZE 5
using namespace std;

int main() {
    int Array[DEFAULT_SIZE] = {3,23,4,20,6};
    float FloatArr[DEFAULT_SIZE] = {3.3,2.4,4.6,5.1,5.0};
    Point pointArr[DEFAULT_SIZE];
    for(int i = 0 ; i < DEFAULT_SIZE ; i++) {
        pointArr[i] = Point(i,i*5);
    }
    cout << pointArr[1].x << endl 
         << pointArr[1].y << endl;
    std::cout << (MinArray<int>(Array)) << std::endl;
    std::cout << (MinArray<float>(FloatArr)) << std::endl;
    // PrintArray<int>(Array);
    return 0;
}