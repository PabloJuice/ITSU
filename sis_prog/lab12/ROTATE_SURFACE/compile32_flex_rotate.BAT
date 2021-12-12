@echo off
del flex_rotate.exe
tasm32.exe /x /m /ml flex_rotate.txt
tlink32.exe /Tpe /aa /c flex_rotate.obj,,,Import32.LIB
del flex_rotate.obj
del flex_rotate.map
flex_rotate.exe
pause
