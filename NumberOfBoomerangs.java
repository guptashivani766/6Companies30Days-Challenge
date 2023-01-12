class NumberOfBoomerangs 
{
	 public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0){
			return 0;
		}
		int count = 0;
		Map<Integer,Integer> hashMap = new HashMap<>();
		for (int i = 0;i < points.length;i++){
			
			hashMap.clear();
			for (int j = 0;j < points.length;j++){
				
				if (i == j){
					continue;
				}
				int distance = (points[j][0]-points[i][0])*(points[j][0]-points[i][0]) + (points[j][1]-points[i][1]) * (points[j][1]-points[i][1]);
				count += hashMap.getOrDefault(distance,0) * 2;
				hashMap.put(distance,hashMap.getOrDefault(distance,0) + 1);
			}
		}
		return count;
    }
}
