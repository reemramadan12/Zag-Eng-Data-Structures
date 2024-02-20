#include <iostream>
#include <string>

using namespace std;

int main() {
    string S;
    getline(cin, S);

    int freqSort[26] = {0};
    int count[26] = {0};

    for (int i = 0; i < S.size(); i++) {
        freqSort[S[i] - 'a']++;
        count[S[i] - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
        if (freqSort[i] != 0 && count[i] == 1) {
            cout << char('a' + i) << "\n";
        }
    }

    cout << "All characters are repeated\n";
}
