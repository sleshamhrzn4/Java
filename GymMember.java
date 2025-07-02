

public abstract class GymMember
{
     //Attributes
   protected int id;
   protected String name;
   protected String location;
   protected String phone;
   protected String email;
   protected String gender;
   protected String DOB;
   protected String membershipStartDate;
   protected int attendance;
   protected double loyalityPoints;
   protected boolean activeStatus;
   
   
   //Constructor
   public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate){
       this.id= id;
       this.name=name;
       this.location=location;
       this.phone=phone;
       this.email=email;
       this.gender=gender;
       this.DOB=DOB;
       this.membershipStartDate=membershipStartDate;
       this.attendance=0;
       this.loyalityPoints=0;
       this.activeStatus=false;
   }
   
   
   
   //Accessor  methods
   public int getID(){
       return id;
   }
   
   public String getName(){
       return name;
   }
   
   public String getLocation(){
       return location;
   }
   
   
   public String getPhone(){
       return phone;
   }
   
   
   public String getEmail(){
       return email;
   }
   

   public String getGender(){
       return gender;
   }
   
   public String getDOB(){
       return DOB;
    }
   
   public String getMembershipStartDate(){
       return membershipStartDate;
   }
   
   public int getAttendance(){
       return attendance;
   }
   
   public double loyalityPoints(){
       return loyalityPoints;
   }
   
   public boolean activeStatus(){
       return activeStatus;
   }
   
   
   
   
   // Abstract method for mark attendance
   public abstract void markAttendance();
   
   
   
   // Method for activateMembership
   public void activateMembership(){
       this.activeStatus=true;
   }
   
   
   
   
   // Method for deactivateMembership
   public void deactivateMembership(){
       if (this.activeStatus==true){
           this.activeStatus=false;
       }
       else{
           System.out.println("Membership is already deactivated");
       }
   }
   
   
   
   // Method for resetMember
   public void resetMember(){
       this.activeStatus=false;
       this.attendance=0;
       this.loyalityPoints=0.0;
       
   }
   
   
   
   
   // Display method to output member details
    public void display() {
        System.out.println("Gym Member Details:");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Location: " + this.location);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
        System.out.println("Gender: " + this.gender);
        System.out.println("Date of Birth: " + this.DOB);
        System.out.println("Membership Start Date: " + this.membershipStartDate);
        System.out.println("Attendance: " + this.attendance);
        System.out.println("Loyalty Points: " + this.loyalityPoints);
        System.out.println("Active Status: " + (this.activeStatus ? "Active" : "Inactive"));
    }
}
