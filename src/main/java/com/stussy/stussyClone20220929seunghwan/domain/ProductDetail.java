package com.stussy.stussyClone20220929seunghwan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetail {
    private int group_id;
    private String name;
    private int price;
    private String color;
    private String size;
    private List<ProductImgFile> productImgFiles;
}


