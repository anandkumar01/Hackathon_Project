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
	public static XSSFSheet sheet = workbook.createSheet("BikeDetails");
	public static XSSFRow headerRow = sheet.createRow(0);

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
			headerRow = sheet.getRow(0);

			setHeaderStyle(headerRow, 0, "Bike Name");
			setHeaderStyle(headerRow, 1, "Bike Price");
			setHeaderStyle(headerRow, 2, "Launch Date");

			int rowNum = 1;
			for (List<String> detailsList : bikeDetails.values()) {
				XSSFRow row = sheet.createRow(rowNum++);

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
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				sheet.autoSizeColumn(i);
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
