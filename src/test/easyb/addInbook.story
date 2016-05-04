import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*
import java.io.File

description """An inbook is added."""

scenario "add a new inbook", {
    given 'command to add a new inbook is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa", "inbook", "citationKey", "author", "title", "1", "publisher", "2016", "1", "2", "address", "2", "4", "note", "key", "listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new inbook is added', {
        test.run()
    }

    then 'new inbook is in the system', {
        io.getPrintouts().shouldHave("INBOOK{citationKey=citationKey, author=author, title=title, chapter=1, publisher=publisher, year=2016, volume=1, series=2, address=address, edition=2, month=4, note=note, key=key}")
        new File("test1.db").delete()
    }
}