import java.util.Scanner

fun manageArchive(archive: Archive, scanner: Scanner) {
    while (true) {
        println("\nАрхив: ${archive.name}")
        if (archive.notes.isEmpty()) {
            println("Нет заметок")
        } else {
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1}. ${note.title}")
            }
        }
        println("0. Создать заметку")
        println("-1. Назад")

        print("Выбор: ")
        when (val input = scanner.nextLine()) {
            "-1" -> return
            "0" -> {
                print("Введите заголовок: ")
                val title = scanner.nextLine().trim()
                if (title.isEmpty()) {
                    println("Ошибка: заголовок не может быть пустым")
                    continue
                }
                print("Введите содержание: ")
                val content = scanner.nextLine().trim()
                if (content.isEmpty()) {
                    println("Ошибка: содержание не может быть пустым")
                    continue
                }
                archive.notes.add(Note(title, content))
                println("Заметка '$title' создана!")
            }

            else -> {
                val index = input.toIntOrNull()
                if (index != null && index in 1..archive.notes.size) {
                    val note = archive.notes[index - 1]
                    println("\n=== ${note.title} ===")
                    println(note.content)
                    println("\nНажмите Enter для продолжения...")
                    scanner.nextLine()
                } else {
                    println("Ошибка: неверный ввод")
                }
            }
        }
    }
}