package jinbid.converter.comn.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 투찰참여업체 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeBddprPrtcCmpDao {

	/**
	 * 투찰참여업체 입력
	 * 
	 * @param notiId
	 * @return 투찰참여업체 목록 전체건수
	 */
//	void insertNoticeBddprPrtcCmpListCnt(NoticeBddprPrtcCmp noticeBddprPrtcCmp);
	void insertNoticeBddprPrtcCmpList(Map map);

}
