<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/../include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/../include/menucashnew.jsp" %>
    <br>
    <pre>
    ОАО"ТестБанк"
    Рег. N ГНИ ККС 123456789
        КАССОВЫЙ  ЧЕК   N ${userOperation.id}
    дата ${userOperation.timestamp}
    ПРОДАЖА НАЛИЧНОЙ ВАЛЮТЫ ЗА НАЛИЧНЫЕ БЕЛ.РУБЛИ
    Курс операции           ${userOperation.rate}
  <c:forEach items="${userEntriesList}" var="userEntriesList" ><c:if test="${userEntriesList.currencyId!=933}" >
    +--------------------------------------------------+
    |К выдаче Клиенту                                  |
    +--------------------------------------------------+
    |<c:forEach items="${currencyList}" var="currency"><c:if test="${userEntriesList.currencyId==currency.id}" > ${currency.name} </c:if></c:forEach>в сумме ${userEntriesList.sum}                   |
    +--------------------------------------------------+</c:if><c:if test="${userEntriesList.currencyId==933}" >
    |Внесено Клиентом                                  |
    +--------------------------------------------------+
    |<c:forEach items="${currencyList}" var="currency"><c:if test="${userEntriesList.currencyId==currency.id}" > ${currency.name} </c:if></c:forEach>в сумме ${userEntriesList.sum}                   |
    +--------------------------------------------------+
    </c:if></c:forEach>Кассир /код:   ${user.login} / ${user.id}
    </pre>
</div>
</body>
</html>
