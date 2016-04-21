import miniohtu.database.*
import miniohtu.IO.*
import miniohtu.app.*

description """A book is added."""

scenario "add a new book", {
    given 'command to add a new article is selected', {
        database = new Database("test1.db")

    }

    when 'a new book is added', {
    
    }

    then 'new book is in the system', {

    }
}