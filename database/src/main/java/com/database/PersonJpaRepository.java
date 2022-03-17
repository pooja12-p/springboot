package com.database;
	import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
	//import java.util.List;

	@Repository
	@Transactional
	public class PersonJpaRepository {
		
	@PersistenceContext
	 EntityManager entitymanager;   
	//public PoojaPerson findById(int id) {
		//return entityManager.find(PoojaPerson.class, id);
	
		public Object findById(int id) {
			// TODO Auto-generated method stub
			return entitymanager.find(PoojaPerson.class, id); //JPA;
    }
		public void findAll(){
			TypedQuery<PoojaPerson> namedQuery = entitymanager.createNamedQuery("find_all_persons", PoojaPerson.class);
		    namedQuery.getResultList();
}
	/*	public void deleteById(int id){
			PoojaPerson person = (PoojaPerson) findById(id);
			entitymanager.remove(person);
}*/
		public PoojaPerson insert(PoojaPerson person) {
			return entitymanager.merge(person);
}
		public PoojaPerson update(PoojaPerson person) {
			return entitymanager.merge(person);
}
}