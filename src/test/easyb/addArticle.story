import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*
import java.io.File

description """An article is added."""

scenario "add a new article", {
    given 'command to add a new article is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","article","abc","pentti","title","journal","2000","1","1","1-2","2","note","listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new article is added', {
        test.run()
    }

    then 'new article is in the system', {
        io.getPrintouts().shouldHave("Article title: title")
        io.getPrintouts().shouldHave("Written by: pentti - year: 2000")
        io.getPrintouts().shouldHave("Journal: journal - volume: 1")
        new File("test1.db").delete()
    }
}