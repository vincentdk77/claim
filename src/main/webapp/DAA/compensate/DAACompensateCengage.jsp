<%--
****************************************************************************
* DESC       ���ر�Լ����ʾ����
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-05-20
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<script language="javascript">
//Add By caopeng  start 20051219
//
//��ť�����¼��������������ʾ
function buttonOnClick1(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//����
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}
//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage2(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID);
  var strTemp = span.id;
  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y

  ex = ex - 520;

  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;

  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
}
//Add By caopeng  end 20051219
</script>
<!--������ʾ��¼����������������ʾ��-->   
   <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
          name="EngageImg" onclick="showPage(this,spanEngage)">�ر�Լ��<br>
        <span style="display:none">
          <table id="Engage_Data">
            <tbody>   
            </tbody> 
          </table>
        </span>

        <span id="spanEngage" style="display:none">
          <table class=common cellpadding="5" cellspacing="1" id="Engage">
            <thead>
              <tr>
                <td class="centertitle">���</td>
                <td class="centertitle">��Լ����</td>
                <td class="centertitle" colspan="3">��Լ����</td>
              </tr>
            </thead>
            <tbody>
            <% 
              int indexEngage=0;
              int i = 1; 
              com.sinosoft.claim.dto.domain.PrpCengageDto prpCengageDto = (com.sinosoft.claim.dto.domain.PrpCengageDto)request.getAttribute("prpCengageDto");
              java.util.Collection collectionTemp1 = prpCengageDto.getPrpCengageList();
              java.util.Iterator iteratorTemp1 = collectionTemp1.iterator();
              while(iteratorTemp1.hasNext()){ 
              com.sinosoft.claim.dto.domain.PrpCengageDto prpCengageDtoTemp = (com.sinosoft.claim.dto.domain.PrpCengageDto)iteratorTemp1.next();
            %>  
              <tr>
             <%--   <td class="centertitle"><%= prpCengageDtoTemp.getSerialNo() %></td>  --%>
                <td class="centertitle"><%= i %></td>
                <td class="centertitle"><%= prpCengageDtoTemp.getClauseCode() %></td>
                <td class="centertitle"><%= prpCengageDtoTemp.getClauses() %></td> 
                <td class="centertitle"><input type=button class=button ACCESSKEY="." num=<%=indexEngage%>  value='����' name='button_Engage_Open_Context'
                      onclick="buttonOnClick1(this);"> 
                 <span id="span_Engage_Context" style='width:520;display:none;position:absolute;background-color:FFFFFF;'>
                    <table class="common">
                       <tr><td class="prompttitle" colspan="6">�ر�Լ����ϸ��Ϣ</td> </tr>
                      <tr> 
                          <td class="prompt" colspan="6"><%= prpCengageDtoTemp.getContext() %></td>
                      </tr>              
                 
                       <tr>  
                        <td colspan=6 class="common" >
                         <input type=button class=button  name = 'button_Engage_Close_Context' value='(O)�ر�' ACCESSKEY="O"  onclick="hideSubPage(this,'span_Engage_Context')">  
                        </td> 
                      </tr>
                    </table> 
                     
                  </span>
                </td>
              </tr>
               <% 
               indexEngage++;   i++;
                }
               %>
            </tbody>
          </table>
        </span>
      </td>
    </tr>
  </table>
 
  
