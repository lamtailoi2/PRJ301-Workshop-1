
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop Page</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.USER}">
            <c:set var="fullName" value="${sessionScope.USER.fullName}" />
            <c:set var="role" value="${sessionScope.USER.role}" />
            <h1>Welcome ${fullName}</h1>
            <a href="cartView.jsp">View Your Cart</a>
        </c:if>

        <form action="DispatchController">
            <input type="number" min="1" name="txtMinPrice" value="${param.txtMinPrice}" placeholder="Enter min price...." />
            <input type="number" min="1" name="txtMaxPrice" value="${param.txtMaxPrice}" placeholder="Enter max price...." />
            <input type="hidden" name="txtRole" value="${role}" />
            <input type="submit" value="Search" name="btAction" />
        </form>
        <c:if test="${ (not empty param.txtMinPrice) && (not empty param.txtMaxPrice)}">
            <c:choose>
                <c:when test="${not empty requestScope.SEARCH_RESULT}">
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
                            <c:forEach items="${requestScope.SEARCH_RESULT}" var="mobile">
                                <tr>
                            <form action="DispatchController" method="POST">
                                <td>${mobile.mobileId}
                                    <input type="hidden" name="txtMobileId" value="${mobile.mobileId}" />
                                </td>
                                <td>${mobile.mobileName}
                                </td>
                                <td>${mobile.price}
                                </td>
                                <td>${mobile.description}
                                </td>
                                <td>${mobile.yearOfProduction}
                                </td>
                                <td>${mobile.quantity}
                                </td>
                                <td><input type="checkbox" name="txtNotSale" value="ON" ${mobile.notSale ? 'checked="checked"' : ''} readonly /></td>
                                <td>
                                    <input type="submit" value="Add To Cart" name="btAction" />
                                    <input type="hidden" name="txtRole" value="${role}" />
                                    <input type="hidden" name="lastMinPrice" value="${param.txtMinPrice}"  />
                                    <input type="hidden" name="lastMaxPrice" value="${param.txtMaxPrice}" />
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
