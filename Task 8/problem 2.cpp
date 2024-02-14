#include <iostream>

using namespace std;

int main(){
    string S;
    getline(cin, S);

    int freqArray [26] = {0};
    for (int i = 0; i < S.size(); i++){
        freqArray[ S[i] - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
        if(freqArray[i]!=0)
            cout <<  char(i + 'a') << " : " << freqArray[i] << "\n";
    }
}
