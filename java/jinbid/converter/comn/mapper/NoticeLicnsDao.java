package jinbid.converter.comn.mapper;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.NoticeLicns;

import java.util.List;
import java.util.Map;

/**
 * 공고면허코드 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeLicnsDao {

    /**
     * 공고면허 목록을 조회한다.
     *
     * @param notiId 공고ID
     * @return 공고면허 목록
     */
    List<NoticeLicns> selectNoticeLicnsList(Long notiId);

//    int insertNoticeLicns(NoticeLicns noticeLicns);
    int insertNoticeLicns(Map map);

}
