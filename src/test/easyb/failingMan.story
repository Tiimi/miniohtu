
import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*
import java.io.File

description """Fail selecting an action"""

scenario "invalid action input", {
    given 'bad command is written', {
        database = new Database("test1.db")
        io = new IOStub("wrong", "lopeta")
        test = new TextUI(io, database)
    }

    when 'wrong selection is entered', {
        test.run()
    }

    then 'error message is given', {
        io.getPrintouts().shouldHave("Väärä komento: wrong")        
        new File("test1.db").delete()
    }
}

description """Fail after add"""

scenario "invalid add input", {
    given 'bad command is written', {
        database = new Database("test1.db")
        io = new IOStub("lisaa", "wrong", "lopeta")
        test = new TextUI(io, database)
    }

    when 'wrong selection is entered', {
        test.run()
    }

    then 'error message is given', {
        io.getPrintouts().shouldHave("Viite tyyppiä: wrong ei ole.")        
        new File("test1.db").delete()
    }
}

description """Fail removing from non-existing table"""

scenario "invalid remove input", {
    given 'bad command is written', {
        database = new Database("test1.db")
        io = new IOStub("poista", "wrong", "anything", "lopeta")
        test = new TextUI(io, database)
    }

    when 'wrong selection is entered', {
        test.run()
    }

    then 'error message is given', {
        io.getPrintouts().shouldHave("Viitetyyppiä wrong ei ole.")        
        new File("test1.db").delete()
    }
}

description """Fail removing from non-existing id"""

scenario "invalid remove input", {
    given 'an article exists and user tries to remove an article with wrong id', {
        database = new Database("test1.db")
        io = new IOStub("lisaa","article","abc","pentti","title","journal",
            "2000","2","3","1-2","9","note", "poista", "article", "wrong", "lopeta")
        test = new TextUI(io, database)
    }
    when 'wrong id is entered', {
        test.run()
    }
    then 'error message is given', {
        io.getPrintouts().shouldHave("Viitettä wrong ei ole.")        
        new File("test1.db").delete()
    }
}
