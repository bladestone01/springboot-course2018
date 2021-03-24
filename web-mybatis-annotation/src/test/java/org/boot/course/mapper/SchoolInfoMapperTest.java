package org.boot.course.mapper;

import java.util.List;

import org.boot.course.dao.entity.SchoolInfoEnum;
import org.boot.course.dao.mapper.SchoolInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SchoolInfoMapperTest {
	
	@Autowired 
	private SchoolInfoMapper schoolInfoMapper;
	
	/**
	 * 正确映射枚举
	 */
	@Test
	public void testEnumMapping() {
		List<SchoolInfoEnum> pageResult = this.schoolInfoMapper.getSchoolEnums();
		
		log.info("PageResult:{}", pageResult);
	}

}
