<%-- 
    Document   : projectInfo
    Created on : 9/09/2024, 03:21:38 PM
    Author     : juann
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información de Proyectos</title>
    </head>
    <body>
        <h1>Información de Proyectos</h1>
        <form action="./ProjectServlet" method="POST">
            <table>
                <tr>
                    <td>ID del Proyecto</td>
                    <td><input type="text" name="projectId" value="${project.projectid}" /></td>
                </tr>
                <tr>
                    <td>Nombre del Proyecto</td>
                    <td><input type="text" name="projectName" value="${project.projectname}" /></td>
                </tr>
                <tr>
                    <td>Descripción del Proyecto</td>
                    <td><input type="text" name="projectDesc" value="${project.projectdesc}" /></td>
                </tr>
                <tr>
                    <td>Localidad</td>
                    <td><input type="text" name="projectPlace" value="${project.projectplace}" /></td>
                </tr>
                <tr>
                    <td>Presupuesto</td>
                    <td><input type="text" name="projectBudget" value="${project.projectbudget}" /></td>
                </tr>
                <tr>
                    <td>Número de Habitantes</td>
                    <td><input type="text" name="projectPop" value="${project.projectpop}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" />
                        <input type="submit" name="action" value="Editar" />
                        <input type="submit" name="action" value="Eliminar" />
                        <input type="submit" name="action" value="Buscar" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Nombre del Proyecto</th>
            <th>Descripción</th>
            <th>Localidad</th>
            <th>Presupuesto (USD)</th>
            <th>Número de Habitantes</th>
            <c:forEach items="${allProjects}" var="proj">
                <tr>
                    <td>${proj.projectid}</td>
                    <td>${proj.projectname}</td>
                    <td>${proj.projectdesc}</td>
                    <td>${proj.projectplace}</td>
                    <td>${proj.projectbudget}</td>
                    <td>${proj.projectpop}</td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${not empty searchResult}">
            <h2>Resultado de la Búsqueda</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre del Proyecto</th>
                        <th>Descripción</th>
                        <th>Localidad</th>
                        <th>Presupuesto</th>
                        <th>Número de Habitantes</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${searchResult.projectid}</td>
                        <td>${searchResult.projectname}</td>
                        <td>${searchResult.projectdesc}</td>
                        <td>${searchResult.projectplace}</td>
                        <td>${searchResult.projectbudget}</td>
                        <td>${searchResult.projectpop}</td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <br>
    </body>
</html>

