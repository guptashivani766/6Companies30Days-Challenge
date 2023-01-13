class CountGoodTriplet 
{
	class SegmentTree{
    long[] seg;
    long[] arr;
    int n;

    SegmentTree(int n){
        this.n=n;
        seg = new long[4*n+1];
        build(1, n, 1);
    }

    void build(long l, long r, long c){
        if(l == r){
            seg[(int)c] = 0;
            return;
        }
        long mid = l+(r-l)/2;
        build(l,mid,2*c);
        build(mid+1,r,2*c+1);
        seg[(int)c] = seg[2*(int)c]+seg[2*(int)c+1];
    }

    long query(long l,long r,long a,long b,long c){
        if(l>b || r<a){
            return 0;
        }
        if(l>=a && r<=b){
            return seg[(int)c];
        }
        long mid = l+(r-l)/2;
        return query(l,mid,a,b,2*c)+query(mid+1,r,a,b,2*c+1);
    }

    void update(long l,long r, long ind, long c){
        if(ind<l || r<ind){
            return;
        }
        if(l == r && l == ind){
            seg[(int)c] = 1;
            return;
        }
        long mid = l+(r-l)/2;
        update(l,mid,ind,2*c);
        update(mid+1,r,ind,2*c+1);
        seg[(int)c] = seg[2*(int)c]+seg[2*(int)c+1];   
    }
}

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums2[i]+1, i+1);
        }
        SegmentTree tree = new SegmentTree(n);
        for(int i=1;i<=n;i++){
            long r = map.get(nums1[i-1]+1);
            long q = tree.query(1,n,1,r,1);
            long d = i-q-1;
            long e = n-r-d;
            ans += e*q;
            tree.update(1,n,r,1);
        }
        return ans;
}
}
