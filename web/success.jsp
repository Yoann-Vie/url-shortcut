<%@page errorPage="error.jsp" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
//    Throw an exception to invoke the error page
//    int x = 1;
//    if (x == 1) {
//        throw new RuntimeException("Error condition!!!");
//    }
%>

<t:layout>
  <jsp:body>
        <p>Voici votre url raccourcie : <a href="<c:out value="${url.getShortcutUrl()}"/>"><c:out value="${url.getShortcutUrl()}"/></a></p>
  </jsp:body>
</t:layout>