//Name:Tan Shi Qi
//Student ID: B1901264
//Date:10/10/2020
import java.util.Scanner;
public class B1901264 {
    public static void main (String[] args){
         double malaysianPrice= 80.30;//malaysian charges per day
         double residentPrice=100.60;//resident charges per day
         double expatPrice=120.90;// expat charges per day
         double chargesDays=0,amount_Day =0,total_Price=0,price=0,total_Amount=0,highest_Amount=0,totalprice_Mls=0,
                totalprice_Frn=0,averageMly=0,averageFrn,fund_amount=3000,govPaid=0,total_Balance=0,selfPaid=0,topUp=0;
         String highest_categoryName="",highest_Category="";
         char category,topupchoice;
         int  transactionID;
         int day,quarantineDay,count=0,total_numberMly=0,total_numberFrn=0;
         Scanner input = new Scanner(System.in);
         System.out.format("Quarantine fund balance: %.2f RM\n",fund_amount);
         System.out.print("Enter your name(Q/q to quit): ");//enter name and pressQ/qto quit
         String name=input.nextLine();   
         if (name.equalsIgnoreCase("q")){
             System.out.println("No Transactions ");
        }
        else{
            while(!name.equalsIgnoreCase("q")) {
                System.out.print("Enter your category( Malaysian (M/m), Resident(R/r), Expat(E/e)): ");
                category=input.nextLine().charAt(0);
                while(category!='M' && category!='m' && category!='R' && category!='r' && category!='E' && category!='e'){
                    System.out.println("Invalid Value!!" );//invalid show the message and need to input again
                    System.out.print("Enter your category( Malaysian (M/m), Resident(R/r), Expat(E/e)): ");
                    category=input.nextLine().charAt(0); 
                }
                System.out.print("Number of days(14-42)days:");
                day=input.nextInt();
                if(day<=13 || day>=43 ){//check the input in betweeen 14-42
                    quarantineDay=21;
                    System.out.printf("Default value %d set for Days stayed \n",quarantineDay);
                   
                }
                else{
                    quarantineDay=day;
                    
                }

                transactionID=(int)(Math.random()*1000+1);//random the transactionID between 001-999
                System.out.format("TransactionID:%03d",transactionID);
                System.out.print("\n");

                switch (category){
                    case 'M' :
                    govPaid= govpaid_Malaysian(quarantineDay,malaysianPrice);
                    if(fund_amount>govPaid){
                        price=Malaysian_price(quarantineDay,malaysianPrice);
                        selfPaid=(price-govPaid);
                        chargesDays=malaysianPrice;
                        totalprice_Mls+=price;
                        total_numberMly++;
                        count++;
                        total_Amount+=price;
                        input.nextLine(); 
                    }
                    else{
                        input.nextLine();  
                    }
                    break;
                    case 'm' :
                    govPaid= govpaid_Malaysian(quarantineDay,malaysianPrice);
                    if(fund_amount>govPaid){
                       price=Malaysian_price(quarantineDay,malaysianPrice);
                       selfPaid=(price-govPaid);
                       chargesDays=malaysianPrice;
                       totalprice_Mls+=price;
                       total_numberMly++;
                       count++;
                       total_Amount+=price;
                       input.nextLine(); 
                    }
                    else{
                        input.nextLine();  
                    }
                    break;
                    case 'R' : 
                    govPaid= govpaid_Resident(quarantineDay, residentPrice);
                    if(fund_amount>govPaid){
                        price=Resident_price(quarantineDay,residentPrice);
                        selfPaid=(price-govPaid);
                        chargesDays=residentPrice;
                        totalprice_Frn+=price;
                        total_numberFrn++;
                        count++;
                        total_Amount+=price;
                        input.nextLine(); 
                    }
                    else{
                        input.nextLine();  
                    }
                    break;
                    case 'r' :
                    govPaid= govpaid_Resident(quarantineDay, residentPrice);
                    if(fund_amount>govPaid){
                       price=Resident_price(quarantineDay,residentPrice);
                       selfPaid=(price-govPaid);
                       chargesDays=residentPrice;
                       totalprice_Frn+=price;
                       total_numberFrn++;
                       count++;
                       total_Amount+=price;
                       input.nextLine(); 
                    }
                    else{
                        input.nextLine();  
                    }
                    break;
                    case 'E' :
                    govPaid= govpaid_Expat(quarantineDay,expatPrice);
                     if(fund_amount>govPaid){
                        price=Expat_price(quarantineDay,expatPrice);
                        selfPaid=(price-govPaid);
                        chargesDays=expatPrice;
                        totalprice_Frn+=price;
                        total_numberFrn++;
                        count++;
                        total_Amount+=price;
                        input.nextLine(); 
                    }
                    else{
                        input.nextLine();  
                    }
                    break;
                    case 'e' : 
                    govPaid= govpaid_Expat(quarantineDay,expatPrice);
                    if(fund_amount>govPaid){
                        price=Expat_price(quarantineDay,expatPrice);
                        selfPaid=(price-govPaid);
                        chargesDays=expatPrice;
                        totalprice_Frn+=price;
                        total_numberFrn++;
                        count++;
                        total_Amount+=price;
                        input.nextLine();
                    }
                    else{
                        input.nextLine();  
                    }
                    break;
                    }
                

                if (price>highest_Amount){//show the highest amount in which category
                    highest_Amount=price;
                    highest_categoryName=name;
                    switch (category) {
                        case 'm':
                        case 'M':
                            highest_Category="Malaysian";
                            break;
                        case 'r':
                        case 'R':
                            highest_Category="Resident";
                            break;
                        case 'e':
                        case 'E':
                            highest_Category="Expat";
                            break;
                        default:
                            break;
                    }
                } 
                if(fund_amount>govPaid){
                    total_Balance=quarantine_Fund(govPaid,fund_amount);
                    fund_amount=total_Balance; 
                    System.out.printf("\nAmount charged for %d days @%.2f RM/day: RM %.2f",quarantineDay,chargesDays,price);
                    System.out.printf("\nPaid by Self:RM %.2f",selfPaid);//show the amount of selfPaid
                    System.out.printf("\nPaid by gov:RM %.2f ",govPaid );//show the amount of govPaid
                    System.out.println("\nQuarantine fund balance:RM"+Math.round(fund_amount));
                }
                else {
                    System.out.println("\nInsufficient balance in quarantine fund");
                    System.out.println("Would you like to:");
                    System.out.println("T. Top Up , Any other key to quit");
                    System.out.print("Your choice:");
                    topupchoice =input.nextLine().charAt(0);
                    if (topupchoice=='T' || topupchoice =='t'){//press T/t to top up the amount
                        System.out.print("Top Up Amount:");
                topUp=input.nextInt();
                fund_amount=topUp_Fund(fund_amount,topUp);
                System.out.println("Quarantine fund balance:RM "+Math.round(fund_amount));
                input.nextLine();
                    } 
                }    
                System.out.print("\nEnter your name(Q/q to quit): ");
                name=input.nextLine(); 
            }
            
                averageMly=totalprice_Mls/total_numberMly;//calculate the avgMly 
                averageFrn=totalprice_Frn/total_numberFrn;//calculate the avgFrn
                System.out.print("\n");
                System.out.println("-------------------------------------------");
                System.out.printf("Total Amount from %d guests is RM %.2f", count,total_Amount);
                System.out.printf("\nHighest amount paid RM %.2f  by %s, is an %s",highest_Amount,highest_categoryName, highest_Category);
                System.out.printf("\nAverage amount from Malaysians:RM %.2f",averageMly);
                System.out.printf("\nAverage amount from Foreign:RM %.2f",averageFrn);
                System.out.println("\nQuarantine fund balance:RM "+Math.round(fund_amount));
        }     
    }
        static double Malaysian_price(int quarantineDay, double malaysianPrice){//this method to calculate the malaysian amount charged  
            double amount_Day= quarantineDay* malaysianPrice;
            double govPaid=0;
            if(amount_Day<1500){
               govPaid=100;
            }
            else if (amount_Day>1500 && amount_Day<=2000){
                govPaid=(amount_Day*0.15);
            }
            else if (amount_Day>2000 && amount_Day<=2500){
                govPaid=(amount_Day*0.215);
            }
            else if(amount_Day>=2500 ){
                govPaid=(amount_Day*0.275);
            }
            return amount_Day;
        }
        static double Resident_price(int quarantineDay, double residentPrice){//this method to calculate the foreigner amount charged  
            double amount_Day= quarantineDay*residentPrice;
            double govPaid=0;
            if(amount_Day<2000){
               govPaid=80;
            }
            else if(amount_Day>2000 && amount_Day<=3000){
               govPaid=(amount_Day*0.095);
            }
            else if(amount_Day>=3000){
                govPaid=(amount_Day*0.175);
 
            }
        return (amount_Day);    
        }
        static double Expat_price(int quarantineDay, double expatPrice){//this method to calculate the foreigner amount charged 
            double amount_Day= quarantineDay*expatPrice;
            double govPaid=0;
            if(amount_Day<2000){
                govPaid=80;
            }
            else if(amount_Day>2000 && amount_Day<=3000){
                govPaid=(amount_Day*0.095);
            }
            else if(amount_Day>=3000){
                govPaid=(amount_Day*0.175);
            }
        return amount_Day;  
        }
         static double govpaid_Malaysian(int quarantineDay, double malaysianPrice){//this method calculate the citizens govPaid 
            double amount_Day = quarantineDay *  malaysianPrice;
            double govPaid=0;
            if (amount_Day<1500){
                govPaid=100;
            }
            else if(amount_Day>=1500 && amount_Day< 2000){
                govPaid=amount_Day*0.15;
            }
            else if(amount_Day>=2000 && amount_Day< 2500){
                govPaid=amount_Day*0.215;
            }
            else if(amount_Day>=2500 ){
                govPaid=amount_Day*0.275;
            }
            return govPaid;
        }
        static double govpaid_Resident(int quarantineDay, double residentPrice){//this method calculate the foreigner govPaid 
            double amount_Day = quarantineDay* residentPrice;
            double govPaid=0;
            if (amount_Day<2000){
                govPaid=80;
            }
            else if(amount_Day>=2000 && amount_Day< 3000){
                govPaid=amount_Day*0.095;
            }
            else if(amount_Day>=3000){
                govPaid=amount_Day*0.175;
            }
            return govPaid;
        }
        static double govpaid_Expat(int quarantineDay, double expatPrice){//this method calculate the foreigner govPaid   
            double amount_Day = quarantineDay * expatPrice;
            double govPaid=0;
            if (amount_Day<2000){
                govPaid=80;
            }
            else if(amount_Day>=2000 && amount_Day< 3000){
                govPaid=amount_Day*0.095;
            }
            else if(amount_Day>=3000){
                govPaid=amount_Day*0.175;
            }
            return govPaid;
        } 
        //this method will calculate the quarantine fund 
        public static double quarantine_Fund(double govPaid,double fund_amount){
            fund_amount-=govPaid;
            return fund_amount;
        }
        //this method will top up the quarantine fund
        public static double topUp_Fund(double fund_amount,double topUp){
            fund_amount+=topUp;
            return fund_amount;
        }
}
      
     

     
             
         
          
    
          
     
          
              
              
          
          
                  
          
          
          
          
          
          
          
          
      
    

