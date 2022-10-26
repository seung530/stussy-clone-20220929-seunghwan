package com.stussy.stussyClone20220929seunghwan.repository;

import com.stussy.stussyClone20220929seunghwan.domain.CollectionProduct;
import com.stussy.stussyClone20220929seunghwan.domain.Product;
import com.stussy.stussyClone20220929seunghwan.domain.ProductDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopRepository {
    public List<CollectionProduct> getCollectionList(Map<String, Object> map) throws Exception;
    public List<ProductDetail> getProduct(int groupId) throws Exception;
}
