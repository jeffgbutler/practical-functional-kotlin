## Setup

### Maven Notes
If you experience difficulties in building the project, it might be that your workstation is configured to communicate with an internal Maven repository that cannot be reached when you are off-site. If this is true in your case, you can temporarily disable your connection to the internal Maven repository by renaming your Maven `settings.xml` file:

1. (Windows) Navigate to `\Users\<your id>\.m2`
2. (Linux/Mac) Navigate to `~\.m2`
3. Rename `settings.xml` to `settings.xml.save`

**Important** Remember to rename the file back to `settings.xml` once you are finished with this workshop. 

### Setup for Eclipse
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install Eclipse from [http://www.eclipse.org/downloads/](http://www.eclipse.org/downloads/)
3. Clone the repository from [https://github.com/jeffgbutler/practical-functional-kotlin.git](https://github.com/jeffgbutler/practical-functional-kotlin.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-kotlin/archive/master.zip](https://github.com/jeffgbutler/practical-functional-kotlin/archive/master.zip)
4. Open Eclipse, make a new workspace
5. Install the Kotlin plugin from the Eclipse marketplace
   - Help->Eclipse Marketplace...
   - Search for Kotlin
   - Install the plugin, restart, etc.
6. Import the project from the cloned code repo (File->Import...->Existing Maven Project)
7. Run all the tests by right clicking on the project and selecting "Run As->JUnit Test"

### Setup for IntelliJ
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install IntelliJ Community Edition from [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)
3. Clone the repository from [https://github.com/jeffgbutler/practical-functional-kotlin.git](https://github.com/jeffgbutler/practical-functional-kotlin.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-kotlin/archive/master.zip](https://github.com/jeffgbutler/practical-functional-kotlin/archive/master.zip)
4. Open IntelliJ, import Maven project from the cloned repo (File->New->Project From Existing Sources...)
5. Run tests with ctrl-shift-F10

### Setup for Visual Studio Code
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Download Maven from [http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi) - the binary zip archive is sufficient
3. Unzip Maven to some convenient location (I usually use \JavaTools\apache-maven-3.5.3) 
4. Install VS code from [https://code.visualstudio.com/](https://code.visualstudio.com/)
5. Clone the repository from [https://github.com/jeffgbutler/practical-functional-kotlin.git](https://github.com/jeffgbutler/practical-functional-kotlin.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-kotlin/archive/master.zip](https://github.com/jeffgbutler/practical-functional-kotlin/archive/master.zip)
6. Open VS code in the cloned code repo:
   - cd ...\practical-functional-kotlin
   - code .
7. Open the extensions page (ctrl-shift-X), install the following extensions:
  - Java Extension Pack (from Microsoft)
  - Kotlin Language (from mathiasfrolich)
8. If you get the message from VS Code that it can't find the Java Runtime...
   - ctrl-shift-P (show all commands)
   - Open Workplace settings
   - Add setting "java.home": "\<your JDK location\>" (for example "C:\\\\Program Files\\\\Java\\\\jdk1.8.0_121")
   - Add setting "maven.terminal.useJavaHome": true
   - Reload the window (ctrl-shift-P, then "Reload Window")
9. Specify the location of the Maven executable:
   - ctrl-shift-P (show all commands)
   - Open Workplace settings
   - Add setting "maven.executable.path": "\<maven location\>" (for example "C:\\\\JavaTools\\\\apache-maven-3.5.3\\\\bin\\\\mvn.cmd")
   - Reload the window (ctrl-shift-P, then "Reload Window")
10. You can run the tests by selecting the project in the "Maven Projects" panel, then right clicking and selecting "test"
