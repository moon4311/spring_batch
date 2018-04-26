package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고투찰참여업체
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class NoticeBddprPrtcCmp extends Basic {

    private static final long serialVersionUID = -5701829698586442296L;

    /**    * ID     */
    private Long id;

    /**     * 공고ID     */
    private Long notiId;

    /**     * 업체명     */
    private String cmpNm;

    /**     * 대표자명     */
    private String rpsntvNm;

    /**     * 사업자번호     */
    private String bizNo;
    
    /**     * 지역코드     -- */
    private String areaCd;

    /**     * 투찰일시     */
    private String bddprDt;

    /**     * 투찰금액     */
    private String bddprAmt;

    /**     * 투찰율     */
    private String bddprRt;

    /**     * 기초대비투찰율 --     */
    private String baseBddprRt;
    
    /**     * 업체순위     */
    private int cmpRank;

    /**     * 선택예가번호     */
    private String choicePrdprcNo;

    /**     * 비고     */
    private String rmark;

    /**     * 최초입력일시     */
    private String firstInputDt;

    /**     * 최초입력자     */
    private String firstInptps;

    /**     * 최종수정일시     */
    private String lastUpdtDt;

    /**     * 최종수정자     */
    private String lastAmndr;

    /**     * 사용여부     */
    private String useYn;
}
