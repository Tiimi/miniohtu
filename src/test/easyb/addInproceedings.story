import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*
import java.io.File

description """An inproceedings is added."""

scenario "add a new inbook with all fields", {
    given 'command to add a new inbook is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa", "inproceedings", "citationKey", "author", "title","booktitle","9001","editor","1-2","organization","publisher","address","1","This is a Note","Key","listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new inbook is added', {
        test.run()
    }

    then 'new inproceedings is in the system', {
        io.getPrintouts().shouldHave("INPROCEEDINGS{citationKey=citationKey, author=author, title=title, booktitle=booktitle, year=9001, editor=editor, pages=1-2, organization=organization, publisher=publisher, address=address, month=1, note=This is a Note, key=Key}")
        io.getPrintouts().shouldHave("Inproceedings lisätty.")
        new File("test1.db").delete()
    }

}
