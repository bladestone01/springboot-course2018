package org.boot.course.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class ResultInfo {
	private String code;
	private String mesg;
	private Object data;

	public static ResultInfo success() {
	   return ResultInfo.builder().code("0").mesg("ok").build();
   }
}
