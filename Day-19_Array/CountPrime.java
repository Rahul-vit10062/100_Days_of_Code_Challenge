class test
{
    int checkPrime(int n)
    {
        for(int i=2;i<n/2;i++)
        {
            if(n%i==0)
            {
                return 0;
            }
        }
        return 1;
    }
}
public class CountPrime
{
     public static void main(String []args)
     {
        test t1=new test();
        int starting=10;
        int ending=20;
        int cnt=0;
        for (int i=starting;i<=ending;i++)
        {
            if(t1.checkPrime(i)==1)
            {
                cnt++;
            }
        }
        System.out.println("NUmber of prime numbers in the given range is: "+cnt);
     }
}
