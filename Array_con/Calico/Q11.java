import java.io.InputStream;
import java.io.IOException;

public class Q11 {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[32768];
        private int head = 0;
        private int tail = 0;

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                if (c < '0' || c > '9') break;
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public long nextLong() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                if (c < '0' || c > '9') break;
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    // type: 0 = NONE, 1 = UPPER_MAX (lower bound = val), 2 = LOWER_ZERO (upper bound = val)
    static class FlexState {
        int type;
        long val;

        FlexState(int type, long val) {
            this.type = type;
            this.val = val;
        }
    }

    static final FlexState STATE_NONE = new FlexState(0, 0);

    static int[] fixedCount = new int[30];
    static int[] generalCount = new int[30];
    static long[] generalL = new long[30];
    static long[] generalR = new long[30];

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int T = scanner.nextInt();
        if (T == -1) return;

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = scanner.nextInt();
            long[] L = new long[N];
            long[] R = new long[N];

            for (int i = 0; i < N; i++) {
                L[i] = scanner.nextLong();
            }
            for (int i = 0; i < N; i++) {
                R[i] = scanner.nextLong();
            }

            for (int b = 0; b < 30; b++) {
                fixedCount[b] = 0;
                generalCount[b] = 0;
            }

            for (int i = 0; i < N; i++) {
                long l = L[i];
                long r = R[i];
                if (l == r) {
                    for (int b = 0; b < 30; b++) {
                        if (((l >> b) & 1) == 1) {
                            fixedCount[b]++;
                        }
                    }
                } else {
                    long xor = l ^ r;
                    int msb = 63 - Long.numberOfLeadingZeros(xor);
                    generalCount[msb]++;
                    generalL[msb] = l;
                    generalR[msb] = r;
                    for (int b = msb + 1; b < 30; b++) {
                        if (((l >> b) & 1) == 1) {
                            fixedCount[b]++;
                        }
                    }
                }
            }

            long ans = solve(29, STATE_NONE);
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static long solve(int b, FlexState flex) {
        if (b < 0) return 0;

        long mask = 1L << b;

        boolean isFlexActive = false;
        long flexFixedBit = 0;
        FlexState forcedNextFlex = STATE_NONE;

        if (flex.type == 1) { // UPPER_MAX with lower bound l
            long l = flex.val;
            if (l >= mask) {
                isFlexActive = false;
                flexFixedBit = 1;
                forcedNextFlex = new FlexState(1, l - mask);
            } else {
                isFlexActive = true;
            }
        } else if (flex.type == 2) { // LOWER_ZERO with upper bound r
            long r = flex.val;
            if (r < mask) {
                isFlexActive = false;
                flexFixedBit = 0;
                forcedNextFlex = new FlexState(2, r);
            } else {
                isFlexActive = true;
            }
        }

        int numFlexAtB = (isFlexActive ? 1 : 0) + generalCount[b];
        int numForcedFlexAtB = (flex.type != 0 && !isFlexActive) ? 1 : 0;

        // If >= 2 active intervals exist (flexible + forced), maximum all 1s is achievable for remaining bits
        if (numFlexAtB + numForcedFlexAtB >= 2) {
            return (1L << (b + 1)) - 1;
        }

        long fixedXor = (fixedCount[b] % 2) ^ (isFlexActive ? 0 : flexFixedBit);

        if (numFlexAtB == 0 && numForcedFlexAtB == 0) {
            return (fixedXor << b) + solve(b - 1, STATE_NONE);
        }

        if (numForcedFlexAtB == 1) {
            return (fixedXor << b) + solve(b - 1, forcedNextFlex);
        }

        // numFlexAtB == 1 and numForcedFlexAtB == 0
        if (isFlexActive) {
            if (flex.type == 1) {
                // UPPER_MAX with l < mask
                long l = flex.val;
                long val0 = (fixedXor << b) + solve(b - 1, new FlexState(1, l));
                long val1 = ((fixedXor ^ 1) << b) + (1L << b) - 1;
                return Math.max(val0, val1);
            } else {
                // LOWER_ZERO with r >= mask
                long r = flex.val;
                long val0 = (fixedXor << b) + (1L << b) - 1;
                long val1 = ((fixedXor ^ 1) << b) + solve(b - 1, new FlexState(2, r - mask));
                return Math.max(val0, val1);
            }
        } else {
            // generalCount[b] == 1
            long l = generalL[b] & (mask - 1);
            long r = generalR[b] & (mask - 1);

            long val0 = (fixedXor << b) + solve(b - 1, new FlexState(1, l));
            long val1 = ((fixedXor ^ 1) << b) + solve(b - 1, new FlexState(2, r));
            return Math.max(val0, val1);
        }
    }
}