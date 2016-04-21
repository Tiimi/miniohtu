import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*

description """An article is added."""

scenario "add a new article", {
    given 'command to add a new article is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa", "artikkeli","abc123","pentti","title","journal","2000","1","1","1-2","4","note","listaa","lopeta")
        test = new TextUI(io, database)
    }

    when 'a new article is added', {
        test.run()
    }

    then 'new article is in the system', {
        io.getPrintouts().shouldHave("Article title: title \nWritten by: pentti - year: 2000\nJournal: journal - volume: 1")
    }
}