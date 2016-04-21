import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*

description """References from the database are listed on the screen when requested"""

scenario "listing references", {
    given 'command to list all references on the screen', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","article","abc123","pentti","title","journal","2000","1","1","1-2","2","note")
        io = new IOStub("lisaa","article","321cba","erkki","TheMainArticle","LeMagazine","1999","3","4","52-95","4","some notes about it")
        io = new IOStub("lisaa","article","555ccc","jari","SecondArticle","journalize","1985","4","6","92-110","3","more notes","listaa","lopeta")
        test = new TextUI(io, database)
    }
    when 'multiple references are in the database', {
        test.run()
    }
    then 'articles are listed on the screen', {
        io.getPrintouts().shouldHave("Article title: title\nWritten by: pentti - year: 2000\nJournal: journal - volume: 1\nArticle title: TheMainArticle\nWritten by: erkki - year: 1999\nJournal: LeMagazine - volume: 3\nArticle title: SecondArticle\nWritten by: jari - year: 1985\nJournal: journalize - volume: 4")
    }
}
