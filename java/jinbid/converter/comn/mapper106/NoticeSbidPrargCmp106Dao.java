package jinbid.converter.comn.mapper106;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeSbidPrargCmp;

/**
 * 공고낙찰예정업체 DAO
 *
 * @author LEESEUNGGI
 * @since 2018-01-18
 */
@Mapper
public interface NoticeSbidPrargCmp106Dao {

	/**
	 * 공고낙찰예정업체를 조회한다.
	 * 
	 * @param notiId
	 * @return 공고낙찰예정업체
	 */
//List<NoticeSbidPrargCmp> selectNoticeSbidPrargCmp(Long notiId);
List<NoticeSbidPrargCmp> selectNoticeSbidPrargCmp(Map<String, Object> map);

}
