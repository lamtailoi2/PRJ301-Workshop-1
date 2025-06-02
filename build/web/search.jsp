
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.USER}">
            <c:set var="fullName" value="${sessionScope.USER.fullName}" />
            <c:set var="role" value="${sessionScope.USER.role}" />
            <h1>Welcome ${fullName}</h1>
        </c:if>

        <a href="createMobile.html">Create new mobile</a>    

        <form action="DispatchController">
            <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" placeholder="Enter device name or id...." />
            <input type="hidden" name="txtRole" value="${role}" />
            <input type="submit" value="Search" name="btAction" />
        </form>

        <c:if test="${not empty param.txtSearchValue}">
            <c:choose>
                <c:when test="${not empty SEARCH_RESULT}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>YearOfProduction</th>
                                <th>Quantity</th>
                                <th>Not Sale</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="mobile" items="${SEARCH_RESULT}">
                                <tr>
                            <form action="DispatchController" method="POST">

                                <td>
                                    ${mobile.mobileId}
                                    <input type="hidden" name="txtMobileId" value="${mobile.mobileId}" />
                                </td>
                                <td>
                                    ${mobile.mobileName}
                                    <input type="hidden" name="txtMobileName" value="${mobile.mobileName}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPrice" value="${mobile.price}" />

                                </td>
                                <td>
                                    <input type="text" name="txtDescription" value="${mobile.description}" />

                                </td>
                                <td>
                                    <input type="text" name="txtYearOfProduction" value="${mobile.yearOfProduction}" />

                                </td>
                                <td>
                                    <input type="text" name="txtQuantity" value="${mobile.quantity}" />

                                </td>

                                <td> <input type="checkbox" name="txtNotSale" value="ON" ${mobile.notSale ? 'checked="checked"' : ''} /> </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="submit" value="Delete" name="btAction"/>
                                    <input type="hidden" name="lastSearchValue" value="${param.txtSearchValue}" />
                                    <input type="hidden" name="txtRole" value="${role}" />
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <h2>No Mobile Recorded</h2>
        </c:otherwise>
    </c:choose>
</c:if>



</body>
</html>
