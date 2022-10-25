package com.stussy.stussyClone20220929seunghwan.service.admin;

import com.stussy.stussyClone20220929seunghwan.domain.Product;
import com.stussy.stussyClone20220929seunghwan.dto.admin.ProductAdditionReqDto;
import com.stussy.stussyClone20220929seunghwan.dto.admin.ProductListRespDto;
import com.stussy.stussyClone20220929seunghwan.dto.admin.ProductModificationReqDto;

import java.util.List;

public interface ProductService {
    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;

    public List<ProductListRespDto> getProductList(int pageNumber, String category, String searchText) throws Exception;

    public boolean updateProduct(ProductModificationReqDto productModificationReqDto) throws Exception;

    public boolean deleteProduct(int productId) throws Exception;
}

