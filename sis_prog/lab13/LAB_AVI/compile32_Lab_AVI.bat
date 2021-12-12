@echo off
del Lab_AVI.exe
tasm32.exe /x /m /ml Lab_AVI.txt
tlink32.exe /Tpe /aa /c Lab_AVI.obj,,,Import32.LIB
del Lab_AVI.obj
del Lab_AVI.map
Lab_AVI.exe
pause
