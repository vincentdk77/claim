<%--
****************************************************************************
* DESC       �����ձ�����ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-23
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="PolicyDAAPolicyFormatPrintIni.jsp"%>

<%int strLineLimit = 15;%>

<html>
  <head>
    <title>���ձ�����ӡ</title>
    <link rel="stylesheet" type="text/css" href="/ddccallweb/css/Standard.css">
  </head>
  
  <body style="font-size:9pt">
    <form id=fm>
      <!-- ���ⲿ�� -->  
      <table width="94%" align="center" cellspacing="0" cellpadding="0" border="0">
        <!--<tr>
        <td height="90px">
        </td>
        </tr>-->
		<td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
                <img src="/claim/images/LOGO.jpg"/>
          </td>
        <tr>
          <td align=center height="20" style="text-align:center; font-family:����; font-size:14pt;">  
            <b>�����������յ���������</b>
          </td>  
        </tr>
        <!--<tr>
          <td align=center height="30" style="text-align:center; font-family:����; font-size:14pt;">  
            <b><font size=2><%=strBigTitle%></font></b>
          </td>  
        </tr>-->
        <tr>
          <td align=right height="20" style="font-family:����; font-size:10pt;">
            ���յ���: <%=strPolicyNo%>
          </td>
        </tr>
        <tr>
          <td style="font-family:����; font-size:11pt;">              
            &nbsp;&nbsp;&nbsp;&nbsp;����Ͷ���������������Ͷ�����룬��ͬ�ⰴԼ���������շѣ����������ճб����ּ����Ӧ������ر�Լ���е��⳥���Ρ�
          </td>
        </tr>
      </table>
      
      <!-- Ͷ����Ϣ -->  
      <table border=1 width="94%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:9pt;">
        <tr>
          <td height=22 colSpan=2>&nbsp;�� �� �� �� </td>
          <td height=22 colspan=12 align=left>&nbsp;<%=strInsuredName%></td>
        </tr>
        <tr>
          <td width="4%" height=22 rowSpan=6 align="center">���ճ������</td>
          <td width="10%" height=22>&nbsp;���ƺ���</td>
          <td height=22 colspan=3>&nbsp;<%=strLicenseNo%> </td>
          <td width="10%" height=22>&nbsp;�����ͺ�</td>
          <td height=22 colspan=4>&nbsp;<%=strBrandName%></td>
          <td width="10%" height=22 colspan=2>&nbsp;��������</td>
          <td height=22 colspan=2>&nbsp;<%=strEngineNo%> </td>
        </tr>
        <tr>
          <td height=22>&nbsp;VIN ��</td>
          <td height=22 colspan=3>&nbsp;<%=strVINNo%></td>
          <td height=22>&nbsp;�� �� ��</td>
          <td height=22 colspan=4>&nbsp;<%=strFrameNo%></td>
          <td height=22 colspan=2>&nbsp;��������</td>
          <td height=22 colspan=2>&nbsp;<%=strCarKind%></td>
        </tr>
        <tr>
          <td height=22 colspan=3>&nbsp;�˶��ؿ�&nbsp;<%=strSeatCount%>&nbsp;��</td>
          <td height=22 colspan=3>&nbsp;�˶�������&nbsp;<%=strTonCount%>&nbsp;��
          <td height=22 colspan=4>&nbsp;����/����&nbsp;<%=strExhaustScale%>&nbsp;L/KW</td>
          <td height=22 colspan=3>&nbsp;��ʹ������&nbsp;<%=strUseYears%>&nbsp;��</td>
        </tr>
        <tr>
          <td height=22>���εǼ�����</td>
          <td height=22 colspan=3>&nbsp;<%=strEnrollDate%></td>
          <td height=22 colspan=4>&nbsp;����ʻ���&nbsp;<%=strRunMiles%>&nbsp;����</td>
          <td height=22 colspan=1>&nbsp;ʹ������</td>
          <td height=22 colspan=4>&nbsp;<%=strUseNature%></td>
        </tr>
        <tr>
          <td height=22>&nbsp;��ȫ����</td>
          <td height=22 colspan=7>&nbsp;<%=strSafeDevice%></td>
          <td height=22 colspan=1>&nbsp;�̶�ͣ�ŵص�</td>
          <td height=22 colspan=4>&nbsp;<%=strParkSite%></td>
        </tr>
        <tr>
          <td height=22>&nbsp;��ʻ����</td>
          <td height=22 colspan=7>&nbsp;<%=strRunAreaName%></td>
          <td height=22 colspan=1>&nbsp;�³����ü�</td>
          <td height=22 colspan=4>&nbsp;<%=strPurchasePrice%>Ԫ</td>
        </tr>
        <tr>
          <td height=22 width ="28%" colspan=9 align=center>&nbsp;�б�����</td>
          <td height=22 width ="28%" colspan=4 align=center>&nbsp;���ս��/�����޶�(Ԫ)</td>
          <td height=22 width="12%" align=center>&nbsp;���շ�(Ԫ)</td>
        </tr>
