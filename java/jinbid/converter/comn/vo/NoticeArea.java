package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고지역
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class NoticeArea extends Basic{

    /**
     * ID
     */
    private Long id;

    /**
     * 공고ID
     */
    private Long notiId;

    /**
     * 지역코드
     */
    private String areaCd;

    /**
     * 지역코드
     */
    private String areaNm;

    /**
     * 도내코드
     */
    private String prvnclCd;

    /**
     * 도내명
     */
    private String prvnclNm;

    /**
     * 지역레벨
     */
    private int areaLvl;

    /**
     * 최초입력일시
     */
    private String firstInputDt;

    /**
     * 최초입력자
     */
    private String firstInptps;

    /**
     * 최종수정일시
     */
    private String lastUpdtDt;

    /**
     * 최종수정자
     */
    private String lastAmndr;

    /**
     * 사용여부
     */
    private String useYn;

}
