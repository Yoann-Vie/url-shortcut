<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<% throw new RuntimeException("Error condition!!!"); %>

<t:layout>
  <jsp:body>
      <p>Voici votre url raccourcie : <c:out value="${url.getShortcutUrl()}"/></p>
  </jsp:body>
</t:layout>