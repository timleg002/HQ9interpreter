import java.io.File

class Main(private val Path: String) {
    private fun read(path: String = Path): ArrayList<Char>{
        val fr = File(path)
        val arr = ArrayList<Char>()
        fr.forEachLine{for(i in 0 until fr.length()){arr.add(it[i.toInt()])}}
        return arr
    }

    private fun interpret(arr: ArrayList<Char>): ArrayList<String>{
        val output = ArrayList<String>()
        var acc=0
        for(i in 0 until arr.size){
            when(arr.get(i)){
                'H' -> output.add("Hello World")
                'Q' -> for(i in 0 until arr.size) output.add(arr[i].toString())
                '9' -> for(i in 99 downTo 1){
                    if(i-1 == 0 || i==0)
                        output.add("$i bottles of beer\nyou take one down, pass it around,\nno more bottles of beer on the wall.")
                     else
                        output.add("$i bottles of beer\nyou take one down, pass it around,\n${i-1} bottles of beer on the wall.\n")
                }
                '+' -> acc++
            }
        }
        return output
    }

    fun main(path: String = Path){
        val arr = interpret(read(path))
        for(i in 0 until arr.size) print(arr.get(i))
    }
}
