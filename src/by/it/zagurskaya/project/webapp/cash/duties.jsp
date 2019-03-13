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
    <br>
     <H4> ${messageDuties}</H4>
        --------------------------------------------------------------------------------------------------------------------------------------
        <div class="row">   <div class=col-md-2>|Пользователь</div>
                            <div class=col-md-3>|Время открытия</div>
                            <div class=col-md-2>|Номер смены</div>
                            <div class=col-md-2>|Признак закрытия</div>
                            <div class=col-md-1>|</div></div>
        --------------------------------------------------------------------------------------------------------------------------------------
                <div class="row">
                    <div class="col-md-2"> <c:forEach items="${users}" var="users">
                    <c:if test="${duties.userId==users.id}" >|${users.login} </c:if>
                    </c:forEach></div>
                    <div class="col-md-3">|${duties.timestamp}</div>
                    <div class="col-md-2">|${duties.number}</div>
                    <div class="col-md-2">|${duties.isClose}</div>
                    <div class="col-md-1">|</div>
                </div>
        --------------------------------------------------------------------------------------------------------------------------------------
    <br>
    <br>
        <form class="form-horizontal" action="do?command=Duties" method="post">
           <fieldset>
               <div class="form-group">
                 <div class="col-md-8">
                   <button id="open" name="open" class="btn btn-success">Открыть смену</button>
                   <button id="close" name="close" class="btn btn-danger">Закрыть смену</button>
                 </div>
               </div>
           </fieldset>
        </form>
</div>
</body>
</html>
