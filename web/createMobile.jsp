
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Mobile</title>
    </head>
    <body>
        <c:set var="errors" value="${requestScope.CREATE_ERRORS}" />
        <h1>Create New Mobile</h1>
        <form action="DispatchController" method="POST">
            Id<input type="text" name="txtMobileId" value="" /> <br />
            <p style="color: red"> ${errors.idIsExisted} </p>
            Name<input type="text" name="txtMobileName" value="" /> <br />
            <p style="color: red"> ${errors.mobileNameLengthError} </p>
            Price<input type="text" name="txtMobilePrice" value="" /> <br />
            <p style="color: red"> ${errors.priceIsNotPositiveNumber} </p>
            Description<input type="text" name="txtDescription" value="" /> <br />
            <p style="color: red"> ${errors.descriptionLengthError} </p>
            Quantity<input type="text" name="txtQuantity" value="" /> <br />
            <p style="color: red"> ${errors.quantityIsNotPositiveNumber} </p>
            YearOfProduction<input type="text" name="txtYearOfProduction" value="" /> <br />
            <p style="color: red"> ${errors.yearOfProductionIsNotPositiveNumber} </p>
            NotSale<input type="checkbox" name="txtNotSale" value="ON" /> <br />
            <input type="submit" value="Create" name="btAction" />
        </form>
    </body>
</html>
