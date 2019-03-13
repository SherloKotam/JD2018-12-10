<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <H4>Реестр купленной иностранной валюты</H4>
    <p>${now}</p>
--------------------------------------------+----------------------------+----------------------------+---------------------------+-----------------------------+
                            <div class="row">
                            <div class=col-md-3>|Время совершения операции</div>
                            <div class=col-md-2>|Наименование иностранной валюты</div>
                            <div class=col-md-2>|Сумма иностранной валюты</div>
                            <div class=col-md-2>|Курс покупки </div>
                            <div class=col-md-2>|Сумма к выдаче</div>
                            <div class=col-md-1>|</div></div>
--------------------------------------------+----------------------------+----------------------------+---------------------------+-----------------------------+
        <c:forEach items="${report1List}" var="report1" >
            <div class="row">
                <div class="col-md-3">|      ${report1.userOperation.timestamp}</div>
                <div class="col-md-2">|
                    <c:forEach items="${currencies}" var="currency">
                    <c:if test="${report1.userOperation.currencyId==currency.id}" > ${currency.name} </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-2">|      ${report1.userOperation.sum}</div>
                <div class="col-md-2">|      ${report1.userOperation.rate}</div>
                <div class="col-md-2">|      ${report1.sum933}</div>
                <div class="col-md-1">|  </div>
            </div>
        </c:forEach>
--------------------------------------------+----------------------------+----------------------------+---------------------------+-----------------------------+
</div>
</body>
</html>
