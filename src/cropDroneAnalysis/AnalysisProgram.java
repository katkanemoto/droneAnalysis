/**************************************************\
 * Crop Drone Analysis
 * 
 * write intro stuff here
 * 
 * 
 * last updated 8.4.2021
 \*************************************************/

package cropDroneAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AnalysisProgram {

	//data variables
	private double droneEquipmentCosts = 20000;
	private int numOfYearsUsed = 1;
	private double employeeTrainingCosts = 0;
	private double employeeBenefitsCosts = 0;
	private double repairAndUpgradeCosts = 0;
	private double numOfEmployees = 1;
	
	//reading in the weather data
	//**change these names to the files you are using
	private static ArrayList<Record> weatherData = new ArrayList<Record>();
	private static String mesoWestData = "KMOD.csv";
	private static String outputFile = "2020_modesto.csv";

	public static void main(String[] args) {
		//write some test output to test the methods

	}

	//methods for calculations
	//Megan - method on calculating the energy used for a drone


	//Angelica - method for finding a beginning date, and ending date,
	//how many hours one could fly within those 2 dates - meets all the criteria 
	//for flying
	

	//method to read in the weather csv file, and load it into an
	public static void readInWeatherData()  {
		Scanner input = null;
		try {
			input = new Scanner(new File(mesoWestData)); //looks for file losBanosData2
		} catch (FileNotFoundException e) {
			System.out.println("file not found"); //if file not found then it is caught and 'file not found' prints
			e.printStackTrace();
		}
		
		PrintWriter output = null;
		try {
			output = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//to read in the 8 header lines of the text file
		int count = 0;
		while(count++ < 8) {
			input.nextLine();
			//count++;
		}

		while(input.hasNext())  {
			String line = input.nextLine();
			System.out.println(line);
			String[] fields = line.split(",");
			//public Record(String station, String date, double temp, double humidity, double windSpeed, double windDirection,
			//				String recordAsString) {
			//if(fields.length < 6)
			weatherData.add(new Record(fields[0], 
					fields[1],
					Double.parseDouble(fields[2]),
					Double.parseDouble(fields[3]),
					Double.parseDouble(fields[4]),
					Double.parseDouble(fields[5]),
					line));
		}//end while
	}
	
	public double getDroneEquipmentCosts() {
		return droneEquipmentCosts;
	}

	public void setDroneEquipmentCosts(double droneEquipmentCosts) {
		this.droneEquipmentCosts = droneEquipmentCosts;
	}

	public double getEmployeeTrainingCosts() {
		return employeeTrainingCosts;
	}

	public void setEmployeeTrainingCosts(double employeeTrainingCosts) {
		this.employeeTrainingCosts = employeeTrainingCosts;
	}

	public double getEmployeeBenefitsCosts() {
		return employeeBenefitsCosts;
	}

	public void setEmployeeBenefitsCosts(double employeeBenefitsCosts) {
		this.employeeBenefitsCosts = employeeBenefitsCosts;
	}

	public double getRepairAndUpgradeCosts() {
		return repairAndUpgradeCosts;
	}

	public void setRepairAndUpgradeCosts(double repairAndUpgradeCosts) {
		this.repairAndUpgradeCosts = repairAndUpgradeCosts;
	}

	public double getNumOfEmployees() {
		return numOfEmployees;
	}

	public void setNumOfEmployees(double numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}

	public void setNumOfYearsUsed(int numYears) {
		this.numOfYearsUsed = numYears;	
	}

	public double calculateEmployeeAndEquipmentCosts() {
		// fixed costs = technology equipment costs  / num of years you are using it + employee training costs + employee benefits costs + technology upgrading and repair costs
		return droneEquipmentCosts/numOfYearsUsed + (employeeTrainingCosts + employeeBenefitsCosts)*numOfEmployees + repairAndUpgradeCosts;
	}
	
 
}
