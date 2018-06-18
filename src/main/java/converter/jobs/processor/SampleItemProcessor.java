package converter.jobs.processor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.item.ItemProcessor;

import converter.comn.vo.Sample;

/**
 * itemProcessor 는 Reader 로부터 한 객체씩 받아온다.
 * 수정/삭제 작업을 할 수 있다.
 * 수정 : 객체 수정 후 리턴
 * 삭제 : return null; 
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
public class SampleItemProcessor implements ItemProcessor<Sample, Sample> {

    @Resource(name="db1SqlSessionFactory")
    private SqlSessionFactory db1SqlSessionFactory;
	
    
    
    
	@Override
	public Sample process(Sample Sample) throws Exception{
		Map<String,Object> params = new HashMap();
		params.put("prfId", Sample.getPrfId());
		Sample tmp = db1SqlSessionFactory.openSession().selectOne("selectExistedSample", params);
		if(tmp != null){ 
			return null;
		}
		return Sample;
	}
	
}