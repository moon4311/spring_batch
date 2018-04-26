package jinbid.converter.comn.vo;

import lombok.Data;

/**
 * 공통
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */

@Data
public class Basic {

    /** ID */
    Long id ;
    
    /** 공고번호 */
    Long notiId;

    /** 최초입력일시 */
    String firstInputDt;

    /** 최초입력자 */
    String firstInptps;

    /** 최종수정일시 */
    String lastUpdtDt;

    /** 최종수정자 */
    String lastAmndr;

    /** 사용여부 */
    String useYn = "Y";
 
}
