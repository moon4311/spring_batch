package converter.comn.mapper106;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import converter.comn.vo.Sample;




@Mapper
public interface Sample106Dao {
/**
 *  구DB 에서Table의 항목들 조회
 */

	/**
	 * 조회
	 * @param InputTime (sec)초 전
	 * @return 
	 * @exception Exception
	 */
	 List<Sample> selectSample(int sec) throws Exception;
	
}