package converter.jobs.writer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.TransactionAwareProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 공고수집 ItemWriter
 *
 * @author Kim Jae Moon
 * @since 2017. 4. 06.
 */
public class NewItemWriter implements ItemWriter<Sample> {

	/*		테스트 DB		*/
	@Resource(name="db1SqlSessionFactory")
	private SqlSessionFactory db1SqlSessionFactory;
	
	
	@Autowired
	private SampleArea106Dao sampleArea106Dao;
	
	
    @Override
    public void write(List<? extends Sample> sampleList) throws Exception {

    	MyBatisBatchItemWriter<Sample> itemWriter = new MyBatisBatchItemWriter<>() ;
		itemWriter.setSqlSessionFactory(db1SqlSessionFactory);
		itemWriter.setStatementId("insertSample");
    	itemWriter.write(sampleList);
    	
    	//지역
    	MyBatisBatchItemWriter<SampleArea> itemWriter2 = new MyBatisBatchItemWriter<>() ;
    	itemWriter2.setSqlSessionFactory(db1SqlSessionFactory);
    	itemWriter2.setStatementId("insertNoticeArea");
    	
    	for(Sample sample : sampleList){
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("id", sample.getId());
        	// 지역
        	itemWriter2.write(noticeArea106Dao.selectNoticeArea(map));
    	}
    	
    }
    
    
}
