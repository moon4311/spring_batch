package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고낙찰예정업체
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class NoticeSbidPrargCmp extends Basic{

    private static final long serialVersionUID = 6934163652282371993L;

    /**
     * ID
     */
    private Long id;

    /**
     * 공고ID
     */
    private Long notiId;

    /**
     * 업체명
     */
    private String cmpNm;

    /**
     * 대표자명
     */
    private String rpsntvNm;

    /**
     * 사업자번호
     */
    private String bizNo;

    /**
     * 투찰금액
     */
    private String bddprAmt;

    /**
     * 최종낙찰여부
     */
    private String lastSbidYn;
    
    /**
     * 최종낙찰일시
     */
    private String lastSbidDt;

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
