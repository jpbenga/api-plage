<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="include/header.jsp"></jsp:include>
<link href="style/parasol.css" rel="stylesheet">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<jsp:include page="include/nav.jsp"></jsp:include>
    <h1>Liste des parasols</h1>
    <form>
        <select name="ID_FILE">
            <option value="0">Toutes les files</option>
            <c:forEach items="${files}" var="file">
                <option value="${file.id}"
                    <c:if test="${file.id eq idFile}"> SELECTED</c:if>>${file.numero}</option>
            </c:forEach>
        </select> <input type="submit" value="Filtrer">
    </form>
    <ul>
        <!-- Le forEach ci-dessous parcourt le contenu de la page de parasols -->
        <c:forEach items="${pageDeParasols.content}" var="parasol">
            <li>${parasol.numEmplacement}en file ${parasol.file.numero}
                (${parasol.file.prixJournalier} &euro;) <a
                href="parasol?ID_PARASOL=${parasol.id}">Modifier</a>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${!pageDeParasols.isFirst()}">
    <a href="parasols?page=0&sort=${sort}">&#x23EE;</a>
    <a href="parasols?page=${pageDeParasols.number-1}&sort=${sort}">&#x23EA;</a>
    </c:if>
    Page ${pageDeParasols.getNumber()+1}
    <c:if test="${!pageDeParasols.last}">
    <a href="parasols?page=${pageDeParasols.number+1}&sort=${sort}">&#x23E9;</a>
    <a href="parasols?page=${pageDeParasols.totalPages - 1}&sort=${sort}">&#x23ED;</a>
    <h2>Parasols ${(pageDeParasols.size)*(pageDeParasols.number)+1} a ${(pageDeParasols.size)*(pageDeParasols.number)+pageDeParasols.numberOfElements} sur ${pageDeParasols.getTotalElements()}</h2>
    </c:if>
    <a href="parasol">Ajouter un parasol</a>
<jsp:include page="include/piedDePage.jsp"></jsp:include>
</body>
</html>