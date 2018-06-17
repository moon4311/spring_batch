package converter.comn.mapperSub;

import converter.comn.vo.Sample;
import converter.comn.vo.SampleArea;

import java.util.List;
import java.util.Map;

/**
 * DAO
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
@Mapper
public interface SampleAreaSubDao {

	Sample selectExistedSample(Map<String,Object> map);
	/**
     * 조회한다.
     *
     * @param id ID
     * @return 공고
     */
    Sample selectSample(Map map);
	
    List<SampleArea> selectSampleArea(Map map);
    long insertSample(Sample sample);
    long updateSample(Sample sample);

}
