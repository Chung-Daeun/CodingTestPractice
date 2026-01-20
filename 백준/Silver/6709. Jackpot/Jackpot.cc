#include <iostream>

using namespace std;

int N;
int numW;
int wheels[5];

void input() {
    cin >> numW;
    for (int i = 0; i < numW; i++) {
        cin >> wheels[i];
    }
}

int findLSD(int a, int b) {
    if (a % b == 0) {
        return b;
    }

    return findLSD(b, a % b);
}

void pro() {
    long gcd = wheels[0];
    bool isOver = false;

    for (int i = 1; i < numW; i++) {
        gcd = gcd * wheels[i] / findLSD(max(gcd, (long)wheels[i]), min(gcd, (long)wheels[i]));

        if (gcd > 1000000000) {
            cout << "More than a billion.\n";
            isOver = true;
            break;
        }
    }

    if (!isOver) {
        cout << gcd << "\n";
    }
}



int main() {
    // 입출력 최적화
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 입력
    cin >> N;
    for (int i = 0; i < N; i++) {
        input();
        pro();
    }

}