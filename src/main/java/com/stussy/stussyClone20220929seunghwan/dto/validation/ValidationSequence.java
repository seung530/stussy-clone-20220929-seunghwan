package com.stussy.stussyClone20220929seunghwan.dto.validation;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({
        ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeCheckGroup.class,
        ValidationGroups.PatternCheckGroup.class,
        Default.class
})
public interface ValidationSequence {


}
