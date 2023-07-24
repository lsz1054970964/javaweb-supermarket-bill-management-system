<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>Bill management page >> modify bill</span>
    </div>
    <div class="providerAdd">
        <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/static/jsp/bill.do">
            <input type="hidden" name="method" value="modifysave">
            <input type="hidden" name="id" value="${bill.id }">
            <div class="">
                <label for="billCode">bill code：</label>
                <input type="text" name="billCode" id="billCode" value="${bill.billCode }" readonly="readonly">
            </div>
            <div>
                <label for="productName">product name：</label>
                <input type="text" name="productName" id="productName" value="${bill.productName }">
                <font color="red"></font>
            </div>
            <div>
                <label for="productUnit">product unit：</label>
                <input type="text" name="productUnit" id="productUnit" value="${bill.productUnit }">
                <font color="red"></font>
            </div>
            <div>
                <label for="productCount">product count：</label>
                <input type="text" name="productCount" id="productCount" value="${bill.productCount }">
                <font color="red"></font>
            </div>
            <div>
                <label for="totalPrice">total price：</label>
                <input type="text" name="totalPrice" id="totalPrice" value="${bill.totalPrice }">
                <font color="red"></font>
            </div>
            <div>
                <label for="providerId">provider：</label>
                <input type="hidden" value="${bill.providerId }" id="pid" />
                <select name="providerId" id="providerId">
                </select>
                <font color="red"></font>
            </div>
            <div>
                <label >is paid：</label>
                <c:if test="${bill.isPayment == 1 }">
                    <input type="radio" name="isPayment" value="1" checked="checked">not paid
                    <input type="radio" name="isPayment" value="2" >paid
                </c:if>
                <c:if test="${bill.isPayment == 2 }">
                    <input type="radio" name="isPayment" value="1">not paid
                    <input type="radio" name="isPayment" value="2" checked="checked">paid
                </c:if>
            </div>
            <div class="providerAddBtn">
                <input type="button" name="save" id="save" value="save">
                <input type="button" id="back" name="back" value="back" >
            </div>
        </form>
    </div>

</div>
</section>

<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billmodify.js"></script>
