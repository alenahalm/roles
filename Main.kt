import java.io.FileInputStream
import java.util.*

fun main() {
    val sc = Scanner(FileInputStream("roles.txt"))

    val roles = arrayListOf<String>()
    val text = arrayListOf<String>()

    while (sc.hasNextLine()){
        val line = sc.nextLine()
        if (line == "roles:")
            continue
        if (line == "textLines:")
            break
        roles.add(line)
    }
    while (sc.hasNextLine()) {
        text.add(sc.nextLine())
    }

    val lines = arrayListOf<String>()

    for (i in roles){
        var line = "$i:\n"
        for (j in 0 until text.size) {
            if (text[j].startsWith("$i:")) {
                line += "${j+1}) ${text[j].substring("$i: ".length)}\n"
            }
        }
        lines.add(line)
    }

    for (i in lines){
        println(i)
    }
}
