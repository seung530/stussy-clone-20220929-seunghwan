package com.stussy.stussyClone20220929seunghwan.domain;

import com.stussy.stussyClone20220929seunghwan.dto.shop.CollectionListRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CollectionProduct {

    private int group_id;
    private String category;
    private String name;
    private int price;
    private String temp_name;
    private int total_count;

    public CollectionListRespDto toListRespDto() {
        return CollectionListRespDto.builder()
                .groupId(group_id)
                .category(category)
                .name(name)
                .price(price)
                .imgName(temp_name)
                .totalCount(total_count)
                .build();
    }
}
