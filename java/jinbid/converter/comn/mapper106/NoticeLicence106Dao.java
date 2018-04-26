package jinbid.converter.comn.mapper106;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeLicns;




@Mapper
public interface NoticeLicence106Dao {
/**
 *  구DB 에서 Noti Table의 항목들 조회
 */

	/**
	 * 공고 면허 조회
	 * @param vo - 조회할 정보가 담긴 
	 * @return 조회한 글
	 * @exception Exception
	 */
//	 List<NoticeLicns> selectNoticeLicense(Long idx) throws Exception;
	 List<NoticeLicns> selectNoticeLicense(Map<String, Object> map) throws Exception;
		
	
}