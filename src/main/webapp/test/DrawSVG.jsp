<?xml version="1.0" standalone="no"?>
<%String testString = "ddd";%>  
<svg width="500" height="300" xmlns="http://www.w3.org/2000/svg">
   <!-- Box around the image -->
  <rect x="1" y="1" width="498" height="298"
        fill="none" stroke="blue" stroke-width="2" />
  <rect x="0" y="25" width="450" height="120"
        fill="none" stroke="blue" stroke-width="2" />

  <% out.println("<text x='15' y='50'>JSP create code</text>");%>      
  <!-- Visible path -->
  <path d="M0,300 S150,100 200,200 S400,400 500,0"
        fill="none" stroke="red" stroke-width="2"  />
  <!-- Group of elements to animate -->
  <g stroke-width="5" stroke="black">
      <!-- Stick figure pieces -->
    <circle cx="0" cy="-45" r="10" fill="black"/>
    <line x1="-20" y1="-30" x2="0" y2="-25"/>
    <line x1="20" y1="-30" x2="0" y2="-25"/>
    <line x1="-20" y1="0" x2="0" y2="-10"/>
    <line x1="20" y1="0" x2="0" y2="-10"/>
    
    <line x1="0" y1="-10" x2="0" y2="-45"/>
    <%System.out.println("testString="+testString);%>	
    
    <!-- Animation controls -->	
    <animateMotion path="M0,300 S150,100 200,200 S400,400 500,0" 
                   dur="8s" repeatCount="indefinite"
                   rotate="auto" />
  </g>
</svg>
