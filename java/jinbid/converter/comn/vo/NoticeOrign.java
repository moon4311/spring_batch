package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고원문
 *
 * @author Kim Jae Moon
 * @since 2018.04.06
 */
@Data
public class NoticeOrign extends Basic{

    private static final long serialVersionUID = 8569987382449935197L;

    /**
     * ID
     */
    private Long id;

    /**
     * 공고ID
     */
    private Long notiId;

    
    /**
     * 공고첨부파일 ID
     */
    private Long notiAtchmnflId;
    
    
    /**
     * 공고첨부파일여부
     */
    private String notiAtchmnflYn = "N";

    
    /**
     * 원문타입코드
     */
    private String orignTpCd;

    /**
     * 원문내용
     */
    private String orignText;
    
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
