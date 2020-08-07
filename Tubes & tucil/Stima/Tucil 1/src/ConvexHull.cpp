#include "ConvexHull.h"
#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <time.h>
using namespace std;

int scanNumber(){
    int number;
    cout << "Berapa Banyak Point yang Anda Inginkan?" << endl << "> ";
    cin  >> number;
    return number;
}

bool isPointEqual(Point P1, Point P2){
    return((P1.X == P2.X) && (P1.Y == P2.Y));
}

void printPoint(Point P) {
    cout << "(" << P.X << "," << P.Y << ")";
}

Point getRandomPoint() {
    Point P;
    P.X = (double)(rand() % 21);
    P.Y = (double)(rand() % 21);
    return P;
}

TabPoint createEmptyTabPoint(int NbElmt) {
    TabPoint Hasil;
    Hasil.TabP = (Point*) malloc((NbElmt) * sizeof(Point));
    Hasil.Neff = NbElmt;
    return Hasil; 
}

TabPoint generateRandomPoints(int Neff) {
    TabPoint TP = createEmptyTabPoint(Neff);
    for(int i = 0 ; i < Neff ; i++) {
        TP.TabP[i] = getRandomPoint();
    }
    return TP;
}

//Function printTabPoint only for debugging
void printTabPoint(TabPoint TP) {
    for(int i = 0 ; i < TP.Neff ; i++) {
        cout << "Point ke-" << i+1 << " :" << endl;
        printPoint(TP.TabP[i]); cout << endl;
    }
    cout << endl;
}

bool isPointInsideTabPoint(Point P, TabPoint TP) {
    int i = 0;
    while(!isPointEqual(P,TP.TabP[i]) && i < TP.Neff) {
        i++;
    }
    return (i < TP.Neff);
}


bool isPointAboveLine(Point P, Line L) {
    return ( (L.Y*P.Y) > ((-L.X * P.X) - L.konstanta) );
}

Line makeLineFromPoints(Point P1, Point P2){
    Line Hasil;
    double selisihX = P2.X - P1.X;
    double selisihY = P2.Y - P1.Y;
    Hasil.Y = selisihX;
    Hasil.X = -selisihY;
    Hasil.konstanta = (-selisihX * P1.Y) + (selisihY * P1.X);
    return Hasil;
}


bool isLineConvexHull(Line L, TabPoint TP) {
    bool check = true;
    bool temp = isPointAboveLine(TP.TabP[0],L);
    bool isOneSide = temp;
    int i = 1;
    while(check && i < TP.Neff) {
        temp = isPointAboveLine(TP.TabP[i],L);
        if(temp != isOneSide) {
            check = false;
        }
        i++;
    }
    return check;
}

TabPoint getFirstConvexHull(TabPoint TP) {
    bool found = false;
    int i = 0;
    int j;
    Line L;
    TabPoint Hasil = createEmptyTabPoint(2);
    while(!found){
        j = 0;
        while(!found && j < TP.Neff){
            if(j != i && !isPointEqual(TP.TabP[i],TP.TabP[j])) {
                L = makeLineFromPoints(TP.TabP[i],TP.TabP[j]);
                found = (isLineConvexHull(L,TP));
            }
            j++;
        }
        i++;
    }
    Hasil.TabP[0] = TP.TabP[i-1];
    Hasil.TabP[1] = TP.TabP[j-1];
    return Hasil;
}

Point getNextConvexHullPoint(Point P, TabPoint TP, TabPoint CurrentConvexHull) {
//I.S. Point P ada di TabPoint TP, Point P merupakan bagian dari himpunan point convex hull
    Point Hasil;
    bool found = false;
    int i = 0;
    while(!found){
        if(!isPointEqual(P, TP.TabP[i])) {
            Hasil = TP.TabP[i];
            found = isLineConvexHull(makeLineFromPoints(P,Hasil),TP);
            if(found && !isPointEqual(Hasil,CurrentConvexHull.TabP[0])) {
                found = !isPointInsideTabPoint(Hasil,CurrentConvexHull);
            }
        }
        i++;
    }
    return Hasil;
}

TabPoint getConvexHull(TabPoint TP) {
    TabPoint Hasil = createEmptyTabPoint(TP.Neff + 1);
    TabPoint FirstTwoPoint = getFirstConvexHull(TP);
    Hasil.TabP[0] = FirstTwoPoint.TabP[0];
    Hasil.TabP[1] = FirstTwoPoint.TabP[1];
    Hasil.Neff = 2;
    for(int i = 1 ; i < TP.Neff ; i++) {
        Hasil.TabP[i+1] = getNextConvexHullPoint(Hasil.TabP[i],TP,Hasil);
        Hasil.Neff++;
        if(isPointEqual(Hasil.TabP[i+1],Hasil.TabP[0])) {
            break;
        }
    }
    Hasil.TabP[Hasil.Neff-1].X = Hasil.TabP[0].X;
    Hasil.TabP[Hasil.Neff-1].Y = Hasil.TabP[0].Y;
    return Hasil;
}

void printConvexHull(TabPoint TP) {
    cout << "( ";
    for(int i = 0 ; i < TP.Neff-1 ; i++) {
        printPoint(TP.TabP[i]);
        cout << ",";
    }
    printPoint(TP.TabP[0]);
    cout << " )";
}


int main() {
    int NElement = scanNumber();
    TabPoint ArrayPoint = generateRandomPoints(NElement);
    printTabPoint(ArrayPoint);
    clock_t tStart = clock();
    TabPoint Result = getConvexHull(ArrayPoint);
    cout << "Executing Time : " << (double)((clock() - tStart)/CLOCKS_PER_SEC) << endl;
    cout << "Hasil Convex Hull : "; printConvexHull(Result);
    return 0;
}