<%--
  Created by IntelliJ IDEA.
  User: Archibald
  Date: 04/11/2018
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<nav>
    <ul class="menu">

        <li><a>Cadastrar</a>
            <ul>
                <li><a href="controller?acao=cadastroCliente">Cliente</a></li>
                <li><a href="controller?acao=cadastroEmpresa">Empresa</a></li>

            </ul>
        </li>

        <li><a>Relatórios</a>
            <ul>
                <li><a href="controller?acao=relatorio&tipo=clienteEmpresa">Clientes por Empresa</a></li>
                <li><a href="controller?acao=relatorio&tipo=listaUsuarios">Lista de Usuários</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tickets por Cliente</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tickets sem Resposta por Cliente</a></li>
                <li><a href="controller?acao=relatorio">Lista de Tickets sem Resposta por Cliente</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tickets Resolvidos por Cliente</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tickets Reabertos por Cliente</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tópicos por Usuário</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tópicos sem Resposta</a></li>
                <li><a href="controller?acao=relatorio">Quantidade de Tópicos Marcados como Resolvidos</a></li>
            </ul>
        </li>

        <li><a>Tickets</a>
            <ul>
                <li><a href="controller?acao=listarTickets&tipo=todos">Todos</a></li>
                <li><a href="controller?acao=listarTickets&tipo=Aberto">Aberto</a></li>
                <li><a href="controller?acao=listarTickets&tipo=Fechado">Fechado</a></li>
                <li><a href="controller?acao=listarTickets&tipo=Andamento">Em Andamento</a></li>
            </ul>
        </li>

        <li><a>Tópicos</a></li>

        <li><a>Listar</a>
            <ul>
                <li><a href="controller?acao=listarClientes">Clientes</a></li>
                <li><a href="controller?acao=listarEmpresas">Empresas</a></li>
            </ul>
        </li>
    </ul>
    </ul>
</nav>

</body>
</html>