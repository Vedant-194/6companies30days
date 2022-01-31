class Solution {
	int a = 0;
	int b = 0;

	public boolean stoneGame(int[] piles) {
		pick(piles, 0, piles.length-1);
		return a > b;
	}

	private void pick(int [] piles, int start , int end) {
		if(end - start >= 3) {
			if(piles[start] + piles[end - 1] > piles[end] + piles[start + 1]) {
				//choose start
				a += piles[start];
				b += piles[end];
			}else {
				//choose end
				a += piles[end];
				b += piles[start];
			}
			pick(piles, start + 1, end - 1);

		}else {
			a += Math.max(piles[start], piles[end]);
			b += Math.min(piles[start], piles[end]);
		}
	}
}
