#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int main() {
    int n;
    int sum = 0;
    cin >> n;
    if( n > 0) {
        vector<int> A(n);
        int modus = 0;
        int nelmt_modus = 0;
        int occurence_now = 0;
        for(int i = 0 ; i < n ; i++) {
            cin >> A[i];
            sum += A[i];
        }
        vector<int> B = A;
        sort(A.begin(), A.end());
        for(int i = 0 ; i < n ; i++) {
            if( i == 0) {
                modus = A[i];
                nelmt_modus = 1;
            }
            else if(A[i] != A[i - 1]) {
                occurence_now = 1;
            }
            else {
                if(modus == A[i]) {
                    nelmt_modus++;
                } 
                else {
                    occurence_now++;
                } 
                if(occurence_now > nelmt_modus) {
                    modus = A[i];
                    nelmt_modus = occurence_now;
                }
                else if(occurence_now == nelmt_modus) {
                    if(A[i] < modus) {
                        modus = A[i];
                    }
                }
            }
            
        }
        float mean   = (float)sum / (float)n;
        float median = n % 2 == 0 ? ((float)A[n/2 - 1]+ (float)A[n/2]) / 2 : A[n/2];
        cout << mean << endl;
        cout << median << endl;
        cout << modus << endl;
        for(int i = 0 ; i < n ; i++) {
            cout << B[i] << " ";
        }
        for(int i = 0 ; i < nelmt_modus - 1 ; i++) {
            cout << modus << " ";
        }
        cout << modus << endl;
        cout << n + nelmt_modus << endl;
    }
    else {
        cout << "-" << endl
             << "-" << endl
             << "-" << endl
             << "-" << endl
             << 0;
    }
    return 0;
}
