package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고복수예가
 *
 * @author Kim Jae Moon
 * @since 2018.04.06
 */
@Data
public class NoticeCompnoPrdprc extends Basic {

    private static final long serialVersionUID = 7535126570423826711L;

    /**
     * ID
     */
    private Long id;

    /**
     * 공고번호
     */
    private Long notiId;

    /**
     * 복수예가
     */
    private String compnoPrdprc;

    /**
     * 복수예가율
     */
    private double compnoPrdprcRt;

    /**
     * 정렬순서
     */
    private int sortOrdr;

    /**
     * 입찰선택여부
     */
    private String opbdChoiceYn;

    /**
     * 입찰선택횟수
     */
    private int opbdChoiceTmcnt;

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