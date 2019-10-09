import java.util.Scanner;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class Testing {
	
	/*
	 * here are all of the variables that i have set, they are here because
	 * i need then static so i can use then throughout all of my methods
	 */
	static Scanner Input = new Scanner (System.in);
	static Scanner FinchDecision = new Scanner (System.in);
	static char Decision, DecimalToHexChar, YorN;
	static int BinaryReverseStatic, HexInt1or2, OctInt, BinInt, no, j, DecimalIntForArray, decimal1, DecimalChar, DecimalintHex, BinaryDec, rev;
	static String hex, Oct, Bin, HexDec, OctDec, Decimal;
	static int[] binaryNum = new int [1000];
	static StringBuilder result = new StringBuilder();
	//I ised the index 0 so these all have the same values because i will be changing the Decimalint value but not the others.
	static int index = 0, ReverseBinaryint = 0, Decimalint = 0, DecimalForYorN = 0;

	static Finch myFinch = new Finch();
	
	public static void main(String[] args) {
		 
		
		System.out.println("Please enter your first number");
		//Main input for the program
		Decimalint = Input.nextInt();
		
		
		
		
		
		//checks whether the input is above 0 or below 255
		if(Decimalint < 0 || Decimalint > 255) {
			System.out.println("Please enetr a number higher than 0 and less than 255");
			Decimalint = Input.nextInt();
		}
		
		DecimalBelow50(); //This is to check whether the input is below 50 or not and will ad 50 on to it if it is
		
		
		//Checks the Length of the Hexadecimal
		int hexLength = String.valueOf(hex).length();	
		if (hexLength == 1)
		{
			 HexInt1or2 = 1;
		}
		else
		{
			HexInt1or2 = 2;
		}
		
		
		toHex(Decimalint); //this converts the Decimalint input to a hexadecimal
		FinchDecision();
		YesOrNo();
		myFinch.quit();
		}
		
		
		
	
	
	//this checks is the user wants to continue the program or wants to exit it.
	static void YesOrNo() 

	{
		System.out.println("Would you like to continue the program?");
		Scanner InputTwo = new Scanner (System.in);
		
		YorN = InputTwo.next().charAt(0);
		if(YorN == 'y') 
		{
			System.out.println("Please enter a new decimal Number");
			
			Decimalint = Input.nextInt();
		}	
	}
	
	/*
	 * This is the method where the finch will move, so it asks if they want the movemetn or not
	 * if they do then they will see the conversions and the finch will move
	 * otherwise it will just show the conversions
	 */
	
	static void FinchDecision() 
	{
		System.out.println("Would you like the finch to move based on the conversitons?");
		Decision = FinchDecision.next().charAt(0);
		
		if (Decision == 'y')
		{
			System.out.println("Decimal: " + Decimalint);
			System.out.print("Binary: ");
			decToBinary(Decimalint);
			System.out.println(" ");
			System.out.println("Hexadecimal: " + toHex(Decimalint));
			System.out.println("Octal: " + toOctal(Decimalint));
			
			
			HexDec = toHex(Decimalint);
			
			
			
			OctDec = toOctal(Decimalint);
			Integer.parseInt(OctDec);
			
			
			myFinch.setWheelVelocities(Decimalint,Decimalint,HexInt1or2);
			ReverseBinary();
			myFinch.buzz(OctInt,1000);
			
			//test to see if the correct values where being output properly.
			//System.out.println(" ");
			//ReverseBinary();
			//System.out.println(Decimalint + "  " + HexInt1or2);
			//System.out.println(toOctal(Decimalint)); 

			
		}
		else if (Decision == 'n')
		{
				System.out.println("Decimal: " + Decimalint);
				System.out.print("Binary: ");
				decToBinary(Decimalint);
				System.out.println(" ");
				System.out.println("Hexadecimal: " + toHex(Decimalint));
				System.out.println("Octal: " + toOctal(Decimalint));
				myFinch.quit();
						
						
		}
	}
	
	// function to convert decimal to binary 
    static public int decToBinary(int n) 
    { 
        // The array was decalred as static so is outside the main method or in this method.
    	
   
        // counter for binary array 
        int i = 0; 
        while (n > 0)  
        { 
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
   
        // printing binary array in reverse order 
        for (j = i - 1; j >= 0; j--) 
        	
            System.out.print(binaryNum[j]); 
        BinaryReverseStatic = binaryNum[Decimalint];
        return binaryNum[Decimalint];
        
         
    } 
	
    public static void ReverseBinary()
    {
    	
    	String ReverseStringBinary = String.format ("%d", decToBinary(ReverseBinaryint));
    	
    	
    	
    	for(int i = ReverseStringBinary.length()-1; i >= 0; i--){
    	    if(ReverseStringBinary.charAt(i) == '1')
    	    	myFinch.setLED(0,128,0, 1000);
    	    	//System.out.println("GREEN"); These are to test if the correct value was coming out 
    	    	//System.out.println("1");
    	    if(ReverseStringBinary.charAt(i) == '0');
    	    	myFinch.setLED(255,0,0,1000);
    	    	//System.out.println("RED");
    	    	//System.out.println("2");
    	}
    	
    	
    	
    }
    
    
    
    public static String toHex(int decimal){    
        int rem;  
        hex="";   
        //These are the declared numbers and letters and numbers for the hexadecimal in the array.
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
       while(decimal>0)  
        {  
          rem=decimal%16;   
          hex=hexchars[rem]+hex;   
          decimal=decimal/16;  
        }  
       return hex;  
   }    
	
    public static String toOctal(int decimalOct){    
        int rem; //declaring variable to store remainder  
        String octal=""; //declaring variable to store octal  
        //declaring array of octal numbers  
        char octalchars[]={'0','1','2','3','4','5','6','7'};  
        //writing logic of decimal to octal conversion   
        while(decimalOct>0)  
        {  
           rem=decimalOct%8;   
           octal=octalchars[rem]+octal;   
           decimalOct=decimalOct/8;  
        }  
        return octal;  
    }    
	

    //This is to check if the decimal is below 50 or not
    static void DecimalBelow50() 
    {
    	if (Decimalint < 50)
    	{
    		Decimalint = Decimalint+ 50;
    	}
    }
	
}
