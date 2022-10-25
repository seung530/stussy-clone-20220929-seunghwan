package com.stussy.stussyClone20220929seunghwan.dto.admin;

import com.stussy.stussyClone20220929seunghwan.domain.Product;
import com.stussy.stussyClone20220929seunghwan.dto.validation.ValidationGroups;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProductModificationReqDto {

    @Min(value = 0, message = "상품 코드는 음수일 수 없습니다..")
    private int id;
    @Max(value = 1000000, message = "최대 금액은 100만원 까지만 설정 가능합니다.")
    @Min(value = 100, message = "최소 금액은 100원입니다.")
    private int price;
    @NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String color;
    @NotBlank(message = "빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String size;

    //    빈 값일 수 있는 항목들
    private String infoSimple;
    private String infoDetail;
    private String infoOption;
    private String infoManagement;
    private String infoShipping;

    private List<String> deleteImgFiles;
    private List<MultipartFile> files;

    public Product toProductEntity() {
        return Product.builder()
                .id(id)
                .price(price)
                .color(color)
                .size(size)
                .info_simple(infoSimple)
                .info_detail(infoDetail)
                .info_option(infoOption)
                .info_management(infoManagement)
                .info_shipping(infoShipping)
                .build();
    }

}
