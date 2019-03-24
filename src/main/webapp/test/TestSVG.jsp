<%--
****************************************************************************
* DESC       ：测试SVG
* AUTHOR     ：weishixin
* CREATEDATE ：2004-08-04
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>  
  
<html>
<head>
    <!--对title处理-->
    <title>
      测试使用SVG
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
 </head>    
 <body>
     一种画图方式
     <embed type="image/svg+xml" src="Draw1SVG.svgz" width="599" height="500" />
     
     <br>
     
     
     另一种方式
     <object type="image/svg+xml" data="DrawSVG.jsp"
                          width="599" height="500">
     </object>
 </body>

</html>