# Here are detailed instructions on how to install, build, and run the ShoppingBasket application from a clean repository:

## Prerequisites
- Java Development Kit (JDK)
- Scala Build Tool (sbt)
- Git (optional, if you're cloning from a Git repository)

## Step-by-Step Guide

1. Clone or Download the Project\
   If Using Git:\
   Open a terminal or command prompt.\
   Navigate to where you want to clone the project: 

   git clone repository-url
   cd ShoppingBasket

   If Downloading a Zip:  \
   Download the zip file from your source control system. \
   Extract it to a folder of your choice. \
   Navigate to that folder in your terminal or command prompt.

2. Install IntelliJ IDEA (optional, but recommended for better development experience)

3. Open the Project in IntelliJ IDEA:  
   Launch IntelliJ IDEA:  \
   Choose "Open" or "Import Project".  \ 
   Navigate to the directory where you cloned or extracted the project and select it. 

4. Build the Project.  \
   
   Open a terminal in IntelliJ or from your operating system at the project's root directory.  

   Run:   \
   sbt compile

5. Run the Application.  
   From Command Line, execute one after one to see results for different scenarios:
   
   sbt "run Apples Milk Bread"  \  
   sbt "run Apples Apples Milk Bread"  \
   sbt "run Apples Milk Milk Bread"  \
   sbt "run Bread"

   Replace Apples Milk Bread with any items you want to price.  

   From IntelliJ IDEA:  \
   Navigate to src/main/scala/Main.scala.  \
   Right-click in the editor and choose Run 'Main' or use the play button next to def main(args: Array[String]).  \
   Enter the items in the run configuration if necessary or modify the run parameters in the run configuration settings. 

7. Run Unit Tests
   From Command Line:  \
   Execute:  \
   sbt test  

   From IntelliJ IDEA:  \
   Use the test runner:  \
   Open src/test/scala/ShoppingBasketSpec.scala.  \
   Right-click within the file and select Run 'ShoppingBasketSpec' or use the play button next to any test method.  

Troubleshooting:

If sbt commands fail: Check your internet connection for downloading dependencies. Ensure sbt is correctly installed and in your PATH.
Java version issues: Make sure you're using a compatible Java version. You can specify a Java version in build.sbt with javaOptions += "-target:11" for example.
This guide should enable someone with no prior knowledge of Scala or sbt to set up, compile, run, and test the application locally.
