import java.util.*;
import java.io.*;


abstract class Account
{
    String a[]=new String[4];     
    { 
        a[0]="23243";    // 4 Account numbers 
        a[1]="96875";
        a[2]="58657";
        a[3]="97576";
    }
}

class Pins extends Account
{
    String b[]=new String[4];                     
    { 
        b[0]="12629";      // 4 Pins for accounts 
        b[1]="76876";
        b[2]="67777";
        b[3]="99978";
    }
}

class Balance{
    int c[]=new int[4];
    {
        c[0]=4242;          // Initial balance in all 4 accounts
        c[1]=768;     
        c[2]=11110;
        c[3]=590;
    }
}

public class CS21B033ATM{

    public static void dispenseCash(int ammount, int twoK,int fiveH, int twoH, int oneH ) 
    {
        int temp = ammount;
        int current_twoK =0, current_fiveH =0, current_twoH=0, current_oneH =0;
        while(temp>0) {
            if(temp>=2000 && twoK>0) 
            {
                current_twoK++;           //twoK = two thousand , fiveH = five hundred , twoH = two hundred , oneH = one hundred in ATM
                twoK--;                  // Current_twoK is the number of two thousands notes in dispender during withdrawl 
                temp -=2000;       //current_fiveH , current_twoH and current_oneH are their respective value of notes in dispenser during withdrawl
            }
            else if(temp>=500 && fiveH>0) 
            {
                current_fiveH++;
                fiveH--;
                temp -=500;
            }
            else if(temp>=200 && twoH>0) 
            {
                current_twoH++;
                twoH--;
                temp -=200;
            }
            else if(temp>=100 && oneH>0) 
            {
                current_oneH++;
                oneH--;
                temp -=100;
            }
        }

        System.out.println("Please collect your cash from the dispenser:\n Total Ammount = "+ ammount+ "\n");
        if(current_twoK>0) 
        {
            System.out.println(current_twoK+" Two Thousand Notes");
        }

        if(current_fiveH>0)
        {
            System.out.println(current_fiveH+" Five Hundred Notes");
        }

        if(current_twoH>0) 
        {
            System.out.println(current_twoH+" Two Hundred Notes");
        }

        if(current_oneH>0)
        {
            System.out.println(current_oneH+" One Hundred Notes");
        }

    }

