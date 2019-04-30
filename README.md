# dnd-api
Start of an API that displays & filters spells from 5th Edition Dungeons & Dragons

Current endpoints:
* `/spell/{name}`: Retrieves all info on that spell
* `/spells/class-list/{className}`: Retrieves all info on the spell list for the given class
* `/spells/by-level/{level}`: Retrieves all info for spells of a given level

Later I intend to add the ability to just get basic details of a spell when you search by class list or level. I also want to add the ability to search for a spell based on a name, as well as just about any other property.