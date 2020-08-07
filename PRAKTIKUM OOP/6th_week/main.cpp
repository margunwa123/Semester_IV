#include <iostream>
#include <map>
using namespace std;

int main() {
    map<int,string> hojunWords;
    map<int,string> qilaWords;
    map<int,string> result;
    map<int,string>::iterator it;
    string temp;
    int resIndex = 0;
    bool found;

    int sizeHojunWords; cin >> sizeHojunWords;
    for(int i = 0 ; i < sizeHojunWords ; i++) {
        cin >> temp;
        hojunWords[i] = temp;
    }

    int sizeQilaWords;  cin >> sizeQilaWords;
    for(int i = 0 ; i < sizeQilaWords ; i++) {
        cin >> temp;
        qilaWords[i] = temp;
    }

    for(int i = 0 ; i < sizeHojunWords ; i++) {
        found = false;
        for(it = qilaWords.begin() ; it != qilaWords.end() ; it++) {
            if(hojunWords[i] == it->second) {
                found = true;
                qilaWords.erase(it);
            }
        }
        if(!found) {
            result[resIndex] = hojunWords[i];
            cout << result[resIndex] << endl;
            resIndex++;
        }
    }

    return 0;
}
