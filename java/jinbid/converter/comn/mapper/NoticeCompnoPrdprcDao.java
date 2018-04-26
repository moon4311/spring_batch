package jinbid.converter.comn.mapper;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeCompnoPrdprc;

import java.util.List;
import java.util.Map;

/**
 * 공고복수예가 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeCompnoPrdprcDao {

    /**
     * 공고복수예가 목록을 조회한다.
     *
     * @param notiId 공고ID
     * @return 공고복수예가 목록
     */
    List<NoticeCompnoPrdprc> selectNoticeCompnoPrdprcList(long notiId);

    
    /** 공고복수예가 입력	**/
//    int insertCompnoPrdprc(NoticeCompnoPrdprc noticeCompnoPrdprc);
    int insertCompnoPrdprc(Map map);


}
