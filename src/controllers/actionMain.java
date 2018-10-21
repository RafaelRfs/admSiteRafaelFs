package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.google.gson.Gson;
import dao.DAO;
import forms.servsForm;

public class actionMain extends DispatchAction{
	private static String INSERTSERVICES = "insertservices";
	private static String LISTSERVICES = "listservices";
	private SessionFactory factory;
	
	public SessionFactory getFactory(){
		try{
		if(factory == null){
			factory = (new Configuration()).configure("hibernate.cfg.xml").buildSessionFactory();
		}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return factory;
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response) throws Exception {
		getListData(request);
		return mapping.findForward(LISTSERVICES);
	}
	
	public ActionForward insert(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response) throws Throwable{
		return mapping.findForward(INSERTSERVICES);
	}
	
	private void getListData(HttpServletRequest request){
		String busca =  request.getParameter("busca") != null ?  request.getParameter("busca").trim() : "";
		Integer page = request.getParameter("page") != null ? Integer.valueOf(request.getParameter("page").trim()) : 0;
		Integer limit = request.getParameter("limit") != null ? Integer.valueOf(request.getParameter("limit").trim()) : 20;
		page = (page < 0) ? 0 : page;
		limit = (limit < 5)? 5 : limit;
		Integer qtdPage = page * limit;
		Session session = getFactory().openSession();
	      Transaction tx = null;
	      try {
	      tx = session.beginTransaction();
	      TypedQuery<DAO> query = session.createQuery("FROM DAO WHERE nome LIKE :nome ORDER BY id DESC");	      
	      query.setParameter("nome", "%" + busca + "%");
	      query.setFirstResult(page);
	      query.setMaxResults(limit);
	      ArrayList<DAO> srvs = (ArrayList<DAO>) query.getResultList();
	      HttpSession sessionHttp = request.getSession();
	      sessionHttp.setAttribute("LIST_SERVICES", srvs); 
	      tx.commit();
	      }catch(HibernateException e){
	    	  if (tx!=null) tx.rollback();
	          e.printStackTrace(); 
	      }
	      finally {
	          session.close(); 
	      }
	}
	
	
	public void save(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws IOException {
		servsForm srvs = (servsForm) form; 
		Session session = getFactory().openSession();
		try{
		 Transaction tx = null;
		 DAO servico =  new DAO();
		 servico.setNome(srvs.getNome());
		 servico.setDescricao(srvs.getDescricao());
		 servico.setConteudo(srvs.getConteudo());
		 servico.setImg(srvs.getImg());
		 servico.setData_mod(new Date());
		 session.save(servico);
		 tx = session.beginTransaction();
		 session.getTransaction().commit();
		 response.sendRedirect("adm.do?action=list"); 
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	
	private servsForm recoveServ() {
		servsForm srvs = new servsForm();
		Session session =  getFactory().openSession();
		try {
			Transaction tx  = session.beginTransaction();
			@SuppressWarnings("unchecked")
			TypedQuery<DAO> query = session.createQuery("FROM DAO ORDER BY id DESC");	      
		      query.setFirstResult(0);
		      query.setMaxResults(1);
		      ArrayList<DAO> servs = (ArrayList<DAO>) query.getResultList();
		      srvs.setId(servs.get(0).getId());
		      srvs.setNome(servs.get(0).getNome());
		      srvs.setData_mod(servs.get(0).getData_mod().toString());
		      srvs.setDescricao(servs.get(0).getDescricao());
		      srvs.setConteudo(servs.get(0).getConteudo());
		      srvs.setImg(servs.get(0).getImg());
			tx.commit();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {session.close();}
		
		return srvs;
		
	}
	
	private servsForm insertServ(servsForm srvs) {
		Session session = getFactory().openSession();
		try {
			Transaction tx = null;
			DAO servico =  new DAO();
			 servico.setId(srvs.getId());
			 servico.setNome(srvs.getNome());
			 servico.setDescricao(srvs.getDescricao());
			 servico.setConteudo(srvs.getConteudo());
			 servico.setImg(srvs.getImg());
			 servico.setData_mod(new Date());
			 session.save(servico);
			 tx = session.beginTransaction();
			 session.getTransaction().commit();
			 srvs = recoveServ();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}	
		return srvs;
	}
	
	
	private void updateServ(servsForm srvs){
		Session session = getFactory().openSession();
		try{
		 Transaction tx = null;
		 DAO servico =  new DAO();
		 servico.setId(srvs.getId());
		 servico.setNome(srvs.getNome());
		 servico.setDescricao(srvs.getDescricao());
		 servico.setConteudo(srvs.getConteudo());
		 servico.setImg(srvs.getImg());
		 session.saveOrUpdate(servico);
		 tx = session.beginTransaction();
		 session.getTransaction().commit();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	
	
	private void deleteServ(servsForm srvs){
		Session session = getFactory().openSession();
		try{
		 Transaction tx = null;
		 DAO servico =  new DAO();
		 servico.setId(srvs.getId());
		 servico.setNome(srvs.getNome());
		 servico.setDescricao(srvs.getDescricao());
		 servico.setConteudo(srvs.getConteudo());
		 servico.setImg(srvs.getImg());
		 session.delete(servico);
		 tx = session.beginTransaction();
		 session.getTransaction().commit();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
		
	public void api(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response) throws IOException
		  {
		   servsForm srvs = (servsForm) form; 
		    String act = request.getParameter("act");
		    if(act.equals("Dlt")){
		    	deleteServ(srvs);
		    }
		    else if(act.equals("Updt")){
		    	updateServ(srvs);
		    }
		    else if(act.equals("Inst")) {
		    	srvs = insertServ(srvs);
		    }
		    String resposta = new Gson().toJson(srvs); 
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().println(resposta);
		}
	
}
