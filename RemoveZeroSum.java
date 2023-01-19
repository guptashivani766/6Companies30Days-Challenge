class RemoveZeroSum 
{
	 public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> sumNodeMap = new HashMap<>();
        
        ListNode dummyPreHead = new ListNode(0);
        dummyPreHead.next = head;
        
        sumNodeMap.put(0, dummyPreHead);                                    //Init the stack with prehead.
        
        ListNode currNode = head;

        int sum = 0;
        
        while(currNode!=null){
            
            sum += currNode.val;
            
            if(sumNodeMap.containsKey(sum)){
                
                ListNode oldNodeWithSameSum = sumNodeMap.get(sum);          //Old node with same sum
                
                ListNode toBeRemovedNode = oldNodeWithSameSum.next;         //Remove zero-sum in-between nodes from sumNodeMap
                int toBeRemovedSum = sum;
                while(toBeRemovedNode != currNode){
                    toBeRemovedSum = toBeRemovedSum + toBeRemovedNode.val;
                    sumNodeMap.remove(toBeRemovedSum);
                    toBeRemovedNode = toBeRemovedNode.next;
                }
                oldNodeWithSameSum.next = currNode.next;                    //Point old node to current next node
            }
            else{
                sumNodeMap.put(sum, currNode);
            }
            
            currNode = currNode.next;
        }
        
        return dummyPreHead.next; 
    }
}
