class unique{ 
    
    static int singleElement(int[] a, int n){
        int single=0,flag=0;
        for(int i=0; i<n; i++){
            flag = 0;
            single = a[i];
            for(int j=0; j<n; j++){
                if((a[j]==single)&&(j!=i)){
                    flag=1;
                }    
            }
            if(flag==0){
                return single;
            }    
        }
        return single;
    }
    public static void main (String[] args){ 
  
        int a[] = {1, 3, 5, 5, 2, 1, 3}; 
        int n = a.length; 
        System.out.println(singleElement(a, n)); 
        
    } 
} 
