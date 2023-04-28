package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.CarVO;
import com.example.domain.Criteria;
import com.example.domain.ImageVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.example.config.RootConfig.class})
@Log4j
public class CarMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private CarMapper mapper;
	
	/* 차량 등록 */
//	@Test
	public void insertTest() throws Exception{
		
		CarVO car = new CarVO();
		
		car.setCop_name("기아");
		car.setBr_name("모닝");
		car.setCar_name("GV80");
		car.setPrice("1000");
		car.setMileage(12000);
		car.setModel_year(2020);
		car.setFuel_type("가솔린");
		car.setColor("검정");
		car.setRegion("부산");
		car.setNumber_p(5);
		car.setSeller("김칼춤");
		car.setUc_text("낙장불입");
		car.setOwner("실차주");
		
//		System.out.println("Before CarVO :" + car);
		
		mapper.insert(car);
		
//		System.out.println("After CarVO :" + car);
	}
	
	/* 이미지 등록 */
//	@Test
	public void imageEnrollTest() {
		
		ImageVO vo = new ImageVO();
		
		vo.setNum(4);
		vo.setFileName("test");
		vo.setUploadPath("test");
		vo.setUuid("test4");
		
		mapper.imageEnroll(vo);
		
	}
	
	/* 상품 리스트 & 상품 총 갯수 */
//	@Test
	public void goodsGetListTest() {
		
		Criteria cri = new Criteria();
		
//		/* 검색조건 */
//		cri.setKeyword("테스트");
		
		/* 검색 리스트 */
		List list = mapper.goodsGetList(cri);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("result......." + i + " : " + list.get(i));
		}
//		
//		/* 상품 총 갯수 */
//		int result = mapper.goodsGetTotal(cri);
//		System.out.println("resutl.........." + result);
				
	}
	
	/* 상품 정보 */
	@Test
	public void getGoodsInfo() {
		int num = 3;
		CarVO goodsInfo = mapper.getGoodsInfo(num);
		System.out.println("===========================");
		System.out.println(goodsInfo);
		System.out.println("===========================");
		
		
	}
}