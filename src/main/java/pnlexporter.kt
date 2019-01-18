import generated.Documents
import java.io.File

data class Pnlrecord(val pnldref: String?, val cjsoffencecode: String?, val title : String?, val maxcustodialsentenceunitmagctDesc: String?,
                     val maxcustodialsentencelengthmagct: String , val maxcustodialsentenceunitcrownctDesc: String?,
                     val maxcustodialsentencelengthcrownct: String?, val libracategoryCode:String?, val filename: String)


fun convertDocumentsToPnlRecords(docs: Documents?,  filename: String): Pnlrecord{

    return  Pnlrecord(docs?.document?.pnldref, docs?.document?.codes?.cjsoffencecode, docs?.document?.english?.title,
        docs?.document?.libra?.maxcustodialsentenceunitmagct?.description, docs?.document?.libra?.maxcustodialsentencelengthmagct.toString(),
        docs?.document?.libra?.maxcustodialsentenceunitcrownct?.description, docs?.document?.libra?.maxcustodialsentencelengthcrownct.toString(),
        docs?.document?.libra?.libracategory?.code, filename)
}

fun main(args: Array<String>) {
    val listOfDocuments = mutableListOf<Pnlrecord>()
        File(args[0]).walk().filter { it.isFile && it.toString().endsWith("xml") }
        .forEach { listOfDocuments. add(convertDocumentsToPnlRecords(PnlFileMarshaller.getGeneratedDocumets(it.absoluteFile),it.name)) }

    writeExcelreport(listOfDocuments)

    println(listOfDocuments)
}
