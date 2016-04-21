import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*

description """A book is added."""

scenario "add a new book", {
    given 'command to add a new article is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","book","citkey","Ville","Title","publisher","2016","2","2","Address","1","4","Note","Key","listaa","lopeta")
        test = new TextUI(io, database)
    }

    when 'a new book is added', {
        test.run()
    }

    then 'new book is in the system', {
        io.getPrintouts().shouldHave("Book{citationKey=citkey, author=Ville, title=Title, publisher=publisher, year=2016, volume=2, series=2, address=Address, edition=1, month=4, note=Note, key=Key}")
        new File("test1.db").delete()
    }
}