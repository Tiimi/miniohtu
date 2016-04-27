import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*
import java.io.File

description """A Conference is added."""

scenario "add a new conference with all fields", {
    given 'command to add a new conference is selected', {
        database = new Database("test1.db")
        io = new IOStub("lisaa", "conference", "citationKey", "author", "title", "bookTitle", "2016", "editor", "10", "organization", "publisher", "address", "4", "note", "key", "listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new conference is added', {
        test.run()
    }

    then 'new conference is in the system', {
        io.getPrintouts().shouldHave("Conference{citationKey=citationKey, author=author, title=title, bookTitle=bookTitle, year=2016, editor=editor, pages=10, organization=organization, publisher=publisher, address=address, month=4, note=note, key=key}")
        new File("test1.db").delete()
    }
}

scenario "add a new conference with some optional fields", {
    given 'command to add a new conference is selected', {
        database = new Database("test2.db")
        io = new IOStub("lisaa", "conference", "citationKey", "author", "title", "bookTitle", "2016", "editor", "", "organization", "publisher", "", "", "note", "key", "listaa", "lopeta")
        test = new TextUI(io, database)
    }

    when 'a new conference is added', {
        test.run()
    }

    then 'new conference is in the system', {
        io.getPrintouts().shouldHave("Conference{citationKey=citationKey, author=author, title=title, bookTitle=bookTitle, year=2016, editor=editor, organization=organization, publisher=publisher, note=note, key=key}")
        new File("test2.db").delete()
    }
}