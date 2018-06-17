package converter.jobs.processor;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.item.ItemProcessor;

import converter.comn.vo.Sample;

/**
 * 개찰 공고수집 ItemWriter
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