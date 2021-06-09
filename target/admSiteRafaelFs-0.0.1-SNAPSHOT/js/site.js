var url_site = "";

$(document).ready(function(){
	url_site = $('#contextPath').val()+'/adm.do?action=api';
});

function setData(data){
	var id = data.id;
	$('#nome-'+id).text(data.nome.trim());
	$('#descricao-'+id).text(data.descricao.trim());
	$('#conteudo-'+id).text(data.conteudo.trim());
	$('#img-'+id).text(data.img.trim());
	$('#EditModal').modal('toggle');
}

function addData(data){
	$('#EditModal').modal('toggle');
	$('#datax tbody').prepend('<tr class="even"><td>  <input type="hidden" id="_dataMod-'+data.id+'"  value="'+data.data_mod+'" / >  <p id="_id-'+data.id+'">'+data.id+'</p></td><td>  <p id="nome-'+data.id+'">'+data.nome+'</p>  </td><td>   <p id="descricao-'+data.id+'">'+data.descricao+'</p>  </td><td>   <p id="conteudo-'+data.id+'">'+data.conteudo+'</p>  </td><td>   <p id="img-'+data.id+'">'+data.img+'</p>  </td><td>  <a href="#" class="glyphicon glyphicon-edit" title="Editar "  onclick="angular.element(this).scope().editMe(event,'+data.id+')">Editar</a>   <a href="#" class="fa fa-trash" title="Excluir " onclick="angular.element(this).scope().deleteMe(event,'+data.id+')" > Excluir</a></td></tr>');
}

function getData(id){
	if(id == 0){ return {id:0, nome:'teste', descricao:'teste', conteudo:'teste', img:'teste'};}else{
	var nome = $('#nome-'+id).text().trim();
	var descricao = $('#descricao-'+id).text().trim();
	var conteudo = $('#conteudo-'+id).text().trim();
	var img = $('#img-'+id).text().trim();
	var dados = {id:id, nome:nome, descricao:descricao, conteudo:conteudo, img:img}; 
	return dados;
	}
}

function deleteMe(id){
		var nome = $('#nome-'+id);
		if(confirm('Deseja mesmo excluir o serviço '+nome.text().trim()+'?')){
		    nome.parent().parent('tr').fadeOut(2000).remove();
		    $.post(url_site,{id:id,nome:nome.text().trim(), act:'Dlt' }, function(ret){
		    	alert('Serviço "'+ret.id+' - '+ret.nome+'" excluído com sucesso');
		    },'json');
		}	
		
}

function insertMe(data){
	data.act = "Inst";
	$.post(url_site,data,function(ret){
		addData(ret);
	},'json');
}

function updateMe(data){
	data.act = "Updt";
	data.data_mod = $('#_dataMod-'+data.id).val().trim();
	$.post(url_site, data, function(ret){console.log(ret);},'json');
}