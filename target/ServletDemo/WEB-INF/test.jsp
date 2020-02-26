<html>
<body>
<p>Good Job</p>
<%
    if(request.getAttribute("name")!=null){
       String name = (String) request.getAttribute("name");

%>
<div>Welcome <%= name %> </div>
<div>Your name has <%=name.length()%> letters </div>
<% } %>
</body>
</html>