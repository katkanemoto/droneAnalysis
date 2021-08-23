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
	private JLabel droneMixingEquipmentCostLabel;
	private JTextField numOfEmployeesTextField;
	private JTextField numOfYearsUsedTextField;
	private AnalysisProgram analysis;
	private JTextField numOfDronesUsedTextField;
	private JTextField droneBegDateTextField;
	private JTextField droneEndDateTextField;
	private JTextField textField;

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
		
		
	}
}
