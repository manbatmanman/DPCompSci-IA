package classregit;

import java.util.Scanner;

public class Menuandreceipt
{
    public static String [] names = new String [10];
    public static int [] price = new int [10];

    public static void main(String[] args)
    {
        new Menuandreceipt ();
    }

    public Menuandreceipt ()
    {
        IBIO.output ("Welcome to");
        IBIO.output ("Finance Register");
        IBIO.output ("--------------");
        IBIO.output ("You can use this register for up to 10 Task");
        IBIO.output ("");
        
        for (int i = 0; i <= 9; i++)
        {
            names [i] = "-";
            price [i] = -1;
        }
        
        while (true)
        {
            IBIO.output ("");
            IBIO.output ("MENU:");
            int choice = IBIO.inputInt("Type 1 to display the register\n2 to enter the register\n3 to delete a menu\n4 to append a menu to the end of the register \n5 to write receipt\n0 to end: ");
            if (choice == 1)
            {
                displayRegister ();
            }
            if (choice == 2)
            {
                enterFood ();
            }
            if (choice == 3)
            {
                IBIO.output ("");
                int unwantedFoodNo = IBIO.inputInt ("Which menu do you want to delete? (0 to 9) ");
                IBIO.output(deleteFood (unwantedFoodNo));
            }
            if (choice == 4)
            {
                IBIO.output ("");
                String newName = IBIO.input ("Task name? ");
                int newPrice = IBIO.inputInt ("Value? ");
                if (appendFood (newName, newPrice))
                {
                    IBIO.output ("");
                    IBIO.output ("Sorry, the register is full.");
                }
            }
            if (choice == 5)
            {
            	displayRegister();
            	enterReceipt();
            }
            
   
            if (choice == 0)
            {
                break;
            }
        }
    }

    public static void displayRegister ()
    {
        IBIO.output ("");
        IBIO.output ("REGISTER:");
        for (int i = 0; i <= 9; i++)
        {
            if (names[i].charAt(0) == '-')
            {
                break;
            }
            IBIO.output (names [i] + " (Price $" + price [i] + ")");
        }
    } 
    
    public static void enterFood ()
    {
        for (int i = 0; i <= 9; i++)
        {
            names [i] = "-";
            price [i] = -1;
        }
        for (int i = 0; i <= 9; i++)
        {
            IBIO.output ("");
            names [i] = IBIO.input ("Food name? (- to finish) ");
            if (names [i].charAt(0) == '-')
            {
                break;
            }
            price [i] = IBIO.inputInt ("Price? ");
        }
    }
       
    public static String deleteFood (int unwanted)
    {
        String deleteMessage = "Student not deleted";
        IBIO.output ("");
        IBIO.output ("Are you sure you want to permanently delete " + names [unwanted] + "?");
        char areYouSure = IBIO.input ("Type Y to confirm deletion: ").charAt(0);
        if (areYouSure == 'Y')
        {
            for (int i = unwanted; i < 9; i++)
            {
                names [i] = names [i + 1];
                price [i] = price [i + 1];
            }
            names [9] = "-";
            price [9] = -1;
            deleteMessage = "Student deleted";
        }
        return deleteMessage;
    }
    
    public static void enterReceipt() {
    	IBIO.output("Generate the receipt...");
    	int fullcost = 0;
    	int foodnumber = 0 ;
        while (!(foodnumber == -1))
        {
        	foodnumber = IBIO.inputInt("Give number 0-9 for the food price (type '-1' to stop): ");
        	if(foodnumber != -1)
        	{
        		fullcost += price[foodnumber];
        		if(price[foodnumber] == -1)
        		{
        			price[foodnumber] + 1;
        		}
        		IBIO.output("Total = " + fullcost);
        	}
        	
        }
    	IBIO.output("Total = " + fullcost);
    }
     
    
    public static boolean appendFood (String name, int pric)
    {  
        boolean full = false;
        for (int i=0; i<=9; i++) {
            if (names[i].charAt(0) == '-')
            {
                names[i] = name;
                price[i] = pric;
                return full; 
            }
        }
        full = true;
        return full;
    }
}