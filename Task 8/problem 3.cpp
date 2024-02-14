#include <iostream>

using namespace std;

int main(){
    string S;
    getline(cin, S);

    int freqSort[26] = {0};
    for (int i = 0; i < S.size(); i++)
        freqSort[ S[i] - 'a']++;

    for (int i = 0; i < 26; i++){
        if (freqSort[i]!= 0)
            for(int j = 0; j < freqSort[i]; j++)
                cout << char(i + 'a');
    }
}
