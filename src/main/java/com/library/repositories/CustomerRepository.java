package com.library.repositories;

import com.library.DAOs.CustomerDAO;
import com.library.models.Customer;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements CustomerDAO {
	private final MongoTemplate mongoTemplate;
	
	public CustomerRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<Customer> findAll() {
		return mongoTemplate.findAll(Customer.class);
	}
	
	@Override
	public Customer findById(String id) {
		return mongoTemplate.findById(id, Customer.class);
	}
	
	@Override
	public Customer save(Customer customer) {
		return mongoTemplate.save(customer);
	}
	
	@Override
	public Customer update(String id, Customer customer) {
		Query query = new Query(Criteria.where("id").is(id));
		Update updateStatement = new Update();
//		return mongoTemplate.updateFirst(query,customer, Customer.class);
	}
	
	@Override
	public void delete(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, "customers");
	}
}
