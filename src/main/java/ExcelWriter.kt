import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.io.IOException
import java.io.File
import java.io.FileInputStream



private val COLUMNs = arrayOf("file name", "pnldref", "cjsoffencecode",
    "english title", "maxcustodialsentenceunitmagct desc",
    "maxcustodialsentencelengthmagct", "maxcustodialsentenceunitcrownct desc", "maxcustodialsentencelengthcrownct",
    "libracategory code")



@Throws(IOException::class)
fun writeExcelreport(records: List<Pnlrecord>) {

    val workbook = XSSFWorkbook()
    val createHelper = workbook.getCreationHelper()

    val sheet = workbook.createSheet("Customers")

    val headerFont = workbook.createFont()
    headerFont.bold = true
    headerFont.color = IndexedColors.BLUE.getIndex()

    val headerCellStyle = workbook.createCellStyle()
    headerCellStyle.setFont(headerFont)

    // Row for Header
    val headerRow = sheet.createRow(0)

    // Header
    for (col in COLUMNs.indices) {
        val cell = headerRow.createCell(col)
        cell.setCellValue(COLUMNs[col])
        cell.setCellStyle(headerCellStyle)
    }

    // CellStyle for Age
    val ageCellStyle = workbook.createCellStyle()
    ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"))

    var rowIdx = 1
    for (record in records) {
        val row = sheet.createRow(rowIdx++)
        row.createCell(0).setCellValue(record.filename)

        row.createCell(1).setCellValue(record.pnldref)
        row.createCell(2).setCellValue(record.cjsoffencecode)
        row.createCell(3).setCellValue(record.title)

        row.createCell(4).setCellValue(record.maxcustodialsentenceunitmagctDesc)
        row.createCell(5).setCellValue(record.maxcustodialsentencelengthmagct)
        row.createCell(6).setCellValue(record.maxcustodialsentenceunitcrownctDesc)
        row.createCell(7).setCellValue(record.maxcustodialsentencelengthcrownct)
        row.createCell(8).setCellValue(record.libracategoryCode)

    }

    val fileOut = FileOutputStream("export.xlsx")
    workbook.write(fileOut)
    fileOut.close()
    workbook.close()
}