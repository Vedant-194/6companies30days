public int[] recoverArray(int n, int[] sums) {
	int[] ret = new int[n];
	Arrays.sort(sums);
	generate(ret, 0, Arrays.stream(sums).boxed().collect(Collectors.toList()));
	return ret;
}

void generate(int[] ret, int c, List<Integer> currentLevel) {
	if (currentLevel.size() == 1) return;
	List<Integer> left = new ArrayList<>();
	List<Integer> right = new ArrayList<>();
	int k = 0;
	boolean containsZero = false;  
	for (int i = 0; i < currentLevel.size(); i++) {
		if (right.size() > k && right.get(k).equals(currentLevel.get(i))) {
			k++;
		} else {
			left.add(currentLevel.get(i));
			if (currentLevel.get(i) == 0) {
				containsZero = true;
			}
			right.add(currentLevel.get(i) + currentLevel.get(1) - currentLevel.get(0));
		}
	}
	ret[c++] = containsZero ? currentLevel.get(1) - currentLevel.get(0) : currentLevel.get(0) - currentLevel.get(1); 
	generate(ret, c, containsZero ? left : right);  
}
