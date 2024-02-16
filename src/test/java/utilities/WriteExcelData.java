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

				// use cell index 1 to write in the second column
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
}
