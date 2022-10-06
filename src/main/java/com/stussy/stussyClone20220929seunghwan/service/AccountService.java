package com.stussy.stussyClone20220929seunghwan.service;

import com.stussy.stussyClone20220929seunghwan.dto.account.RegisterReqDto;

public interface AccountService {
    public boolean checkDuplicateEmail(String email);

    public boolean register(RegisterReqDto registerReqDto) throws Exception;


}
