<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <br>
    <br>
    <br>
    <H4>Перечень валют</H4>
   ------------------------------------------------------------------------------------------
   <div class="row">   <div class=col-md-2>|      Номер</div>
                       <div class=col-md-2>|      ISO</div>
                       <div class=col-md-2>|      Наименование</div>
                       <div class=col-md-1>|</div></div>
   ------------------------------------------------------------------------------------------
       <c:forEach items="${currency}" var="currency" >
           <div class="row">
               <div class="col-md-2">|      ${currency.id}</div>
               <div class="col-md-2">|      ${currency.iso}</div>
               <div class="col-md-2">|      ${currency.name}</div>
               <div class="col-md-1">|  </div>
           </div>
       </c:forEach>
   ------------------------------------------------------------------------------------------
</div>
</body>
</html>
