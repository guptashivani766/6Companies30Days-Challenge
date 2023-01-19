class MinGenericMutuation 
{
	 public int minMutation(String start, String end, String[] bank) {
        Set<String> geneBankSet = new HashSet<>(Arrays.asList(bank));
        
        if(! geneBankSet.contains(end)) return -1;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int level = 0;
        
        //valid mutations
        char [] mutations = new char [] {'A', 'C', 'G', 'T'};
        
        while(! queue.isEmpty()){
            
            //iterate thru gene seqs in current level
            int size = queue.size();            
            for(int i = 0 ; i < size; i++){
                String seq = queue.poll();    
                
                // try mutations at each char pos
                for(int j = 0 ; j < seq.length(); j++){
                    char [] chars = seq.toCharArray();
                    
                    for(char c: mutations){
                        chars[j] = c;
                        String newSeq = new String(chars);
                        
                        if(end.equals(newSeq)){
                            return level + 1 ;
                        }
                        
                        if(! visited.contains(newSeq) && geneBankSet.contains(newSeq)){
                            visited.add(newSeq);
                            queue.add(newSeq);
                        }
                    }    
                }
                
            }
            
            level++;
            
        }
        
        return -1;
        
    }
}
