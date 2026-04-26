import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());
        long shift = 1;
        
        while (N % 4 == 0) {
            N /= 4;
            shift *= 2;
        }
        
        if (isSquare(N)) {
            print(shift, (long) Math.round(Math.sqrt(N)));
        }
        
        Map<Long, Integer> fac = new HashMap<>();
        factorize(N, fac);
        if (isSumOf2Squares(fac)) {
            long[] xy = get2Squares(N, fac);
            print(shift, xy[0], xy[1]);
        }
        
        if (N % 8 != 7) {
            for (long z = 1; z * z < N; z++) {
                long rem = N - z * z;
                fac.clear();
                factorize(rem, fac);
                if (isSumOf2Squares(fac)) {
                    long[] xy = get2Squares(rem, fac);
                    print(shift, xy[0], xy[1], z);
                }
            }
        }
        
        for (long w = 1; w * w < N; w++) {
            long rem1 = N - w * w;
            if (is3Squares(rem1)) {
                for (long z = 1; z * z < rem1; z++) {
                    long rem2 = rem1 - z * z;
                    fac.clear();
                    factorize(rem2, fac);
                    if (isSumOf2Squares(fac)) {
                        long[] xy = get2Squares(rem2, fac);
                        print(shift, xy[0], xy[1], z, w);
                    }
                }
            }
        }
    }

    static void print(long shift, long... arr) {
        List<Long> list = new ArrayList<>();
        for (long v : arr) {
            if (v > 0) list.add(v * shift);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i == list.size() - 1 ? "" : " "));
        }
        System.out.println();
        System.exit(0);
    }

    static boolean isSquare(long n) {
        long sq = (long) Math.round(Math.sqrt(n));
        return sq * sq == n;
    }

    static boolean is3Squares(long n) {
        while (n % 4 == 0) n /= 4;
        return n % 8 != 7;
    }

    static long mulMod(long a, long b, long m) {
        long res = 0;
        a %= m;
        b %= m;
        while (b > 0) {
            if ((b & 1) == 1) res = (res + a) % m;
            a = (a + a) % m;
            b >>= 1;
        }
        return res;
    }

    static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = mulMod(res, base, mod);
            base = mulMod(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    static boolean millerRabin(long n, long a) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        long d = n - 1;
        int s = 0;
        while (d % 2 == 0) {
            d /= 2;
            s++;
        }
        long x = modPow(a, d, n);
        if (x == 1 || x == n - 1) return true;
        for (int r = 1; r < s; r++) {
            x = mulMod(x, x, n);
            if (x == n - 1) return true;
        }
        return false;
    }

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3 || n == 5 || n == 7) return true;
        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) return false;
        long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        for (long a : primes) {
            if (n == a) return true;
            if (!millerRabin(n, a)) return false;
        }
        return true;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static long pollardRho(long n) {
        if (n % 2 == 0) return 2;
        if (isPrime(n)) return n;
        long x = 2, y = 2, d = 1, c = 1;
        while (d == 1) {
            x = (mulMod(x, x, n) + c) % n;
            y = (mulMod(y, y, n) + c) % n;
            y = (mulMod(y, y, n) + c) % n;
            d = gcd(x > y ? x - y : y - x, n);
            if (d == n) {
                x = (long) (Math.random() * (n - 2)) + 2;
                y = x;
                c = (long) (Math.random() * (n - 1)) + 1;
                d = 1;
            }
        }
        return d;
    }

    static void factorize(long n, Map<Long, Integer> factors) {
        if (n == 1) return;
        while (n % 2 == 0) {
            factors.put(2L, factors.getOrDefault(2L, 0) + 1);
            n /= 2;
        }
        if (n == 1) return;
        if (isPrime(n)) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
            return;
        }
        long d = pollardRho(n);
        factorize(d, factors);
        factorize(n / d, factors);
    }

    static boolean isSumOf2Squares(Map<Long, Integer> factors) {
        for (Map.Entry<Long, Integer> entry : factors.entrySet()) {
            if (entry.getKey() % 4 == 3 && entry.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    static long[] cornacchia(long p) {
        long a = 2;
        while (modPow(a, (p - 1) / 2, p) == 1) {
            a++;
        }
        long r = modPow(a, (p - 1) / 4, p);
        long r1 = p, r2 = r;
        long limit = (long) Math.sqrt(p);
        while (r2 > limit) {
            long temp = r1 % r2;
            r1 = r2;
            r2 = temp;
        }
        long x = r2;
        long y = (long) Math.sqrt(p - x * x);
        return new long[]{x, y};
    }

    static long[] get2Squares(long n, Map<Long, Integer> factors) {
        long X = 1, Y = 0;
        for (Map.Entry<Long, Integer> entry : factors.entrySet()) {
            long p = entry.getKey();
            int e = entry.getValue();
            if (p % 4 == 3) {
                long mult = 1;
                for (int i = 0; i < e / 2; i++) mult *= p;
                X *= mult;
                Y *= mult;
            } else if (p == 2) {
                for (int i = 0; i < e; i++) {
                    long nX = Math.abs(X - Y);
                    long nY = Math.abs(X + Y);
                    X = nX;
                    Y = nY;
                }
            } else {
                long[] xy = cornacchia(p);
                for (int i = 0; i < e; i++) {
                    long nX = Math.abs(X * xy[0] - Y * xy[1]);
                    long nY = Math.abs(X * xy[1] + Y * xy[0]);
                    X = nX;
                    Y = nY;
                }
            }
        }
        return new long[]{X, Y};
    }
}