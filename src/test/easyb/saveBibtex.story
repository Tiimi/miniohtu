import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.UI.*

description """Bibtex file is saved"""

scenario "save bibtex", {
    given 'command to save is selected', {
        database = new Database("testBibtex.db")
        io = new IOStub("tallenna", "./superhieno.tex", "lopeta")
        test = new TextUI(io, database)
    }

    when 'bibtex is saved', {
        test.run()
    }

    then 'bibtex file is in the system', {
        new File("./superhieno.tex").isFile().shouldBe true
        new File("./superhieno.tex").delete()
        new File("testBibtex.db").delete()
    }
}

scenario "save bibtex to an invalid path", {
    given 'command to save is selected', {
        database = new Database("testBibtex.db")
        io = new IOStub("tallenna", "invalid/invalid.tex", "lopeta")
        test = new TextUI(io, database)
    }
    
    when 'bibtex is saved', {
        test.run();
    }

    then 'error message should be displayed', {
        io.getPrintouts().shouldHave("Tallennus epäonnistui. Tarkista polku")
        new File("testBibtex.db").delete()
    }
}
