package converter.jobs.writer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;

import converter.comn.mapperSub.SampleAreaSubDao;
import converter.comn.vo.Sample;
import converter.comn.vo.SampleArea;


/**
 * 공고수집 ItemWriter
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
public class ModifyItemWriter implements ItemWriter<Sample> {


	/*		테스트 DB		*/
	@Resource(name="db1SqlSessionFactory")
	private SqlSessionFactory db1SqlSessionFactory;
	
	
	@Autowired
	private SampleAreaSubDao sampleAreaSubDao;
	
    @Override
    public void write(List<? extends Sample> sampleList) throws Exception {

    	MyBatisBatchItemWriter<Sample> itemWriter = new MyBatisBatchItemWriter<>() ;
		itemWriter.setSqlSessionFactory(db1SqlSessionFactory);
		itemWriter.setStatementId("insertSample");
		itemWriter.setAssertUpdates(false);
    	itemWriter.write(sampleList);
    	
    	//지역
    	MyBatisBatchItemWriter<SampleArea> itemWriter2 = new MyBatisBatchItemWriter<>() ;
    	itemWriter2.setSqlSessionFactory(db1SqlSessionFactory);
    	itemWriter2.setStatementId("insertSampleArea");

    	for(Sample sample : sampleList){
    		Map map = new HashMap();
    		map.put("id", sample.getId());
        	// 지역
        	itemWriter2.write(sampleAreaSubDao.selectSampleArea(map));
    	}
        
    }
    
}
