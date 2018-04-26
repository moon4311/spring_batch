package jinbid.converter.comn.mapper106;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeCompnoPrdprc;




@Mapper
public interface NoticeCompnoPrdprc106Dao {

	/**
	 * 공고 복수예가 조회
	 * @param  
	 * @return 조회한 글
	 * @exception Exception
	 */
//	 List<NoticeCompnoPrdprc> selectNoticeCompnoPrdprcList(Long idx) throws Exception;
	 List<NoticeCompnoPrdprc> selectNoticeCompnoPrdprcList(Map<String, Object> map) throws Exception;
	 
	
}