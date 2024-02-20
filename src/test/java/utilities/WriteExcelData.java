package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {
	public static XSSFWorkbook workbook = new XSSFWorkbook();
	public static XSSFSheet bikesheet = workbook.createSheet("BikeDetails");
	public static XSSFRow headerRow1 = bikesheet.createRow(0);

	public static XSSFSheet carsheet = workbook.createSheet("PopularCarModels");
	public static XSSFRow headerRow2 = carsheet.createRow(0);

	public static XSSFSheet carSheet = workbook.createSheet("CarDetails");
	public static XSSFRow headerRow3 = carSheet.createRow(0);

	public static XSSFSheet healthSheet = workbook.createSheet("HealthInsurance");
	public static XSSFRow headerRow4 = healthSheet.createRow(0);

	// Created a method to set the style of top row for Headings
	private static void setHeaderStyle(XSSFRow headerRow, int colIndex, String headerName) {
		CellStyle style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);

		headerRow.createCell(colIndex).setCellValue(headerName);
		headerRow.getCell(colIndex).setCellStyle(style);
	}

	// This method will write all upcoming bike details in BikeDetails sheet
	public static void writeBikeDetails(LinkedHashMap<String, List<String>> bikeDetails, String filePath) {
		try {
			headerRow1 = bikesheet.getRow(0);

			setHeaderStyle(headerRow1, 0, "Bike Name");
			setHeaderStyle(headerRow1, 1, "Bike Price");
			setHeaderStyle(headerRow1, 2, "Launch Date");

			int rowNum = 1;
			for (List<String> detailsList : bikeDetails.values()) {
				XSSFRow row = bikesheet.createRow(rowNum++);

				int cellNum = 0;
				for (String detail : detailsList) {
					XSSFCell cell = row.createCell(cellNum++);
					if (cellNum == 3) {
						String det = detail.substring(14, detail.length());
						cell.setCellValue(det);
					} else {
						cell.setCellValue(detail);
					}
				}
			}

			// Auto-fit column width implementation
			for (int i = 0; i < headerRow1.getLastCellNum(); i++) {
				bikesheet.autoSizeColumn(i);
			}

			// writing data in the excel sheet
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method will write all car models in PopularCarModels sheet
	public static void writePopularCarModel(List<String> carModels, String filePath) {
		try {
			headerRow2 = carsheet.getRow(0);

			setHeaderStyle(headerRow2, 0, "Popular Car Model");

			for (int i = 0; i < carModels.size(); i++) {
				XSSFRow row = carsheet.getRow(i + 1);

				// if row doesn't exist, create a new one
				if (row == null) {
					row = carsheet.createRow(i + 1);
				}

				// use cell index 0 to write in the first column
				row.createCell(0).setCellValue(carModels.get(i));
			}

			// Auto-fit column width implementation
			for (int i = 0; i < headerRow2.getLastCellNum(); i++) {
				carsheet.autoSizeColumn(i);
			}

			// writing data in the excel sheet
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method will write all upcoming car details in CarDetails sheet
	public static void writeCarDetails(LinkedHashMap<String, List<String>> carDetails, String filePath) {
		try {
			headerRow3 = carSheet.getRow(0);

			setHeaderStyle(headerRow3, 0, "Car Name");
			setHeaderStyle(headerRow3, 1, "Car Price");
			setHeaderStyle(headerRow3, 2, "Launch Date");

			int rowNum = 1;
			for (List<String> detailsList : carDetails.values()) {
				XSSFRow row = carSheet.createRow(rowNum++);

				int cellNum = 0;
				for (String detail : detailsList) {
					XSSFCell cell = row.createCell(cellNum++);
					if (cellNum == 3) {
						String det = detail.substring(14, detail.length());
						cell.setCellValue(det);
					} else {
						cell.setCellValue(detail);
					}
				}
			}

			// Auto-fit column width implementation
			for (int i = 0; i < headerRow3.getLastCellNum(); i++) {
				carSheet.autoSizeColumn(i);
			}

			// writing data in the excel sheet
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method will write all Health insurance brand name in HealthInsurance
	public static void writeHealthInsuranceBrandName(List<String> insuranceBrandName, String filePath) {
		try {
			headerRow4 = healthSheet.getRow(0);

			setHeaderStyle(headerRow4, 0, "Health Insurance Brand Name");

			for (int i = 0; i < insuranceBrandName.size(); i++) {
				XSSFRow row = healthSheet.getRow(i + 1);

				// if row doesn't exist, create a new one
				if (row == null) {
					row = healthSheet.createRow(i + 1);
				}

				// use cell index 0 to write in the first column
				row.createCell(0).setCellValue(insuranceBrandName.get(i));
			}

			// Auto-fit column width implementation
			for (int i = 0; i < headerRow4.getLastCellNum(); i++) {
				healthSheet.autoSizeColumn(i);
			}

			// writing data in the excel sheet
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// This method will write all Health insurance plan in HealthInsurance
	public static void writeHealthInsurancePlan(List<String> insurancePlan, String filePath) {
		try {
			headerRow4 = healthSheet.getRow(0);

			setHeaderStyle(headerRow4, 1, "Health Insurance Plan");

			for (int i = 0; i < insurancePlan.size(); i++) {
				XSSFRow row = healthSheet.getRow(i + 1);

				// if row doesn't exist, create a new one
				if (row == null) {
					row = healthSheet.createRow(i + 1);
				}

				// use cell index 1 to write in the second column
				row.createCell(1).setCellValue(insurancePlan.get(i));
			}

			// Auto-fit column width implementation
			for (int i = 0; i < headerRow4.getLastCellNum(); i++) {
				healthSheet.autoSizeColumn(i);
			}

			// writing data in the excel sheet
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
