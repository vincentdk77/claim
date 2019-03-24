package com.sinosoft.claim.ui.view.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class UIImgTag extends TagSupport{

    private String type = "";

    public int doStartTag() throws JspException
    {
        String imgString ="";
        String type = this.getType();

        if (type.equals("must"))
          imgString = "markMustInput.jpg";
        else if (type.equals("common"))
           imgString = "bgCommon.gif";
        else if (type.equals("expand"))
           imgString = "butExpand.gif";
        else if (type.equals("collapse"))
           imgString = "butCollapse.gif";

        imgString = "<img src=\"/claim/images/" + imgString + "\">";

        JspWriter writer = pageContext.getOut();
        try{
            writer.print(imgString);
        }
        catch(IOException e){
            throw new JspException(e.toString());
        }
        // Evaluate the body of this tag
        return(EVAL_BODY_INCLUDE);
    }

    /**
     * Render the end of the hyperlink.
     * @return int
     * @exception JspException if a JSP exception has occurred
     */
    public int doEndTag() throws JspException{
        return(EVAL_PAGE);
    }

    /** Release any acquired resources. */
    public void release(){
        super.release();
        this.type = null;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
