
//Angelica 
//Megan Phillips
//Kathy Kanemoto

package cropDroneAnalysis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AnalysisProgram_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel droneEquipmentCostLabel;
	private JLabel employeeTrainingCostLabel;
	private JLabel employeeBenefitsCostLabel;
	private JLabel repairAndUpgradeCostLabel;
	private JLabel totalEmployeeAndEquipment;
	private JLabel otherEquipmentCostLabel;
	private JLabel droneMixingEquipmentCostLabel;
	private JTextField numOfEmployeesTextField;
	private JTextField numOfYearsUsedTextField;
	private AnalysisProgram analysis;
	private JTextField numOfDronesUsedTextField;
	private JTextField droneBegDateTextField;
	private JTextField droneEndDateTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the  application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalysisProgram_GUI frame = new AnalysisProgram_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnalysisProgram_GUI() {

		//creating an instance of the analysis program
		analysis = new AnalysisProgram();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 1012);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Drone Equipment and Employee Costs");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 237, 14);
		contentPane.add(lblNewLabel);

		JSlider droneEquipment = new JSlider();
		droneEquipment.setMinorTickSpacing(1000);
		droneEquipment.setMajorTickSpacing(1000);
		droneEquipment.setValue(20000);
		droneEquipment.setMinimum(10000);
		droneEquipment.setMaximum(50000);
		droneEquipment.setBounds(173, 36, 140, 26);
		droneEquipment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = droneEquipment.getValue();
				analysis.setDroneEquipmentCosts(value);
				droneEquipmentCostLabel.setText("$" + value);
			}
		});
		contentPane.add(droneEquipment);

		droneEquipmentCostLabel = new JLabel("$20000");
		droneEquipmentCostLabel.setBounds(10, 56, 48, 14);
		contentPane.add(droneEquipmentCostLabel);

		JTextArea txtrFixedEquipmentCosts = new JTextArea();
		txtrFixedEquipmentCosts.setLineWrap(true);
		txtrFixedEquipmentCosts.setText("Fixed Equipment Costs");
		txtrFixedEquipmentCosts.setBounds(10, 36, 140, 22);
		contentPane.add(txtrFixedEquipmentCosts);

		JTextArea txtrEmployeeTrainingCosts = new JTextArea();
		txtrEmployeeTrainingCosts.setText("Employee Training Costs");
		txtrEmployeeTrainingCosts.setLineWrap(true);
		txtrEmployeeTrainingCosts.setBounds(10, 166, 140, 22);
		contentPane.add(txtrEmployeeTrainingCosts);

		employeeTrainingCostLabel = new JLabel("$2500");
		employeeTrainingCostLabel.setBounds(10, 188, 48, 14);
		contentPane.add(employeeTrainingCostLabel);

		JSlider employeeTrainingSlider = new JSlider();
		employeeTrainingSlider.setValue(0);
		employeeTrainingSlider.setMinorTickSpacing(500);
		employeeTrainingSlider.setMaximum(10000);
		employeeTrainingSlider.setMajorTickSpacing(500);
		employeeTrainingSlider.setBounds(173, 162, 140, 26);
		employeeTrainingSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = employeeTrainingSlider.getValue();
				analysis.setEmployeeTrainingCosts(value);
				employeeTrainingCostLabel.setText("$" + value);
			}
		});
		contentPane.add(employeeTrainingSlider);

		JTextArea txtEmployeeBenefits = new JTextArea();
		txtEmployeeBenefits.setText("Employee(s) Benefits");
		txtEmployeeBenefits.setLineWrap(true);
		txtEmployeeBenefits.setBounds(10, 213, 140, 26);
		contentPane.add(txtEmployeeBenefits);

		JSlider employeeBenefitsSlider = new JSlider();
		employeeBenefitsSlider.setValue(0);
		employeeBenefitsSlider.setMinorTickSpacing(500);
		employeeBenefitsSlider.setMaximum(10000);
		employeeBenefitsSlider.setMajorTickSpacing(500);
		employeeBenefitsSlider.setBounds(173, 213, 140, 26);
		employeeBenefitsSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = employeeBenefitsSlider.getValue();
				analysis.setEmployeeBenefitsCosts(value);
				employeeBenefitsCostLabel.setText("$" + value);
			}
		});
		contentPane.add(employeeBenefitsSlider);

		JTextArea txtrRepairAndUpgrade = new JTextArea();
		txtrRepairAndUpgrade.setText("Repair and Upgrade Costs");
		txtrRepairAndUpgrade.setLineWrap(true);
		txtrRepairAndUpgrade.setBounds(10, 264, 140, 22);
		contentPane.add(txtrRepairAndUpgrade);

		repairAndUpgradeCostLabel = new JLabel("$2500");
		repairAndUpgradeCostLabel.setBounds(10, 288, 48, 14);
		contentPane.add(repairAndUpgradeCostLabel);

		JSlider repairAndUpgradeSlider = new JSlider();
		repairAndUpgradeSlider.setValue(0);
		repairAndUpgradeSlider.setMinorTickSpacing(500);
		repairAndUpgradeSlider.setMaximum(10000);
		repairAndUpgradeSlider.setMajorTickSpacing(500);
		repairAndUpgradeSlider.setBounds(173, 264, 140, 26);
		repairAndUpgradeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = repairAndUpgradeSlider.getValue();
				analysis.setRepairAndUpgradeCosts(value);
				repairAndUpgradeCostLabel.setText("$" + value);
			}
		});
		contentPane.add(repairAndUpgradeSlider);

		JTextArea txtrNumberOfEmployees = new JTextArea();
		txtrNumberOfEmployees.setText("Number of Employees");
		txtrNumberOfEmployees.setLineWrap(true);
		txtrNumberOfEmployees.setBounds(10, 133, 140, 22);
		contentPane.add(txtrNumberOfEmployees);

		numOfEmployeesTextField = new JTextField();
		numOfEmployeesTextField.setBounds(171, 131, 96, 20);
		contentPane.add(numOfEmployeesTextField);
		numOfEmployeesTextField.setColumns(10);
		numOfEmployeesTextField.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {

				try {
					if (Integer.parseInt(numOfEmployeesTextField.getText())<=0){
						JOptionPane.showMessageDialog(null,
								"Error: Please enter number bigger than 0", "Error Message",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						analysis.setNumOfEmployees(Integer.parseInt(numOfEmployeesTextField.getText()));
					}
				} catch(NumberFormatException e) {
					System.out.println("oops");
				}
			}
		});

		employeeBenefitsCostLabel = new JLabel("$2500");
		employeeBenefitsCostLabel.setBounds(10, 239, 48, 14);
		contentPane.add(employeeBenefitsCostLabel);

		JTextArea txtrNumberOfYears = new JTextArea();
		txtrNumberOfYears.setText("Number of Years used");
		txtrNumberOfYears.setLineWrap(true);
		txtrNumberOfYears.setBounds(10, 100, 140, 22);
		contentPane.add(txtrNumberOfYears);

		numOfYearsUsedTextField = new JTextField();
		numOfYearsUsedTextField.setColumns(10);
		numOfYearsUsedTextField.setBounds(171, 100, 96, 20);
		contentPane.add(numOfYearsUsedTextField);
		// Listen for changes in the text
		numOfYearsUsedTextField.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
				
			}
			public void insertUpdate(DocumentEvent e) { 
				warn();
			}

			public void warn() {
				try {
					if (Integer.parseInt(numOfYearsUsedTextField.getText())<=0){
						JOptionPane.showMessageDialog(null,
								"Error: Please enter number bigger than 0", "Error Message",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						analysis.setNumOfYearsUsed(Integer.parseInt(numOfYearsUsedTextField.getText()));
					}
				} catch(NumberFormatException e) {
					System.out.println("oopsy");
				}
			}
		});

		totalEmployeeAndEquipment = new JLabel("$2500");
		totalEmployeeAndEquipment.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment.setBounds(246, 313, 102, 26);
		contentPane.add(totalEmployeeAndEquipment);

		JButton btnTotalEmployeesAnd = new JButton("TOTAL Employee(s) and Equipment");
		btnTotalEmployeesAnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTotalEmployeesAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calculate the employee and equipment costs based on user input
				double costs = analysis.calculateEmployeeAndEquipmentCosts();
				totalEmployeeAndEquipment.setText("$" + costs);	
			}
		});
		btnTotalEmployeesAnd.setBounds(10, 313, 226, 26);
		contentPane.add(btnTotalEmployeesAnd);
		
		JTextArea setUpTimeTextArea = new JTextArea();
		setUpTimeTextArea.setText("Set Up Time");
		setUpTimeTextArea.setLineWrap(true);
		setUpTimeTextArea.setBounds(10, 375, 140, 22);
		contentPane.add(setUpTimeTextArea);
		
		JTextArea chargingTimeTextArea = new JTextArea();
		chargingTimeTextArea.setText("Charging Time");
		chargingTimeTextArea.setLineWrap(true);
		chargingTimeTextArea.setBounds(10, 408, 140, 22);
		contentPane.add(chargingTimeTextArea);
		
		JTextArea areaToSprayAcres = new JTextArea();
		areaToSprayAcres.setText("Acres To Spray ");
		areaToSprayAcres.setLineWrap(true);
		areaToSprayAcres.setBounds(10, 441, 140, 26);
		contentPane.add(areaToSprayAcres);
		
		JTextArea amountToSprayPerAcre = new JTextArea();
		amountToSprayPerAcre.setText("Amount To Spray Per Acre");
		amountToSprayPerAcre.setLineWrap(true);
		amountToSprayPerAcre.setBounds(10, 478, 140, 38);
		contentPane.add(amountToSprayPerAcre);
		
		JTextArea beginngDate = new JTextArea();
		beginngDate.setText("Beginning Date");
		beginngDate.setLineWrap(true);
		beginngDate.setBounds(10, 686, 140, 22);
		contentPane.add(beginngDate);
		
		JTextArea endingDate = new JTextArea();
		endingDate.setText("EndingDate");
		endingDate.setLineWrap(true);
		endingDate.setBounds(10, 719, 140, 22);
		contentPane.add(endingDate);
		
		JLabel lblDroneEquipmentSpraying = new JLabel("Drone Spraying Costs");
		lblDroneEquipmentSpraying.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDroneEquipmentSpraying.setBounds(10, 350, 237, 14);
		contentPane.add(lblDroneEquipmentSpraying);
		
		JTextArea txtrBatteryChargeTime = new JTextArea();
		txtrBatteryChargeTime.setText("Battery Charge Time");
		txtrBatteryChargeTime.setLineWrap(true);
		txtrBatteryChargeTime.setBounds(10, 777, 140, 22);
		contentPane.add(txtrBatteryChargeTime);
		
		JTextArea txtrBatteryLife = new JTextArea();
		txtrBatteryLife.setText("Battery Life");
		txtrBatteryLife.setLineWrap(true);
		txtrBatteryLife.setBounds(10, 810, 140, 22);
		contentPane.add(txtrBatteryLife);
		
		JTextArea txtrNumberOfDrones = new JTextArea();
		txtrNumberOfDrones.setText("Number of Drones used");
		txtrNumberOfDrones.setLineWrap(true);
		txtrNumberOfDrones.setBounds(10, 73, 140, 22);
		contentPane.add(txtrNumberOfDrones);
		
		numOfDronesUsedTextField = new JTextField();
		numOfDronesUsedTextField.setColumns(10);
		numOfDronesUsedTextField.setBounds(173, 73, 96, 20);
		contentPane.add(numOfDronesUsedTextField);
		
		JSlider droneSetUpTime = new JSlider();
		droneSetUpTime.setValue(20000);
		droneSetUpTime.setMinorTickSpacing(5);
		droneSetUpTime.setMinimum(20);
		droneSetUpTime.setMaximum(300);
		droneSetUpTime.setMajorTickSpacing(5);
		droneSetUpTime.setBounds(160, 375, 140, 26);
		contentPane.add(droneSetUpTime);
		
		JSlider droneChargeTime = new JSlider();
		droneChargeTime.setValue(20000);
		droneChargeTime.setMinorTickSpacing(5);
		droneChargeTime.setMinimum(20);
		droneChargeTime.setMaximum(300);
		droneChargeTime.setMajorTickSpacing(5);
		droneChargeTime.setBounds(160, 408, 140, 26);
		contentPane.add(droneChargeTime);
		
		JSlider droneAcresToSpray = new JSlider();
		droneAcresToSpray.setValue(20000);
		droneAcresToSpray.setMinorTickSpacing(5);
		droneAcresToSpray.setMaximum(500);
		droneAcresToSpray.setMajorTickSpacing(5);
		droneAcresToSpray.setBounds(160, 441, 140, 26);
		contentPane.add(droneAcresToSpray);
		
		JSlider droneAmountToSpray = new JSlider();
		droneAmountToSpray.setValue(20000);
		droneAmountToSpray.setMinorTickSpacing(5);
		droneAmountToSpray.setMaximum(500);
		droneAmountToSpray.setMajorTickSpacing(5);
		droneAmountToSpray.setBounds(160, 478, 140, 26);
		contentPane.add(droneAmountToSpray);
		
		JSlider droneBatteryChargeTime = new JSlider();
		droneBatteryChargeTime.setValue(20000);
		droneBatteryChargeTime.setMinorTickSpacing(5);
		droneBatteryChargeTime.setMaximum(500);
		droneBatteryChargeTime.setMajorTickSpacing(5);
		droneBatteryChargeTime.setBounds(160, 777, 140, 26);
		contentPane.add(droneBatteryChargeTime);
		
		JSlider droneBatteryLifeTime = new JSlider();
		droneBatteryLifeTime.setValue(20000);
		droneBatteryLifeTime.setMinorTickSpacing(5);
		droneBatteryLifeTime.setMaximum(500);
		droneBatteryLifeTime.setMajorTickSpacing(5);
		droneBatteryLifeTime.setBounds(160, 810, 140, 26);
		contentPane.add(droneBatteryLifeTime);
		
		droneBegDateTextField = new JTextField();
		droneBegDateTextField.setColumns(10);
		droneBegDateTextField.setBounds(171, 688, 96, 20);
		contentPane.add(droneBegDateTextField);
		
		droneEndDateTextField = new JTextField();
		droneEndDateTextField.setColumns(10);
		droneEndDateTextField.setBounds(171, 721, 96, 20);
		contentPane.add(droneEndDateTextField);
		
		JButton btnTotalDroneSprayingCosts = new JButton("TOTAL Drone Spraying Costs");
		btnTotalDroneSprayingCosts.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTotalDroneSprayingCosts.setBounds(10, 878, 219, 26);
		contentPane.add(btnTotalDroneSprayingCosts);
		
		JLabel totalEmployeeAndEquipment_1 = new JLabel("$2500");
		totalEmployeeAndEquipment_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment_1.setBounds(246, 878, 102, 26);
		contentPane.add(totalEmployeeAndEquipment_1);
		
		JLabel totalEmployeeAndEquipment_1_1 = new JLabel("Days able to fly: 10");
		totalEmployeeAndEquipment_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment_1_1.setBounds(10, 915, 182, 26);
		contentPane.add(totalEmployeeAndEquipment_1_1);
		
		JLabel lblDroneEnergyCosts = new JLabel("Drone Energy Costs");
		lblDroneEnergyCosts.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDroneEnergyCosts.setBounds(10, 752, 237, 14);
		contentPane.add(lblDroneEnergyCosts);
		
		JTextArea droneCostOfSpray = new JTextArea();
		droneCostOfSpray.setText("Cost of Spray");
		droneCostOfSpray.setLineWrap(true);
		droneCostOfSpray.setBounds(10, 527, 140, 26);
		contentPane.add(droneCostOfSpray);
		
		JTextArea txtrCostPerWatt = new JTextArea();
		txtrCostPerWatt.setText("Cost Per Watt");
		txtrCostPerWatt.setLineWrap(true);
		txtrCostPerWatt.setBounds(10, 843, 140, 22);
		contentPane.add(txtrCostPerWatt);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 847, 96, 20);
		contentPane.add(textField);
		
		JSlider droneCostSpray = new JSlider();
		droneCostSpray.setValue(20000);
		droneCostSpray.setMinorTickSpacing(5);
		droneCostSpray.setMaximum(500);
		droneCostSpray.setMajorTickSpacing(5);
		droneCostSpray.setBounds(160, 527, 140, 26);
		contentPane.add(droneCostSpray);
		
		JTextArea droneRequireMixing = new JTextArea();
		droneRequireMixing.setText("Requires Mixing?");
		droneRequireMixing.setLineWrap(true);
		droneRequireMixing.setBounds(10, 564, 140, 26);
		contentPane.add(droneRequireMixing);
		
		JCheckBox droneRequireMixChckbx = new JCheckBox("Yes");
		droneRequireMixChckbx.setBounds(170, 565, 97, 23);
		contentPane.add(droneRequireMixChckbx);
		
		JTextArea droneTankSize = new JTextArea();
		droneTankSize.setText("Tank Size");
		droneTankSize.setLineWrap(true);
		droneTankSize.setBounds(10, 661, 140, 26);
		contentPane.add(droneTankSize);
		
		JSlider droneCostSpray_1 = new JSlider();
		droneCostSpray_1.setValue(20000);
		droneCostSpray_1.setMinorTickSpacing(1);
		droneCostSpray_1.setMaximum(50);
		droneCostSpray_1.setMajorTickSpacing(1);
		droneCostSpray_1.setBounds(160, 658, 140, 26);
		contentPane.add(droneCostSpray_1);
		
		JLabel droneWeightOutput = new JLabel("Drone Weight: 55lbs");
		droneWeightOutput.setFont(new Font("Tahoma", Font.BOLD, 11));
		droneWeightOutput.setBounds(10, 936, 182, 26);
		contentPane.add(droneWeightOutput);
		
		JTextArea droneMixingCostEquipment = new JTextArea();
		droneMixingCostEquipment.setText("Equipment Mixing Cost");
		droneMixingCostEquipment.setLineWrap(true);
		droneMixingCostEquipment.setBounds(20, 599, 140, 26);
		contentPane.add(droneMixingCostEquipment);
		
		JSlider droneCostMixingEquipmentSlider = new JSlider();
		droneCostMixingEquipmentSlider.setValue(20000);
		droneCostMixingEquipmentSlider.setMinorTickSpacing(500);
		droneCostMixingEquipmentSlider.setMaximum(50000);
		droneCostMixingEquipmentSlider.setMajorTickSpacing(1000);
		droneCostMixingEquipmentSlider.setBounds(160, 595, 140, 26);
		droneCostMixingEquipmentSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = droneCostMixingEquipmentSlider.getValue();
				//analysis.setEmployeeTrainingCosts(value);
				droneMixingEquipmentCostLabel.setText("$" + value);
			}
		});
		contentPane.add(droneCostMixingEquipmentSlider);
		
		droneMixingEquipmentCostLabel = new JLabel("$2500");
		droneMixingEquipmentCostLabel.setBounds(199, 612, 48, 26);
		contentPane.add(droneMixingEquipmentCostLabel);
		
		JLabel lblOtherCropSpraying = new JLabel("Other Crop Spraying Techniques Cost");
		lblOtherCropSpraying.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtherCropSpraying.setBounds(415, 11, 237, 14);
		contentPane.add(lblOtherCropSpraying);
		
		JTextArea txtrPlanePilot = new JTextArea();
		txtrPlanePilot.setText("Plane + Pilot Cost");
		txtrPlanePilot.setLineWrap(true);
		txtrPlanePilot.setBounds(388, 36, 140, 22);
		contentPane.add(txtrPlanePilot);
		
		JSlider otherEquipment = new JSlider();
		otherEquipment.setValue(20000);
		otherEquipment.setMinorTickSpacing(1000);
		otherEquipment.setMinimum(10000);
		otherEquipment.setMaximum(40000);
		otherEquipment.setMajorTickSpacing(1000);
		otherEquipment.setBounds(538, 36, 140, 26);
		otherEquipment.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = otherEquipment.getValue();
				//analysis.setEmployeeTrainingCosts(value);
				otherEquipmentCostLabel.setText("$" + value);
			}
		});
		contentPane.add(otherEquipment);
		
		otherEquipmentCostLabel = new JLabel("$20000");
		otherEquipmentCostLabel.setBounds(388, 56, 48, 14);
		contentPane.add(otherEquipmentCostLabel);
		
		JTextArea NumberOfHours = new JTextArea();
		NumberOfHours.setText("Number of Hours Flight");
		NumberOfHours.setLineWrap(true);
		NumberOfHours.setBounds(388, 83, 140, 22);
		contentPane.add(NumberOfHours);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(538, 85, 96, 20);
		contentPane.add(textField_1);
		
		JTextArea PioltTrainingCosts = new JTextArea();
		PioltTrainingCosts.setText("Employee Training Costs");
		PioltTrainingCosts.setLineWrap(true);
		PioltTrainingCosts.setBounds(388, 116, 140, 22);
		contentPane.add(PioltTrainingCosts);
		
		JSlider employeeTrainingSlider_1 = new JSlider();
		employeeTrainingSlider_1.setValue(0);
		employeeTrainingSlider_1.setMinorTickSpacing(500);
		employeeTrainingSlider_1.setMaximum(10000);
		employeeTrainingSlider_1.setMajorTickSpacing(500);
		employeeTrainingSlider_1.setBounds(538, 116, 140, 26);
		contentPane.add(employeeTrainingSlider_1);
		
		JLabel employeeTrainingCostLabel_1 = new JLabel("$2500");
		employeeTrainingCostLabel_1.setBounds(388, 138, 48, 14);
		contentPane.add(employeeTrainingCostLabel_1);
		
		JTextArea RepairAndUpgrades = new JTextArea();
		RepairAndUpgrades.setText("Repair and Upgrade Costs");
		RepairAndUpgrades.setLineWrap(true);
		RepairAndUpgrades.setBounds(388, 166, 140, 22);
		contentPane.add(RepairAndUpgrades);
		
		JLabel repairAndUpgradeCostLabel_1 = new JLabel("$2500");
		repairAndUpgradeCostLabel_1.setBounds(388, 188, 48, 14);
		contentPane.add(repairAndUpgradeCostLabel_1);
		
		JSlider employeeTrainingSlider_1_1 = new JSlider();
		employeeTrainingSlider_1_1.setValue(0);
		employeeTrainingSlider_1_1.setMinorTickSpacing(500);
		employeeTrainingSlider_1_1.setMaximum(10000);
		employeeTrainingSlider_1_1.setMajorTickSpacing(500);
		employeeTrainingSlider_1_1.setBounds(538, 166, 140, 26);
		contentPane.add(employeeTrainingSlider_1_1);
		
		JButton btnTotalCropDuster = new JButton("TOTAL Crop Duster Cost");
		btnTotalCropDuster.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTotalCropDuster.setBounds(355, 212, 226, 26);
		contentPane.add(btnTotalCropDuster);
		
		JLabel totalCropDusterCost = new JLabel("$2500");
		totalCropDusterCost.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalCropDusterCost.setBounds(598, 212, 102, 26);
		contentPane.add(totalCropDusterCost);
		
		JTextArea GroundSprayer = new JTextArea();
		GroundSprayer.setText("Ground Spraier Cost");
		GroundSprayer.setLineWrap(true);
		GroundSprayer.setBounds(388, 264, 140, 22);
		contentPane.add(GroundSprayer);
		
		JSlider otherEquipment_1 = new JSlider();
		otherEquipment_1.setValue(20000);
		otherEquipment_1.setMinorTickSpacing(1000);
		otherEquipment_1.setMinimum(10000);
		otherEquipment_1.setMaximum(40000);
		otherEquipment_1.setMajorTickSpacing(1000);
		otherEquipment_1.setBounds(538, 264, 140, 26);
		contentPane.add(otherEquipment_1);
		
		JLabel otherEquipmentCostLabel_1 = new JLabel("$20000");
		otherEquipmentCostLabel_1.setBounds(388, 288, 48, 14);
		contentPane.add(otherEquipmentCostLabel_1);
		
		JTextArea NumberOfHours_1 = new JTextArea();
		NumberOfHours_1.setText("Number of Hours Flight");
		NumberOfHours_1.setLineWrap(true);
		NumberOfHours_1.setBounds(388, 314, 140, 22);
		contentPane.add(NumberOfHours_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(538, 316, 96, 20);
		contentPane.add(textField_2);
		
		JTextArea txtrNumberOfEmployees_1 = new JTextArea();
		txtrNumberOfEmployees_1.setText("Number of Employees");
		txtrNumberOfEmployees_1.setLineWrap(true);
		txtrNumberOfEmployees_1.setBounds(388, 350, 140, 22);
		contentPane.add(txtrNumberOfEmployees_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(538, 347, 96, 20);
		contentPane.add(textField_3);
		
		JTextArea txtrEmployeeTrainingCosts_1 = new JTextArea();
		txtrEmployeeTrainingCosts_1.setText("Employee Training Costs");
		txtrEmployeeTrainingCosts_1.setLineWrap(true);
		txtrEmployeeTrainingCosts_1.setBounds(388, 379, 140, 22);
		contentPane.add(txtrEmployeeTrainingCosts_1);
		
		JSlider employeeTrainingSlider_2 = new JSlider();
		employeeTrainingSlider_2.setValue(0);
		employeeTrainingSlider_2.setMinorTickSpacing(500);
		employeeTrainingSlider_2.setMaximum(10000);
		employeeTrainingSlider_2.setMajorTickSpacing(500);
		employeeTrainingSlider_2.setBounds(538, 375, 140, 26);
		contentPane.add(employeeTrainingSlider_2);
		
		JLabel employeeTrainingCostLabel_2 = new JLabel("$2500");
		employeeTrainingCostLabel_2.setBounds(388, 408, 48, 14);
		contentPane.add(employeeTrainingCostLabel_2);
		
		JTextArea txtrRepairAndUpgrade_1 = new JTextArea();
		txtrRepairAndUpgrade_1.setText("Repair and Upgrade Costs");
		txtrRepairAndUpgrade_1.setLineWrap(true);
		txtrRepairAndUpgrade_1.setBounds(388, 425, 140, 22);
		contentPane.add(txtrRepairAndUpgrade_1);
		
		JSlider repairAndUpgradeSlider_1 = new JSlider();
		repairAndUpgradeSlider_1.setValue(0);
		repairAndUpgradeSlider_1.setMinorTickSpacing(500);
		repairAndUpgradeSlider_1.setMaximum(10000);
		repairAndUpgradeSlider_1.setMajorTickSpacing(500);
		repairAndUpgradeSlider_1.setBounds(538, 424, 140, 26);
		contentPane.add(repairAndUpgradeSlider_1);
		
		JLabel repairAndUpgradeCostLabel_2 = new JLabel("$2500");
		repairAndUpgradeCostLabel_2.setBounds(388, 446, 48, 14);
		contentPane.add(repairAndUpgradeCostLabel_2);
		
		JButton btnTotalGroundSprayer = new JButton("TOTAL Group Spraier Cost");
		btnTotalGroundSprayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTotalGroundSprayer.setBounds(355, 463, 226, 26);
		contentPane.add(btnTotalGroundSprayer);
		
		JLabel totalEmployeeAndEquipment_2 = new JLabel("$2500");
		totalEmployeeAndEquipment_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment_2.setBounds(591, 467, 102, 26);
		contentPane.add(totalEmployeeAndEquipment_2);
		
		JLabel totalEmployeeAndEquipment_1_1 = new JLabel("Days able to fly: 10");
		totalEmployeeAndEquipment_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment_1_1.setBounds(10, 971, 182, 26);
		contentPane.add(totalEmployeeAndEquipment_1_1);
		
		JLabel lblDroneEnergyCosts = new JLabel("Drone Energy Costs");
		lblDroneEnergyCosts.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDroneEnergyCosts.setBounds(10, 764, 237, 14);
		contentPane.add(lblDroneEnergyCosts);
		
		JTextArea droneCostOfSpray = new JTextArea();
		droneCostOfSpray.setText("Cost of Spray");
		droneCostOfSpray.setLineWrap(true);
		droneCostOfSpray.setBounds(10, 483, 140, 26);
		contentPane.add(droneCostOfSpray);
		
		JTextArea droneChargeTimesTextArea = new JTextArea();
		droneChargeTimesTextArea.setText("Number of Battery Charges");
		droneChargeTimesTextArea.setLineWrap(true);
		droneChargeTimesTextArea.setBounds(10, 888, 140, 22);
		contentPane.add(droneChargeTimesTextArea);
		
		droneChargeTimesTextField = new JTextField();
		droneChargeTimesTextField.setColumns(10);
		droneChargeTimesTextField.setBounds(171, 892, 96, 20);
		contentPane.add(droneChargeTimesTextField);
		
		JSlider droneCostSpray = new JSlider();
		droneCostSpray.setValue(20000);
		droneCostSpray.setMinorTickSpacing(5);
		droneCostSpray.setMaximum(500);
		droneCostSpray.setMajorTickSpacing(5);
		droneCostSpray.setBounds(160, 483, 140, 26);
		contentPane.add(droneCostSpray);
		
		JTextArea droneRequireMixing = new JTextArea();
		droneRequireMixing.setText("Requires Mixing?");
		droneRequireMixing.setLineWrap(true);
		droneRequireMixing.setBounds(10, 520, 140, 26);
		contentPane.add(droneRequireMixing);
		
		JCheckBox droneRequireMixChckbx = new JCheckBox("Yes");
		droneRequireMixChckbx.setBounds(170, 521, 97, 23);
		contentPane.add(droneRequireMixChckbx);
		
		JTextArea droneTankSizeTextArea = new JTextArea();
		droneTankSizeTextArea.setText("Tank Size");
		droneTankSizeTextArea.setLineWrap(true);
		droneTankSizeTextArea.setBounds(10, 664, 140, 26);
		contentPane.add(droneTankSizeTextArea);
		
		JSlider droneTankSizeSlider = new JSlider();
		droneTankSizeSlider.setValue(20000);
		droneTankSizeSlider.setMinorTickSpacing(1);
		droneTankSizeSlider.setMaximum(50);
		droneTankSizeSlider.setMajorTickSpacing(1);
		droneTankSizeSlider.setBounds(160, 661, 140, 26);
		contentPane.add(droneTankSizeSlider);
		
		JLabel droneWeightOutput = new JLabel("Drone Weight: 55lbs");
		droneWeightOutput.setFont(new Font("Tahoma", Font.BOLD, 11));
		droneWeightOutput.setBounds(10, 992, 182, 26);
		contentPane.add(droneWeightOutput);
		
		JTextArea droneCostEquipmentMixingTextArea = new JTextArea();
		droneCostEquipmentMixingTextArea.setText("Equipment Mixing Cost");
		droneCostEquipmentMixingTextArea.setLineWrap(true);
		droneCostEquipmentMixingTextArea.setBounds(51, 557, 140, 26);
		contentPane.add(droneCostEquipmentMixingTextArea);
		
		JSlider droneCostEquipmentMixingSlider = new JSlider();
		droneCostEquipmentMixingSlider.setValue(20000);
		droneCostEquipmentMixingSlider.setMinorTickSpacing(500);
		droneCostEquipmentMixingSlider.setMaximum(50000);
		droneCostEquipmentMixingSlider.setMajorTickSpacing(1000);
		droneCostEquipmentMixingSlider.setBounds(201, 551, 140, 26);
		droneCostEquipmentMixingSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = droneCostEquipmentMixingSlider.getValue();
				//analysis.setEmployeeTrainingCosts(value);
				droneCostEquipmentMixingLabel.setText("$" + value);
			}
		});
		contentPane.add(droneCostEquipmentMixingSlider);
		
		droneCostEquipmentMixingLabel = new JLabel("$2500");
		droneCostEquipmentMixingLabel.setBounds(341, 551, 48, 26);
		contentPane.add(droneCostEquipmentMixingLabel);
		
		JTextArea droneCostWaterMixingTextArea = new JTextArea();
		droneCostWaterMixingTextArea.setText("Water Mixing Cost");
		droneCostWaterMixingTextArea.setLineWrap(true);
		droneCostWaterMixingTextArea.setBounds(51, 589, 140, 26);
		contentPane.add(droneCostWaterMixingTextArea);
		
		JSlider droneCostWaterMixingSlider = new JSlider();
		droneCostWaterMixingSlider.setValue(20000);
		droneCostWaterMixingSlider.setMinorTickSpacing(500);
		droneCostWaterMixingSlider.setMaximum(50000);
		droneCostWaterMixingSlider.setMajorTickSpacing(1000);
		droneCostWaterMixingSlider.setBounds(201, 590, 140, 26);
		droneCostWaterMixingSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = droneCostWaterMixingSlider.getValue();
				//analysis.setEmployeeTrainingCosts(value);
				droneCostWaterMixingLabel.setText("$" + value);
			}
		});
		contentPane.add(droneCostWaterMixingSlider);
		
		droneCostWaterMixingLabel = new JLabel("$2500");
		droneCostWaterMixingLabel.setBounds(341, 588, 48, 26);
		contentPane.add(droneCostWaterMixingLabel);
		
		JLabel totalEmployeeAndEquipment_1_2 = new JLabel("$2500");
		totalEmployeeAndEquipment_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment_1_2.setBounds(246, 971, 102, 26);
		contentPane.add(totalEmployeeAndEquipment_1_2);
		
		JTextArea droneMixingTimeTextArea = new JTextArea();
		droneMixingTimeTextArea.setText("Mixing Time");
		droneMixingTimeTextArea.setLineWrap(true);
		droneMixingTimeTextArea.setBounds(51, 624, 140, 26);
		contentPane.add(droneMixingTimeTextArea);
		
		JSlider droneMixingTimeSlider = new JSlider();
		droneMixingTimeSlider.setValue(20000);
		droneMixingTimeSlider.setMinorTickSpacing(500);
		droneMixingTimeSlider.setMaximum(120);
		droneMixingTimeSlider.setMajorTickSpacing(1000);
		droneMixingTimeSlider.setBounds(201, 627, 140, 26);
		droneMixingTimeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int value = droneMixingTimeSlider.getValue();
				//analysis.setEmployeeTrainingCosts(value);
				droneMixingTimeLabel.setText(value + " mins");
			}
		});
		contentPane.add(droneMixingTimeSlider);
		
		droneMixingTimeLabel = new JLabel("120 mins ");
		droneMixingTimeLabel.setBounds(341, 625, 71, 26);
		contentPane.add(droneMixingTimeLabel);
		
		JTextArea droneCostPerWattTextArea = new JTextArea();
		droneCostPerWattTextArea.setText("Cost Per Kilowatt hour");
		droneCostPerWattTextArea.setLineWrap(true);
		droneCostPerWattTextArea.setBounds(10, 855, 140, 22);
		contentPane.add(droneCostPerWattTextArea);
		
		droneCostPerWattTextField = new JTextField();
		droneCostPerWattTextField.setColumns(10);
		droneCostPerWattTextField.setBounds(171, 859, 96, 20);
		contentPane.add(droneCostPerWattTextField);
		
	}
}
