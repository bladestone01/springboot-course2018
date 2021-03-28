package org.boot.course.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResultInfo {
    private String code;
    private String mesg;
    
    private Object data;
    
    public static ResultInfo success() {
    	return ResultInfo.builder().code("0").mesg("ok").build();
    }
    
    public static ResultInfo fail() {
    	return ResultInfo.builder().code("-1").mesg("fail").build();
    }
}
