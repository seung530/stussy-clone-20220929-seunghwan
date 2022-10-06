package com.stussy.stussyClone20220929seunghwan.dto.account;

import com.stussy.stussyClone20220929seunghwan.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterReqDto {
    @NotBlank(message = "이름은 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1, max = 3, message = "이름은 한글자에서 세글자 사이여야 합니다", groups = ValidationGroups.SizeCheckGroup.class)
    @Pattern(regexp = "^[가-힇]*$",
            message = "이름은 한글만 입력 가능합니다",
            groups = ValidationGroups.PatternCheckGroup.class
    )
    private String lastName;

    @NotBlank(message = "성은 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1, max = 2, message = "이름은 한글자에서 두글자 사이여야 합니다", groups = ValidationGroups.SizeCheckGroup.class)
    @Pattern(regexp = "^[가-힇]*$",
            message = "성은 한글만 입력 가능합니다",
            groups = ValidationGroups.PatternCheckGroup.class
    )
    private String firstName;

    @Email(message = "잘못된 이메일 형식 입니다")  // 오류 메세지 입력하지 않아도 default 메세지가 전송됨
    @NotBlank(message = "이메일은 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    private String email;

    @NotBlank(message = "비밀번호는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자에서 16자 사이여야 합니다.", groups = ValidationGroups.SizeCheckGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$",
            message = "비밀번호는 숫자, 영문, 특수기호를 하나 이상 포함하여 작성해야 합니다",
            groups = ValidationGroups.PatternCheckGroup.class
    )
    private String password;


}
