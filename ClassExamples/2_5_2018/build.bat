@echo off
cls

set DRIVE_LETTER=%1:
set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.9\bin;c:\Windows
set CLASSPATH=./src;%DRIVE_LETTER%/Java/jdom-2.0.6/jdom-2.0.6.jar

::call ant build -Ddrive-letter=%DRIVE_LETTER%
::ant test -Ddrive-letter=%DRIVE_LETTER%
ant run -Ddrive-letter=%DRIVE_LETTER%

::javac -cp %CLASSPATH% src/csc2310/RationalNumber.java
::javac -cp %CLASSPATH% src/csc2310/RationalNumbers.java

::javac -cp %CLASSPATH% src/csc2310/RationalDriver.java
::java -cp %CLASSPATH% csc2310.RationalDriver

::javac -cp %CLASSPATH% src/csc2310/Driver.java
::java -cp %CLASSPATH% csc2310.Driver

::javac -cp %CLASSPATH% src/csc2310/EnumDriver.java
::java -cp %CLASSPATH% csc2310.EnumDriver

::javac -cp %CLASSPATH% src/csc2310/PQDriver.java
::java -cp %CLASSPATH% csc2310.PQDriver


