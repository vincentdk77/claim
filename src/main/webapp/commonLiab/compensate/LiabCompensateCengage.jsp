<%--
****************************************************************************
* DESC       ：特别约定显示画面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-05-20
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--建立显示的录入条，可以收缩显示的-->   
<%@ page import="java.util.*"%>
   <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
          name="EngageImg" onclick="showPage(this,spanEngage)">特别约定<br>
        <span style="display:none">
          <table id="Engage_Data">
            <tbody>   
            </tbody>
          </table>
        </span>

        <span id="spanEngage" style="display:none">
          <table class="sub" style='width:100%' id="Engage">
            <thead>
              <tr>
                <td class="centertitle">序号</td>
                <td class="centertitle">特约代码</td>
                <td class="centertitle" colspan="3">特约名称</td>
              </tr>
            </thead>
            <tbody>
            
            <% 
              int indexEngage=0; 
              PrpCengageDto prpCengageDto = (PrpCengageDto)request.getAttribute("prpCengageDto");
              Collection collectionTemp1 = prpCengageDto.getPrpCengageList();
              Iterator iteratorTemp1 = collectionTemp1.iterator();
              while(iteratorTemp1.hasNext()){ 
              PrpCengageDto prpCengageDtoTemp = (PrpCengageDto)iteratorTemp1.next();
            %>  
            
              <tr class=oddrow>
               <td class="centertitle"><%= prpCengageDtoTemp.getSerialNo() %></td>
                <td class="centertitle"><%= prpCengageDtoTemp.getClauseCode() %></td>
                <td class="centertitle"><%= prpCengageDtoTemp.getClauses() %></td> 
                <td class="centertitle"><input type=button ACCESSKEY="." value='...' class="smallbutton" name='button_Engage_Open_Context'
                      onclick="buttonOnClick1(this);">
                  <span id="span_Engage_Context"
                        style='width:520;display:none;position:absolute;background-color:FFFFFF;'>
                    <table class=sub>
                      <tr> 
                          <td class="prompt" colspan="6"><%= prpCengageDtoTemp.getContext() %></td>
                      </tr>    
                      <tr> 
                        <td colspan=2 align=center>
                          <input type=button name = 'button_Engage_Close_Context' class="button" value='(O)确定'
                            ACCESSKEY="O"
                            onclick="hideSubPage(this,'span_Engage_Context')">
                        </td>
                      </tr>
                    </table>   
                  </span>
                </td>
              </tr>

            </tbody>
             <% 
               indexEngage++; 
                }
               %>
          </table>
        </span>
      </td>
    </tr>
  </table>
 
  
