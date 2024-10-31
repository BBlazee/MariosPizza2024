# MariosPizza2024

Skriver på Teams


@ Thomas
chaotic notes:
Cleaned the Main and reorganized the structure and flow
Changed Menu.java to PizzaMenu.java
Deleted previous "MenuPersistens" file
created PizzaFactory file
created InputHelper file
created FileManager file
Revised pizza file
revised Customer file
Revised Order file
Removed PizzaFactory and consolidated into PizzaMenu
Revised Order class (again, again)
removed customer class
revised FileManager
Dropped Filemanager

Getting validation errors on customer class while parsing arguments. fixed and rewritten some of the customer class

Problem with the filemanager, the parsed fields throws errors, possibly wrong parse for the wrong field.
The Pizza list was throwing the errors, changed regex to semicolon among other things.

Currently the main menu is operational but updating the orders in the txt file creates duplicates. The solution is (sadly) to read the entire contents of the file, edit the specific line and rewrite the entire txt file.

Databases other than orders seem redundant now, Pizzas are written straight into the PizzaMenu class, customer information is retained in the order database. further information is unneccesary. removing customer and pizzas .txt file creation

Rewrote main menu for more readability, creating methods for case options.

Datetime format needs to be converted for readability

The VIP status is currently selectable, which it should not be. Use phonenumber as a criteria for search and and generate vip status from that. VIP status may need revising entirely

The application currently allows the adding of pizzas, but it is not persistent.

https://www.ascii-code.com/
https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
https://docs.oracle.com/javase/tutorial/jdbc/index.html
https://www.sqliz.com/posts/java-basic-sqlite/
https://www.sqlitetutorial.net/sqlite-java/select/
https://www.youtube.com/watch?v=0beocykXUag



For vscode
1. Download the SQLite JDBC Driver
Go to the SQLite JDBC Driver page on Maven Repository.
Download the latest version of sqlite-jdbc-x.x.x.jar (replace x.x.x with the latest version number) under the Files section.
2. Add the Driver to Your Project
Place the downloaded .jar file in a folder in your project directory, typically in a lib or libs folder (create it if it doesn’t exist).
3. Configure VSCode to Include the JDBC Driver in Your Project
Open VSCode and navigate to your project folder.
Go to File > Open Folder... and select your project folder in VSCode if you haven’t already.
To configure the .jar file as a library in VSCode, open the Command Palette (press Ctrl+Shift+P or Cmd+Shift+P on macOS) and search for Java: Configure Java Runtime.
In the settings, look for the ClassPath section, where you can add external .jar files.
