<%-- 
    Document   : search.jsp
    Created on : Jul 16, 2018, 7:24:22 AM
    Author     : Mochi
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <s:if test="%{#session.USERNAME == null}">
            <c:redirect url="login.html"/>
        </s:if>
        <s:else>
        <font color="red">
        Welcome, <s:property value="%{#session.USERNAME}"/>
        </font>
        <h1>Search Page</h1>
        <s:form action="logout">
            <s:submit value="Log out"/>
        </s:form>
        <s:form action="search">
            <s:textfield label="Min" name="min" value="%{min}"/>
            <s:textfield label="Max" name="max" value="%{max}"/>
            <s:submit value="Search"/>
        </s:form>
        
        <s:if test="%{!min.isEmpty() && !max.isEmpty()}">
            <s:if test="%{product != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>ReleaseDate</th>
                            <th>ExpiredDate</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="product" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="name"/>
                                </td>
                                <td>
                                    <s:property value="description"/>
                                </td>
                                <td>
                                    <s:property value="price"/>
                                </td>
                                <td>
                                    <s:property value="release"/>
                                </td>
                                <td>
                                    <s:property value="expired"/>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                <font color="red">
                    No record is matched!
                </font>
            </s:else>
        </s:if>
        </s:else>
    </body>
</html>
