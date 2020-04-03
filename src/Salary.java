import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

public class Salary {

	public static void main(String args[]) {

		System.out.println("Enter the choice u want : ");
		System.out.println("1. Create New Salary Document /n 2. Edit Existing Salary Document");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		operateAsPerChoiceSelected(choice);
		scanner.close();

	}

	private static void operateAsPerChoiceSelected(int choice) {

		if (choice == 1) {
			createNewSalaryDocument();
		} else if (choice == 2) {
			editExistingSalaryDocument();
		} else {
			System.out.println("Please Select from the choices given above");
		}
	}

	private static void createNewSalaryDocument() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Year to create Salary Document");

		String year = scanner.nextLine();

		System.out.println("Enter Month to create Salary Document");

		String month = scanner.nextLine();

		System.out.println("You are creating Salary Document for " + month + " " + year);
		createSheetWithGivenDate(month, year);
		scanner.close();

	}

	private static void createSheetWithGivenDate(String month, String year) {

		ArrayList<EmployeeModel> enteredEmployees = getEmployeeDetails();
		int rowNum = 0;
		int column = 0;
		try {

			String filename = "C:/Users/Desktop/" + year + " - Salaries" + ".xls";
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(month + "-" + year);

			Row titleRow = sheet.createRow(rowNum);
			Cell titleCell = titleRow.createCell(column);
			titleCell.setCellValue("Salaries for the month of" + month + " " + year);

			rowNum = rowNum + 1;
			Row headingRow = sheet.createRow(rowNum);

			// column = column + 1;

			Cell slNoHeadingCell = headingRow.createCell(column);
			slNoHeadingCell.setCellValue("SL No");

			column = column + 1;

			Cell nameHeadingCell = headingRow.createCell(column);
			nameHeadingCell.setCellValue("Name of the Employee");

			column = column + 1;

			Cell designationHeadingCell = headingRow.createCell(column);
			designationHeadingCell.setCellValue("Designation");

			column = column + 1;

			Cell salaryHeadingCell = headingRow.createCell(column);
			salaryHeadingCell.setCellValue("Salary");

			column = column + 1;

			Cell allowanceHeadingCell = headingRow.createCell(column);
			allowanceHeadingCell.setCellValue("Allowances");

			column = column + 1;

			Cell deductionHeadingCell = headingRow.createCell(column);
			deductionHeadingCell.setCellValue("Deductions");

			column = column + 1;

			Cell netPayableHeadingCell = headingRow.createCell(column);
			netPayableHeadingCell.setCellValue("Net Payable");

			column = column + 1;

			Cell paidHeadingCell = headingRow.createCell(column);
			paidHeadingCell.setCellValue("Paid");

			column = column + 1;

			Cell remarksHeadingCell = headingRow.createCell(column);
			remarksHeadingCell.setCellValue("Remarks");

			column = column + 1;
			rowNum = rowNum + 1;

			enterValuesToSheet(sheet, enteredEmployees);

			File file = new File(filename);
			if (!file.exists()) {
				FileOutputStream fileOut = new FileOutputStream(filename);
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
				System.out.println("Your excel file has been generated!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void enterValuesToSheet(HSSFSheet sheet, ArrayList<EmployeeModel> enteredEmployees) {
		int i = 1;
		int rowNum = 2;
		int column = 0;
		for (EmployeeModel employeeModel : enteredEmployees) {

			Row employeeRow = sheet.createRow(rowNum);
			Cell slNoCell = employeeRow.createCell(column);
			slNoCell.setCellValue(i);

			column = column + 1;

			Cell nameCell = employeeRow.createCell(column);
			nameCell.setCellValue(employeeModel.getEmpName());

			column = column + 1;

			Cell designationCell = employeeRow.createCell(column);
			designationCell.setCellValue(employeeModel.getDesignation());

			column = column + 1;

			Cell salaryCell = employeeRow.createCell(column);
			salaryCell.setCellValue(employeeModel.getSalary());

			column = column + 1;

			Cell allowanceCell = employeeRow.createCell(column);
			allowanceCell.setCellValue(employeeModel.getAllowance());

			column = column + 1;

			Cell deductionCell = employeeRow.createCell(column);
			deductionCell.setCellValue(employeeModel.getDeductions());

			column = column + 1;

			Cell netPayableCell = employeeRow.createCell(column);
			netPayableCell.setCellValue(employeeModel.getNetPayable());

			column = column + 1;

			Cell paidCell = employeeRow.createCell(column);
			paidCell.setCellValue(employeeModel.getPaid());

			column = column + 1;

			Cell remarksCell = employeeRow.createCell(column);
			remarksCell.setCellValue(employeeModel.getRemarks());
			rowNum++;
			i++;
		}

	}

	private static ArrayList<EmployeeModel> getEmployeeDetails() {
		ArrayList<EmployeeModel> employees = new ArrayList();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter no of employees:");
		int noOfEmployees = scanner.nextInt();

		for (int i = 0; i < noOfEmployees; i++) {

			System.out.println("Enter Employee Name:");
			String employeeName = scanner.nextLine();

			System.out.println("Enter Employee Designation:");
			String designation = scanner.nextLine();

			System.out.println("Enter Base Salary:");
			float salary = scanner.nextFloat();

			System.out.println("Enter Allowance:");
			float allowance = scanner.nextFloat();

			System.out.println("Enter Deductions:");
			float deductions = scanner.nextFloat();

			System.out.println("Enter Net Payable:");
			float netPayable = scanner.nextFloat();

			System.out.println("Enter Paid:");
			float paid = scanner.nextFloat();

//			System.out.println("Enter Remarks:");
//			String remarks = scanner.nextLine();

			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel.setEmpName(employeeName);
			employeeModel.setDesignation(designation);
			employeeModel.setSalary(salary);
			employeeModel.setAllowance(allowance);
			employeeModel.setDeductions(deductions);
			employeeModel.setNetPayable(netPayable);
			employeeModel.setPaid(paid);
			//employeeModel.setRemarks(remarks);

			employees.add(employeeModel);
		}
		scanner.close();

		return employees;

	}

	private static void editExistingSalaryDocument() {

	}

}
