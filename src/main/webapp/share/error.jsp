<div class="alert-container">
    <%
        String success = (String) request.getAttribute("successMessage");
        if (success != null && !success.isEmpty()) {
    %>    
    <div class="alert alert-success">
        <strong>Success:</strong> ${successMessage}
    </div>
    <% }%>
</div>

<div class="alert-container">
    <%
        String error = (String) request.getAttribute("errorMessage");
        if (error != null && !error.isEmpty()) {
    %>    
    <div class="alert alert-danger">
        <strong>Error:</strong> ${errorMessage}
    </div>
    <% }%>
</div>