import java.util.Arrays;   
public class PlusOne 
{  
//function to add 1 to the array  
public static int[] plusOne(int[] digits)   
{  
int n = digits.length;  
for(int i=n-1; i>=0; i--)   
{  
if(digits[i] < 9)   
{  
digits[i]++;   
return digits;  
}  
digits[i] = 0;  
}  
int[] newNumber = new int [n+1];  
newNumber[0] = 1;  
return newNumber;  
}  
//driver code  
public static void main(String args[])   
{  
int [] arr = {6, 3, 8, 2};   
//function calling  
int[]ans=plusOne(arr);   
//prints the resultant array after adding 1 to MSB  
System.out.println(Arrays.toString(ans));  
}  
}  

