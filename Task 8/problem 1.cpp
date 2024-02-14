#include <iostream>

using namespace std;

int main(){
    int N, M;
    cin >> N >> M;

    int freqArray[M + 1] = {0};

    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        freqArray[num]++;
    }
    for (int i = 1; i <= M; i++)
        cout << freqArray[i] << "\n";
}



