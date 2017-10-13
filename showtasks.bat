call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo File rancrud has errors - breaking work
goto fail

:startbrowser
start chrome.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto  end
echo Cannot open page
goto fail

:fail
echo.
echo Something gone wrong

:end
echo.
echo Hurra done!!