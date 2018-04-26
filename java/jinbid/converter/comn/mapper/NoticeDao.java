package jinbid.converter.comn.mapper;

import org.apache.ibatis.annotations.Mapper;

import jinbid.converter.comn.vo.Notice;

import java.util.Map;

/**
 * 공고 DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface NoticeDao {

	/**
	 * 공고 존재여부 체크
	 *
	 * @param id ID
	 * @return 공고
	 */
	Notice selectExistedNotice(Map<String,Object> map);
	/**
     * 공고 내역을 조회한다.
     *
     * @param id ID
     * @return 공고
     */
    Notice selectNotice(Map map);
	
    /*** 공고를 입력한다.     */
    long insertNotice(Notice notice);
    long updateNotice(Notice notice);

    /*  insert 후속조치  */
    void updateOrderOffiCd();/*** 공고 발주처코드 변경   **/    
    void updateActulDnttCd();/*** 공고 실수요기관코드 변경   **/
    void updateCfmtUndwrtStId();	/*** 적격심사기준ID 변경   * */
}
