class Solution{
	public static int getMinStep(int[] road){
		Set<Integer> c = new HashSet<Integer>();
		Set<Integer> ans = new HashSet<Integer>();
		
		c.addAll(Arrays.stream(road).boxed().collect(Collectors.toList()));
		int min = 0;
		for(int i = 0;i < road.length;i++){
			int step = 1;
			ans.add(road[i]);
			for(int j = i+1;j < road.length;j++){
				step++;
				ans.add(road[j]);
				if(ans.size() == c.size()){
					if(min == 0 || min > step)min = step;
					ans.clear(); 
					break;
				}
			}
		}
		return min;
	}

}
