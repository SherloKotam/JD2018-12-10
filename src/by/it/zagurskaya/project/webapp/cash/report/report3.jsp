<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <H4>Реестр проданной иностранной валюты</H4>
    <p>${now}</p>
+----------------------------+----------------------------+-------------+-------------+----------------------------+-------------------------------------------+
                            <div class="row">
                            <div class=col-md-2>|Время операции</div>
                            <div class=col-md-2>|Валюта операции</div>
                            <div class=col-md-1>|Сумма</div>
                            <div class=col-md-1>|Курс </div>
                            <div class=col-md-2>|Описание</div>
                            <div class=col-md-3>|Расчетный счет получателя</div>
                            <div class=col-md-1>|</div></div>
+----------------------------+----------------------------+-------------+-------------+----------------------------+-------------------------------------------+
        <c:forEach items="${userOperation998}" var="userOperation" >
            <div class="row">
                <div class="col-md-2">|${userOperation.timestamp}</div>
                <div class="col-md-2">|
                    <c:forEach items="${currencies}" var="currency">
                    <c:if test="${userOperation.currencyId==currency.id}" > ${currency.name} </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-1">|${userOperation.sum}</div>
                <div class="col-md-1">|${userOperation.rate}</div>
                <div class="col-md-2">|${userOperation.specification}</div>
                <div class="col-md-3">|${userOperation.checkingAccount}</div>
                <div class="col-md-1">|</div>
            </div>
        </c:forEach>
+----------------------------+----------------------------+-------------+-------------+----------------------------+-------------------------------------------+
</div>
</body>
</html>
