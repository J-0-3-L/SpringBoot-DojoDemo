<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Ninja</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/' />">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/dojos' />">Dashboard</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <div class="card border rounded shadow">
                    <div class="card-body">
                        <form action="<c:url value='/ninjas/new' />" method="post">
                            <div class="form-group">
                                <label for="dojo">Dojo:</label>
                                <select name="dojo_id" class="form-control" required>
                                    <c:forEach items="${dojos}" var="dojo">
                                        <option value="${dojo.id}">${dojo.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="firstName">FirstName:</label>
                                <input type="text" name="firstName" value="${ninja.firstName}" class="form-control"  minlength="3" required>   
                            </div>
                            <div class="form-group">
                                <label for="lastName">LastName:</label>
                                <input type="text" name="lastName" value="${ninja.lastName}" class="form-control" minlength="3" required>   
                            </div>
                            <div class="form-group">
                                <label for="age">Age:</label>
                                <input type="number" name="age" value="${ninja.age}" class="form-control" required>   
                            </div>
                            <button type="submit" class="btn btn-primary">CREATE</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>