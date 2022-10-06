package com.stussy.stussyClone20220929seunghwan.controller.api;


import com.stussy.stussyClone20220929seunghwan.aop.annotation.LogAspect;
import com.stussy.stussyClone20220929seunghwan.aop.annotation.ValidAspect;
import com.stussy.stussyClone20220929seunghwan.dto.CMRespDto;
import com.stussy.stussyClone20220929seunghwan.dto.account.RegisterReqDto;
import com.stussy.stussyClone20220929seunghwan.dto.validation.ValidationSequence;
import com.stussy.stussyClone20220929seunghwan.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/register")      // ResisterReqDto 기준으로 Validation검사 진행 후, BindingResult를 결과로 가져온다.
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {
                                                                                                    // validation 체크를 하면 bindingResult가 따라온다.
        accountService.checkDuplicateEmail(registerReqDto.getEmail());

        accountService.register(registerReqDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "Successfully registered", registerReqDto));
    }
}



        // 유효성 검사
//        if(bindingResult.hasErrors()) {
//            log.error("유효성 검사 오류 발생");
//
//            Map<String, String> errorMap = new HashMap<String, String>();
//
//            List<List<FieldError>> codeList = new ArrayList<List<FieldError>>();
//            codeList.add(new ArrayList<FieldError>());  // Pattern
//            codeList.add(new ArrayList<FieldError>());  // NotBlank
//
//            bindingResult.getFieldErrors().forEach(error -> {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//
//                if(error.getCode().equals("Pattern")) {
//                    codeList.get(0).add(error);
//                }else if(error.getCode().equals("NotBlank")) {
//                    codeList.get(1).add(error);
//                }
//            });
//
//            log.info("codeList: {}", codeList);
//
//            codeList.forEach(errorMapList -> {
//                errorMapList.forEach(error -> {
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                });
//            log.info("error: {}", errorMap);
//            });

////            bindingResult.getFieldErrors().forEach(error -> {
////                log.info("Error: 코드({}), 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
////
////              if(!error.getCode().equals("NotBlank")){
////                errorMap.put(error.getField(), error.getDefaultMessage());
////             }
////        });
////
////            bindingResult.getFieldErrors().forEach(error -> {
////                log.info("Error: 코드({}), 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
////
////                if(error.getCode().equals("NotBlank")){
////                    errorMap.put(error.getField(), error.getDefaultMessage());
////                }
////            });
//
//            return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMap));
//        }

//        log.info("{}", registerReqDto);
//
//        return ResponseEntity.ok(null);
//    }

//    public ResponseEntity<?> login() {
