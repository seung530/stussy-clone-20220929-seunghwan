package com.stussy.stussyClone20220929seunghwan.service;

import com.stussy.stussyClone20220929seunghwan.dto.shop.CollectionListRespDto;
import com.stussy.stussyClone20220929seunghwan.dto.shop.ProductDetailResDto;

import java.util.List;

public interface ShopService {
    public List<CollectionListRespDto> getCollections(String category, int page) throws Exception;
    public ProductDetailResDto getProductDetails(int groupId) throws Exception;
}
