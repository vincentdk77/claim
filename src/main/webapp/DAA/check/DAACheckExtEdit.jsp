<%--
****************************************************************************
* DESC       ��4.3.10  �鿱/���鿱��չҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-03
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>  
 
   <table class="common" align="center" width="100%"> 
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="CheckLossTextImg" onclick="showPage(this,CheckLossText)">
             �鿱��չ��Ϣ
        <br>
        <table class="common" align="center" id="CheckLossText" style="display:none">
          <tbody>
          
          <%//
          //modify by lixiang add 20050311 start
//reason:�鿱��չ��Ϣ����ɫ������֣�����һ����ȷ��ѡ��,������-1,��Ϊ�ж����Ϊ-1��js��дֵ
          %>
              <tr class=listeven>
                <td align="left" colspan=4>1�����ճ����ĳ��ƺ��롢�������š����ܺ����뱣�յ��������Ƿ����
                  <input type="radio" name="CheckExt01" value="1">��
                  <input type="radio" name="CheckExt01" value="0">��
                  <input type="radio" name="CheckExt01" value="2">��ȷ��
                  
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>2������ʱ���Ƿ��ڱ�����Ч������
                  <input type="radio" name="CheckExt02" value="1">��
                  <input type="radio" name="CheckExt02" value="0">��
                  <input type="radio" name="CheckExt02" value="2">��ȷ��
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>3������ʱ��ӽ����������ڵģ�������Ӧʱ��֤��
                  <input type="radio" name="CheckExt03" value="1">     ��
                  <input type="radio" name="CheckExt03" value="0">     ��
                  <input type="radio" name="CheckExt03" value="2">��ȷ��
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>4��ʵ��ʹ�������뱣������ע�����Ƿ�һ�£�
                  <input type="radio" name="CheckExt04" value="1">��
                  <input type="radio" name="CheckExt04" value="0">��
                  <input type="radio" name="CheckExt04" value="2">��ȷ��
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>5�����ճ�����ʻԱ����뱨���������Ƿ�һ��:
                  <input type="radio" name="CheckExt05" value="1">��
                  <input type="radio" name="CheckExt05" value="0">��
                  <input type="radio" name="CheckExt05" value="2">��ȷ��
                </td>
              </tr>
             <tr class="listodd">
               <td align="left" colspan=4>6�����ճ�����ʻԱ�ļ�ʻ֤�Ƿ���Ч��
                 <input type="radio" name="CheckExt06" value="1">��
                 <input type="radio" name="CheckExt06" value="0">��
                 <input type="radio" name="CheckExt06" value="2">��ȷ��
               </td>
             </tr>
             <tr class=listeven>
               <td align="left" colspan=4>7�����ճ�����ʻԱ׼�ݳ�����ʵ�ʼ�ʻ�����Ƿ������
                 <input type="radio" name="CheckExt07" value="1">��
                 <input type="radio" name="CheckExt07" value="0">��
                 <input type="radio" name="CheckExt07" value="2">��ȷ��
               </td>
             </tr>
             <tr class="listodd">
               <td align="left" colspan=4>8��ʹ�ø���ר�û�е�������ֳ�����Ա�Ƿ��й����йز��ź˷�����Ч����֤��
                 <input type="radio" name="CheckExt08" value="1">��
                 <input type="radio" name="CheckExt08" value="0">��
                 <input type="radio" name="CheckExt08" value="2">��ȷ��
               </td>
             </tr>
             <tr class=listeven>
               <td align="left" colspan=4>9����ʻӪҵ�Կͳ��ļ�ʻԱ�޹����й����������ź˷�����Ч�ʸ�֤�飺
                 <input type="radio" name="CheckExt09" value="1">��
                 <input type="radio" name="CheckExt09" value="0">��
                 <input type="radio" name="CheckExt09" value="2">��ȷ��
               </td>
             </tr>
             <tr class="listodd">
               <td align="left" colspan=4>10�����ճ�����ʻԱ�Ƿ�Ϊ������������ļ�ʻԱ��
                 <input type="radio" name="CheckExt10" value="1">��
                 <input type="radio" name="CheckExt10" value="0">��
                 <input type="radio" name="CheckExt10" value="2">��ȷ��
             </tr>
             <tr class=listeven>
               <td align="left" colspan=4>11�����ճ�����ʻԱ�Ƿ�Ϊ���պ�ͬԼ���ļ�ʻԱ��
                 <input type="radio" name="CheckExt11" value="1">��
                 <input type="radio" name="CheckExt11" value="0">��
                 <input type="radio" name="CheckExt11" value="2">��ȷ��
               </td>
             </tr>
             <tr class="listodd">
               <td align="left" colspan=4>12�����ճ�����ʻԱ�Ƿ�Ϊ�ƺ�ݳ���
                 <input type="radio" name="CheckExt12" value="1">��
                 <input type="radio" name="CheckExt12" value="0">��
                 <input type="radio" name="CheckExt12" value="2">��ȷ��
               </td>
             </tr>
              <tr class=listeven>
                <td align="left" colspan=4>13���¹ʳ�����ʧ�ۼ����¹��ֳ��ۼ��Ƿ��Ǻϣ�
                  <input type="radio" name="CheckExt13" value="1">��
                  <input type="radio" name="CheckExt13" value="0">��
                  <input type="radio" name="CheckExt13" value="2">��ȷ��
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>14�������߳����Ƿ�������б���˾���������⣺
                  <input type="radio" name="CheckExt14" value="1">��
                  <input type="radio" name="CheckExt14" value="0">��
                  <input type="radio" name="CheckExt14" value="2">��ȷ��
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>15���¹��Ƿ��漰����������������
                  <input type="radio" name="CheckExt15" value="1">��
                  <input type="radio" name="CheckExt15" value="0">��
                  <input type="radio" name="CheckExt15" value="2">��ȷ��
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>16���¹��Ƿ��漰�������Ʋ���ʧ��
                  <input type="radio" name="CheckExt16" value="1">��
                  <input type="radio" name="CheckExt16" value="0">��
                  <input type="radio" name="CheckExt16" value="2">��ȷ��
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>17���¹��Ƿ��漰��������Ա������
                  <input type="radio" name="CheckExt17" value="1">��
                  <input type="radio" name="CheckExt17" value="0">��
                  <input type="radio" name="CheckExt17" value="2">��ȷ��
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>18���Ƿ����������չ�˾Ͷ����
                  <input type="radio" name="CheckExt18" value="1">��
                  <input type="radio" name="CheckExt18" value="0">��
                  <input type="radio" name="CheckExt18" value="2">��ȷ��
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>19���¹ʳ����Ƿ����÷���װ�ã�
                  <input type="radio" name="CheckExt19" value="1">��
                  <input type="radio" name="CheckExt19" value="0">��
                  <input type="radio" name="CheckExt19" value="2">��ȷ��
                </td>
              </tr>
              
              <%//modify by lixiang add 20050311 end%>
							<%--��չ˵������--%>
							<input  name="CheckExt01Dis" type="hidden" value="���ճ����ĳ��ƺ��롢�����Ǻš����ܺ����뱣�յ����Ƿ����:">
							<input  name="CheckExt02Dis" type="hidden" value="����ʱ���Ƿ�����Ч����:">
							<input  name="CheckExt03Dis" type="hidden" value="����ʱ��ӽ����������ڵģ�������Ӧʱ��֤��:">
							<input  name="CheckExt04Dis" type="hidden" value="ʵ��ʹ�������뱣������ע�����Ƿ�һ��:">
							<input  name="CheckExt05Dis" type="hidden" value="���ճ�����ʻԱ����뱨���������Ƿ�һ��:">
							<input  name="CheckExt06Dis" type="hidden" value="���ճ�����ʻԱ�ļ�ʻ֤�Ƿ���Ч:">
							<input  name="CheckExt07Dis" type="hidden" value="���ճ�����ʻԱ׼�ݳ�����ʵ�ʼ�ʻ�����Ƿ����:">
							<input  name="CheckExt08Dis" type="hidden" value="ʹ��ר�û�е�������ֳ�����Ա�Ƿ��й��Һ˷�����Ч����֤:">
							<input  name="CheckExt09Dis" type="hidden" value="��ʻӪҵ�Կͳ��ļ�ʻԱ�޹������������ź˷�����Ч�ʸ�֤��:">
							<input  name="CheckExt10Dis" type="hidden" value="���ճ�����ʻԱ�Ƿ�Ϊ����������ļ�ʻԱ:">
							<input  name="CheckExt11Dis" type="hidden" value="���ճ�����ʻԱ�Ƿ�Ϊ���պ�ͬԼ���ļ�ʻԱ:">
							<input  name="CheckExt12Dis" type="hidden" value="���ճ�����ʻԱ�Ƿ�Ϊ�ƺ�ݳ�:">
							<input  name="CheckExt13Dis" type="hidden" value="�¹ʳ�����ʧ�ۼ����¹��ֳ��ۼ��Ƿ��Ǻ�:">
							<input  name="CheckExt14Dis" type="hidden" value="�����߳����Ƿ�������б���˾����:">
							<input  name="CheckExt15Dis" type="hidden" value="�¹��Ƿ��漰��������������:">
							<input  name="CheckExt16Dis" type="hidden" value="�¹��Ƿ��漰�������Ʋ���ʧ:">
							<input  name="CheckExt17Dis" type="hidden" value="�¹��Ƿ��漰��������Ա����:">
							<input  name="CheckExt18Dis" type="hidden" value="�Ƿ����������չ�˾Ͷ��:">							
							<input  name="CheckExt19Dis" type="hidden" value="�¹ʳ����Ƿ����÷���װ��:">							
							<input  name="CheckExt01Serial" type="hidden" value="1">
							<input  name="CheckExt02Serial" type="hidden" value="2">
							<input  name="CheckExt03Serial" type="hidden" value="3">
							<input  name="CheckExt04Serial" type="hidden" value="4">
							<input  name="CheckExt05Serial" type="hidden" value="5">
							<input  name="CheckExt06Serial" type="hidden" value="6">
							<input  name="CheckExt07Serial" type="hidden" value="7">
							<input  name="CheckExt08Serial" type="hidden" value="8">
							<input  name="CheckExt09Serial" type="hidden" value="9">
							<input  name="CheckExt10Serial" type="hidden" value="10">
							<input  name="CheckExt11Serial" type="hidden" value="11">
							<input  name="CheckExt12Serial" type="hidden" value="12">
							<input  name="CheckExt13Serial" type="hidden" value="13">
							<input  name="CheckExt14Serial" type="hidden" value="14">
							<input  name="CheckExt15Serial" type="hidden" value="15">
							<input  name="CheckExt16Serial" type="hidden" value="16">
							<input  name="CheckExt17Serial" type="hidden" value="17">
							<input  name="CheckExt18Serial" type="hidden" value="18">							
							<input  name="CheckExt19Serial" type="hidden" value="19">
          </tbody>
        </table>
      </td>
    </tr>
  </table>
