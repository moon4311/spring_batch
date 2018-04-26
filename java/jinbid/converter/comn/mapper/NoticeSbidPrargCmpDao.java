package jinbid.converter.comn.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeSbidPrargCmp;

/**
 * 공고낙찰예정업체 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeSbidPrargCmpDao {

	/**
	 * 공고낙찰예정업체를 조회한다.
	 * 
	 * @param notiId
	 * @return 공고낙찰예정업체
	 */
	NoticeSbidPrargCmp selectNoticeSbidPrargCmp(Long notiId);

	/**
	 * 공고낙찰예정업체를 입력한다.
	 * 
	 * @param notiId
	 * @return 공고낙찰예정업체
	 */
//	int insertNoticeSbidPrargCmp(NoticeSbidPrargCmp noticeSbidPrargCmp);
	int insertNoticeSbidPrargCmp(Map map);

	
	
}
