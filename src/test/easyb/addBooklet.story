import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*

description """A booklet is added."""

scenario "add a new booklet", {
    given 'command to add a new article is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","booklet","citkey","title","Ville","somehow","address","4","2016","note","key","listaa","lopeta")
        test = new TextUI(io, database)
    }

    when 'a new article is added', {
        test.run()
    }

    then 'new article is in the system', {
        io.getPrintouts().shouldHave("Booklet{citationKey=citkey, title=title, author=Ville, howpublished=somehow, address=address, month=4, year=2016, note=note, key=key}")
        new File("test1.db").delete()
    }
}