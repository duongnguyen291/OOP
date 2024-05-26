@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-22
set PATH=%JAVA_HOME%\bin;%PATH%
set JAVAFX_LIB="d:\\ApplicationSetup\\javafx-sdk-22.0.1\\lib"

echo Compiling...
javac --module-path %JAVAFX_LIB% --add-modules javafx.controls,javafx.fxml -d ../bin src/ict/Painter.java

if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b %errorlevel%
)

echo Running...
java --module-path %JAVAFX_LIB% --add-modules javafx.controls,javafx.fxml -cp ../bin ict.Painter
