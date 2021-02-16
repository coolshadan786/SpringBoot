<html>
<head>
<%@include file="./base.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/css/image.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<div class="container mt-3 " >

		<div class="row">

			<div class="col-md-12">

				<h1 class="text-center mb-3">Welcome to CRUD App</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${product }" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.description }</td>
								<td class="font-weight-bold">&#x20B9; ${p.price }</td>
								<td> 
									<a href="update/${p.id }"><i class="fas fa-pen-nib text-primary mr-3"></i></a>
									<a href="delete/${p.id }"><i class="fas fa-trash text-danger"></i></a>									
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				
				<div class="conatiner text-center">
					<a href="addProduct" class="btn btn-outline-success">Add Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
