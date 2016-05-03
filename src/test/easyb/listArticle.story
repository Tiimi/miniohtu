import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*

description """References from the database are listed on the screen when requested"""

scenario "listing references", {
    given 'command to list all references on the screen', {
        database = new Database("test2.db")
        io = new IOStub("lisaa","article","abc123","pentti","title","journal","2000","1","1","1-2","2","note","lisaa","article","321cba","erkki","TheMainArticle","LeMagazine","1999","3","4","52-95","4","some notes about it","lisaa","article","555ccc","jari","SecondArticle","journalize","1985","4","6","92-110","3","more notes","listaa","lopeta")
        test = new TextUI(io, database)
    }
    when 'multiple references are in the database', {
        test.run()
    }
    then 'articles are listed on the screen', {
        io.getPrintouts().shouldHave("ARTICLE{citationKey=abc123, author=pentti, title=title, journal=journal, year=2000, volume=1, number=1, pages=1-2, month=2, note=note}")        
        new File("test2.db").delete()
    }
}
