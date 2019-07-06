package com.helixleisure.bookingboss.dao.impl;

import com.helixleisure.bookingboss.dao.ProductDAO;
import com.helixleisure.bookingboss.model.po.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: ProductDAOImpl
 * @Description: ProductDAOImpl
 * @author: John
 * @date: 2019/7/6
 */

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManager entityManager;


	@Override
	public List<Product> selectByIds(List<Long> ids) {

		MultiIdentifierLoadAccess<Product> multiLoadAccess;
		try (Session session = entityManager.unwrap(Session.class)) {
			multiLoadAccess = session.byMultipleIds(Product.class);
		}

		List<Product> products = multiLoadAccess.multiLoad(ids);
		//products.stream().filter(temp -> temp != null);
		products.removeIf(temp -> temp == null);
		return products;
	}

	@Override
	public List<Product> insert(List<Product> products) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		products.forEach(item -> session.persist(item));
		return products;
	}

}
