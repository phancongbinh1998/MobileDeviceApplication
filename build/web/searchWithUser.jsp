<%-- 
    Document   : searchWithUser
    Created on : Jul 12, 2018, 4:25:22 PM
    Author     : Mochi
--%>
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
            <%@include file="login.html" %>
        </s:if>  
        <s:else>
        <font color="red">
        Welcome, <s:property value="%{#session.USERNAME}"/>
        </font>
        </br>
        <s:form action="logout">
              <s:submit value="Log Out" />
        </s:form>
        <h1>Search With User</h1>
        
        <form action="searchInRange">
            Search Device With Price Range</br>
            Min <input type="text" name="min" value="${param.min}" /></br>
            Max <input type="text" name="max" value="${param.max}" /></br>
            <input type="submit" value="Search" />
        </form>
            <s:if test="%{!min.isEmpty() && !max.isEmpty()}">
                <s:if test="%{products != null}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>MobileId</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>MobileName</th>
                                <th>YearOfProduction</th>
                                <th>Quantity</th>
                                <th>IsSale</th>
                                <th>Add To Cart</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="products" status="counter">
                                <s:form theme="simple">
                                    <tr>
                                        <td>
                                            
                                            <s:property value="%{#counter.count}"/>
                                        </td>
                                        <td>
                                            <s:property value="mobileId"/>
                                            <s:hidden name="mobileId" value="%{mobileId}"/>
                                        </td>
                                        <td>
                                            <s:property value="description"/>
                                            
                                        </td>
                                        <td>
                                            <s:property value="price"/>
                                        </td>
                                        <td>
                                            <s:property value="mobileName"/>
                                        </td>
                                        <td>
                                            <s:property value="yearOfProduction"/>
                                        </td>
                                        <td>
                                            <s:property value="quantity"/>
                                        </td>
                                        <td>
                                           
                                            <s:checkbox name="chkSale" value="%{isSale}"/>
                                        </td>
                                        <td>
                                            <s:form action="addToCart">
                                                <s:submit value="Add To Cart"/>
                                                <s:hidden name="searchValueMin" value="%{min}" />
                                                <s:hidden name="searchValueMax" value="%{max}" />
                                                <s:hidden name="mobileName" value="%{mobileName}" />
                                            </s:form>
                                    
                                        </td>
                                    </tr>
                                    </s:form>
                                    
                            </s:iterator>
                        </tbody>
                    </table>

                </s:if>
           
                <s:else>
                    <h2>
                        <font color="red">No record is matched!!!</font>
                    </h2>
                </s:else>
                </s:if>
            <s:form action="addToCart">
                <s:submit value="View Your Cart"  />
            </s:form>
        </s:else>

    </body>
</html>
