@echo off
cls

set DRIVE_LETTER=%1:
set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.9\bin;c:\Windows
set CLASSPATH=./src;%DRIVE_LETTER%/Java/jdom-2.0.6/jdom-2.0.6.jar
:: . means current directory - if you want the current directory, you must explicitly include it

::call ant build -Ddrive-letter=%DRIVE_LETTER%
ant test -Ddrive-letter=%DRIVE_LETTER%
::ant run -Ddrive-letter=%DRIVE_LETTER%

::-verbose lets you see more of where the compiler is looking
::javac -verbose -cp %CLASSPATH% src/csc2310/RationalNumber.java
::javac -verbose -cp %CLASSPATH% src/QueueDriver.java
::java -cp %CLASSPATH% QueueDriver


