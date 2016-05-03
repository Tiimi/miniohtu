import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*
import java.io.File

description """An article is added."""

scenario "add a new article", {
    given 'command to add a new article is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","article","abc","pentti","title","journal","2000","2","3","1-2","9","note","listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new article is added', {
        test.run()
    }

    then 'new article is in the system', {
        io.getPrintouts().shouldHave("ARTICLE{citationKey=abc, author=pentti, title=title, journal=journal, year=2000, volume=2, number=3, pages=1-2, month=9, note=note}")        
        new File("test1.db").delete()
    }
}