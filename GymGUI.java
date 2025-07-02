import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;


public class GymGUI {
   
    private ArrayList<GymMember> members= new ArrayList<>();
    private JFrame frame,memberFrame,managerFrame, membershipFrame,markAttendanceFrame, displayFrame;
    private JButton regularMemberButton, premiumMemberButton, managerButton, memberButton,membershipControlButton,paymentButton,revertRegularButton, revertPremiumButton, attendanceButton,
    regularPriceLabel,displayButton;
    private JLabel idLabel, nameLabel, locationLabel, phoneLabel, emailLabel, genderLabel, dateLabel, membershipStartDateLabel, referralSourceLabel,trainersNameLabel,planLabel;
    private JTextField paidAmountField,amountField,idField, nameField, locationField, phoneField, emailField, referralSourceField, trainersNameField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JButton submitButton;
    private JComboBox<Integer> yearComboBox, dayComboBox;
    private JComboBox<String> monthComboBox,planComboBox;
    public static void main(String[] args) {
        new GymGUI();
    }

      public GymGUI() {
       
        // Set up the main frame
        frame = new JFrame("Gym Management System");
        frame.setLayout(new BorderLayout()); // Use BorderLayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Disable maximize button
        
        // Left Panel (40%)
        JPanel leftPanel = new JPanel();
        Color lightPurple = new Color(96, 0, 160); // Custom light purple color
        leftPanel.setBackground(lightPurple);
        leftPanel.setPreferredSize(new Dimension(180, 0)); 
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // Vertical alignment

        // Add the words as separate labels
        JLabel welcomeLabel = new JLabel("WELCOME", JLabel.CENTER);
        JLabel toLabel = new JLabel("TO", JLabel.CENTER);
        JLabel theLabel = new JLabel("THE", JLabel.CENTER);
        JLabel gymLabel = new JLabel("GYM", JLabel.CENTER);
        Font labelFont = new Font("Times New Roman", Font.BOLD, 24);
        welcomeLabel.setFont(labelFont);
        toLabel.setFont(labelFont);
        theLabel.setFont(labelFont);
        gymLabel.setFont(labelFont);
        
        // Set font color to white for all labels
        welcomeLabel.setForeground(Color.WHITE);
        toLabel.setForeground(Color.WHITE);
        theLabel.setForeground(Color.WHITE);
        gymLabel.setForeground(Color.WHITE);

        // Center-align the labels
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        toLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        theLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gymLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Add labels to the left panel
        leftPanel.add(Box.createVerticalGlue()); // Add vertical space
        leftPanel.add(welcomeLabel);
        leftPanel.add(toLabel);
        leftPanel.add(theLabel);
        leftPanel.add(gymLabel);
        leftPanel.add(Box.createVerticalGlue()); // Add vertical space
        
        // Right Panel 
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for button positioning
        rightPanel.setBackground(Color.WHITE);

        // Create and add the "Member" button
        memberButton = new JButton("Add Member");
        memberButton.setPreferredSize(new Dimension(150, 50));
        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMemberFrame(); // Open the Member Frame
            }
        });

        // Create and add the "Manager" button
        managerButton = new JButton("Manager");
        managerButton.setPreferredSize(new Dimension(150, 50));
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openManager(); // Open the Manager Frame
            }
        });
        
        attendanceButton = new JButton("Mark Attendance");
        attendanceButton.setPreferredSize(new Dimension(150,50));
        attendanceButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              openMarkAttendance();
            }
        });
        
        
        displayButton = new JButton("Display");
        displayButton.setPreferredSize(new Dimension(150,50));
        displayButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e ){
                openDisplay();
            }
        });
        

        // Use GridBagConstraints to center the buttons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between buttons

        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(memberButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        rightPanel.add(managerButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0 ;
        rightPanel.add(attendanceButton, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        rightPanel.add(displayButton,gbc);

        // Add panels to the frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);

        // Set up the frame size and visibility
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
       }
        
    


    
      private void openMemberFrame() {
        // Create a new frame for the Member options
         memberFrame = new JFrame("Member Options");
        memberFrame.setLayout(new GridBagLayout());
        memberFrame.setSize(400, 300);
        memberFrame.setLocationRelativeTo(null);
        memberFrame.setResizable(false);

        // Create "Regular Member" and "Premium Member" buttons
        JButton regularMemberButton = new JButton("Regular Member");
        regularMemberButton.setPreferredSize(new Dimension(150, 50));
        regularMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegularMemberForm(); // Open the RegularMemberForm
            }
        });

        JButton premiumMemberButton = new JButton("Premium Member");
        premiumMemberButton.setPreferredSize(new Dimension(150, 50));
        premiumMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PremiumMemberForm(); // Open the PremiumMemberForm
            }
        });

        // Use GridBagConstraints to arrange buttons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        memberFrame.add(regularMemberButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        memberFrame.add(premiumMemberButton, gbc);
        memberFrame.setVisible(true);
      }
      
      
      private void openDisplay() {
        // Creating a new frame for the Member options
         memberFrame = new JFrame("Member Options");
        memberFrame.setLayout(new GridBagLayout());
        memberFrame.setSize(400, 300);
        memberFrame.setLocationRelativeTo(null);
        memberFrame.setResizable(false);

        // Creating "Regular Member" and "Premium Member" buttons
        JButton regularMemberButton = new JButton("Regular Member");
        regularMemberButton.setPreferredSize(new Dimension(150, 50));
        regularMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                         JFrame displayFrame = new JFrame("Regular Members");
                    displayFrame.setSize(600, 400);
            
                    JTextArea textArea = new JTextArea();
                    textArea.setEditable(false);
            
                    for (GymMember m : members) {
                        if (m instanceof RegularMember) {
                            RegularMember rm = (RegularMember) m;
                            String memberInfo = String.format(
                                "ID: %d\nName: %s\nLocation: %s\nPhone: %s\nEmail: %s\nGender: %s\nDOB: %s\n" +
                                "Membership Start Date: %s\nPlan: %s\nPrice: %.2f\n" +
                                "--------------------------\n",
                                rm.getID(),
                                rm.getName(),
                                rm.getLocation(),
                                rm.getPhone(),
                                rm.getEmail(),
                                rm.getGender(),
                                rm.getDOB(),
                                rm.getMembershipStartDate(),
                                rm.getPlan(),
                                rm.getPrice()
                            );
        
                        textArea.append(memberInfo);
                    }
                }
                displayFrame.add(new JScrollPane(textArea));
                displayFrame.setVisible(true);
            }
        });

        JButton premiumMemberButton = new JButton("Premium Member");
        premiumMemberButton.setPreferredSize(new Dimension(150, 50));
        premiumMemberButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                JFrame displayFrame = new JFrame("Premium Members");
                displayFrame.setSize(600, 400);
        
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
        
                for (GymMember m : members) {
                    if (m instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) m;
                        String memberInfo = String.format(
                            "ID: %d\nName: %s\nLocation: %s\nPhone: %s\nEmail: %s\nGender: %s\nDOB: %s\n" +
                            "Membership Start Date: %s\nPersonal Trainer: %s\nPremium Charge: %.2f\n" +
                            "Paid Amount: %.2f\nIs Full Payment: %b\nDiscount Amount: %.2f\n" +
                            "--------------------------\n",
                            pm.getID(),
                            pm.getName(),
                            pm.getLocation(),
                            pm.getPhone(),
                            pm.getEmail(),
                            pm.getGender(),
                            pm.getDOB(),
                            pm.getMembershipStartDate(),
                            pm.getPersonalTrainer(),
                            pm.getPremiumCharge(),
                            pm.getPaidAmount(),
                            pm.getIsFullPayment(),
                            pm.getDiscountAmount()
                        );
        
                        textArea.append(memberInfo);
                    }
                 }
                        displayFrame.add(new JScrollPane(textArea));
                        displayFrame.setVisible(true);
                    }
                });
        
                //GridBagConstraints to arrange buttons
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.gridx = 0;
                gbc.gridy = 0;
                memberFrame.add(regularMemberButton, gbc);
                gbc.gridx = 1;
                gbc.gridy = 0;
                memberFrame.add(premiumMemberButton, gbc);
                memberFrame.setVisible(true);
              }
    
    
     // Regular Member Form
       public class RegularMemberForm extends JFrame {
        public RegularMemberForm() {
            setTitle("Regular Member Form");
            setSize(600, 800);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null); // Set layout to null for manual positioning
             // Disable the maximize button
            setResizable(false);
            // ID field
            idLabel = new JLabel("ID:");
            idLabel.setBounds(50, 20, 100, 30); // Positioning label
            add(idLabel);
            idField = new JTextField(20);
            idField.setBounds(150, 20, 200, 30); // Positioning text field
            add(idField);

            // Name field
            nameLabel = new JLabel("Name:");
            nameLabel.setBounds(50, 60, 100, 30);
            add(nameLabel);
            nameField = new JTextField(20);
            nameField.setBounds(150, 60, 200, 30);
            add(nameField);

            // Location field
            locationLabel = new JLabel("Location:");
            locationLabel.setBounds(50, 100, 100, 30);
            add(locationLabel);
            locationField = new JTextField(20);
            locationField.setBounds(150, 100, 200, 30);
            add(locationField);

            // Phone field
            phoneLabel = new JLabel("Phone:");
            phoneLabel.setBounds(50, 140, 100, 30);
            add(phoneLabel);
            phoneField = new JTextField(20);
            phoneField.setBounds(150, 140, 200, 30);
            add(phoneField);

            // Email field
            emailLabel = new JLabel("Email:");
            emailLabel.setBounds(50, 180, 100, 30);
            add(emailLabel);
            emailField = new JTextField(20);
            emailField.setBounds(150, 180, 200, 30);
            add(emailField);

            // Gender options
            genderLabel = new JLabel("Gender:");
            genderLabel.setBounds(50, 220, 100, 30);
            add(genderLabel);
            maleRadioButton = new JRadioButton("Male");
            maleRadioButton.setBounds(150, 220, 100, 30);
            femaleRadioButton = new JRadioButton("Female");
            femaleRadioButton.setBounds(250, 220, 100, 30);
            genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);
            add(maleRadioButton);
            add(femaleRadioButton);

            // Date of Birth 
            dateLabel = new JLabel("DOB:");
            dateLabel.setBounds(50,260,80,30);
            add(dateLabel);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            Integer[] years = new Integer[currentYear - 1900 + 1];
            for (int i = 1900; i <= currentYear; i++) {
                years[i - 1900] = i;
            }
            yearComboBox = new JComboBox<>(years);
            yearComboBox.setBounds(150, 260, 80, 30);
            add(yearComboBox);

            String[] months = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December"};
            monthComboBox = new JComboBox<>(months);
            monthComboBox.setBounds(250, 260, 120, 30);
            add(monthComboBox);

            Integer[] days = new Integer[31];
            for (int i = 1; i <= 31; i++) {
                days[i - 1] = i;
            }
            dayComboBox = new JComboBox<>(days);
            dayComboBox.setBounds(400, 260, 60, 30);
            add(dayComboBox);
            
            
            // Membership Start Date
            membershipStartDateLabel = new JLabel("Membership Start Date:");
            membershipStartDateLabel.setBounds(50, 315, 150, 30); // Adjusted Y position
            add(membershipStartDateLabel);

            Integer[] membershipYears = new Integer[currentYear - 1990 + 1];
            for (int i = 1990; i <= currentYear; i++) {
            membershipYears[i - 1990] = i;
            }
            JComboBox<Integer> membershipYearComboBox = new JComboBox<>(membershipYears);
            membershipYearComboBox.setBounds(200, 315, 80, 30); // Adjusted Y position
            add(membershipYearComboBox);

            JComboBox<String> membershipMonthComboBox = new JComboBox<>(months);
            membershipMonthComboBox.setBounds(300, 315, 120, 30); // Adjusted Y position
            add(membershipMonthComboBox);

            Integer[] membershipDays = new Integer[31];
            for (int i = 1; i <= 31; i++) {
            membershipDays[i - 1] = i;
            }
            JComboBox<Integer> membershipDayComboBox = new JComboBox<>(membershipDays);
            membershipDayComboBox.setBounds(450, 315, 60, 30); // Adjusted Y position
            add(membershipDayComboBox);
            
            
            referralSourceLabel = new JLabel("ReferralSource");
            referralSourceLabel.setBounds(50, 360, 100, 30);
            add(referralSourceLabel);
            referralSourceField = new JTextField(20);
            referralSourceField.setBounds(150, 360, 200, 30);
            add(referralSourceField);

            // Plan field
            planLabel = new JLabel("Plan:");
            planLabel.setBounds(50, 400, 100, 30); // Positioning the label
            add(planLabel);

            String[] plans = {"Basic", "Standard", "Deluxe"};
            planComboBox = new JComboBox<>(plans);
            planComboBox.setBounds(150, 400, 100, 30); // Positioning the combo box
            add(planComboBox);
            
            // Non-editable text fields
            JLabel regularPriceLabel = new JLabel("Regular Plan Price:");
            regularPriceLabel.setBounds(50, 440, 150, 30);
            add(regularPriceLabel);
            JTextField regularPriceField = new JTextField("6500"); 
            regularPriceField.setBounds(200, 440, 100, 30);
            regularPriceField.setEditable(false);
            add(regularPriceField);
        
            JLabel premiumChargeLabel = new JLabel("Premium Plan Charge:");
            premiumChargeLabel.setBounds(50, 480, 150, 30);
            add(premiumChargeLabel);
            JTextField premiumChargeField = new JTextField("18500"); 
            premiumChargeField.setBounds(200, 480, 100, 30);
            premiumChargeField.setEditable(false);
            add(premiumChargeField);
        
            JLabel discountLabel = new JLabel("Discount Amount:");
            discountLabel.setBounds(50, 520, 150, 30);
            add(discountLabel);
            JTextField discountField = new JTextField("0");
            discountField.setBounds(200, 520, 100, 30);
            discountField.setEditable(false);
            add(discountField);
            
                       

            // Submit button
            submitButton = new JButton("Submit");
            submitButton.setBounds(200, 560, 100, 30);
            add(submitButton);
            setVisible(true);
            submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  try{
                    // Validate ID field
                    if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    int id = int.parseInt(idField.getText());

                    // Check for duplicate ID
                    for (GymMember m : members) {
                       if (m.getID() == id) {
                        JOptionPane.showMessageDialog(frame, "Member ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                       return; // Stop further execution if ID exists
                        }
                     }

                     // Validate other fields
                     if (nameField.getText().isEmpty() || locationField.getText().isEmpty() || 
                     phoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
                      JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                      }

                     // Validate gender selection
                     if (genderGroup.getSelection() == null) {
                      JOptionPane.showMessageDialog(frame, "Please select a gender!", "Error", JOptionPane.ERROR_MESSAGE);
                      return;
                     }

                     // Extract data for new member
                     String name = nameField.getText();
                     String location = locationField.getText();
                     String phone = phoneField.getText();
                     String email = emailField.getText();
                     String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                     String referralSource = referralSourceField.getText();

                     // Create DOB and membership start date strings
                     String dob = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
                     String membershipStartDate = membershipYearComboBox.getSelectedItem() + "-" + 
                     membershipMonthComboBox.getSelectedItem() + "-" + 
                     membershipDayComboBox.getSelectedItem();

                      // Create and add the new member
                      RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, dob, membershipStartDate, referralSource);
                      members.add(newMember);
                      
                      writeToFile();

                     JOptionPane.showMessageDialog(frame, "New member added successfully!");

                    } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(frame, "ID must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                     } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                           
                  }
                 
          });
            
        }
      }
      
      
       // Premium Member Form
      public class PremiumMemberForm extends JFrame {

        public PremiumMemberForm() {
            setTitle("Premium Member Form");
            setSize(600, 600);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(null); // Set layout to null for manual positioning
            // Disable the maximize button
            setResizable(false);
            
            idLabel = new JLabel("ID:");
            idLabel.setBounds(50, 20, 100, 30); 
            add(idLabel);
            idField = new JTextField(20);
            idField.setBounds(150, 20, 200, 30); 
            add(idField);

            // Name field
            nameLabel = new JLabel("Name:");
            nameLabel.setBounds(50, 60, 100, 30);
            add(nameLabel);
            nameField = new JTextField(20);
            nameField.setBounds(150, 60, 200, 30);
            add(nameField);

            // Location field
            locationLabel = new JLabel("Location:");
            locationLabel.setBounds(50, 100, 100, 30);
            add(locationLabel);
            locationField = new JTextField(20);
            locationField.setBounds(150, 100, 200, 30);
            add(locationField);

            // Phone field
            phoneLabel = new JLabel("Phone:");
            phoneLabel.setBounds(50, 140, 100, 30);
            add(phoneLabel);
            phoneField = new JTextField(20);
            phoneField.setBounds(150, 140, 200, 30);
            add(phoneField);

            // Email field
            emailLabel = new JLabel("Email:");
            emailLabel.setBounds(50, 180, 100, 30);
            add(emailLabel);
            emailField = new JTextField(20);
            emailField.setBounds(150, 180, 200, 30);
            add(emailField);

            // Gender options
            genderLabel = new JLabel("Gender:");
            genderLabel.setBounds(50, 220, 100, 30);
            add(genderLabel);
            maleRadioButton = new JRadioButton("Male");
            maleRadioButton.setBounds(150, 220, 100, 30);
            femaleRadioButton = new JRadioButton("Female");
            femaleRadioButton.setBounds(250, 220, 100, 30);
            genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);
            add(maleRadioButton);
            add(femaleRadioButton);
            
            
            
            
            // Date of Birth 
            dateLabel = new JLabel("DOB:");
            dateLabel.setBounds(50,260,80,30);
            add(dateLabel);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            Integer[] years = new Integer[currentYear - 1900 + 1];
            for (int i = 1900; i <= currentYear; i++) {
                years[i - 1900] = i;
            }
            yearComboBox = new JComboBox<>(years);
            yearComboBox.setBounds(150, 260, 80, 30);
            add(yearComboBox);

            String[] months = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December"};
            monthComboBox = new JComboBox<>(months);
            monthComboBox.setBounds(250, 260, 120, 30);
            add(monthComboBox);

            Integer[] days = new Integer[31];
            for (int i = 1; i <= 31; i++) {
                days[i - 1] = i;
            }
            dayComboBox = new JComboBox<>(days);
            dayComboBox.setBounds(400, 260, 60, 30);
            add(dayComboBox);
            
            
            // Membership Start Date
            membershipStartDateLabel = new JLabel("Membership Start Date:");
            membershipStartDateLabel.setBounds(50, 315, 150, 30); // Adjusted Y position
            add(membershipStartDateLabel);

            Integer[] membershipYears = new Integer[currentYear - 1990 + 1];
            for (int i = 1990; i <= currentYear; i++) {
            membershipYears[i - 1990] = i;
            }
            JComboBox<Integer> membershipYearComboBox = new JComboBox<>(membershipYears);
            membershipYearComboBox.setBounds(200, 315, 80, 30); // Adjusted Y position
            add(membershipYearComboBox);

            JComboBox<String> membershipMonthComboBox = new JComboBox<>(months);
            membershipMonthComboBox.setBounds(300, 315, 120, 30); // Adjusted Y position
            add(membershipMonthComboBox);

            Integer[] membershipDays = new Integer[31];
            for (int i = 1; i <= 31; i++) {
            membershipDays[i - 1] = i;
            }
            JComboBox<Integer> membershipDayComboBox = new JComboBox<>(membershipDays);
            membershipDayComboBox.setBounds(450, 315, 60, 30); // Adjusted Y position
            add(membershipDayComboBox);
            
            
            trainersNameLabel = new JLabel("Trainer's Name");
            trainersNameLabel.setBounds(50, 360, 100, 30);
            add(trainersNameLabel);
            trainersNameField = new JTextField(20);
            trainersNameField.setBounds(150, 360, 200, 30);
            add(trainersNameField);
            
            JLabel paidAmountLabel = new JLabel("Paid Amount");
                            
            paidAmountLabel.setBounds(50, 400, 100, 30);  // position below trainer's name
            add(paidAmountLabel);
            
            paidAmountField = new JTextField(20);
            paidAmountField.setBounds(150, 400, 200, 30);
            add(paidAmountField);
            
            // Submit button
            JButton submitButton = new JButton("Submit");
            submitButton.setBounds(200, 475, 100, 30); // Positioning submit button
            add(submitButton);
             submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                 if (idField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = Integer.parseInt(idField.getText());

            for (GymMember m : members) {
                if (m.getID() == id) {
                    JOptionPane.showMessageDialog(frame, "Member ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (nameField.getText().isEmpty() || locationField.getText().isEmpty() || phoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (genderGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(frame, "Please select a gender!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Collect all necessary data from fields
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String trainersName = trainersNameField.getText();

            String dob = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
            String membershipStartDate = membershipYearComboBox.getSelectedItem() + "-" + membershipMonthComboBox.getSelectedItem() + "-" + membershipDayComboBox.getSelectedItem();

            // Construct PremiumMember using correct constructor ONLY
            PremiumMember newMember = new PremiumMember(id, name, location, phone, email, gender, dob, membershipStartDate, trainersName);

            members.add(newMember);

            writeToFile();

            JOptionPane.showMessageDialog(frame, "New member added successfully!");
            } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "ID must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
                  
                      
                  }
                 
          });
            setVisible(true);
        }

     }
     
     
     
     
     

        private void openManager() {
        managerFrame = new JFrame("Manager Options");
        managerFrame.setLayout(new GridBagLayout());
        managerFrame.setSize(400, 300);
        managerFrame.setLocationRelativeTo(null);
        // Disable the maximize button
        managerFrame.setResizable(false);
        
        JButton regularControllerButton = new JButton("Regular Controller");
        regularControllerButton.setPreferredSize(new Dimension(150, 50));
        regularControllerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegularController() ;
            }
        });
        
        JButton premiumControllerButton  = new JButton("Premium Controller");
        premiumControllerButton.setPreferredSize(new Dimension(150, 50));
        premiumControllerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PremiumController();
            }
        });
        
         
        JButton readFromFileButton = new JButton("Show Members From File");
        readFromFileButton.setPreferredSize(new Dimension(150, 50));
        readFromFileButton.addActionListener(new ActionListener() {
               @Override
                public void actionPerformed(ActionEvent e) {
                 JFrame displayFrame = new JFrame("Members From File");
                 displayFrame.setSize(500, 400);
                 displayFrame.setLocationRelativeTo(null);
                 displayFrame.setLayout(new BorderLayout());
                    
                 JTextArea textArea = new JTextArea();
                  textArea.setEditable(false);
                    
                 try {
                                FileReader fr = new FileReader("members.txt");
                                int c;
                                while ((c = fr.read()) != -1) {
                                    textArea.append(Character.toString((char)c));
                                }
                                fr.close();
                   } catch (IOException ex) {
                          JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
                    }
                    
                 JScrollPane scrollPane = new JScrollPane(textArea);
                  displayFrame.add(scrollPane, BorderLayout.CENTER);
                  displayFrame.setVisible(true);
                 }
            });
                    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        managerFrame.add(regularControllerButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        managerFrame.add(premiumControllerButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        managerFrame.add(readFromFileButton, gbc);        

        managerFrame.setVisible(true);
       }

        public class RegularController extends JFrame {
                  public RegularController() {
                    setTitle("Regular Controller");
                    setSize(700, 700);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    setLocationRelativeTo(null);
                    setLayout(null);
                    setResizable(false);
                    
                    // Back button
                JButton backButton = new JButton("Back");
                backButton.setBounds(50, 10, 100, 30);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose(); // Close this window
                    }
                });
                add(backButton);
        
                // Search button
                JButton searchButton = new JButton("Search");
                searchButton.setBounds(450, 10, 100, 30);
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchMember();
                    }
                });
                add(searchButton);
        
                // ID label and field
                idLabel = new JLabel("ID:");
                idLabel.setBounds(50, 60, 100, 40);
                add(idLabel);
                idField = new JTextField(20);
                idField.setBounds(160, 60, 250, 40);
                add(idField);
        
                // Name label and field
                nameLabel = new JLabel("Name:");
                nameLabel.setBounds(50, 120, 100, 40);
                add(nameLabel);
                nameField = new JTextField(20);
                nameField.setBounds(160, 120, 250, 40);
                add(nameField);
        
                // Phone label and field
                phoneLabel = new JLabel("Phone:");
                phoneLabel.setBounds(50, 180, 100, 40);
                add(phoneLabel);
                phoneField = new JTextField(20);
                phoneField.setBounds(160, 180, 250, 40);
                add(phoneField);
        
                // Email label and field
                emailLabel = new JLabel("Email:");
                emailLabel.setBounds(50, 240, 100, 40);
                add(emailLabel);
                emailField = new JTextField(20);
                emailField.setBounds(160, 240, 250, 40);
                add(emailField);
        
                // Activate button
                JButton activateButton = new JButton("Activate Member");
                activateButton.setBounds(50, 375, 150, 40);
                activateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String memberId = idField.getText(); 
                        boolean found = false;
        
                        try {
                            int idToSearch = Integer.parseInt(memberId);
        
                            for (GymMember member : members) {
                                if (member.getID() == idToSearch) {
                                    member.activateMembership();
                                    JOptionPane.showMessageDialog(RegularController.this, "Membership Activated!");
                                    found = true;
                                    break;
                                }
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(RegularController.this, "Invalid ID. Please enter a numeric ID.");
                        }
        
                        if (!found) {
                            JOptionPane.showMessageDialog(RegularController.this, "Member not found.");
                        }
                    }
                });
                add(activateButton);
        
                // Deactivate button
                JButton deactivateButton = new JButton("Deactivate Member");
                deactivateButton.setBounds(350, 375, 150, 40);
                deactivateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String memberId = idField.getText();
                        boolean found = false;
        
                        try {
                            int idToSearch = Integer.parseInt(memberId);
        
                            for (GymMember member : members) {
                                if (member.getID() == idToSearch) {
                                    member.deactivateMembership();
                                    JOptionPane.showMessageDialog(RegularController.this, "Membership Deactivated!");
                                    found = true;
                                    break;
                                }
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(RegularController.this, "Invalid ID. Please enter a numeric ID.");
                        }
        
                        if (!found) {
                            JOptionPane.showMessageDialog(RegularController.this, "Member not found.");
                        }
                    }
                });
                add(deactivateButton);
        
                // Revert Regular Member button
                JButton revertMemberButton = new JButton("Revert Member");
                revertMemberButton.setBounds(200, 450, 150, 40);
                revertMemberButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        revertRegularMember();
                    }
                });
                add(revertMemberButton);
        
                
        
                setVisible(true);
            }

         }
        
         
         public class PremiumController extends JFrame {
                  public PremiumController() {
                    setTitle("Premium Controller");
                    setSize(650, 600);
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    setLocationRelativeTo(null);
                    setLayout(null);
                    setResizable(false);
                    
                    // Back button
                JButton backButton = new JButton("Back");
                backButton.setBounds(50, 10, 100, 30);
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose(); // Close this window
                    }
                });
                add(backButton);
        
                // Search button
                JButton searchButton = new JButton("Search");
                searchButton.setBounds(450, 10, 100, 30);
                searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchMember();
                    }
                });
                add(searchButton);
        
                // ID label and field
                idLabel = new JLabel("ID:");
                idLabel.setBounds(50, 60, 100, 40);
                add(idLabel);
                idField = new JTextField(20);
                idField.setBounds(160, 60, 250, 40);
                add(idField);
                
                JLabel amountLabel = new JLabel("Amount:");
                amountLabel.setBounds(50, 300, 100, 40);
                add(amountLabel);
                 amountField = new JTextField(20);
                amountField.setBounds(160, 300, 250, 40);
                add(amountField);
        
                // Name label and field
                nameLabel = new JLabel("Name:");
                nameLabel.setBounds(50, 130, 100, 40);
                add(nameLabel);
                nameField = new JTextField(20);
                nameField.setBounds(160, 130, 250, 40);
                add(nameField);
        
                // Phone label and field
                phoneLabel = new JLabel("Phone:");
                phoneLabel.setBounds(50, 180, 100, 40);
                add(phoneLabel);
                phoneField = new JTextField(20);
                phoneField.setBounds(160, 180, 250, 40);
                add(phoneField);
        
                // Email label and field
                emailLabel = new JLabel("Email:");
                emailLabel.setBounds(50, 240, 100, 40);
                add(emailLabel);
                emailField = new JTextField(20);
                emailField.setBounds(160, 240, 250, 40);
                add(emailField);
        
                // Activate button
                JButton activateButton = new JButton("Activate Member");
                activateButton.setBounds(50, 375, 150, 40);
                activateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String memberId = idField.getText(); // no trim as requested
                        boolean found = false;
        
                        try {
                            int idToSearch = Integer.parseInt(memberId);
        
                            for (GymMember member : members) {
                                if (member.getID() == idToSearch) {
                                    member.activateMembership();
                                    JOptionPane.showMessageDialog(PremiumController.this, "Membership Activated!");
                                    found = true;
                                    break;
                                }
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(PremiumController.this, "Invalid ID. Please enter a numeric ID.");
                        }
        
                        if (!found) {
                            JOptionPane.showMessageDialog(PremiumController.this, "Member not found.");
                        }
                    }
                });
                add(activateButton);
        
                // Deactivate button
                JButton deactivateButton = new JButton("Deactivate Member");
                deactivateButton.setBounds(350, 375, 150, 40);
                deactivateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String memberId = idField.getText();
                        boolean found = false;
        
                        try {
                            int idToSearch = Integer.parseInt(memberId);
        
                            for (GymMember member : members) {
                                if (member.getID() == idToSearch) {
                                    member.deactivateMembership();
                                    JOptionPane.showMessageDialog(PremiumController.this, "Membership Deactivated!");
                                    found = true;
                                    break;
                                }
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(PremiumController.this, "Invalid ID. Please enter a numeric ID.");
                        }
        
                        if (!found) {
                            JOptionPane.showMessageDialog(PremiumController.this, "Member not found.");
                        }
                    }
                });
                add(deactivateButton);
        
                
                JButton revertMemberButton = new JButton("Revert Member");
                revertMemberButton.setBounds(50, 450, 150, 40);
                revertMemberButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        revertPremiumMember();
                    }
                });
                add(revertMemberButton);
        
                
                JButton payDueAmountButton = new JButton("Pay Due Amount");
                payDueAmountButton.setBounds(350, 450, 150, 40);
                payDueAmountButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     payDueAmount();
               }
              });
                add(payDueAmountButton);
               
                                                    
        
                setVisible(true);
             }
             
             
                 private void calculateDiscount() {
                try {
                    int id = Integer.parseInt(idField.getText());
                    for (GymMember member : members) {
                        if (member.getID() == id) {
                            if (member instanceof PremiumMember) {
                                PremiumMember premium = (PremiumMember) member;
                                premium.calculateDiscount(); 
                                writeToFile(); 
                                premium.display(); 
                                return; 
                            }
                        }
                    }
                    
                    JOptionPane.showMessageDialog(this, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Member ID!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            private void payDueAmount() {
                try {
                    int id = Integer.parseInt(idField.getText());
                    double amount = Double.parseDouble(amountField.getText());
            
                    for (GymMember member : members) {
                        if (member.getID() == id) {
                            if (member instanceof PremiumMember) {
                                PremiumMember premium = (PremiumMember) member;
                                premium.payDueAmount(amount);
                                writeToFile(); 
                                premium.display(); 
                                return; 
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Member ID or amount!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
             private GymMember findMemberById(int memberId) {
                for (GymMember member : members) {
                    if (member.getID() == memberId) {
                        return member;
                    }
                }
                return null;
             }
             
             
         }

       private void openMarkAttendance(){
        
        markAttendanceFrame = new JFrame("Attendance Options");
        markAttendanceFrame.setLayout(new GridBagLayout());
        markAttendanceFrame.setSize(400, 300);
        markAttendanceFrame.setLocationRelativeTo(null);
        markAttendanceFrame.setResizable(false);
        
        JButton regularAttendanceButton = new JButton("Regular attendance");
        regularAttendanceButton.setPreferredSize(new Dimension(150, 50));
        regularAttendanceButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               new RegularAttendance();
            }
        });
        
        JButton premiumAttendanceButton = new JButton("Premium Attendance");
        premiumAttendanceButton.setPreferredSize(new Dimension(150, 50));
        premiumAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new PremiumAttendance();               
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        markAttendanceFrame.add(regularAttendanceButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        markAttendanceFrame.add(premiumAttendanceButton, gbc);
        markAttendanceFrame.setVisible(true);
       }
     
    
   
        public class RegularAttendance{
        public RegularAttendance(){
            JFrame regularAttendanceFrame = new JFrame("Member Information");
            regularAttendanceFrame.setSize(500, 350);
            regularAttendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            regularAttendanceFrame.setLayout(new GridBagLayout());
            
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            
            
        
             GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Padding for components
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // ID Field
            gbc.gridx = 0;
            gbc.gridy = 1;
            regularAttendanceFrame.add(new JLabel("ID:"), gbc);

            idField = new JTextField(20);
            gbc.gridx = 1;
            regularAttendanceFrame.add(idField, gbc);

            // Name Field
            gbc.gridx = 0;
            gbc.gridy = 2;
            regularAttendanceFrame.add(new JLabel("Name:"), gbc);

            nameField = new JTextField(20);
            gbc.gridx = 1;
            regularAttendanceFrame.add(nameField, gbc);
    
            // Phone Field
            gbc.gridx = 0;
            gbc.gridy = 3;
            regularAttendanceFrame.add(new JLabel("Phone:"), gbc);
    
            phoneField = new JTextField(20);
            gbc.gridx = 1;
            regularAttendanceFrame.add(phoneField, gbc);

            
            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                
                        regularAttendanceFrame.dispose(); // Close the current window
                    
                    }
            });
            gbc.gridx = 0;
            gbc.gridy = 0;
            regularAttendanceFrame.add(backButton, gbc);
        
            // Search button (same line as Back button, top-right)
            JButton searchButton = new JButton("Search");
            searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchMember();
                    }
            });
            gbc.gridx = 3;
            gbc.gridy = 0;
            regularAttendanceFrame.add(searchButton, gbc);
            
            
            attendanceButton = new JButton("Mark Attendence");
            attendanceButton.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
             String memberIdText = idField.getText();
             boolean found = false;
                for (GymMember member : members) {
                    if (member.getID() == Integer.parseInt(memberIdText)) {
                        found = true;
                                member.markAttendance(); 
                        JOptionPane.showMessageDialog(membershipFrame, "Attendance marked successfully for Member ID: " + memberIdText);
                    break;
                   }
                 }

                    if (!found) {
                    JOptionPane.showMessageDialog(membershipFrame, "Member ID not found.");
                   }
            }
           });
            gbc.gridx = 1;
            gbc.gridy = 4;
            regularAttendanceFrame.add(attendanceButton, gbc);
            
            regularAttendanceFrame.setVisible(true);

        }
        
        
        public class markRegularAttendance extends JFrame{
          
         private void markRegularAttendace(){
             String memberIdText = idField.getText();
             boolean found = false;
             for (GymMember member : members) {
            if (member.getID() == Integer.parseInt(memberIdText)) {
                found = true;
                member.markAttendance(); 
                JOptionPane.showMessageDialog(membershipFrame, "Attendance marked successfully for Member ID: " + memberIdText);
                break;
              }
          }

          if (!found) {
            JOptionPane.showMessageDialog(membershipFrame, "Member ID not found.");
            }
        
         }
     
       }
      }
    
    
    
      public class PremiumAttendance{
        public PremiumAttendance(){
            JFrame premiumAttendanceFrame = new JFrame("Member Information");
            premiumAttendanceFrame.setSize(500, 350);
            premiumAttendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            premiumAttendanceFrame.setLayout(new GridBagLayout());
            
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            
            
        
             GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Padding for components
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // ID Field
            gbc.gridx = 0;
            gbc.gridy = 1;
            premiumAttendanceFrame.add(new JLabel("ID:"), gbc);

            idField = new JTextField(20);
            gbc.gridx = 1;
            premiumAttendanceFrame.add(idField, gbc);

            // Name Field
            gbc.gridx = 0;
            gbc.gridy = 2;
            premiumAttendanceFrame.add(new JLabel("Name:"), gbc);

            nameField = new JTextField(20);
            gbc.gridx = 1;
            premiumAttendanceFrame.add(nameField, gbc);
    
            // Phone Field
            gbc.gridx = 0;
            gbc.gridy = 3;
            premiumAttendanceFrame.add(new JLabel("Phone:"), gbc);
    
            phoneField = new JTextField(20);
            gbc.gridx = 1;
            premiumAttendanceFrame.add(phoneField, gbc);

            
            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                
                        premiumAttendanceFrame.dispose(); // Close the current window
                    
                    }
            });
            gbc.gridx = 0;
            gbc.gridy = 0;
            premiumAttendanceFrame.add(backButton, gbc);
        
            // Search button (same line as Back button, top-right)
            JButton searchButton = new JButton("Search");
            searchButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchMember();
                    }
            });
            gbc.gridx = 3;
            gbc.gridy = 0;
            premiumAttendanceFrame.add(searchButton, gbc);
            
            
            attendanceButton = new JButton("Mark Attendence");
            attendanceButton.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
             String memberIdText = idField.getText();
             boolean found = false;
                for (GymMember member : members) {
                    if (member.getID() == Integer.parseInt(memberIdText)) {
                        found = true;
                                member.markAttendance(); 
                        JOptionPane.showMessageDialog(membershipFrame, "Attendance marked successfully for Member ID: " + memberIdText);
                    break;
                   }
                 }

                    if (!found) {
                    JOptionPane.showMessageDialog(membershipFrame, "Member ID not found.");
                   }
            }
           });
            gbc.gridx = 1;
            gbc.gridy = 4;
            premiumAttendanceFrame.add(attendanceButton, gbc);
            
            premiumAttendanceFrame.setVisible(true);

        }
        
        
             public class markRegularAttendance extends JFrame{
              
             private void markRegularAttendace(){
                 String memberIdText = idField.getText();
                 boolean found = false;
                 for (GymMember member : members) {
                if (member.getID() == Integer.parseInt(memberIdText)) {
                    found = true;
                    member.markAttendance(); 
                    JOptionPane.showMessageDialog(membershipFrame, "Attendance marked successfully for Member ID: " + memberIdText);
                    break;
                  }
              }
    
              if (!found) {
                JOptionPane.showMessageDialog(membershipFrame, "Member ID not found.");
                }
            
             }
            
             }
      }
     
      
        private void revertRegularMember() {
        String memberIdText = idField.getText().trim();
        if (memberIdText.isEmpty()) {
            JOptionPane.showMessageDialog(membershipFrame, "Please enter a Member ID.");
            return;
        }

        boolean found = false;

        for (GymMember member : members) {
            if (member.getID() == Integer.parseInt(memberIdText)) {
                    found = true;

                // Revert the Regular Member using its specific method
                if (member instanceof RegularMember) {
                    ((RegularMember) member).revertRegularMember();
                    JOptionPane.showMessageDialog(membershipFrame, "Regular Member reverted successfully.");
                }
               break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(membershipFrame, "Member ID not found.");
        }
      }
      
         private void revertPremiumMember() {
        String memberIdText = idField.getText().trim();
        if (memberIdText.isEmpty()) {
            JOptionPane.showMessageDialog(membershipFrame, "Please enter a Member ID.");
            return;
        }

        boolean found = false;

        for (GymMember member : members) {
            if (member.getID() == Integer.parseInt(memberIdText)) {
                found = true;

                // Revert the Premium Member using its specific method
                if (member instanceof PremiumMember) {
                    ((PremiumMember) member).revertPremiumMember();
                    JOptionPane.showMessageDialog(membershipFrame, "Premium Member reverted successfully.");
                }
            break;
           }   
        }

        if (!found) {
            JOptionPane.showMessageDialog(membershipFrame, "Member ID not found.");
        }
      }
     
      
       private void searchMember() {
            String memberId = idField.getText().trim();
            boolean found = false;
            for (GymMember member : members) {
            if (member.getID() == Integer.parseInt(memberId)) {
                found = true;
    
                // Check if the membership is active
                if (member.activeStatus()) {
                    nameField.setText(member.getName());
                    phoneField.setText(member.getPhone());
                    emailField.setText(member.getEmail());
                    JOptionPane.showMessageDialog(membershipFrame, "Member details found and displayed.");
                } else {
                    JOptionPane.showMessageDialog(membershipFrame, "Membership is deactivated. Details cannot be displayed.");
                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                }
                break;
            }
          }
    
           if (!found) {
            JOptionPane.showMessageDialog(membershipFrame, "Member not found.");
            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");
            }
        }
        
        
        
        public void writeToFile() {
            File memberFile = new File("C:\\Users\\A C E R\\Desktop\\24046895 Slesha Maharjan\\24046895 Slesha Maharjan\\24046895 Slesha Maharjan\\Members.txt");
        
             try (FileWriter memberWriter = new FileWriter(memberFile, true)) {
                boolean fileExists = memberFile.exists();
        
                if (!fileExists || memberFile.length() == 0) {
                    memberWriter.write(String.format(
                        "%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-15s %-15s %-15s %-15s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Membership Start Date",
                        "Plan", "Price", "Attendance", "Loyalty Points", "Active Status",
                        "Full Payment", "Discount Amount", "Net Amount Paid"));
                }
        
                // Write data for all members
                for (GymMember member : members) {
                    if (member instanceof PremiumMember) {
                        PremiumMember premium = (PremiumMember) member;
                        memberWriter.write(String.format(
                            "%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10d %-15.2f %-15s %-15s %-15.2f %-15.2f\n",
                            premium.getID(), premium.getName(), premium.getLocation(), premium.getPhone(),
                            premium.getEmail(), premium.getMembershipStartDate(),
                            "-", "-",  // Plan and Price not applicable
                            premium.attendance, premium.loyalityPoints,
                            premium.activeStatus ? "Active" : "Inactive",
                            premium.getIsFullPayment(), premium.getDiscountAmount(), premium.getPaidAmount()));
                    } else if (member instanceof RegularMember) {
                        RegularMember regular = (RegularMember) member;
                        memberWriter.write(String.format(
                            "%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-15s %-15s %-15s %-15s\n",
                            regular.getID(), regular.getName(), regular.getLocation(), regular.getPhone(),
                            regular.getEmail(), regular.getMembershipStartDate(),
                            regular.getPlan(), regular.getPrice(),
                            regular.getAttendance(), regular.loyalityPoints(),
                            regular.activeStatus() ? "Active" : "Inactive",
                            "-", "-", "-", "-"));  
                    }
                }
        
                System.out.println("Member details successfully written to Members.txt file.");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
}
