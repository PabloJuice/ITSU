@echo off
del %1.exe
tasm32.exe /x /m /ml %1.txt
tlink32.exe /Tpe /aa /c %1.obj,,,Import32.LIB
del %1.obj
del %1.map
%1.exe
pause