<%    
      //*****���������Ϣ��PrpTitemKind*****
      String strKindCode    = "";       //�ձ����
      String strKindCodeTmp = "";     //�ձ����ĵ�һ����ĸ
      String strKindCode1    = "";       //�������������ձ����
      String strFront       = "";     //���ڲ�ͬ���ձ��ڱ��ս��ǰ��������������
        String strMiddle      = "";     //���ڲ�ͬ���ձ�ı��ս��
      String strBack        = "";     //���ڲ�ͬ���ձ��ڱ��ս����������������
    boolean isA            = false;   //�Ƿ�Ͷ��A��  
        //reason:�����Ը���
        boolean isQ      = false;   //�Ƿ�Ͷ���Ը�����Լ��
        double  dValue        = 0;
        //modify by lirj update end 040522       
      
      //1.�ж��Ƿ�Ͷ��A��
    if(policyDtoOld.getPrpCitemKindDtoList()!=null){     
      for (index=0;index<intItemKindCount;index++)
      {
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)policyDtoOld.getPrpCitemKindDtoList().get(index);
        strKindCodeTmp = prpCitemKindDto.getKindCode().substring(0,1);
        if( strKindCodeTmp.equals("A") )
        {
          isA = true;
          //modify by lirj update begin 040522
                    //reason:�����Ը���
          dValue = prpCitemKindDto.getValue();
          if(dValue>0) 
          {
             isQ = true;
          }
          //modify by lirj update end 040522
          break;
        }
        else
          isA = false;
      }
    } 
      //2.���Ͷ����A�վͲ�����B�պ�ƴ�������
      for(index=0;index<strLineLimit;index++)
      {
        //���ӱ���ʱ�ڵ�һ�д�ӡ��ʾ��Ϣ
        if((index==0)&&(strCarType.equals("MultiCar")))   
        {
%>
        <tr>
          <td height=22 colspan=9>���ӱ���,����������յ�����</td>
          <td height=22 colspan=4></td>
          <td height=22></td>
        </tr>
<%
        }
        //��������ָ����ӡ��Χʱ�ڵ�һ�д�ӡ��ʾ��Ϣ
        else if((index==0)&&(intItemKindCount>strLineLimit))   
        {
%>        
        <tr>
           <td height=22 colspan=9>�б�������̫��,�����������</td>
           <td height=22 colspan=4></td>
           <td height=22></td>
        </tr>
<%      }
        else if((intItemKindCount<strLineLimit)&&
                (!strCarType.equals("MultiCar"))&&
                (index<intItemKindCount))
        {
  
          prpItemKindDto = (PrpCitemKindDto)policyDtoOld.getPrpCitemKindDtoList().get(index);
System.out.println("-------1---prpItemKindDto----"+prpItemKindDto.getKindName());          
          strKindCodeTmp = prpItemKindDto.getKindCode().substring(0,1);
          if( strKindCodeTmp.equals("B")&&(isA==true) ) 
            strKindCode = "B";
          else
            strKindCode = StringConvert.encode(prpItemKindDto.getKindCode());
          
          //������ʾ�ĵ�һ�������ձ𣬺�����������Ҫ��ʾ����
          if( strKindCodeTmp.equals("A")&&(isA==true)||strKindCodeTmp.equals("B")&&(!(isA==true)) )
          {
            if(strKindCode.length()>1)
            {
              strCode = StringConvert.encode(strKindCode.substring(1));
              strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
              strKindCode = strName; 
            }
            strKindCode1 = strKindCodeTmp;
          }
          else
            strKindCode1 = strKindCode;
          
          //����ÿ���ձ���Żݽ��
          dblTotalProfit = 0;
          if(policyDtoOld.getPrpCprofitDtoList()!=null){        
            for (index1=0;index1<intProfitCount;index1++)
            {
              prpProfitDto = (PrpCprofitDto)policyDtoOld.getPrpCprofitDtoList().get(index1);
              if(prpProfitDto.getKindCode().equals(strKindCode1)&& (prpProfitDto.getItemkindNo()==prpItemKindDto.getItemKindNo()))
               {
                dblTotalProfit += prpProfitDto.getTotalProfit();
                dblSumTotalProfit += prpProfitDto.getTotalProfit();
              }
            }
          }  
          
          //��������������
          if( strKindCode.equals("F") )         
          {
            if( prpItemKindDto.getModeCode().equals("2") )
            { 
              //strFront = "����";
              strFront = "";
              strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getAmount());
              strBack  = "";
        strMiddle = "";
            }
            else if( prpItemKindDto.getModeCode().equals("1") )
            {
              //strFront = "����";
              strFront = "";
              strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getAmount());
              strBack  = "";   
        strMiddle = "";
            }
            else
            {
              //strFront = "δ֪";
              strFront = "";
              strBack  = "";    
        	  strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getAmount());
            }
            if(prpItemKindDto.getAmount() == 0.00 || prpItemKindDto.getAmount() == 0.0){
            strMiddle = "0.00";
            }
            //System.out.println("checkpoint"+strMiddle);
          }
          else if( strKindCode.equals("T") )    //����ͣʻ��ʧ��
          {
            strFront = "";
            strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getUnitAmount());
            strBack  = "";
            strBack  = "/��*" + new DecimalFormat("0").format(prpItemKindDto.getQuantity()) + "��";         
          }
          else if( strKindCode.equals("D3") )
          {
            strFront = "";
            strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getUnitAmount());
            strBack  = "";
            strBack  = "/��*" + new DecimalFormat("0").format(prpItemKindDto.getQuantity()) + "��";         
          }      
          else if( strKindCode.equals("D1") )
          {
            strFront = "";
            strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getUnitAmount());
            strBack  = "";
            strBack  = "/��*" + new DecimalFormat("0").format(prpItemKindDto.getQuantity()) + "��";         
          }
          else
          {
            strFront = "";
            strMiddle = new DecimalFormat("#,##0.00").format(prpItemKindDto.getAmount());
            strBack  = "";        
          }           
          /*
          if(strKindCode.equals("M"))
                {
                  String strTemp = "(";
                  boolean bflag = false;
                  int intCount = 0;

                  if(policyDtoOld.getPrpCitemKindDtoList()!=null){
                    for(int j=0; j<intItemKindCount; j++)
                    {
                      PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto)policyDtoOld.getPrpCitemKindDtoList().get(j);
                      if(prpCitemKindDtoTemp.getFlag()!=null && prpCitemKindDtoTemp.getFlag().length()>4 &&prpCitemKindDtoTemp.getFlag().substring(4,5).equals("1"))
                      {
                        intCount ++;
                        if(intCount==3)
                        {
                          strTemp += "��";
                          break;
                        }
                        if(bflag)
                        {
                          strTemp += ","+StringConvert.encode(prpCitemKindDtoTemp.getKindName());
                        }else
                        {
                          strTemp += StringConvert.encode(prpCitemKindDtoTemp.getKindName());
                          bflag = true;
                        }
                      }
                    }      
                  }                  

                  strTemp += ")";
                  prpItemKindDto.setKindName(prpItemKindDto.getKindName()+strTemp);
                } 
*/                
        
          /*if(strMiddle.equals("0.00"))
          {
            strMiddle = ""; 
          }*/           
