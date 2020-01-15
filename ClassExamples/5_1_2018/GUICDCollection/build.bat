@echo off
cls

set DRIVE_LETTER=%1:
set FILE_NAME=%2

set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.9\bin;c:\Windows
set CLASSPATH=./src;%DRIVE_LETTER%/Java/jdom-2.0.6/jdom-2.0.6.jar
:: . means current directory - if you want the current directory, you must explicitly include it

::call ant build -Ddrive-letter=%DRIVE_LETTER%
::ant test -Ddrive-letter=%DRIVE_LETTER%
::ant run-nongui -Ddrive-letter=%DRIVE_LETTER%
:: Below ant task will work whether or not a second command line argument is specified.  
:: See http://ss64.com
:: path information needs to be given for the file name, i.e., resources/cds.txt
if "%FILE_NAME%"=="" (
    call ant run -Ddrive-letter=%DRIVE_LETTER%
) else (
    call ant run-gui-with-arg -Ddrive-letter=%DRIVE_LETTER% -Dfile-name=%FILE_NAME%
)

::-verbose lets you see more of where the compiler is looking
::javac -verbose -cp %CLASSPATH% src/CDCollectionGUI.java
::java -cp %CLASSPATH% CDCollectionGUI resources/cds.txt


