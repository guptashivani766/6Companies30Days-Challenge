class LastMomemtBefAllAuntFallOutOfPlank 
{
	public int getLastMoment(int n, int[] left, int[] right) {
    int leftMax = left.length > 0 ? Arrays.stream(left).max().getAsInt() : 0,
        rightMin = right.length > 0 ? Arrays.stream(right).min().getAsInt() : n;
    
    return Math.max(n - rightMin, leftMax);
}
}
