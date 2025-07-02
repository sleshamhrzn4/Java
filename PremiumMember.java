


public class PremiumMember extends GymMember
{
    // Attributes
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    
    // Declaring Constructor
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStratDate, String personalTrainer){
       super (id,name, location, phone, email,gender, DOB, membershipStratDate);
       this.personalTrainer=personalTrainer;
       this.premiumCharge=50000;
       this.paidAmount=0;
       this.isFullPayment=false;
       this.discountAmount=0;
       
    }
    
    
    
     // Accessor Methods
    public double getPremiumCharge(){
        return premiumCharge;
        
    }

    
    public String getPersonalTrainer(){
        return personalTrainer;
    }
    
    public boolean getIsFullPayment(){
       return isFullPayment;       
    }

    
    public double getPaidAmount(){
        return paidAmount;
    }
    
    public double getDiscountAmount(){
        return discountAmount;
    }
    
    
    
    //Overridden markAttendence Method
    @Override 
    public void markAttendance(){
        attendance= attendance + 1;
        loyalityPoints= loyalityPoints + 10;
        System.out.println("Attendance is marked for"+name);
    }
    
    
    
    // Method to pay due amount
    public String payDueAmount(double paidAmount){
        if (this.isFullPayment==true){
            return "Payment is already completed.";
        }
        
        if (paidAmount  > premiumCharge){
            return "Paid amount exceeds the total premium charge.";
        }
        
        // Add to the paid amount
        this.paidAmount += paidAmount;
        double remainingAmount= premiumCharge - this.paidAmount;
        
        // Check if full payment is completed
        if (this.paidAmount == premiumCharge){
            this.isFullPayment = true;
            return "Payment is complete. Thank You.";
        }
        else{
            this.isFullPayment = false;
            return "Payment received:"+ paidAmount+ ". Remaining amount to be paid:"+ remainingAmount;
            
        }
        
    }
    
    
    
    
    // Method to calculate discount
    public String calculateDiscount(){
        if (isFullPayment==true){
            discountAmount = premiumCharge * 0.10;
            return "Discount is calculated successfully. Discount amount:"+discountAmount;
        }
        else{
            return "Sorry, the dicount is not available.";
        }
    }
    
    
    
    
    // Method to revert premium member details
    public void revertPremiumMember(){
        super.resetMember();             // Call parent class reset method
        this.personalTrainer = "";       // Reset personal trainer
        this.isFullPayment = false;      // Reset payment status
        this.paidAmount= 0;              // Reset paid amount
        this.discountAmount=0;           // Reset discount amount
    }
    
    
    
    
    
    // Overridden display method
    @Override
    public void display(){
        super.display();                 // Call parent class display method
        
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Is Full Payment: " + isFullPayment);
        
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);
        
        if (isFullPayment==true) {
        System.out.println("Discount Amount: " + discountAmount);
        }
    
    
    }
}