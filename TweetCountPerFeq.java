class  TweetCountPerFeq
{
	 Map<String, TreeMap<Integer, Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }
    
    // O(1) for existed time
    // O(1) for a new tweetName
    // O(log(N)) for a new time, where N is the number of unique time of a tweetName
    public void recordTweet(String tweetName, int time) {
        if(!map.containsKey(tweetName)) map.put(tweetName, new TreeMap<>());
        map.get(tweetName).put(time, map.get(tweetName).getOrDefault(time, 0) + 1);
    }
    
    // O(k * log(N)), where N is the number of unique time of a tweetName, k is (endTime - startTime) / freq 
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int time = helper(freq);
        List<Integer> ans = new ArrayList<>();
        if(!map.containsKey(tweetName)) return ans;
        for(int i = startTime; i <= endTime; i += time + 1) {
            int start = i;
            int end = Math.min(i + time, endTime);
            int count = 0;
            for(int val: map.get(tweetName).subMap(start, true, end, true).values()) count += val;
            ans.add(count);
        }
        return ans;
    }
    
    private int helper(String freq) {
        if(freq.equals("minute")) return 59;
        else if(freq.equals("hour")) return 3599;
        return 86399;
    }
}
