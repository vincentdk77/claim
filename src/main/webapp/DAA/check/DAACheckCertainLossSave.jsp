<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- ���水ť --%>              
<table id="buttonArea1" cellpadding="0" cellspacing="0" width="80%" style="display:" id="tablebutton">
  <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
  <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
  (2)�ݴ�  
  (5) "����"                  
  --%> 
  <tr>
  <%-- ���������ı��水ť���ĸ��ı�־--%>
    <td>
     
    </td>
  </tr> 
  <tr>
       <logic:notEqual name="prpLcheckDto" property="status" value="4">
              <td class=button style="width:20%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonCertainLossSave class='button' value="�ݴ�" onclick="return saveCertainLossForm(this);">
              </td>
                
      </logic:notEqual>
      <td class=button style="width:33%" align="center">
        <!--ȡ����ť-->
        <input type=button name=buttonCertainReturn class='bigbutton' value="���ز鿱" onclick="backSubPage('span_certa');backSubPage('span_check1');backSubPage('span_check2');" >
      </td>
  </tr>
</table>  