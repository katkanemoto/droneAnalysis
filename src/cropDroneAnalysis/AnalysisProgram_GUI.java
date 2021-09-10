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
	private JLabel droneCostEquipmentMixingLabel;
	private JLabel droneCostWaterMixingLabel;
	private JLabel droneMixingTimeLabel;
	private JTextField numOfEmployeesTextField;
	private JTextField numOfYearsUsedTextField;
	private AnalysisProgram analysis;
	private JTextField numOfDronesUsedTextField;
	private JTextField droneBegDateTextField;
	private JTextField droneEndDateTextField;
	private JTextField droneChargeTimesTextField;
	private JTextField droneCostPerWattTextField;

	/**
	 * Launch the application.
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
		droneEquipmentCostLabel.setBounds(319, 36, 48, 14);
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
		employeeTrainingCostLabel.setBounds(319, 166, 48, 14);
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
		txtEmployeeBenefits.setBounds(10, 199, 140, 26);
		contentPane.add(txtEmployeeBenefits);

		JSlider employeeBenefitsSlider = new JSlider();
		employeeBenefitsSlider.setValue(0);
		employeeBenefitsSlider.setMinorTickSpacing(500);
		employeeBenefitsSlider.setMaximum(10000);
		employeeBenefitsSlider.setMajorTickSpacing(500);
		employeeBenefitsSlider.setBounds(173, 199, 140, 26);
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
		txtrRepairAndUpgrade.setBounds(10, 236, 140, 22);
		contentPane.add(txtrRepairAndUpgrade);

		repairAndUpgradeCostLabel = new JLabel("$2500");
		repairAndUpgradeCostLabel.setBounds(323, 241, 48, 14);
		contentPane.add(repairAndUpgradeCostLabel);

		JSlider repairAndUpgradeSlider = new JSlider();
		repairAndUpgradeSlider.setValue(0);
		repairAndUpgradeSlider.setMinorTickSpacing(500);
		repairAndUpgradeSlider.setMaximum(10000);
		repairAndUpgradeSlider.setMajorTickSpacing(500);
		repairAndUpgradeSlider.setBounds(173, 236, 140, 26);
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
		employeeBenefitsCostLabel.setBounds(319, 204, 48, 14);
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
		totalEmployeeAndEquipment.setBounds(246, 269, 102, 26);
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
		btnTotalEmployeesAnd.setBounds(10, 269, 226, 26);
		contentPane.add(btnTotalEmployeesAnd);
		
		JTextArea setUpTimeTextArea = new JTextArea();
		setUpTimeTextArea.setText("Set Up Time");
		setUpTimeTextArea.setLineWrap(true);
		setUpTimeTextArea.setBounds(10, 331, 140, 22);
		contentPane.add(setUpTimeTextArea);
		
		JTextArea chargingTimeTextArea = new JTextArea();
		chargingTimeTextArea.setText("Charging Time");
		chargingTimeTextArea.setLineWrap(true);
		chargingTimeTextArea.setBounds(10, 364, 140, 22);
		contentPane.add(chargingTimeTextArea);
		
		JTextArea areaToSprayAcres = new JTextArea();
		areaToSprayAcres.setText("Acres To Spray ");
		areaToSprayAcres.setLineWrap(true);
		areaToSprayAcres.setBounds(10, 397, 140, 26);
		contentPane.add(areaToSprayAcres);
		
		JTextArea amountToSprayPerAcre = new JTextArea();
		amountToSprayPerAcre.setText("Amount To Spray Per Acre");
		amountToSprayPerAcre.setLineWrap(true);
		amountToSprayPerAcre.setBounds(10, 434, 140, 38);
		contentPane.add(amountToSprayPerAcre);
		
		JTextArea beginngDateTextArea = new JTextArea();
		beginngDateTextArea.setText("Beginning Date");
		beginngDateTextArea.setLineWrap(true);
		beginngDateTextArea.setBounds(10, 698, 140, 22);
		contentPane.add(beginngDateTextArea);
		
		JTextArea endingDateTextArea = new JTextArea();
		endingDateTextArea.setText("EndingDate");
		endingDateTextArea.setLineWrap(true);
		endingDateTextArea.setBounds(10, 731, 140, 22);
		contentPane.add(endingDateTextArea);
		
		JLabel lblDroneEquipmentSpraying = new JLabel("Drone Spraying Costs");
		lblDroneEquipmentSpraying.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDroneEquipmentSpraying.setBounds(10, 306, 237, 14);
		contentPane.add(lblDroneEquipmentSpraying);
		
		JTextArea droneBatteryChargeTimeTextArea = new JTextArea();
		droneBatteryChargeTimeTextArea.setText("Battery Charge Time");
		droneBatteryChargeTimeTextArea.setLineWrap(true);
		droneBatteryChargeTimeTextArea.setBounds(10, 789, 140, 22);
		contentPane.add(droneBatteryChargeTimeTextArea);
		
		JTextArea droneBatteryLifeTextArea = new JTextArea();
		droneBatteryLifeTextArea.setText("Battery Life");
		droneBatteryLifeTextArea.setLineWrap(true);
		droneBatteryLifeTextArea.setBounds(10, 822, 140, 22);
		contentPane.add(droneBatteryLifeTextArea);
		
		JTextArea txtrNumberOfDrones = new JTextArea();
		txtrNumberOfDrones.setText("Number of Drones used");
		txtrNumberOfDrones.setLineWrap(true);
		txtrNumberOfDrones.setBounds(10, 67, 140, 22);
		contentPane.add(txtrNumberOfDrones);
		
		numOfDronesUsedTextField = new JTextField();
		numOfDronesUsedTextField.setColumns(10);
		numOfDronesUsedTextField.setBounds(173, 69, 96, 20);
		contentPane.add(numOfDronesUsedTextField);
		
		JSlider droneSetUpTime = new JSlider();
		droneSetUpTime.setValue(20000);
		droneSetUpTime.setMinorTickSpacing(5);
		droneSetUpTime.setMinimum(20);
		droneSetUpTime.setMaximum(300);
		droneSetUpTime.setMajorTickSpacing(5);
		droneSetUpTime.setBounds(160, 331, 140, 26);
		contentPane.add(droneSetUpTime);
		
		JSlider droneChargeTime = new JSlider();
		droneChargeTime.setValue(20000);
		droneChargeTime.setMinorTickSpacing(5);
		droneChargeTime.setMinimum(20);
		droneChargeTime.setMaximum(300);
		droneChargeTime.setMajorTickSpacing(5);
		droneChargeTime.setBounds(160, 364, 140, 26);
		contentPane.add(droneChargeTime);
		
		JSlider droneAcresToSpray = new JSlider();
		droneAcresToSpray.setValue(20000);
		droneAcresToSpray.setMinorTickSpacing(5);
		droneAcresToSpray.setMaximum(500);
		droneAcresToSpray.setMajorTickSpacing(5);
		droneAcresToSpray.setBounds(160, 397, 140, 26);
		contentPane.add(droneAcresToSpray);
		
		JSlider droneAmountToSpray = new JSlider();
		droneAmountToSpray.setValue(20000);
		droneAmountToSpray.setMinorTickSpacing(5);
		droneAmountToSpray.setMaximum(500);
		droneAmountToSpray.setMajorTickSpacing(5);
		droneAmountToSpray.setBounds(160, 434, 140, 26);
		contentPane.add(droneAmountToSpray);
		
		JSlider droneBatteryChargeTimeSlider = new JSlider();
		droneBatteryChargeTimeSlider.setValue(20000);
		droneBatteryChargeTimeSlider.setMinorTickSpacing(5);
		droneBatteryChargeTimeSlider.setMaximum(500);
		droneBatteryChargeTimeSlider.setMajorTickSpacing(5);
		droneBatteryChargeTimeSlider.setBounds(160, 789, 140, 26);
		contentPane.add(droneBatteryChargeTimeSlider);
		
		JSlider droneBatteryLifeTimeSlider = new JSlider();
		droneBatteryLifeTimeSlider.setValue(20000);
		droneBatteryLifeTimeSlider.setMinorTickSpacing(5);
		droneBatteryLifeTimeSlider.setMaximum(500);
		droneBatteryLifeTimeSlider.setMajorTickSpacing(5);
		droneBatteryLifeTimeSlider.setBounds(160, 822, 140, 26);
		contentPane.add(droneBatteryLifeTimeSlider);
		
		droneBegDateTextField = new JTextField();
		droneBegDateTextField.setColumns(10);
		droneBegDateTextField.setBounds(171, 700, 96, 20);
		contentPane.add(droneBegDateTextField);
		
		droneEndDateTextField = new JTextField();
		droneEndDateTextField.setColumns(10);
		droneEndDateTextField.setBounds(171, 733, 96, 20);
		contentPane.add(droneEndDateTextField);
		
		JButton btnTotalDroneSprayingCosts = new JButton("TOTAL Drone Spraying Costs");
		btnTotalDroneSprayingCosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTotalDroneSprayingCosts.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTotalDroneSprayingCosts.setBounds(10, 955, 219, 26);
		contentPane.add(btnTotalDroneSprayingCosts);
		
		JLabel totalEmployeeAndEquipment_1 = new JLabel("$2500");
		totalEmployeeAndEquipment_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalEmployeeAndEquipment_1.setBounds(246, 955, 102, 26);
		contentPane.add(totalEmployeeAndEquipment_1);
		
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
