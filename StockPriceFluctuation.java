class StockPriceFluctuation 
{
	 HashMap<Integer,Integer> h; //(key,value)=>(timestamp,price)
    TreeMap<Integer,Integer> tm;//(key,value)=>(price,frequency of price)
    int current;
    public StockPrice() {
        h=new HashMap<>();
        tm=new TreeMap<>();
        current=0;
    }
    
    public void update(int timestamp, int price) {
        current=Math.max(current,timestamp);
        if(h.containsKey(timestamp)) // If timestamp already present
        {    
            int oldprice=h.get(timestamp); // old price of timestamp
            if(tm.containsKey(oldprice))
            {
			    //remove old price from frequency as old value is getting upadated
                if(tm.get(oldprice)==1)  // if frequency of old price is 1 then remove entry
                    tm.remove(oldprice);
                else
                    tm.put(oldprice,tm.get(oldprice)-1); // else update frequency of old -1
            }
        }
		//Update new price in hasmap
        h.put(timestamp,price);
		//Update new frequency of new price in treemap
        tm.put(price,tm.getOrDefault(price,0)+1);
    }
    
    public int current() {
        return h.get(current);
    }
    
    public int maximum() {
        return tm.lastKey();
    }
    
    public int minimum() {
        return tm.firstKey();
    }
}
