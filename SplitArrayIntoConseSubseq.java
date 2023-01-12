class SplitArrayIntoConseSubseq 
{
	public boolean isPossible(int[] nums) {
        Map<Integer, Integer> notPlacedCount = new HashMap<>();   // entry = {num, count of unplaced nums}
        Map<Integer, Integer> sequenceEndCount = new HashMap<>(); // entry = {num, count of sequences ending at num}

        for (int num : nums) increaseCount(notPlacedCount, num);

        for (int num : nums) {
            boolean alreadyContains = notPlacedCount.get(num) == 0;
            boolean canAddToExisting = sequenceEndCount.getOrDefault(num - 1, 0) > 0;
            boolean canAddNewSequence = notPlacedCount.getOrDefault(num + 1, 0) > 0 && notPlacedCount.getOrDefault(num + 2, 0) > 0;

            if (alreadyContains)
                continue;

            if (canAddToExisting) {
                decreaseCount(notPlacedCount, num);
                decreaseCount(sequenceEndCount, num - 1);
                increaseCount(sequenceEndCount, num);
            }

            else if (canAddNewSequence) {
                decreaseCount(notPlacedCount, num);
                decreaseCount(notPlacedCount, num + 1);
                decreaseCount(notPlacedCount, num + 2);
                increaseCount(sequenceEndCount, num + 2);
            }

            else
                return false;
        }
        return true;
    }

    private void increaseCount(Map<Integer, Integer> countMap, int num) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    private void decreaseCount(Map<Integer, Integer> countMap, int num) {
        countMap.put(num, countMap.get(num) - 1);
    }
}
