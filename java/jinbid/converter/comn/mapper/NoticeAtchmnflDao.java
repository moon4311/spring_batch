package jinbid.converter.comn.mapper;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeAtchmnfl;

import java.util.Map;

/**
 * 공고 첨부파일 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeAtchmnflDao {

    /**
     * 공고 첨부파일 목록을 조회한다
     *
     * @param notiId 공고ID
     * @return 공고 첨부파일 목록
     */

    int insertNoticeAtchmnfl(NoticeAtchmnfl noticeAtchmnfl);

    int insertNoticeAtchmnfl(Map map);

}
