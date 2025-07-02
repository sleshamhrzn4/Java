

public class RegularMember extends GymMember
{
    //Attributes 
   private final int attendanceLimit;
   private boolean isEligibleForUpgrade;
   private String removalReason;
   private String referralSource;
   private String plan;
   private double price;
   
   
   // Constructors
   public RegularMember(int id, String name, String location, String phone , String email, String gender, String DOB, String membershipStartDate, String refferalSource){
       super(id, name, location, phone , email, gender ,DOB, membershipStartDate);
       this.referralSource=referralSource;
       this.isEligibleForUpgrade=false;     
       this.attendanceLimit=30;          //Set attendence limit as 30
       this.plan="Basic";                //Set default plan as basic
       this.price= 6500;                 //Set price as 6500
       this.removalReason="";
       
   }
   
   
   
   // Accessor Methods
    public int getAttendenceLimit(){
        return attendanceLimit;
    }
    
    
    public boolean getIsEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }
    
    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    
    
    
    //Overridden markAttendence Method
    @Override
    public void markAttendance(){
        attendance= attendance+1;
        loyalityPoints= loyalityPoints + 5;
        System.out.println("Attendance is marked for"+name);
        if (attendance>=attendanceLimit){
            isEligibleForUpgrade = true;
        }
        
    }
   

    
    
    
    // Method to get the price of the plan
    public double getPlanPrice(String plan){
        switch(plan.toLowerCase()){
            case "basic": 
                return 6500; 
            case "standard": 
                return 12500;
            case "deluxe": 
                return 18500;
            default: 
            return -1;
            
        }
    }
    
    
    
    
    //Method to upgrade the plan
    public String upgradePlan(String newPlan){
        
        double newPrice=getPlanPrice(newPlan);
            if (newPrice==-1){
                return "Invalid plan is selected.";
            }
            
            if (!isEligibleForUpgrade) { // Check eligibility
                return "Upgrade is not allowed as attendances has not reached the limit.";
            }
            
            if (newPlan.equals(plan)){
                return "You are already subscribed to" +plan+"plan.";
            }
            
            //Updating member's plan and price
            plan = newPlan;
            price = newPrice;
            
            return "Your plan is upgradated to" + newPlan + "with price"+price+".";
            
            
        
    }
    
    
    
    // Method to revert premium member details
    public void revertRegularMember(){
        super.resetMember();                // Call parent class reset method
        this.isEligibleForUpgrade = false;
        this.plan="basic";
        this.price = 6500;
        this.removalReason=removalReason;
        
        
    }
    
    
    
    
    
    // Overridden display method
    @Override
    public void display(){
        super.display();                // Call parent class display method
        System.out.println("Plan:"+plan);
        System.out.println("Price:"+price);
        if (!removalReason.isEmpty()){
            System.out.println("Removal Reason:"+removalReason);
        }
        
    }
}
            
     
    
     
    