%>  
        <tr>
          <%-- �ձ� --%>
          <td height=22 colspan=9>
            <table border=0 width="100%" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:9pt;">
              <tr>
                <td width="75%">
                  &nbsp;<%=StringConvert.encode(prpItemKindDto.getKindName())%>(<%=strKindCode%>)
                </td>
                <td width="25%">
                  <%
                              if (dblTotalProfit > 0)
                          {
                                %>
                  �Ż�<%=new DecimalFormat("#,##0.00").format(dblTotalProfit)%>
                <%
                }  
                %>
                </td>
              </tr>
            </table>
          </td>
          <%-- ���� --%>
          <td height=22  colspan=4>
            <!-- ������ܻ��У��������ֿո� -->
            
            <table width="100%"  border="0"  style="font-family:����; font-size:9pt;">
              <tr>
                <td width="60%"><div align="right"><%=strFront%><%=strMiddle%><%=strBack%></div></td>
                <td></td>
              </tr>
            </table>
</td>   
          <%-- ���� --%> 
          <td height=22>
<table width="100%"  border="0"  style="font-family:����; font-size:9pt;">
              <tr>
                <td width="80%"><div align="right"><%=new DecimalFormat("#,##0.00").format(prpItemKindDto.getPremium())%></div></td>
                <td></td>
              </tr>
            </table>           
          </td>
        </tr>
