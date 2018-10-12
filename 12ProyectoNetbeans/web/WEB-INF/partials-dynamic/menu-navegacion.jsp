<%
    String item = request.getParameter("item");
%>
<header class="l-header">
    <div class="ed-container">
        <div class="ed-item">
            <a href="/"><img src="img/logo.png" class="logo"/></a>
        </div>
        <div class="ed-item">
            <div id="open-menu" class="hasta-web icon-menu"></div>
            <nav id="menu" class="menu-container">
                <div id="close-menu" class="icon-close hasta-web"></div>
                <ul class="ed-menu web-horizontal">
                    <!--En este caso nuestro contexto es 12ProyectoNetbeans-->
                    <li><a href="/12ProyectoNetbeans/" class="<% out.print(item.equals("inicio")?"selected":""); %>">inicio</a></li>
                    <li><a href="/12ProyectoNetbeans/nosotros.jsp" class="<% out.print(item.equals("nosotros")?"selected":""); %>">nosotros</a></li>
                    <li><a href="/12ProyectoNetbeans/productos" class="<% out.print(item.equals("productos")?"selected":""); %>">productos</a></li>
                    <li><a href="/12ProyectoNetbeans/carro.jsp" class="<% out.print(item.equals("carro")?"selected":""); %>">mi carro</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>