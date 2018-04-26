package converter.comn.vo;

import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 공고
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Data
public class Sample extends Basic{

    /** ID */
    private Long id;

    /** 최초입력일시 */
    private String firstInputDt;

    /** 최초입력자 */
    private String firstInptps;

    /** 최종수정일시 */
    private String lastUpdtDt;

    /** 최종수정자 */
    private String lastAmndr;

    /** 사용여부 */
    private String useYn = "Y";
    
}
