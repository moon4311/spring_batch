package jinbid.converter.comn.mapper;



import jinbid.converter.comn.vo.NoticeArea;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 공고지역코드 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeAreaDao {

    /**
     * 공고지역 목록을 조회한다.
     *
     * @param notiId 공고ID
     * @return 공고지역 목록
     */
    List<NoticeArea> selectNoticeAreaList(Long notiId);

//    int insertNoticeArea(NoticeArea noticeArea);
    int insertNoticeArea(Map map);


}
