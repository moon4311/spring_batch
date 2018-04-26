package jinbid.converter.comn.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 공고낙찰예정업체 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeOrignDao {

	/**
	 * 공고낙찰예정업체를 입력한다.
	 * 
	 * @param notiId
	 * @return 공고낙찰예정업체
	 */
//	int insertNoticeOrign(NoticeOrign noticeOrign);
	int insertNoticeOrign(Map map);
	
}
