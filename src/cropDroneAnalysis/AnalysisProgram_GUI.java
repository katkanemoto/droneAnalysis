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

public class AnalysisProgram_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel droneEquipmentCostLabel;
	private JLabel employeeTrainingCostLabel;
	private JLabel employeeBenefitsCostLabel;
	private JLabel repairAndUpgradeCostLabel;
	private JLabel totalEmployeeAndEquipment;
	private JTextField numOfEmployeesTextField;
	private JTextField numOfYearsUsedTextField;
	private AnalysisProgram analysis;

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
		setBounds(100, 100, 673, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Drone");
		lblNewLabel.setBounds(87, 11, 48, 14);
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
		txtrEmployeeTrainingCosts.setBounds(10, 147, 140, 22);
		contentPane.add(txtrEmployeeTrainingCosts);

		employeeTrainingCostLabel = new JLabel("$2500");
		employeeTrainingCostLabel.setBounds(10, 169, 48, 14);
		contentPane.add(employeeTrainingCostLabel);

		JSlider employeeTrainingSlider = new JSlider();
		employeeTrainingSlider.setValue(0);
		employeeTrainingSlider.setMinorTickSpacing(500);
		employeeTrainingSlider.setMaximum(10000);
		employeeTrainingSlider.setMajorTickSpacing(500);
		employeeTrainingSlider.setBounds(173, 143, 140, 26);
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
		txtEmployeeBenefits.setBounds(10, 194, 140, 26);
		contentPane.add(txtEmployeeBenefits);

		JSlider employeeBenefitsSlider = new JSlider();
		employeeBenefitsSlider.setValue(0);
		employeeBenefitsSlider.setMinorTickSpacing(500);
		employeeBenefitsSlider.setMaximum(10000);
		employeeBenefitsSlider.setMajorTickSpacing(500);
		employeeBenefitsSlider.setBounds(173, 194, 140, 26);
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
		txtrRepairAndUpgrade.setBounds(10, 248, 140, 22);
		contentPane.add(txtrRepairAndUpgrade);

		repairAndUpgradeCostLabel = new JLabel("$2500");
		repairAndUpgradeCostLabel.setBounds(10, 272, 48, 14);
		contentPane.add(repairAndUpgradeCostLabel);

		JSlider repairAndUpgradeSlider = new JSlider();
		repairAndUpgradeSlider.setValue(0);
		repairAndUpgradeSlider.setMinorTickSpacing(500);
		repairAndUpgradeSlider.setMaximum(10000);
		repairAndUpgradeSlider.setMajorTickSpacing(500);
		repairAndUpgradeSlider.setBounds(173, 248, 140, 26);
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
		txtrNumberOfEmployees.setBounds(10, 114, 140, 22);
		contentPane.add(txtrNumberOfEmployees);

		numOfEmployeesTextField = new JTextField();
		numOfEmployeesTextField.setBounds(171, 112, 96, 20);
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
		employeeBenefitsCostLabel.setBounds(10, 220, 48, 14);
		contentPane.add(employeeBenefitsCostLabel);

		JTextArea txtrNumberOfYears = new JTextArea();
		txtrNumberOfYears.setText("Number of Years used");
		txtrNumberOfYears.setLineWrap(true);
		txtrNumberOfYears.setBounds(10, 81, 140, 22);
		contentPane.add(txtrNumberOfYears);

		numOfYearsUsedTextField = new JTextField();
		numOfYearsUsedTextField.setColumns(10);
		numOfYearsUsedTextField.setBounds(171, 81, 96, 20);
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
		totalEmployeeAndEquipment.setBounds(246, 303, 102, 26);
		contentPane.add(totalEmployeeAndEquipment);

		JButton btnTotalEmployeesAnd = new JButton("TOTAL Employee(s) and Equipment");
		btnTotalEmployeesAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//calculate the employee and equipment costs based on user input
				double costs = analysis.calculateEmployeeAndEquipmentCosts();
				totalEmployeeAndEquipment.setText("$" + costs);	
			}
		});
		btnTotalEmployeesAnd.setBounds(10, 297, 226, 38);
		contentPane.add(btnTotalEmployeesAnd);
	}
}
