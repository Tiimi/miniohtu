import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*

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
