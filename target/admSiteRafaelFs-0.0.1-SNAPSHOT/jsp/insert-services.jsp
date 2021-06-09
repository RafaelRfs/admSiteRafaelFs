<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/layout/header.jsp" />
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<h2>Criação de Serviços: </h2>
<form action="adm.do?action=save" method="POST" >

<div class="form-group">
  <label for="nome">Nome:</label>
  <input type="text" class="form-control" id="nome" name="nome">
</div>

<div class="form-group">
  <label for="descricao">Descrição:</label>
  <input type="text" class="form-control" id="descricao" name="descricao">
</div>

<div class="form-group">
  <label for="conteudo">Conteudo:</label>
  <textarea class="form-control" rows="5" id="conteudo" name="conteudo"></textarea>
</div>

<div class="form-group">
  <label for="img">Imagem:</label>
  <input type="text" class="form-control" id="img" name="img">
</div>

<p><input type="submit" value="salvar" class="btn btn-primary"/></p>
</form>

<c:import url="/layout/footer.jsp" />