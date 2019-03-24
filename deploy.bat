:: 修改文件清单
@echo off
for /f "delims=" %%i in ('dir /s/b list.txt') do ( 
for /f "delims=" %%a in ('type "%%~fi"') do ( 
set "foo=%%a"                
call,set foo=%%foo:claim\src\main\webapp=src\main\webapp%%
call,set foo=%%foo:claim/src/main/webapp=src/main/webapp%%
call,echo/%%foo%%>>"%%~fi._"
)
move "%%~fi._" "%%~fi"
)


:: 编译源脚本，见下
echo off
@echo 是否需要编译？Y/N

set /p ifo=

:: 记录输入的操作
set YY=%date:~0,4%
set MM=%date:~5,2%
set DD=%date:~8,2%
set T2=%time:~0,8%
set HHt=%time:~0,2%  
set MIt=%time:~3,2%  
set SSt=%time:~6,2%  
set xx=%date:~9,1%
echo %ifo% %date% %time% >>操作轨迹.txt

if /i %ifo% EQU y goto Yes
if /i %ifo% EQU n goto No

:Yes
@start ant -f build.xml backup -l AntLog.txt 
goto end
:No
@start ant -f build.xml nobuild -l AntLog.txt 
goto end

:end
exit