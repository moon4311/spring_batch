package jinbid.converter.comn.mapper106;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.Notice;




@Mapper
public interface Notice106Dao {
/**
 *  구DB 에서 Noti Table의 항목들 조회
 */

	/**
	 * 공고 진행 조회
	 * @param InputTime (sec)초 전
	 * @return 
	 * @exception Exception
	 */
	 List<Notice> selectNoticeBase(int sec) throws Exception;
	
}