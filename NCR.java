
import java.util.Scanner;

public class NCR {
    static int fact(int n){
    if (n==0||n==1){
    return 1;
    } 
    else    
    return (n*fact(n-1));
    } 
    public static void main(String [] args)
    {
   Scanner sc = new Scanner(System.in);
   int n,r,res;
   System.out.print("Enter number of items to choose from: ");
   n=sc.nextInt();
   System.out.print("Enter number of items to be chosen: ");
   r=sc.nextInt();
   int result;
   result=fact(n)/(fact(n-r)*fact(r));
    System.out.print("Result ="+result+"\n");}
}
