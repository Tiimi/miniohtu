import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*
import java.io.File

description """An entry is removed."""

scenario "remove an existing entry", {
    given 'command to add a new entry and to remove it is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","article","abc","pentti","title","journal","2000","1","1","1-2","2","note","poista", "article", "abc", "listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new entry is removed', {
        test.run()
    }

    then 'it is not in the system', {
        io.getPrintouts().shouldNotHave("Article title: title")
        io.getPrintouts().shouldNotHave("Written by: pentti - year: 2000")
        io.getPrintouts().shouldNotHave("Journal: journal - volume: 1")
        new File("test1.db").delete()
    }
}
