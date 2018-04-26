package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공고면허
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class NoticeLicns  extends Basic{

    private static final long serialVersionUID = -97053695297103317L;

    /**
     * ID
     */
    private Long id;

    /**
     * 공고ID
     */
    private Long notiId;

    /**
     * 면허코드
     */
    private String licnsCd;

    /**
     * 면허명
     */
    private String licnsNm;

    /**
     * 면허그룹
     */
    private int licnsGroup;

    /**
     * 면허카테고리명
     */
    private String licnsCtgyNm;

    /**
     * 면허구분코드
     */
    private String licnsDstnctCd;

    /**
     * 면허구분코드명
     */
    private String licnsDstnctCdNm;

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

	@Override
	public String toString() {
		return "NoticeLicns [id=" + id + ", notiId=" + notiId + ", licnsCd=" + licnsCd + ", licnsNm=" + licnsNm
				+ ", licnsGroup=" + licnsGroup + ", licnsCtgyNm=" + licnsCtgyNm + ", licnsDstnctCd=" + licnsDstnctCd
				+ ", licnsDstnctCdNm=" + licnsDstnctCdNm + ", firstInputDt=" + firstInputDt + ", firstInptps="
				+ firstInptps + ", lastUpdtDt=" + lastUpdtDt + ", lastAmndr=" + lastAmndr + ", useYn=" + useYn + "]";
	}
    
    
}
