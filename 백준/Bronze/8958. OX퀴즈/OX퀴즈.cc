#include <iostream>
#include <set>
using namespace std;

int score(string str){
    int sc = 0;
    int sum = 0;
    for(int i = 0; i < str.length(); i++){
        switch(str[i]){
            case 'O':
                sc += 1;
                break;
            case 'X':
                sc = 0;
                break;
        }
        sum += sc;
    }
    return sum;
}

int main() {
    int num;
    string str;
    cin >> num;
    for(int i = 0; i < num; i++){
        cin >> str;
        cout << score(str) << endl;
    }

}