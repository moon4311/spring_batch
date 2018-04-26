package jinbid.converter.comn.mapper106;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeOrign;




@Mapper
public interface NoticeOrign106Dao {

	/**
	 * 공고 원문 조회
	 * @param vo - 조회할 정보가 담긴 
	 * @return 조회한 글
	 * @exception Exception
	 */
//	 NoticeOrign selectNoticeOrign(Long idx) throws Exception;
	 NoticeOrign selectNoticeOrign(Map<String, Object> map) throws Exception;
		
	
}