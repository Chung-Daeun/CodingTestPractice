#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<int> st;
    
    for (char c : s) {
        if (c == '(') {
            st.push(0);
        }
        
        if (c == ')') {
            if (st.empty()) {
                return false;
            } else {
                st.pop();
            }
        }
    }
    
    if (!st.empty()){
        return false;
    }
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

    return answer;
}