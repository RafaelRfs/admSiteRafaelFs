<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/layout/header.jsp" />
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="panel panel-default" ng-controller="editServices">
<div class="panel-heading" ng-controller="editServices"><h3>{{titlePage}}</h3></div>
<div class="panel-body">
<a href="#"  ng-click="editMe($event,0)" >Novo Serviço </a>
<display:table name="sessionScope.LIST_SERVICES" class="table" id="datax">
 
  <display:column  sortable="true" title=" Id"><c:out value="${index}"/>
  <input type="hidden" id="_dataMod-<c:out value="${datax.id}" />"  value='<c:out value="${datax.data_mod}" />' / >
  <p id="_id-<c:out value="${datax.id}" />"><c:out value="${datax.id}" /></p>
  </display:column>
  
  <display:column  sortable="true" title=" Serviço ">
  <p id="nome-<c:out value="${datax.id}" />"><c:out value="${datax.nome}" /></p>
  </display:column>
  
  <display:column sortable="true" title=" Descrição ">
   <p id="descricao-<c:out value="${datax.id}" />"><c:out value="${datax.descricao}" /></p>
  </display:column>
  
  <display:column  sortable="true" title=" Conteudo ">
   <p id="conteudo-<c:out value="${datax.id}" />"><c:out value="${datax.conteudo}" /></p>
  </display:column>
  
  <display:column  sortable="true" title=" Imagem " >
   <p id="img-<c:out value="${datax.id}" />"><c:out value="${datax.img}" /></p>
  </display:column>
  
  <display:column>
  <a href="#" class="glyphicon glyphicon-edit" title="Editar "  ng-click="editMe($event, <c:out value="${datax.id}" />)">Editar</a> 
  <a href="#" class="fa fa-trash" title="Excluir " ng-click="deleteMe($event,<c:out value="${datax.id}" />)" > Excluir</a>
  </display:column>
</display:table>
</div>

<div id="EditModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" ng-bind="tp">{{tp}}</h4>
      </div>
      <div class="modal-body">
					<form ng-submit="saveMe()">
						<div class="form-group">
							<label for="nome">Nome:</label> 
							<input type="text"
								class="form-control" id="nome" name="nome" ng-model="dataform.nome" ng-change="setNome()" value="{{dataform.nome}}">
						</div>

						<div class="form-group">
							<label for="descricao">Descrição:</label> <input type="text"
								class="form-control" id="descricao" name="descricao" ng-model="dataform.descricao" value="{{dataform.descricao}}">
						</div>

						<div class="form-group">
							<label for="conteudo">Conteudo:</label>
							<textarea class="form-control" rows="5" id="conteudo"
								name="conteudo" ng-model="dataform.conteudo" value="{{dataform.conteudo}}"></textarea>
						</div>

						<div class="form-group">
							<label for="img">Imagem:</label> <input type="text"
								class="form-control" id="img" name="img" ng-model="dataform.img" value="{{dataform.img}}">
						</div>

						<p>
							<input type="submit" value="salvar" class="btn btn-primary" />
						</p>
					</form>
				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="closeModal">Fechar</button>
      </div>
    </div>

  </div>
</div>
<!-- modal -->
</div>

<c:import url="/layout/footer.jsp" />