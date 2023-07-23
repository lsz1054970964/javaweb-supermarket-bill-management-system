<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/static/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>Your current page:</strong>
        <span>Bill management page >> add bill page</span>
    </div>
    <div class="providerAdd">
        <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/static/jsp/bill.do">
            <input type="hidden" name="method" value="add">
            <div class="">
                <label for="billCode">bill code：</label>
                <input type="text" name="billCode" class="text" id="billCode" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="productName">product name：</label>
                <input type="text" name="productName" id="productName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="productUnit">product unit：</label>
                <input type="text" name="productUnit" id="productUnit" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="productCount">product number：</label>
                <input type="text" name="productCount" id="productCount" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="totalPrice">total account：</label>
                <input type="text" name="totalPrice" id="totalPrice" value="">
                <font color="red"></font>
            </div>
            <div>
                <label >provider id：</label>
                <select name="providerId" id="providerId">
                </select>
                <font color="red"></font>
            </div>
            <div>
                <label >is paid：</label>
                <input type="radio" name="isPayment" value="1" checked="checked">not paid
                <input type="radio" name="isPayment" value="2" >paid
            </div>
            <div class="providerAddBtn">
                <input type="button" name="add" id="add" value="save">
                <input type="button" id="back" name="back" value="back" >
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/static/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billadd.js"></script>
