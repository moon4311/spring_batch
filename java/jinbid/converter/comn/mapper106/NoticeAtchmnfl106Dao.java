package jinbid.converter.comn.mapper106;


import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeAtchmnfl;

import java.util.List;
import java.util.Map;

/**
 * 공고 첨부파일 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeAtchmnfl106Dao {
	/**
	 *  구DB 에서 Noti Table의 항목들 조회
	 */

		/**
		 * 공고 첨부파일 조회
		 * @param vo - 조회할 정보가 담긴 
		 * @return 조회한 글
		 * @exception Exception
		 */
//List<NoticeAtchmnfl> selectNoticeAtchmnfl(Long idx) throws Exception;
List<NoticeAtchmnfl> selectNoticeAtchmnfl(Map<String, Object> map) throws Exception;
			
}
