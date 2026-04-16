import java.util.Scanner



fun main() {
    val archives = mutableListOf<Archive>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n=== Список архивов ===")
        if (archives.isEmpty()) {
            println("Нет архивов")
        } else {
            archives.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
        }
        println("0. Создать архив")
        println("-1. Выход")
        print("Выбор: ")
        when (val input = scanner.nextLine()) {
            "-1" -> {
                println("До свидания!")
                break
            }
            "0" -> {
                print("Введите название архива: ")
                val name = scanner.nextLine().trim()
                if (name.isNotEmpty()) {
                    archives.add(Archive(name))
                    println("Архив '$name' создан!")
                } else {
                    println("Название не может быть пустым")
                }
            }
            else -> {
                val index = input.toIntOrNull()
                if (index != null && index in 1..archives.size) {
                    manageArchive(archives[index - 1], scanner)
                } else {
                    println("Неверный ввод")
                }
            }
        }
    }
}


