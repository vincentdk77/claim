<%--
****************************************************************************
* DESC       : ����ڵ�״̬ͳ�ƽ��ҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-05-28
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="java.util.*" %>

<html xmlns:v="urn:schemas-microsoft-com:vml">
<head>
    <app:css />


  <title>
    �ڵ�״̬��Ϣͳ��
  </title>

  <STYLE>
  v\:* { BEHAVIOR: url(#default#VML) }
  </STYLE>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>


<body  >
<%
  //�����ݿ��еõ���ͳ������
  StatStatusDto statStatusDto = (StatStatusDto)request.getAttribute("statStatusDto");
  List list = (ArrayList)statStatusDto.getStatStatusList();
  int nodeStatusSize = list.size();

%>
<script language="JavaScript">
<!--
  //��������
  var dSumData = 0;
  //��ʱ����
  var dCs = 0;
  //���ֵ
  var MaxData = 0;
  //�����б�
  var dataarray = new Array(2);
  //״̬����
  var temarray0 = new Array(<%= nodeStatusSize %>);
  //ÿ��״̬����
  var temarray1 = new Array(<%= nodeStatusSize %>);
  //ÿ��״̬��ɫ
  var tempColer = new Array(<%= nodeStatusSize %>);
<%

%>
  //temarray0 = new Array('δ<br>��<br>��','δ����','������','�Ѵ���','���ύ','�ѻ���','�ѳ���','���˴���');
  //temarray1 = new Array(0,0,0,0,0,0,0,0);
  //var tempColer = new Array("<%= AppConfig.get("sysconst.ClaimStatus0") %>","<%= AppConfig.get("sysconst.ClaimStatus1") %>","<%= AppConfig.get("sysconst.ClaimStatus2") %>","<%= AppConfig.get("sysconst.ClaimStatus3") %>","<%= AppConfig.get("sysconst.ClaimStatus4") %>","<%= AppConfig.get("sysconst.ClaimStatus5") %>","<%= AppConfig.get("sysconst.ClaimStatus6") %>","<%= AppConfig.get("sysconst.ClaimStatus7") %>");
<%
  String oldName1 ="";
  String nowName1="";
  String displayName="";
  int statusRow=0; //״̬�����ָ��

  int realCol=0;   //�����ĳ���
  String nodeStatusColor =""; //��ȡ��ɫ

  for(int i=0 ;i<list.size();i++){
    StatStatusDto statStatusDto1 = (StatStatusDto)list.get(i);
    nowName1 = statStatusDto1.getNodeTypeName() ;
    //nowStatus =Integer.parseInt(statStatusDto1.getStatus());

    displayName =nowName1;
    if (nowName1.equals(oldName1))
    {displayName="";
    }
    else
    {
    //�����ж��Ƿ���״̬�Ѿ��������ǲ������һ����


    //������һ����Ϊ�ո�ʹ�õ�
    %>
    temarray0[<%= realCol %>] = "";
    temarray1[<%=realCol %>] = -100;
    tempColer[<%= realCol %>] = "";
    <%
    //��������
    realCol++;

    }
    oldName1= nowName1;
    //�ж�״ָ̬���λ���Ƿ���ڵ�ǰָ�룬��������ڣ����ж�״ָ̬������ֵ
   //��ȡ��ǰ����ɫ
    nodeStatusColor = "sysconst.ClaimStatus" + statStatusDto1.getStatus();
%>
    temarray0[<%= realCol %>] = '<%=displayName %>';
    temarray1[<%=realCol %>] = <%= statStatusDto1.getCount() %>;
    tempColer[<%= realCol %>] = '<%= AppConfig.get(nodeStatusColor) %>';
<%

   realCol++;
  }
%>
  //X�������ϵĺ���
  dataarray[0] = temarray0;
  //ֱ��ͼ��������֡�
  dataarray[1] = temarray1;

  /**
   *@description ��������
   *@param       m ��ʾ�������ֵ�ϵ����ߵĳ���
   *@return      ͨ������true,���򷵻�false
  */
  function drawLinesX(m)
  {
    count=0 //��������
    var textPoint=1
    var dcs = 1
    for(var i = 0; i < dataarray[1].length; i ++)
    {
      if(MaxData < dataarray[1][i]) MaxData = dataarray[1][i];
      dSumData = dSumData + dataarray[1][i];
      //alert(":::1:" +dSumData);
    }
    for(var i = 10; i >= 1; i --)
    {
      if(MaxData % i == 0){
        dcs = i;
        break;
      }
    }

    for(var i=1;i<= dcs;i++){
      textPoint = i * (MaxData/dcs)
      var py=2400-i*(2400/dcs) + 300
      var strTo=m+" "+py
      var newLine = document.createElement("<v:line from='150 "+py+"' to='"+strTo+"' style='position:absolute;z-index:8'></v:line>")
      group2.insertBefore(newLine)
      var newStroke = document.createElement("<v:stroke color='#c0c0c0'>")
      newLine.insertBefore(newStroke)
      var newShape= document.createElement("<v:shape style='position:absolute;left:0;top:"+(py-50)+";WIDTH:1000px;HEIGHT:200px;z-index:8' coordsize='21600,21600' fillcolor='white'></v:shape>")
      group2.insertBefore(newShape)
      var newText = document.createElement("<v:textbox id='tx"+textPoint+"' inset='3pt,0pt,0pt,0pt' style='font-size:10pt;v-text-anchor:bottom-right-baseline'></v:textbox>")
      newShape.insertBefore(newText)
      newText.innerText = textPoint
        if(count % 2 == 0){
          var newStroke = document.createElement("<v:stroke dashstyle='dot' color='black'/>")
          newLine.insertBefore(newStroke)
        }
      count++
    }
  }

  /**
   *@description ��������
   *@param       ��
   *@return      ͨ������true,���򷵻�false
  */
  function drawLinesY()
  {
  //��Y���ϵĿ̶�
    var textPoint= "";
   //��X���ϵ����� ���
    var fColWidth = 4200 / (dataarray[0].length + 1);

    var iCols = dataarray[0].length + 1;
    for(var i=1;i<=iCols;i++){
      if(i != iCols){
        //�������ϵ��������ƣ��� �ύʲô��
        textPoint = dataarray[0][i-1];
       // alert(textPoint);
        //alert(textPoint);
      } else {
        textPoint = "";
      }

      if (textPoint=="") continue;
      var py=200+ i * fColWidth ;
      var newLine = document.createElement("<v:line from='"+py+" 2700' to='"+py+" 2750' style='position:absolute;z-index:8'></v:line>");
      group2.insertBefore(newLine);
      var newStroke = document.createElement("<v:stroke color='black'>");
      newLine.insertBefore(newStroke);
      var newShape= document.createElement("<v:shape style='position:absolute;left:"+(py-50)+";top:2750;WIDTH:400px;HEIGHT:150px;z-index:8' coordsize='21600,21600' fillcolor='white'></v:shape>")
      group2.insertBefore(newShape);
      var newText = document.createElement("<v:textbox id='ty"+textPoint+"' inset='-8pt,-2pt,10pt,0pt' style='font-size:9pt;width:6.8pt;top:280.4pt;position:absolute' ></v:textbox>");
      //�����ı���
      newShape.insertBefore(newText);
      newText.innerHTML= textPoint;
    }
  }

  /**
   *@description ����װͼ
   *@param       ��
   *@return      ͨ������true,���򷵻�false
  */
  function drawBar(v,t,color){
    var textPoint= "";
    //��״ͼ�Ŀ�ȣ������С�Ļ�����խ
    var fColWidth = 4200 / (dataarray[0].length + 1)


    var iCols = dataarray[0].length + 1
    if(dSumData == 0) dSumData = 1
    if(MaxData == 0) MaxData = 1
    dCs = 2400 / MaxData

    for(var i = 0; i < iCols - 1; i ++){
      var textPoint = dataarray[1][i]
      var h = dCs * dataarray[1][i]
      var px=2700 - h;
      var py=170 + i * fColWidth + fColWidth / 4 * 3;
      var color1=tempColer[i];
      //�ж�����ǲ�ͬ�İ����ڵ㣬Ҫ���м�ճ�һЩ�ط���
      var realWidth=fColWidth;
      //��ո��õ�
      if (dataarray[1][i]==-100)
      {
          //��������
          //var newLine1= document.createElement("<v:line style='position:relative' from='"+py+",100' to='"+py+",2800' ></v:line>");
          //group2.insertBefore(newLine1);

          //����ո�ͼ
          continue;

      }


      var newShape= document.createElement("<v:rect style='position:absolute;left:"+py+";top:"+px+";WIDTH:" + realWidth+ "px;HEIGHT:"+h+"px;z-index:9;border-width:0' fillcolor='" + color1 + "' title = '������ֵΪ��" + dataarray[1][i] + " �ܺ�Ϊ��" + dSumData + " �ٷֱȣ�" + Math.round(100/(dSumData/dataarray[1][i])) + "%'></v:rect>")
      var tempTextbox=document.createElement("<v:TextBox inset='8pt,-15pt,0pt,0pt' style='font-size:10.2pt;'></v:TextBox>");
      newShape.appendChild(tempTextbox);
      //��������״ͼ�ϱ�����ֵ�����
      var temptext=document.createTextNode(dataarray[1][i]);
      //alert(dataarray[1][i]);
      tempTextbox.appendChild(temptext);
      group2.insertBefore(newShape);
    }
  }
  /**
   *@description ������ͼ��
   *@param       ��
   *@return      ͨ������true,���򷵻�false
  */
  function drawBars(){
    drawLinesX(4500);
    //������
    drawLinesY();
    //��X��Ŀ̶�
    drawBar(2.5,1,"blue");
  }
//-->
</script>

  <table border="0" align="center" cellpadding="5" cellspacing="0" class="common">
    <tr>


      <td align="left"><font color="#FF0080">&nbsp;ͳ������:<bean:write name="statStatusDto" property="startDate"/> -
                       <bean:write name="statStatusDto" property="endDate"/>&nbsp;&nbsp;
            <!--<input type=button name=bgetNew class='button' value="ˢ��" style="align:center" onclick="cmdOK_onclick();">-->

      </td>
    </tr>
  </table>
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr> <td colspan=4 class="formtitle">�ڵ�״̬ͳ��<td></tr>
     <tr>
         <td class="centertitle" >�ڵ�����</td>
         <td class="centertitle" >����Ա����</td>

         <td class="centertitle" >״̬����</td>
         <td class="centertitle" >����</td>

     </tr>
     <%int index=0;%>
     <%int rowindex=0;%>
     <%int nodecount=0; //�ж��ж��ٸ��ڵ�%>
     <%String nowName="";%>
     <%String oldName="";%>

     <logic:notEmpty  name="statStatusDto"  property="statStatusList">
     <logic:iterate id="swfLogNode"  name="statStatusDto"  property="statStatusList">

<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");

%>
        <%  StatStatusDto statStatusDto1 = (StatStatusDto)list.get(rowindex);
           nowName=statStatusDto1.getNodeTypeName();
         %>
        <%if (nowName.equals(oldName))
            {
            %>
       <tr class=common>     <td align="center"></td>
            <%}else{

            //����һ��
            nodecount++;
            out.print("</tr>");
            if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");

            %>

         <td align="center">
         <bean:write name="swfLogNode" property="nodeTypeName"/>
         </td>

          <%}%>

        <%
        oldName=nowName;
        %>

        <td align="center"><bean:write name="swfLogNode" property="userName"/></td>
        <td align="center"><bean:write name="swfLogNode" property="statusName"/></td>
        <td align="center"><bean:write name="swfLogNode" property="count"/></td>


      </tr>
<%        index++;
          rowindex++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="5">
	       ����ѯ��<%= nodecount %>�����������ļ�¼
	      </td>
      </tr>
    </table>
    </tr>
  </table>


<script language = "javascript">
<!--
 // drawBars();
//-->
</script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
<html>