    public static boolean Check(String s)
    {
                           // a function to check the given string only consists of integers , like "22244" 
        int n=s.length();
        char c[]=new char[n];
        for(int i=0;i<n;i++){
            c[i]=s.charAt(i);
            if(c[i]<48 || c[i]>57)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int twoK = 200;   // the initial number of notes of 2000 , 500 , 200 and 100 in ATM 
        int fiveH = 200;
        int twoH = 200;
        int oneH = 200;

        Pins y=new Pins();
        Balance z=new Balance();
        int[] rep=new int[4];    //  an array of integers to hold the new values of balance after withdrawl or deposit
        String[] sure=new String[4];  // an array of strings to hold new passwords
        for(int i=0;i<4;i++){
            rep[i]=z.c[i];
        }
        for(int i=0;i<4;i++){
            sure[i]=y.b[i];
        }
        int loop=1;
        while(loop==1)     //after all the required operations , before logging out , this ATM goes back to the main menu.
        {                                     
        Scanner sc=new Scanner(System.in);
        System.out.println("   Welcome !");
        System.out.println(" Please enter your account number: ");
        String s=sc.nextLine();
        int flag=1,cc=0,index=0;
        while(cc!=1){                   
        for(int i=0;i<4;i++)
        {
            if(!s.equals(y.a[i]))
            {
                flag=0;
            }
            else{
                flag=1;
                cc=1;
                index=i;
                break;
            }
        }
        if(flag==0)
        {                                                             //checking whether given input is a predefined Account number 
            System.out.println("Please enter a valid account number"); 
            s=sc.nextLine();
        }
     }


     flag=1;
     System.out.println("Enter pin: ");
     String pin=sc.nextLine();
     int check=3;    //giving the user 3 tries to enter pin.
     while(check>0)   // if the user fails to enter correct pin in 3 tries , they can't access their account.
     {
        check--;
        
        if(!pin.equals(y.b[index]))
            {
                flag=0;
        }
        else{
                flag=1;
                break;
        }

        if(flag==0){
            System.out.println("Incorrect pin.");
            if(check==0)
            {
                System.out.print("!!Access Denied!!");
                return;
            }
            System.out.println("Tries left :"+(check));
            
            pin=sc.nextLine();
        }
        else {
            break;
        }
        

    }


    int ehe=1;
    while(ehe==1)
    {                                                             //the main menu
    System.out.println("Select an option");                       // giving the user 5 options to proceed
    System.out.println(" 1.Check Balance         2.Withdraw");  // check balance,withdrawing money,depositiong money, changing pin and exit
    System.out.println(" 3.Deposit               4.Change Pin");
    System.out.println(" 5.Exit");
    String opt=sc.nextLine();
    cc=0;

    while(cc!=1)
    {
    
    if(opt.length()>1 || opt.length()==0)        
    {                                                  //if the user enters anything which is not an integer from 1 to 5 , 
        System.out.println("Choose a valid option ");  // they have to enter a proper number again
        opt=sc.nextLine();
    }

    else if(opt.length()==1)
    {
        if(opt.charAt(0)>48 && opt.charAt(0)<54)
        {
            cc=1;
        }
        else
        {
            System.out.println("Choose a valid option");
            opt=sc.nextLine();
    }
    }

} 

if(opt.charAt(0)==49)
{
    System.out.println("You have $" + rep[index] + " left");  // ASCII value of 1 is 49 
System.out.println("");                 //to check balance , im just printing the element of rep array with its respective index
}

else if(opt.charAt(0)==50)
{                                                           //ASCII value of 2 is 50
    System.out.print("Enter amount: ");   // to withdraw money from account , im first checking whether the given input is an integer . then im checking if desired money to withdraw is..
    String amt=sc.nextLine();            //..less than the balance in that account.
    while(Check(amt)==false)
    {
        System.out.println("Invalid entry. Enter again");
        amt=sc.nextLine();
    }
    int x=Integer.parseInt(amt);
    if(x>rep[index] || x%100 != 0)     //in this ATM , the form of currency that can be withdrawn is 100 and mutiples of 100 
    {                                  //So , if the user withdraws anything less than 100 or not a multiple of 100 , this ATM won't give any money and money wont be reduced from balance.
        System.out.println("Insufficient balance / Enter ammount as multiple of 100.");
    }
    else
    {
        rep[index]=rep[index]-x; //Subtracting withdrawn money from balance amount
        System.out.println("Final Balance: " + rep[index]);
        dispenseCash(x, twoK, fiveH, twoH, oneH);
        System.out.println("");
    }
}

else if(opt.charAt(0)==51)
{                                                  // ASCII value of 3 is 51
    System.out.print("Enter amount: ");
    String amt=sc.nextLine();                  //im first checking whether the given input is ann integer.
    while(Check(amt)==false)                   //then , im just adding deposit money to balance.
    {
        System.out.println("Invalid entry. Enter again");
        amt=sc.nextLine();
    }
    int x=Integer.parseInt(amt);
    rep[index]=rep[index]+x;
    System.out.println("Final Balance: " + rep[index]);
    System.out.println("");
}

else if(opt.charAt(0)==52)
{                                       //ASCII value of 4 is 52
    int t=1;                            //for safety purposes , the user has to enter the new password twice
    while(t==1)                         // if the user enter different passwords , they have to restart the process.
    {
    System.out.println("Enter new password");
    String ne=sc.nextLine();
    System.out.println("For conformation , please enter your new password again");
    String nee=sc.nextLine();
    if(!ne.equals(nee))
    {
        System.out.println("Please confirm it properly");
    }
    else
    {
        System.out.println("Congratulations! Your password has been changed successfully");
        sure[index]=ne;
        t=0;
    }
   }
}

else
{                                                   //if the user chooses exit option , they go back to the screen where the ATM asks the account number.
    System.out.println("Thank  you!! Please visit again :)");
    System.out.println("");
    System.out.println("");
    ehe=0;
}    
}    
}
}   
    }