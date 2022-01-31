class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0;
        int countB = 0;

        char[] mass = colors.toCharArray();

        for (int i = 1; i < mass.length - 1; i++) {
            if (mass[i - 1] == 'A' && mass[i] == 'A' && mass[i + 1] == 'A') {
                countA ++;
            }
            if (mass[i - 1] == 'B' && mass[i] == 'B' && mass[i + 1] == 'B') {
                countB ++;
            }
        }
        return countA > countB;
    }
}
