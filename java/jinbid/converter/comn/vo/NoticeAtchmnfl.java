package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고첨부문서
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class NoticeAtchmnfl extends Basic {

    private static final long serialVersionUID = -8812325131486408419L;

    /**
     * ID
     */
    private Long id;

    /**
     * 공고ID
     */
    private Long notiId;

    /**
     * 파일구분명
     */
    private String fileDstnctNm;

    /**
     * 파일명
     */
    private String fileNm;

    /**
     * 파일경로명
     */
    private String filePathNm;

    /**
     * 파일순서
     */
    private int fileOrdr;

    /**
     * 외부파일여부
     */
    private String extrnlFileYn = "N";

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
