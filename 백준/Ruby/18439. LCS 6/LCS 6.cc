#include <iostream>
#include <string>
#include <vector>

using namespace std;

typedef unsigned long long ull;

int main() {
    // 입출력 속도 향상
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string A, B;
    if (!(cin >> A >> B)) return 0;

    int n = A.size();
    int m = B.size();

    // 64비트(ull) 단위로 나눈 블록의 개수
    int words = (m + 63) / 64;

    // 각 알파벳이 B 문자열의 어느 위치에 등장하는지 비트마스크로 저장 (메모리: 약 160KB)
    vector<vector<ull>> P(26, vector<ull>(words, 0));
    for (int i = 0; i < m; ++i) {
        P[B[i] - 'A'][i / 64] |= (1ULL << (i % 64));
    }

    // LCS의 DP 상태를 저장하는 비트셋 역할 (메모리: 약 6KB)
    vector<ull> D(words, 0);

    for (int i = 0; i < n; ++i) {
        int c = A[i] - 'A';
        ull carry_shift = 1;
        ull borrow = 0;

        for (int w = 0; w < words; ++w) {
            ull x = D[w] | P[c][w];
            ull y = (D[w] << 1) | carry_shift;
            
            // 다음 블록으로 넘어갈 시프트 캐리 계산
            carry_shift = D[w] >> 63;

            // x - y를 수행하며 이전 블록의 빌림(borrow)까지 적용
            ull sub = x - y - borrow;

            // borrow 상태 갱신
            if (x < y) borrow = 1;
            else if (x == y && borrow == 1) borrow = 1;
            else borrow = 0;

            // 새로운 D 갱신
            D[w] = x & (~sub);
        }
        
        // 마지막 블록의 범위를 벗어나는 쓰레기 비트값 제거
        if (m % 64 != 0) {
            D[words - 1] &= ((1ULL << (m % 64)) - 1);
        }
    }

    // 1로 세팅된 비트의 총 개수가 곧 LCS의 길이
    int lcs_length = 0;
    for (int w = 0; w < words; ++w) {
        lcs_length += __builtin_popcountll(D[w]);
    }

    cout << lcs_length << "\n";

    return 0;
}