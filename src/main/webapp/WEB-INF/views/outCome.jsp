<%@ page import="za.ac.tut.u220390519.customerapp.model.customer.Customer" %>
<%@ page import="za.ac.tut.u220390519.customerapp.model.customerIncome.CustomerIncome" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<script>
    Swal.fire(
        'Good job!',
        'The Excel file has been read and successfully stored in MySql Data Base!',
        'success'
    )

</script>


<%
    List<CustomerIncome> customerIncomes = (List<CustomerIncome>) request.getAttribute("customers");
    Customer customer = (Customer) request.getAttribute("customer");

    String firstName = customer.getFirstName();
    String lastName = customer.getLastName();
    %>
<H3>Income for customer : <%=firstName%> <%=lastName%>

    <br/><br/><br/>


    <table class="table">
        <thead class="table-dark">
        <tr>
            <th scope="col">Months</th>
            <th scope="col">Incomes</th>
            <th scope="col">Expenses</th>
        </tr>
        </thead>

        <%

            for (CustomerIncome customerIncome: customerIncomes) {
                String months = customerIncome.getMonth();
                String incomes = customerIncome.getIncome();
                String expenses = customerIncome.getExpenses();

        %>

        <tbody>
             <tr>
                 <td><%=months%></td>
                 <td><%=incomes%></td>
                 <td><%=expenses%></td>
            </tr>
        </tbody>


<%}%>
    </table>

</body>
</html>