<%    
        }
        else
        {
          //modify by lirj update begin 040522
            //reason:�����Ը���
            if(isQ)
            {
%>          
              <td height=22 colspan=9> &nbsp;������ʧ�Ը�����Լ����</td>
            <td height=22 colspan=4> &nbsp;�����Ը���<%=new DecimalFormat("#,##0.00").format(dValue)%></td>
            <td height=22> </td>
<%            
              isQ = false;
            }
          else
          {
%>      <tr>
          <td height=22 colspan=9> </td>
          <td height=22 colspan=4> </td>
          <td height=22> </td>
        </tr>
<%        }
         }
      }
%>
         <tr>
          <td height=22 colspan=14>
            <table border=0 width="100%" height="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:9pt;">
              <tr>
                <td width="70%">&nbsp;���շѺϼƣ�����Ҵ�д����<%=strCSumPremium%></td>
                <td width="20%" align=right>(����<%=strSumPremium%></td>
                <td width="10%" align=right>Ԫ)</td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td height=22 colspan=14>
            <table border=0 width="100%" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:9pt;">
              <tr>
                <td width="75%">
                  &nbsp;�����ڼ�&nbsp;��&nbsp;<%=strStartYear%>&nbsp;��&nbsp;<%=strStartMonth%>&nbsp;��&nbsp;<%=strStartDay%>&nbsp;��<%=strStartHour%>ʱ��&nbsp;��
                  &nbsp;<%=strEndYear%>&nbsp;��&nbsp;<%=strEndMonth%>&nbsp;��&nbsp;<%=strEndDay%>&nbsp;��<%=strEndHour%>ʱֹ      
                </td>
<%
              if(!(strCarType.equals("MultiCar")))   
              {
%>
                <td width="25%">
                   <%
                                if (dblSumTotalProfit>0)
                    {
                                %>
                  ���Żݽ�<%=new DecimalFormat("0.00").format(dblSumTotalProfit)%>
                <%
                     }  
                %>
                </td>
<%
              }
%>
              </tr>
            </table>
          </td>
        </tr>
        <tr class=normal>
          <td align="center">�ر�Լ��</td>
          <td colspan=13>
            <textarea name="Engage" rows=5.5 cols=80 class=readonlyWhite readonly  
            style="overflow:hidden;font-size:9pt;border=0;margin-left:10"><%=strClauses%>
            </textarea>
          </td>
        </tr>
        <tr>
          <td height=22 colspan=4>&nbsp;���պ�ͬ��������ʽ</td>
          <td height=22 colspan=10>&nbsp;<%=strArgueSolution%></td>
        </tr>
        <tr>
          <td align="center">��Ҫ��ʾ</td>
          <td colspan=13 height=40>
             &nbsp;1.�����պ�ͬ�ɱ������Ͷ���������յ����������ر�Լ����ɡ�
                <br>&nbsp;2.�յ������յ����б����ֶ�Ӧ�ı���������������˶ԣ����в�������©������48Сʱ��֪ͨ�����˲��������򲹳�����������48Сʱδ֪ͨ�ģ���ΪͶ���������顣
             <br>&nbsp;3.����ϸ�Ķ��б����ֶ�Ӧ�ı�������ر������������Ͷ���ˡ�������������
             <br>&nbsp;4.���ճ���ת����ת�á��������˻�����;��Ӧ����֪ͨ�����˲�������������
          </td>
        </tr>
        <tr>
          <td align="center" height=22>������</td>
          <td height=22 colspan=13>
            <table border=0 width="100%" height="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:9pt;">
              <tr>
                <td width="40%">&nbsp;��˾���ƣ�<%=strComCName%></td>
                <td width="60%" colspan=2>��˾��ַ��<%=strAddressCName%></td>
              </tr>
              <tr>
                <td>&nbsp;��������: <%=strPostCode%></td>
                <td>��ϵ�绰: </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>ǩ�����ڣ�<%=strOperateDate%></td>
                <td>��������ǩ�£�</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    
      <!-- ��β��Ϣ -->
      <table border=0 width="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:9pt;">
        <tr>
          <td width="33%">�˱��ˣ� <%=strUnderwriteName%></td>
          <td width="33%">�Ƶ��ˣ� <%=strOperatorCode%></td>
          <td width="33%">�����ˣ� <%=strHandlerCode%></td>
        </tr>
      </table>
        
      <%-- include��ӡ��ť --%> 
      <jsp:include page="/common/print/PrintButton.jsp" /> 
      
    </form>
  </body>
</html>
 