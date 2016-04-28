
import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*
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
