package jinbid.converter.comn.mapper106;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeBddprPrtcCmp;




@Mapper
public interface NoticeBdprPrtcCmp106Dao {

	/**
	 * 공고 지역 조회
	 * @param vo - 조회할 정보가 담긴 
	 * @return 조회한 글
	 * @exception Exception
	 */
//	 List<NoticeBddprPrtcCmp> selectNoticeBdprPrtcCmp(Long idx) throws Exception;
	 List<NoticeBddprPrtcCmp> selectNoticeBdprPrtcCmp(Map<String, Object> map) throws Exception;
		
	
}