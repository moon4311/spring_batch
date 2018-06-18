package converter.comn.mapperSub;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import converter.comn.vo.Sample;




@Mapper
public interface SampleSubDao {
/**
 *  SubDB 에서Table의 항목들 조회
 */

	/**
	 * 조회
	 * @param InputTime (sec)초 전
	 * @return 
	 * @exception Exception
	 */
	 List<Sample> selectSample(int sec) throws Exception;
	
}