<%--
****************************************************************************
* DESC       ����ʾʵ������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  <%
     String disabledFlag1="";
  
  if(editType.equals("SHOW")){
     disabledFlag1="disabled";
  %>
  <%  
  }else if(editType.equals("EDIT")){
  %>
  <%
  }
  %>
<script language="JavaScript">

</script>

   <table class="common" align="center" width="100%" >
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">���������
        <br>
        <table class="common" align="center" id="RegistText" style="display:none">
          <tbody>
            <tr>
              <td class="input" style="text-align:center;" colspan="0">
              <%
                     //����Ǵ�˫��ϵͳ������,������ʾ�������㱨�水ť. 2005-08-11
                     if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3161,3162,3164,3186,3185,3166,3184,3149,3177,3150,3148,3174,3151,3152,3153,3154,3155,3156,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3179,3187,3158,3178,3176".indexOf(riskCode) > -1)&&hasHeadInsureList) {
                 %>
<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextInnerHTML" readonly><bean:write name="prpLctextDto" property="context"/></textarea>  
                <%
                     }else if(null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1){
                 %>
<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextInnerHTML" readonly><bean:write name="prpLctextDto" property="context"/></textarea>  
                <%
                     }else{
                %>
<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextInnerHTML"><bean:write name="prpLctextDto" property="context"/></textarea>                               
                 <br>
                 <%  }
                     //����Ǵ�˫��ϵͳ������,������ʾ�������㱨�水ť. 2005-08-11
                     if(("3101,3107,3108,3122,3114,3126,3143,3145,3149,3177,3151,3161,3162,3164,3197,3152,3153,3154,3155,3156,3191,3172,3194,3193,3187,3178,3158,3179,3176".indexOf(riskCode) > -1)&&hasHeadInsureList) {
                 %>
                     <input type="button" class=bigbutton name="buttonGenerateCtext" value="�������������" <%=disabledFlag1%> onclick="GenerateCtextFlag('0');generateCtext(fm.prpLcompensatePolicyNo);">
                     <input type="hidden" name="buttonGenerateCtextFlag" value="0"/>
                <%
                     }else if((null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1) || ("3139,3142,3144,3146,3186,3185,3166,3184,3150,3148,3174,3224,3190,3173,3232,3134,3157,3181,3170,31A6,3163,3182".indexOf(riskCode)>-1)){
                     //3142 �۹���3146 �ջ���3186 ��ݮ��3139 ʯ��3144 ӣ�� ������㹫ʽ��ͬ�����������Ա���������㹫ʽ
                 %>
                     <input type="button" class=bigbutton name="buttonGenerateCtext" value="�������������" <%=disabledFlag1%> onclick="GenerateCtextFlag('0');generateAgriPlanting31Ctext(fm.prpLcompensatePolicyNo);">
                     <input type="hidden" name="buttonGenerateCtextFlag" value="0"/>
                <%                     
                     }else if(("3132".indexOf(riskCode) > -1)&&hasHeadInsureList)
                    	 
                     {
                %>
                      <input type="button" class=bigbutton name="buttonGenerateCtext" value="�������������" <%=disabledFlag1%> onclick="GenerateCtextFlag('0');generateCtext(fm.prpLcompensatePolicyNo);">
                     <input type="hidden" name="buttonGenerateCtextFlag" value="0"/>
                
                <% 
                     }
                %>
                
              </td>
            </tr>  
          </tbody>
        </table>
      </td>
    </tr>
  </table>

  
  
 