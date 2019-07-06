package com.helixleisure.bookingboss.dao;

import com.helixleisure.bookingboss.model.po.Product;
import java.util.List;

public interface ProductDAO {

	List<Product> selectByIds(List<Long> ids);

	List<Product> insert(List<Product> products);
}
