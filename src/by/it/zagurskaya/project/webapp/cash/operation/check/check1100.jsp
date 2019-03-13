<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <br>
    <br>
    <H4>Рассходный кассовый ордер</H4>
    <p>${userOperation.specification}</p>
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        <div class="row">   <div class=col-md-2>|      Дебет счета</div>
                            <div class=col-md-2>|      Кредит счета</div>
                            <div class=col-md-2>|      Kод валюты</div>
                            <div class=col-md-2>|      Сумма валюты</div>
                            <div class=col-md-3>|      валюта прописью</div>
                            <div class=col-md-1>|</div></div>
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        <c:forEach items="${userEntriesList}" var="userEntriesList" >
            <div class="row">
                <div class="col-md-2">|      ${userEntriesList.accountDebit}</div>
                <div class="col-md-2">|      ${userEntriesList.accountCredit}</div>
                <div class="col-md-2">|      ${userEntriesList.currencyId}</div>
                <div class="col-md-2">|      ${userEntriesList.sum}</div>
                <div class="col-md-3">|
                    <c:forEach items="${currencyList}" var="currency">
                    <c:if test="${userEntriesList.currencyId==currency.id}" > ${currency.name} </c:if>
                    </c:forEach>
                </div>
                <div class="col-md-1">|  </div>
            </div>
        </c:forEach>
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------
</div>
</body>
</html>
