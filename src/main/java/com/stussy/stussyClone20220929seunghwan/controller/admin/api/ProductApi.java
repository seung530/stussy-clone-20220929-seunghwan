package com.stussy.stussyClone20220929seunghwan.controller.admin.api;

import com.stussy.stussyClone20220929seunghwan.aop.annotation.LogAspect;
import com.stussy.stussyClone20220929seunghwan.aop.annotation.ValidAspect;
import com.stussy.stussyClone20220929seunghwan.dto.CMRespDto;
import com.stussy.stussyClone20220929seunghwan.dto.admin.ProductAdditionReqDto;
import com.stussy.stussyClone20220929seunghwan.dto.admin.ProductModificationReqDto;
import com.stussy.stussyClone20220929seunghwan.dto.validation.ValidationSequence;
import com.stussy.stussyClone20220929seunghwan.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @ValidAspect
    @LogAspect
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@Validated(ValidationSequence.class) ProductAdditionReqDto productAdditionReqDto, BindingResult bindingResult) throws Exception {

//        String productName = productAdditionReqDto.getName();
//
//        for(int i = 0; i < 20; i++) {
//            if(i % 4 == 0) {
//                productAdditionReqDto.setName(productName + "-" + (i + 1));
//            }
//            productService.addProduct(productAdditionReqDto);
//        }
//
//        return ResponseEntity
//                .created(null)
//                .body(new CMRespDto<>(1, "Successfully", null));

        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(1, "Successfully", productService.addProduct(productAdditionReqDto)));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProductList(@RequestParam int page,
                                            @RequestParam @Nullable String category,
                                            @RequestParam @Nullable String searchValue) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.getProductList(page, category, searchValue)));
    }

    @ValidAspect
    @LogAspect
    @PostMapping("/product/modification")
    public ResponseEntity<?> updateProduct(@Valid ProductModificationReqDto productModificationReqDto, BindingResult bindingResult) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.updateProduct(productModificationReqDto)));
    }
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.deleteProduct(productId)));
    }

}
