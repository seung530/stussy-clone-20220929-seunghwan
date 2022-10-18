package com.stussy.stussyClone20220929seunghwan.dto.admin;

import com.stussy.stussyClone20220929seunghwan.domain.ProductImgFile;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProductListRespDto {
    private int id;
    private String category;
    private String name;
    private int price;
    private String color;
    private String size;

    private String infoSimple;
    private String infoDetail;
    private String infoOption;
    private String infoManagement;
    private String infoShipping;

    private List<ProductImgFile> productImgFiles;

    private int productTotalCount;
}
